package io.dsa.striver.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsequences {
    /*
    can be contigous , so if we have to get a subsequence of the array then we can by following take and not-take index
    policy
     */
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();

        // AllSubsequences(new int[]{1, 2, 3}, 0, 3, list, new ArrayList<>());
        //AllSubsequencesWithSum(new int[]{1, 2, 4, 3}, 3, 0, 0, list, new ArrayList<>());

        System.out.println(list);
    }

    private static void AllSubsequences(int[] arr, int index, int len, List<List<Integer>> res, List<Integer> list) {
        // arr = {3,1,2}
        if (index >= len) {
            res.add(new ArrayList<>(list));
            return;
        }

        list.add(arr[index]);
        AllSubsequences(arr, index + 1, len, res, list);
        list.remove(list.size() - 1);
        AllSubsequences(arr, index + 1, len, res, list);

    }

    private static void AllSubsequencesWithSum(int[] arr, int k, int sum, int index, List<List<Integer>> res, List<Integer> list) {
        if (index >= arr.length) {
            if (sum == k) {
                res.add(new ArrayList<>(list));
            }
            return;
        }

        list.add(arr[index]);
        AllSubsequencesWithSum(arr, k, sum + arr[index], index + 1, res, list);

        list.remove(list.size() - 1);
        AllSubsequencesWithSum(arr, k, sum, index + 1, res, list);
    }

    private static void AllSubsWithSumApp2(int[] arr, int k, int sum, int index, List<List<Integer>> res, List<Integer> list) {
        if (index >= arr.length) {
            if (sum == k) {
                res.add(new ArrayList<>(list));
            }
            return;
        }

        list.add(arr[index]);
        sum += arr[index];
        // call including this index

        // remove this element
        // call removing this index
    }

    private static boolean JustOneSubWithSumK(int[] arr, int k, int sum, int index, List<List<Integer>> res,
                                              List<Integer> list) {
        if (index >= arr.length) {
            if (sum == k) {
                return true;
            }
            return false;
        }

        list.add(arr[index]);
        boolean withCall = JustOneSubWithSumK(arr, k, sum + arr[index], index + 1, res, list);
        if (withCall) {
            return true;
        }
        list.remove(list.size() - 1);
        if (JustOneSubWithSumK(arr, k, sum, index + 1, res, list) == true) {
            return true;
        }

        return false;
    }
/*
 To return the count of total subsequence
    we can just return 1 if the contion is satisfied and if not then 0 and the left and right call sum is returned

    If you have to check if the subsequence exist or not - bpoolean
    if you have to check the first avail then boolean
    if count then return 1,0
*/


}
