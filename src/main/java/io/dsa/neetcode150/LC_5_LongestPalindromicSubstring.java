package io.dsa.neetcode150;

public class LC_5_LongestPalindromicSubstring {
    private static String ExpandAroundCenter(String s) {
        /*
        Input: s = "babad"
        Output: "bab"
        Explanation: "aba" is also a valid answer.
         */
        // should be 2 pointer approach
        if (s == null || s.length() == 0) {
            return "";
        }
        int start = 0;
        int end = 0;
        String max = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            String odd = expandFromCenter(i, i, s);
            String even = expandFromCenter(i, i + 1, s);
            if (odd.length() > max.length()) {
                max = odd;
            }
            if (even.length() > max.length()) {
                max = even;
            }
        }
        return max;

    }

    private static String expandFromCenter(int left, int right, String s) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }


    /* ----------------------------------------------------------------------------------------*/

    private static String BruteForce(String s) {
        String maxlen = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String sub = s.substring(i, j + 1);
                if (isPalindrome(sub) && sub.length() > maxlen.length()) {
                    maxlen = sub;
                }
            }
        }
        return maxlen;
    }

    private static boolean isPalindrome(String str) {
        int l = 0;
        int r = str.length() - 1;
        while (l <= r) {
            if (!(str.charAt(l) == str.charAt(r))) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
