package io.dsa.DP;

public class MaxSum {

    static int recursiveSolution(int[] arr, int len, int index) {
        if (index == 0) return arr[0];
        if (index < 0) return 0;
        // at a particular index we can either pick it or not
        // make call for both where you have picked it and not
        int picked = recursiveSolution(arr, len, index - 2) + arr[index];
        int notPicked = recursiveSolution(arr, len, index - 1);

        return Math.max(picked, notPicked);
    }

    static int memoization(int[] arr, int len, int dp[], int index) {
        if (index == 0) return arr[0];
        if (index < 0) return 0;
        if (dp[index] != -1) return dp[index];

        int pick = memoization(arr, len, dp, index - 2) + arr[index];
        int notPick = memoization(arr, len, dp, index - 1);

        int max = Math.max(pick, notPick);
        dp[index] = max;
        return max;
    }

    static int tabulation(int[] arr, int len) {
        if (len == 0) return 0;
        if (len == 1) return arr[0];
        int dp[] = new int[len];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        // we have a dp array to store the maxSum till the particular index right
        // for a particular index the maxSum will be max of if either that element is picked or not
        for (int i = 2; i < len; i++) {
            // dp i is max of left and right
            int pick = dp[i - 2] + arr[i];
            int not_pick = dp[i - 1];
            dp[i] = Math.max(pick, not_pick);
        }

        return dp[len - 1];
    }
}
