package io.dsa.striver.Arrays;

public class SortTheArraysOfOnesAndZeroes {

    static int[] Solution(int[] arr) {
        // One way is to take the count of each and then just add those to the array

        // Optimal -> Dutch National Flag Algo
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while (mid <= high) {
            if (arr[mid] == '0') {// swap with the start (low) and the one there will move to the end of the 1's list
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            } else if (arr[mid] == '1') {
                mid++;
            } else if (arr[mid] == '2') {
                // we have to swap it with the last
                // that last is going to be high and then decrease high
                int temp = arr[high];
                arr[high] = arr[mid];
                arr[mid] = temp;
                high--;
            }
        }
        return arr;
    }

}
