package io.dsa.striver.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {

    }

    private static void Solution(int[] arr, int k) {
        // we have to find the various combs that sum up to k
        // we can think of it as selecting a particular index and then either pick that to be in the target or not

    }

    private static void helper(int[] arr, int k, int curr, int index, List<Integer> list, List<List<Integer>> res) {
        // base condition
        if (curr == k) {
            res.add(new ArrayList<>(list));
        }

        if (index > arr.length || curr > k) {
            return;
        }

        // we take the current index
        list.add(arr[index]);
        helper(arr, k, curr + arr[index], index, list, res);

        // we dont take this index and we move to other index
        // why are we removing the element from the list ?
        // because when the call returns back to the original place we want to explore the condition where it doesnt need the current index
        list.remove(list.size() - 1);
        helper(arr, k, curr, index + 1, list, res);
    }
}
