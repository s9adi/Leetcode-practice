package io.dsa.DP;

import java.util.Arrays;

public class FallingPathSum {

    static int minRecursionMyApproach(int[][] arr, int n, int i, int j) {
        if (i == n - 1) return arr[i][j];
        if (i < 0 || j < 0 || j >= n || i >= n) return Integer.MAX_VALUE;

        int temp = 0;

        for (int k = 0; k < n; k++) {
            // we go down , diag1 , diag2
            int down = minRecursionMyApproach(arr, n, i + 1, j);
            int dg1 = minRecursionMyApproach(arr, n, i + 1, j + 1);
            int dg2 = minRecursionMyApproach(arr, n, i + 1, j - 1);

            temp = Math.min(down, Math.min(dg1, dg2));
        }

        return temp;
    }

    static int recurrence(int[][] arr) {
        int len = arr.length;
        int size = arr[0].length;
        int[][] dp = new int[len][size];

        int min = Integer.MAX_VALUE;
        // here dp is used to store the max points to reach the i,j from any point of the first row
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < size; i++) {
            int ans = helper(arr, len - 1, i, dp);
            min = Math.min(min, ans);
        }
        return min;
    }

    private static int helper(int[][] arr, int i, int j, int[][] dp) {
        if (j < 0 || j >= arr[0].length) return Integer.MAX_VALUE;
        if (i == 0) return arr[0][j];

        if (dp[i][j] != -1) return dp[i][j];

        // go three different directions from a particular point and then update the
        // min of each direction
        int up = helper(arr, i - 1, j, dp) + arr[i][j];
        int left = helper(arr, i, j - 1, dp) + arr[i][j];
        int right = helper(arr, i, j + 1, dp) + arr[i][j];

        return dp[i][j] = Math.min(up, Math.min(left, right));
    }

    static void tabulation(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int[][] dp = new int[m][n];

        // as i have to fill the whole row the first one only
        for (int j = 0; j < n; j++) {
            dp[0][j] = arr[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; i++) {
                int up = arr[i][j] + dp[i - 1][j];
                int leftD = arr[i][j];
                if (j > 0) {
                    leftD += dp[i - 1][j - 1];
                } else {
                    leftD = Integer.MAX_VALUE;
                }
                int rightD = arr[i][j];
                if (j < n) {
                    rightD += dp[i - 1][j + 1];
                } else {
                    rightD = Integer.MAX_VALUE;
                }

                dp[i][j] = Math.max(rightD, Math.max(leftD, up));
            }
        }
    }

}
