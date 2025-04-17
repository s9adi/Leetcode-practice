package io.dsa.neetcode150;

public class LC_528_CoinChange2 {
    public static void main(String[] args) {
        /*
        Input: amount = 5, coins = [1,2,5]
        Output: 4
        Explanation: there are four ways to make up the amount:
        5=5
        5=2+2+1
        5=2+1+1+1
        5=1+1+1+1+1
         */
    }

    private static int Solution(int amount, int coins[]) {
        int count = Integer.MIN_VALUE;
        int dp[] = new int[amount + 1];
        dp[0] = 1;
        // for each coin we can find the way of creating sum up-to amount from 0
        // here dp is the array of getting i amount from the mentioned coin
        // say amount 3 from coin 2 will be equal of amount of getting 2 + 1 (here 1 is the 3-2)
        // amount of getting 2 from 5 will not be there because we are going to start with the coin that is 5
        // and iterate from there , so for every coin we are going to be finding the ways of getting the
        // different amounts from there , so it will be nested loops
        // also see that we have taken the amount array to be amount + 1 to accommodate the amount

        for (int coin : coins)
            for (int i = coin; i <= amount; i++)
                dp[i] = dp[i] + dp[i - coin]; // if we use this coin, i-coin
        return dp[amount];
    }
}
