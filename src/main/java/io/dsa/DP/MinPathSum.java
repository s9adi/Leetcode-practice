package io.dsa.DP;

public class MinPathSum {
    /*
    Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
    Output: 7
    Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
     */
    public static void main(String[] args) {

    }

    static int recursiveSolution(int[][] arr, int i, int j) {
        if (i == 0 && j == 0) return arr[i][j];
        if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length) return Integer.MAX_VALUE;

        int up = recursiveSolution(arr, i, j - 1);
        int left = recursiveSolution(arr, i - 1, j);

        return arr[i][j] + Math.min(up, left);
    }

    static int memoization(int[][] arr, int i, int j, int[][] dp) {
        if (i == 0 || j == 0) return arr[i][j];
        if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length) return Integer.MAX_VALUE;
        if (dp[i][j] != -1) return dp[i][j];

        int left = memoization(arr, i - 1, j, dp);
        int right = memoization(arr, i, j - 1, dp);

        // we update the min of these two calls
        dp[i][j] = Math.min(left, right);
        return dp[i][j]; // upar walo ke liye chod diya ki yaha tak to ye min hai ab aage aap dekho
    }

    static int DPApproach(int[][] arr) {
        int[][] dp = new int[arr.length][arr[0].length];
        dp[0][0] = arr[0][0];
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; i++) {
                // the logic of going up and left will be applied here
                int up = arr[i][j] + dp[i][j - 1];
                int left = arr[i][j] + dp[i - 1][j];
                dp[i][j] = Math.min(up, left);
            }
        }
        return dp[arr.length - 1][arr[0].length];
    }
}
