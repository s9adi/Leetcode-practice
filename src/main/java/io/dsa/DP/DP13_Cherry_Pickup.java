package io.dsa.DP;

import java.util.Arrays;

public class DP13_Cherry_Pickup {

    public static void main(String[] args) {

    }

    static int memoization(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;

        int[][][] dp = new int[m][n][n];

        for (int[][] twoD : dp) {
            for (int[] oneD : twoD) {
                Arrays.fill(oneD, -1);
            }
        }

        return recurrence(dp, arr, 0, 0, n - 1, m, n);

    }

    static int recurrence(int dp[][][], int[][] arr, int i, int j1, int j2, int m, int n) {
        // base condition and terminating conditions
        // if j of either goes out of bounds then we can just stop and return the min value
        if (j1 < 0 || j1 > n || j2 > n || j2 < 0) return (int) (Math.pow(-10, 9));
        // terminating condition , if we reach the last index we just return the values from there
        // which will be handled by the previous calls right
        if (i == m - 1) {
            if (j1 == j2) return arr[i][j1];
            else return arr[i][j1] + arr[i][j2];
        }
        if (dp[i][j1][j2] != -1) return dp[i][j1][j2];

        // now we have to write the recursive solution
        // the delta that is the change in the values are from -1 to +1 for each cell (index)
        int max = Integer.MIN_VALUE;
        for (int d1 = -1; d1 <= +1; d1++) {
            for (int d2 = -1; d2 <= +1; d2++) {
                int ans;
                // now we have to do recursions
                // call itself , in three different locations
                if (j1 == j2) ans = recurrence(dp, arr, i + 1, j1 + d1, j2 + d2, m, n) + arr[i][j1];
                else ans = recurrence(dp, arr, i + 1, j1 + d1, j2 + d2, m, n) + arr[i][j1] + arr[1][j2];
                ans = Math.max(max, ans);
            }
        }

        return dp[i][j1][j2] = max;
    }

    static int tabulation(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        // we have three changing states , i , j1 , j2 -> three changing states are i and j1 anf j2 the j will change from 0 to n
        // the tabulation is bottom up approach
        // so we start with the bottom that is we will take care of the first row itself
        int[][][] dp = new int[m][n][n];
        // base case , this base case will take care of each columns j1 and j2
        for (int j1 = 0; j1 < n - 1; j1++) {
            for (int j2 = 0; j2 < n - 1; j2++) {
                if (j1 == j2) dp[m - 1][j1][j2] = arr[m - 1][j1];
                else dp[m - 1][j1][j2] = arr[m - 1][j1] + arr[m - 1][j2];
            }
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < n; j1++) {
                for (int j2 = 0; j2 < n; j2++) {
                    int max = Integer.MIN_VALUE;
                    // we have to find all 9 options from here and find the max of each
                    for (int d1 = -1; d1 <= +1; d1++) {
                        for (int d2 = -1; d2 <= +1; d2++) {
                            int ans;

                            if (j1 == j2) ans = arr[i][j1];
                            else ans = arr[i][j1] + arr[i][j2];

                            if ((j1 + d1 > n || j2 + d2 < 0) || (j1 + d1 > n || j1 + d1 < 0)) ans = Integer.MIN_VALUE;
                            else ans = ans + dp[i + 1][j1 + d1][j2 + d2]; // we are filling from bottom right
                            max = Math.max(max, ans);
                        }
                    }

                    dp[i][j1][j2] = max;
                }
            }
        }
        return dp[0][0][n - 1];
        // the final result is stored where the ith index is 0 that is the firstIndex , and the jth index is 0 and j+1th index is n-1
    }
}
