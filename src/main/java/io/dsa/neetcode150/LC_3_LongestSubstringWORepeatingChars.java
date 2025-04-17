package io.dsa.neetcode150;

import java.util.HashMap;
import java.util.Map;

public class LC_3_LongestSubstringWORepeatingChars {
    private static void Solution(String s) {
        /*
        Input: s = "abcabcbb"
        Output: 3
        Explanation: The answer is "abc", with the length of 3.
         */
        int maxlen = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        Map<Character, Integer> lastSeen = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (lastSeen.containsKey(c) && lastSeen.get(c) >= left) {
                left = lastSeen.get(c) + 1;
            }
            maxlen = Math.max(maxlen, i - left + 1);
            lastSeen.put(c, i);
        }
    }
}
