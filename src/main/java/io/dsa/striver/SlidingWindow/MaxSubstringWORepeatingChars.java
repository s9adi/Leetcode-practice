package io.dsa.striver.SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaxSubstringWORepeatingChars {

    static void Optimal(String s) {
        // Sliding window and 2 pointer
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLen = Integer.MIN_VALUE;
        int currentLen = 0;
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (!map.containsKey(ch)) {
                currentLen = i - left + 1;
            } else {
                left = Math.max(left, map.get(ch) + 1);
            }

            maxLen = Math.max(maxLen, currentLen);
            map.put(ch, i);

        }
    }

    static void BruteForce(String s) {
        int maxLen = 0; // Keeps track of the maximum length of unique substrings
        for (int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();
            int currLen = 0; // Resets the current length for each starting point
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if (!set.contains(c)) {
                    set.add(c);
                    currLen = j - i + 1; // Update current length
                    maxLen = Math.max(currLen, maxLen); // Compare and update max length
                } else {
                    break; // Exit the inner loop when a duplicate is found
                }
            }
        }
        System.out.println("Maximum Length of Unique Substring: " + maxLen);
    }


}
