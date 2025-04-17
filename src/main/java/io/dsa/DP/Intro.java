package io.dsa.DP;

import java.util.List;

public class Intro {
    public static void main(String[] args) {

    }

    static int memoizationOfFib(int n, int[] dp) {
        if (n <= 1) return n;
        if (dp[n] != -1) return dp[n - 1];
        else return dp[n] = memoizationOfFib(n - 1, dp) + memoizationOfFib(n - 2, dp);
    }
}
