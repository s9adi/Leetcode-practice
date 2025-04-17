package io.dsa.striver.recursion;

public class QuickSort {
    /*
    Sort in Ascending order and with minor tweaks we can sort descending order too
    It has nlogn tc and 1 space complexity
    pick a pivot and place it at its correct place

    after picking the pivot any smaller element will be stored on the left of the pivot
    and other will be stored on the right

    now we can say at-least one element is at the correct position do these two steps for the left and right array now

    PseudoCode
    =========

    1. We take 2 pointers low and high , if low < high that means there are some elements present in the array
    2. Pick pivot to be low pointer
    3. partition() function will partition the array in 2 and will give the pivot location (that is partition index).
       It will keep the smaller numbers to the left of the pivot and greater numbers to be the right of pivot.
    4.

     */

    static void QuickSortMethod(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            QuickSortMethod(arr, low, pivotIndex);
            QuickSortMethod(arr, pivotIndex + 1, high);

        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;
        while (i < j) {
            while (arr[j] > pivot) j--; // looking for element greater than pivot the moment it does it stops
            while (arr[i] <= pivot && i <= high) i++; // looking for el smaller the pivot
            if (i < j)
                swap(arr, i, j); // swap when you find , this swap will stop at the condition when i >j and
            // the j is the partition index that we need
        }
        swap(arr, low, j);
        return j;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
