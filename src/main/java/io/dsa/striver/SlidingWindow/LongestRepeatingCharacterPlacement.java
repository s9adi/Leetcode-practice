package io.dsa.striver.SlidingWindow;

public class LongestRepeatingCharacterPlacement {
    public static void main(String[] args) {
        BruteForce("AABABBA", 2);
    }

    static void BruteForce(String STRING, int k) {
        /*
        AABABBA -> and most we can change is k say 2
        In Brute Force we try to explore all the strings and till that string we try to get the maxF of the
        element till there and no of change operations will be equal to len - maxF
        and if the len - maxF is smaller than k then we can do the operations and update the counter
         and if not then we can just break from there

         Given String is in the Caps so the ASCII starts from 65
         */

        /*
        If i store the frequency in map
         */
        int maxLen = 0;
        for (int i = 0; i < STRING.length(); i++) {
            int[] chars = new int[26];
            int maxF = 0;
            for (int j = i; j < STRING.length(); j++) {
                char ch = STRING.charAt(j);
                chars[ch - 'A'] += 1;
                maxF = Math.max(maxF, chars[ch - 'A']);
                int changes = (1 + j - i) - maxF;
                if (changes < k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                } else {
                    break;
                }
            }
        }
        System.out.println("MaxLen =" + " " + maxLen);
    }

    static void Optimized(String string, int k) {
        /*
        Initially start with 2 pointer from 0
        Map to store the frequency , check if all the chars are same if same update the maxLen len - maxF <= k (conversions needed)
        when the maxLen increases and the conversions needed reaches more than k then we move the left pointer till we trim
        the element that is coming to 0 and then remove it from the map
         */

        int left = 0;
        int maxLen = 0;
        int[] freqCount = new int[26];
        int maxFreq = 0;
        for (int right = 0; right < string.length(); right++) {
            char ch = string.charAt(right);

            freqCount[ch - 'A']++;


            while ((right - left + 1) - maxFreq > k) {

                char charToRemove = string.charAt(right);
                freqCount[charToRemove - 'A'] -= 1;
                maxFreq = 0;
                for (int i = 0; i < freqCount.length; i++) {
                    maxFreq = Math.max(maxFreq, freqCount[i]);
                }

//                if (freqCount[charToRemove - 'A'] == 0) {
//                    break;
//                }
                left++;
            }

            if (left - right + 1 - maxFreq <= k) { // this is a valid segment

                maxFreq = Math.max(maxFreq, right - left + 1);

                maxLen = Math.max(maxLen, right - left + 1);
            }


        }

        System.out.println("MaxLen = " + maxLen);

        // can be optimized more at where we are running the loop till 26 every fking time the maxLen needs to be increased
    }
}
