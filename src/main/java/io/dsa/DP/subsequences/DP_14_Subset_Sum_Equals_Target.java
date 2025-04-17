package io.dsa.DP.subsequences;

import java.util.Arrays;

public class DP_14_Subset_Sum_Equals_Target {

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 1};
        int target = 4;
        int[][] dp = new int[arr.length][target];
        for (int[] array : dp) {
            Arrays.fill(array, -1);
        }
        boolean res = memoization(arr, target, arr.length - 1, dp);
        if (res) System.out.println("The Target is there in the array");
    }

    static boolean recursion(int[] arr, int target, int index) {
        if (index == 0) return target == arr[0];
        if (target == 0) return true;

        // take and not take only two conditions are there

        boolean notTake = recursion(arr, target, index - 1);
        boolean take = false;
        // we can only take if the target is smaller than required
        if (target >= arr[index]) take = recursion(arr, target - arr[index], index - 1);
        // we only need one of the values to be true
        return notTake || take;
    }

    static boolean memoization(int[] arr, int target, int index, int[][] dp) {
        // base condition when to stop recursion
        if (index == 0) return target == arr[index];
        if (target == 0) return true;

        if (dp[index][target] != -1) return dp[index][target] == 0 ? false : true;

        // we have 2 choices we can either take or not take a particular value
        boolean notTake = memoization(arr, target, index - 1, dp);
        boolean take = memoization(arr, target - arr[index], index - 1, dp);

        dp[index][target] = notTake || take ? 1 : 0;
        return notTake || take;
    }

    static boolean tabulation(int[] arr, int target, int len) {
        // this is top down approach we fill the base case first
        // base case = if the target is 0 and the index is 0
        boolean[][] dp = new boolean[len][target + 1];
        for (int i = 0; i < len; i++) dp[i][0] = true;
        if (arr[0] == target) dp[0][arr[0]] = true;

        for (int i = 1; i < len; i++) {
            for (int j = 1; j <= target; j++) {
                // at a particular location , we can either take or not take
                boolean notTaken = dp[i - 1][target];
                // we check if we can take and update the same in the dp arr
                boolean taken = false;
                if (arr[i] <= i) taken = dp[i - 1][j - arr[i]];

                dp[i][j] = notTaken || taken;
            }
        }

        return dp[len - 1][target];
    }
}
