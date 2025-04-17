package io.dsa.striver.SlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class SubstringWithAtmostKDistinct {
    public static void main(String[] args) {
        BruteForce("aaabbbccd", 2);
    }

    static void BruteForce(String str, int k) {
        // aaabbbccd -> 6 as aaabbb
        // Explore all the substrings starting from each index
        Set<Character> set = new HashSet<>();
        int maxLen = 0;
        for (int i = 0; i < str.length(); i++) {
            int len = 0;
            for (int j = i; j < str.length(); j++) {
                char ch = str.charAt(j);
                set.add(ch);
                len++;
                maxLen = Math.max(maxLen, len);
                if (set.size() < k) {
                    break;
                }
            }
        }

        System.out.println("Max Len is = " + maxLen);
    }

    static void Optimized(String str, int k) {
        // aaabbbccd -> 6 as aaabbb
        // Explore all the substrings starting from each index
        int maxLen = 0;
        int left = 0;

        for (int i = 0; i < str.length(); i++) {

        }
    }
}
