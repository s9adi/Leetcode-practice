package io.dsa.striver.recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsetSum {

    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 3};
        List<Integer> list = Solution(arr);
        System.out.println(list);
    }

    static List<Integer> Solution(int[] arr) {
        List<Integer> res = new ArrayList<>();
        backTrack(arr, 0 , res ,0);
        return res;
    }

    static void backTrack(int[] arr, int index, List<Integer> list, int sum) {
        if (index == arr.length) {
            list.add(sum);
            return;
        }

        // to make a subset we can either add current element to the list or not
        // if we do we can increase the sum and after that we can increase the index and then repeat


        // add this index
        sum = sum + arr[index];
        backTrack(arr, index + 1, list, sum);

        // ignore this index
        sum = sum - arr[index];
        backTrack(arr, index + 1, list, sum);

    }
}
