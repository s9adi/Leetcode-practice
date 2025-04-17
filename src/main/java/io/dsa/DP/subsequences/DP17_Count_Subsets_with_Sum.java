package io.dsa.DP.subsequences;

public class DP17_Count_Subsets_with_Sum {
    public static void main(String[] args) {

    }

    static int recursiveSolution(int[] arr, int k, int index) {
        if (index == 0) return arr[index] == k ? 1 : 0;
        if (k == 0) return 1;

        // now we can either take or not take
        int notTake = recursiveSolution(arr, k, index - 1);
        int take = 0;
        if (arr[index] <= k) recursiveSolution(arr, k - arr[index], index - 1);

        return take + notTake;
    }

    static int memoizationSolution(int[] arr, int k, int index, int[][] dp) {
        if (index == 0) return arr[index] == k ? 1 : 0;
        if (k == 0) return 1;
        if (dp[index][k] != -1) return dp[index][k];

        // take and not take

        int notTake = recursiveSolution(arr, k, index - 1);
        int take = 0;
        if (arr[index] <= k) recursiveSolution(arr, k - arr[index], index - 1);

        dp[index][k] = take + notTake;
        return dp[index][k];
    }

    static int tabulation(int[] arr, int k, int len) {
        int[][] dp = new int[len][k + 1];
        // base case
        // since this is the bottom up , so we fill the base case first in the dp array
        // 1. if the index is 0 -> then only if the element is equal to target then we return 1
        // 2. if the target itself is 0 then we can just return 1
        // dp array signifies that at particular index and target what can be the max numbers of subsets with sum k
        // we are essentially making it a sub-problem

        for (int i = 0; i < len; i++) {
            dp[i][0] = 1;
        }
        dp[0][arr[k]] = 1;

        for (int index = 1; index < len; index++) {
            for (int target = 1; target <= k; target++) {
                // we have to check if the subproblem before is able to achieve with same target if we dont take the
                // current element previous dp element tahts is dp[index-1][target] will store the no of ways when
                // the current element is not taken
                int notTake = dp[index - 1][target];
                // see , dp[i][j] tells us that the total subset with sum j that can be possible with array from 0 to i
                int take = 0;
                if (target >= arr[index]) take = dp[index - 1][target - arr[index]];
                dp[index][target] = take + notTake;
            }
        }
        return dp[len - 1][k];
    }
}
