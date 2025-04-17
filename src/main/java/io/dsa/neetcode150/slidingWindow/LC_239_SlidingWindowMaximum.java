package io.dsa.neetcode150.slidingWindow;

public class LC_239_SlidingWindowMaximum {
    public static void main(String[] args) {

    }

    public static int[] Solution(int[] arr, int k) {
        /*
        Input: nums = [1,2,1,0,4,2,6], k = 3
        Output: [2,2,4,4,6]

        Approach is divide the entire array in k blocks itself
        121 042 26
         */
        int len = arr.length;
        int[] result = new int[len - k + 1];
        int left[] = new int[len];
        int right[] = new int[len];
        // we have computed the max element from the start of the block and till i
        for (int i = 0; i < len; i++) {
            if (k % i == 0) {
                left[i] = arr[i];
            } else {
                left[i] = Math.max(left[i - 1], arr[i]);
            }

            // now we will compute the max element from the end of the block to this
            // j is the right index alright and we are calculating from the end of the block in right iteration and
            // the last element is always going to be in the multiple of k-1 that
            // last element is going to be the prev of the first element of the box
            //
            int j = len - 1 - i; // for i = 0 this is the last element
            if ((j + 1) % k == 0 || j == len - 1) {
                right[j] = arr[j];
            } else {
                right[j] = Math.max(arr[j], right[j - 1]);
            }

            // now we have to find

        }

        for (int i = 0; i < k; i++) {
            result[i] = Math.max(left[i], right[i + k - 1]);
        }

        return result;
    }
}
