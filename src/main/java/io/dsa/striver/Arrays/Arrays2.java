package io.dsa.striver.Arrays;

public class Arrays2 {
    static void missingNumBrute(int[] arr, int k) {
        // The array is not sorted
        boolean[] flag = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) flag[i] = false;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == arr[j]) {
                    flag[i] = true;
                }
            }
        }


    }

    static void missingSumOptimized(int[] arr, int k) {
// XOR Operation -> if you XOR a number by itself it becomes 0
        // Do XOR on the nums from 1 to n and the elements of array and then
        // Do XOR on the result

        int XOR1 = 0;
        int XOR2 = 0;

        for (int i = 0; i < arr.length; i++) XOR1 ^= arr[i];
        for (int i = 1; i < k; i++) XOR2 ^= i;
    }


}
