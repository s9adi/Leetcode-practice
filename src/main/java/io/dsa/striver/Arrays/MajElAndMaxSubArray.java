package io.dsa.striver.Arrays;

import java.util.Arrays;

public class MajElAndMaxSubArray {

    static int BruteForce(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        return arr[n / 2];
    }

    static int MooresVotingAlgorithmn(int[] arr) {
        /*
        We randomly chose a element and then increase the count of the variable and decrease if any other comes
         */
        int count = 0;
        int element = 0;
        for (int i = 0; i < arr.length; i++) {
            if (count == 0) {
                element = arr[i];
                count = 1;
            } else if (arr[i] == element) {
                count++;
            } else {
                count--;
            }
        }
        int c = 0;
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == element) c++;
        if (c > arr.length / 2) {
            return element;
        } else {
            return -1;
        }
    }

    static int MaxSubArray(int[] arr) {
// BruteForce is generating all subarrays

        //int[] arr = new int[]{-2,-3,4,-1,-2,1,5,-3};
        // we iterate and we keep the sum updated and if after updating the sum the sum is negative and it is lower than previous
        // it doesnt make sense to carry it forward reduce it to zero as it is going to hamper only

        int csum = arr[0];
        int max = Integer.MIN_VALUE;
        int start = -1;
        int end = -1;
        for (int i = 1; i < arr.length; i++) {

            if(csum == 0){
                start = i;
            }

            csum += arr[i];

            if (csum < 0) {
                csum = 0;
            }

            if (csum > max) {
                max = csum;
                end = i;
            }


        }

        return max;
    }
}
