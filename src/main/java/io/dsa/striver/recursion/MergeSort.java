package io.dsa.striver.recursion;

public class MergeSort {
    /*
Much more optimized sorting algorithm
Divide and Merge - for both even and odd , divide the array in 2 parts (hypothetical)
    take the left part and divide it again untill it cant be divided again (single num)
    now merge this hypothetical array in single but in sorted manner
    essentially we are merging the left sorted half and right sorted half (using the pointer approach )
The array needed to be sorted using 2 pointer approach can just create sub arrays right


So the problem can be divided into the recursive backTracking problem as array is going to be divided with high and low index
and then similar thing is going to happen untill we have a single element or high = low

we have the base condition where the high and low are same.
We have to calculate the middle point from where the array will be divided
     */

    public static void main(String[] args) {

    }

    private static void RecursiveBacktracking(int[] arr, int low, int high) {
        if (high == low) {
            return;
        }

        int mid = (low + high) / 2;
        // we then divide the array again from the low to mid and mid to high , first the left portion will be operated
        // then after the call comes back the next right portion will be operated
        RecursiveBacktracking(arr, low, mid);
        RecursiveBacktracking(arr, mid + 1, high);

        // After the sort of the both left and right part we are merging that is the next step
        // for this we need another function to merge

        merge(arr, low, high, mid);

    }

    private static void merge(int[] arr, int low, int high, int mid) {
        // so the array is sorted from low to mid and then mid to high , we have to now merge both
        // if a value is smaller we are storing it in the new position and the new value is kept in the temp
        // we are taking 2 pointers to compare these two hypothetical arrays and the condition to compare will
        // be till the whole traversal is complete left<=mid , and right <=  , till we have elements on both sides

        int left = low;
        int right = mid + 1;

        int[] temp = new int[high - low + 1];
        int index = 0;

        while (left <= mid && right <= high) {
            if (arr[left] >= arr[right]) {
                temp[index] = arr[right];
                index++;
                right++;
            } else {
                temp[index] = arr[left];
                index++;
                left++;
            }
        }

        while (left <= mid) {
            temp[index++] = arr[left++];
        }
        while (right <= high) {
            temp[index++] = arr[right++];
        }


        for (int i = low; i <= high; i++) {
            arr[i] = temp[i - low]; // temp array must be keeping from 0th index
        }
    }
}
