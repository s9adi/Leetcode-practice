package io.dsa.neetcode150.Arrays;

public class SearchInRoatatedSortedArray {
    public static void main(String[] args) {

    }

    private static void Solution(int[] array, int target) {
        // Input: nums = [4,5,6,7,0,1,2], target = 0 output -> 4

        // the thing id that if the condition of sequential increasing fails in the one of the half it should not fail
        // in the other half so we are basically coding for that one condition that suits what we seek
        int left = 0;
        int right = array.length - 1;
        while (left < right) {

            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                System.out.println("The Answer is " + mid);
                return;
            }
            if (array[left] <= array[mid]) {
                if (array[left] <= target && array[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (array[mid] <= target && target < array[right]) {
                    left = mid + 1;

                } else {
                    right = mid - 1;
                }
            }
        }
    }
}
