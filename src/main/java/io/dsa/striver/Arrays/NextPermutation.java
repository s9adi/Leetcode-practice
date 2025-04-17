package io.dsa.striver.Arrays;

import java.util.*;

public class NextPermutation {
    static void BruteForce(int[] arr) {
        // 1. generate all 2. Linear Search 3.Next

        List<List<Integer>> generate = Generate(arr);

    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
    }

    static List<List<Integer>> Generate(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] flag = new boolean[arr.length];
        Arrays.fill(flag, false);
        helper(arr, res, new ArrayList<>(), 0, flag);
        return res;
    }

    static void helper(int[] arr, List<List<Integer>> res, List<Integer> list, int index, boolean[] flag) {
        if (index == arr.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (flag[i] == false) {
                flag[i] = true;
                list.add(arr[i]);
                helper(arr, res, list, index + 1, flag);
                list.remove(list.size() - 1);
                flag[i] = false;
            }
        }
    }

    static void Optimal(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        int i = n - 2;
        while (i >= 0) {
            if (arr[i] >= arr[i + 1]) i--;

            // once we reach that point then we have to find the next greater element

            if (i >= 0) {
                int j = n - 1;
                while (arr[j] <= arr[i]) {
                    j--; // we have to find the first bigger element than this from the back and swap
                }
                swap(arr, i, j);
            }
            // reverse _> incomplete
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
