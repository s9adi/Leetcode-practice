package io.dsa.neetcode150.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LC_76_MinWinSubstring {
    private static String Solution(String t1, String t2) {
        Map<Character, Integer> targetMap = new HashMap<>(); // to contain the
        Map<Character, Integer> windowMap = new HashMap<>();
        for (char c : t2.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int required = targetMap.size();
        int minlen = Integer.MAX_VALUE;
        int matched = 0;
        int minStart = 0;
        //int window[] = new int[]{-1 , 0 , 0};

        // we have to traverse through the String , Input: s = "ADOBECODEBANC", t = "ABC" output -> BANC
        // why are we taking the required to be the size of map (frequency of each elements) and not the
        // String itself because we have to take the account of the no of times a letter is appearing and
        // that would be difficult when we treat each character separately
        // when we get the substring now we have to make this string small, now we have to find the position

        while (right < t1.length()) {
            char c = t1.charAt(right);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
            if (targetMap.containsKey(c) && windowMap.get(c).equals(targetMap.get(c))) {
                matched++;
            }

            while (matched == required) {
                if (minlen > right - left + 1) {
                    minlen = right - left + 1;
                    minStart = left;
                }

                char ch = t1.charAt(left);
                windowMap.put(ch, windowMap.getOrDefault(ch, 0) - 1);
                if (targetMap.containsKey(c) && windowMap.get(c).equals(targetMap.get(c))) {
                    matched--;
                }
            }
        }

        return minlen == Integer.MAX_VALUE ? " " : t1.substring(minStart, minStart + minlen);

    }
}
