package io.dsa.striver.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class SubsContainingAll3 {
    /*
    Input: s = "abcabc"
    Output: 10
    Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc",
    "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again).
     */
    public static void main(String[] args) {
        BruteForce("abcabc");
    }

    static void BruteForce(String string) {
        /*
        I have to give the count of total Number of Strings that have all three chars
        Brute Force is Generate all the substrings and count if the subs have all three chars

        abcabc
         */
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            Map<Character, Integer> map = new HashMap<>();
            for (int j = i; j < string.length(); j++) {
                char ch = string.charAt(j);
                map.put(ch, map.getOrDefault(ch, 0) + 1);

                if (map.size() == 3) {
                    count = count + string.length() - j;
                    break;
                }
            }
        }

        System.out.println("Count of " + count);
    }

    /*
    I dont understand this below approach need to check it
     */
    static int CountSubstringsWithAllABC(String s) {
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        int left = 0; // Sliding window's left boundary

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1); // Add current character to the map

            // Check if all three characters 'a', 'b', 'c' are in the window
            while (map.size() == 3) {
                result += (s.length() - right); // Add substrings starting from `left` to `right`
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1); // Reduce count of the left character

                if (map.get(leftChar) == 0) {
                    map.remove(leftChar); // Remove the character if its count becomes zero
                }
                left++; // Shrink the window from the left
            }
        }

        return result;
    }

    static void Approach2(String string) {
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            int[] arr = new int[3];
            for (int j = i; j < string.length(); j++) {
                char c = string.charAt(j);
                arr[c - 'a'] = 1;
                if (arr[0] + arr[1] + arr[2] == 3) {
                    count++;
                }
            }
        }
    }

    static void TUFOptimized(String string) {
        int[] charArray = {
                -1, -1, -1
        };
        int count = 0;
        // i create an array to store if the char has appeared or not
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            charArray[ch - 'a'] = i;

            if (charArray[0] != -1 && charArray[1] != -1 && charArray[2] != -1) {
                count = count + min(charArray[0], charArray[2], charArray[1]);
            }
        }
    }

    static int min(int a, int b, int c) {
        return (Math.min(a, Math.min(b, c)));
    }
}
