package io.dsa.DP;

public class Triangle {

    static int minPathSumRecursion(int[][] triangleArray, int i, int j) {
        /*

        we have Triangle array and we have to figure out the maxSum or minSum of the path to reach the last row

        Example 1:

        Input: triangle = [[2],
                           [3,4],
                           [6,5,7],
                           [4,1,8,3]]
        Output: 11
        Explanation: The triangle looks like:
           2
          3 4
         6 5 7
        4 1 8 3
        The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).

        Base Case -> reached at the last array return the element from there
         */
        if (i == triangleArray.length - 1) return triangleArray[i][j];

        int below = minPathSumRecursion(triangleArray, i + 1, j);
        int diagonal = minPathSumRecursion(triangleArray, i + 1, j + 1);

        return Math.min(below, diagonal) + triangleArray[i][j];
    }

    static int memoization(int[][] arr, int i, int j, int[][] dp) {
        if (i == arr.length - 1) return arr[i][j];
        if (dp[i][j] != -1) return dp[i][j];

        int down = memoization(arr, i + 1, j, dp);
        int diagonal = memoization(arr, i + 1, j + 1, dp);

        return Math.min(down, diagonal) + arr[i][j];
    }

    static int dp(int[][] arr, int n) {
        int[][] dp = new int[arr.length][arr[arr.length - 1].length];
        // we have to start from the bottom that is 0,0
        for (int j = n - 1; j >= 0; j--) {
            dp[n - 1][j] = arr[n - 1][j];
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int dg = arr[i][j] + dp[i + 1][j + 1];
                int dn = arr[i][j] + dp[i + 1][j];
                dp[i][j] = Math.min(dg, dn);
            }
        }

        return dp[0][0];
    }
}
