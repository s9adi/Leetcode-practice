package io.dsa.DP;

public class Stairs {

    static int nthStairsRecursion(int stairs) {
        // i can take either one step or 2 step
        if (stairs == 0) return 1;
        if (stairs == 1) return 1;
        if (stairs == 2) return 2;

        return nthStairsRecursion(stairs - 1) + nthStairsRecursion(stairs - 2);
    }

    static int nthStairsMemoization(int stairs, int dp[]) {
        if (stairs == 0) return 1;
        if (stairs == 1) return 1;
        if (stairs == 2) return 2;
        if (dp[stairs] != -1) return dp[stairs];
        else return dp[stairs - 1] + dp[stairs - 1];
    }

    static int nthStairsTabulation(int stairs) {
        int dp[] = new int[stairs + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= stairs; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[stairs + 1];
    }
}
