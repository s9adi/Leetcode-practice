package io.dsa.DP;

import java.util.Arrays;

public class FrogJump {

    static int recursiveSolution(int[] heights, int n) {
        // 1. A frog can jump either one or 2 steps
        // lets break the problem to small pieces
        // A frog can reach at n either by jumping 1 step from n-1 or by jumping 2 steps from n-2
        if (n == 0) return 0;
        int left = recursiveSolution(heights, n - 1) + Math.abs(heights[n] - heights[n - 1]);
        int right = n > 1 ? recursiveSolution(heights, n - 2) + Math.abs(heights[n] - heights[n - 2]) : Integer.MAX_VALUE;
        return Math.min(left, right);
    }

    static int memoizationSolution(int[] heights, int n, int[] dp) {
        if (n == 0) return 0;
        if (dp[n] != -1) return dp[n];
        int jumpOne = memoizationSolution(heights, n - 1, dp) + Math.abs(heights[n] - heights[n - 1]);
        int jumpTwo = n > 1 ? memoizationSolution(heights, n - 2, dp) + Math.abs(heights[n] - heights[n - 2]) : Integer.MAX_VALUE;
        return Math.min(jumpTwo, jumpOne);
    }

    static void dpSolution(int[] heights, int n) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = heights[1] - heights[0];
        for (int i = 2; i < n; i++) {
            int jump1 = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
            int jump2 = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);
            dp[i] = Math.min(jump1, jump2);
        }
    }

    static int recursiveSolutionWithKSteps(int[] heights, int n, int k) {
        if (n == 0) return 0;
        int minEnergy = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            int jump = recursiveSolutionWithKSteps(heights, n - i, k) + Math.abs(heights[n] - heights[n - i]);
            minEnergy = Math.min(minEnergy, jump);
        }
        return minEnergy;
    }

    static int memoKSteps(int[] heights, int n, int k, int[] dp) {
        if (n == 0) return 0;
        if (dp[n] != -1) return dp[n];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            int jump = memoKSteps(heights, n - i, k, dp) + Math.abs(heights[n] - heights[n - i]);
            min = Math.min(jump, min);
        }
        dp[n] = min;
        return min;
    }

    static int tabulationSolution(int[] heights, int n, int k) {
        int[] dp = new int[n]; // Use `n` since that's the size of the problem
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            int minEnergy = Integer.MAX_VALUE; // Reset for each index
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) { // Ensure valid index
                    int jump = dp[i - j] + Math.abs(heights[i] - heights[i - j]);
                    minEnergy = Math.min(minEnergy, jump);
                }
            }
            dp[i] = minEnergy; // Store the best energy for this index
        }
        return dp[n - 1]; // The last index holds the minimum energy needed
    }
}
