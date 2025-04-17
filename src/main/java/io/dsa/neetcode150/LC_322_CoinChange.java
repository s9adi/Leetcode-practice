package io.dsa.neetcode150;

import java.util.Arrays;

public class LC_322_CoinChange {
    public static void main(String[] args) {

    }

    private static void Solution(int[] coins, int target) {
        /*
        Input: coins = [1,2,5], amount = 11
        Output: 3
        Explanation: 11 = 5 + 5 + 1
         */
        int total = Integer.MIN_VALUE;

    }

    private static int recursiveHelper(int[] coins, int target) {
        if (target == 0) {
            return 0;
        }
        if (target < 0) {
            return -1;
        }

        int minCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = recursiveHelper(coins, target);
            if (res != Integer.MAX_VALUE) {
                minCoins = Math.min(minCoins, res + 1);
            }
        }
        return minCoins;
    }

    private static int dpHelper(int[] coins, int target, int dp[]) {
        if (target == 0) {
            return 0;
        }
        if (target < 0) {
            return -1;
        }
        if (dp[target] != -1) {
            return dp[target];
        }

        int minCoins = Integer.MAX_VALUE;

        for (int coin : coins) {
            int res = dpHelper(coins, target, dp);
            if (res != Integer.MAX_VALUE) {
                minCoins = Math.min(minCoins, res + 1);
            }
        }
        dp[target] = minCoins;
        return dp[target];
    }

    private static int BootomUpApproach(int[] coins, int target) {
        int dp[] = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[target] == -1 ? -1 : dp[target];
    }
}
