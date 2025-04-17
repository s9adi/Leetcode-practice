package io.dsa.DP;

public class Grid {
    static int uniquePathsRecursive(int[][] arr, int i, int j) {
        if (i == 0 && j == 0) return 1; // we have reached to the place
        if (i < 0 || j < 0 || i > arr.length || j > arr[0].length) return 0;
        // from here we can either go up or down
        int left = uniquePathsRecursive(arr, i - 1, j);
        int top = uniquePathsRecursive(arr, i, j - 1);
        return top + left;
    }

    static int uniquePathsMem(int[][] arr, int i, int j, int[][] dp) {
        if (i == 0 && j == 0) return 1;
        if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        int left = uniquePathsMem(arr, i - 1, j, dp);
        int top = uniquePathsMem(arr, i, j - 1, dp);

        int res = left + top;
        dp[i][j] = res;
        return res;
    }

    static int DynamicProgram(int[][] arr, int m, int n) {
        int[][] dp = new int[m][n];
        // its bottom down so we have to fill the base case in the dp array
        // dp array is the max paths till i and j
        dp[0][0] = 1;
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++) {
                int left = dp[i - 1][j];
                int right = dp[i][j - 1];
                dp[i][j] = left + right;
            }
        return dp[m - 1][n - 1];
    }
}
