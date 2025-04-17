package io.dsa.neetcode150.Arrays;

public class MinimumInRotatedSortedArray {

    public static void main(String[] args) {

    }

    private static void Solution(int[] array) {
        /*
        Input: nums = [3,4,5,1,2]
        Output: 1
        Explanation: The original array was [1,2,3,4,5] rotated 3 times.
         */

        // we have to find the original array or we can just find the min ?
        // notice that we can have any pattern in the array

        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (array[mid] < array[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(array[left]);
    }
}
