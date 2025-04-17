package io.dsa.striver.SlidingWindow;

public class Problems {

    static int LongestSubArrayWithSumK(int[] arr, int k) {
        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            int sum = 0;
            for (int j = i + 1; j < arr.length; j++) {
                sum = sum + arr[j];
                if (sum <= k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                } else if (sum > k) {
                    break;
                }
            }
        }
        return maxLen;
    }

    static void LongestSubArrayWithSumKOptimal(int[] arr, int k) {

        // some issues with the code and that can be resolved
        int left = 0;
        int right = 0;
        int sum = 0;
        int maxLen = 0;
        int[] index = new int[2];

        while (right > left) {
            sum = sum + arr[right];

            while (sum > k) {
                sum = sum - arr[k];
                left++;
            }
            if (sum <= k) {
                maxLen = Math.max(maxLen, right - left + 1);
                index[0] = left;
                index[1] = right;
            }

            right++;

        }
    }

    static void NoOfSubArrays(int [] arr , int k){

    }
}
