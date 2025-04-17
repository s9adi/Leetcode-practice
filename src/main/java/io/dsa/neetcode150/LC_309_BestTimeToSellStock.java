package io.dsa.neetcode150;

public class LC_309_BestTimeToSellStock {
    public static void main(String[] args) {

    }

    private static int Solution(int[] prices) {
        /*
        Input: prices = [1,2,3,0,2]
        Output: 3
        Explanation: transactions = [buy, sell, cooldown, buy, sell]
        after selling next day cannot buy so check that before buying
         */
        int len = prices.length;
        if (len == 0) {
            return 0;
        }

        // dynamic programming
        int[] sell = new int[len]; // max profit if you sell on the ith day
        int[] buy = new int[len]; // max profit if you currently hold a stock
        int[] cooldown = new int[len]; // max profit if you don't do anything on the ith day

        buy[0] = -prices[0]; // profit is neg if you buy on the very first day
        sell[0] = 0;
        cooldown[0] = 0;

        // max profit can be from selling or staying in cooldown on the last day
        /*
        buy state- you currently just bought or you had stock from the previous day
        sell - you sold today or just hold after selling
        cooldown - you were in cooldown yesterday or you sold yesterday
         */
        for (int i = 0; i < len; i++) {
            buy[i] = Math.max(buy[i - 1], cooldown[i - 1] - prices[i]);
            // above we can either buy today or carry forward the profit of yesterday
            // if we buy then we are going to pay the prices of today stock and yesterday should be the cooldown
            // state therefore we are removing from yesterday
            sell[i] = buy[i - 1] + prices[i];
            cooldown[i] = Math.max(sell[i - 1], cooldown[i - 1]);
        }

        return Math.max(cooldown[len - 1], sell[len - 1]);

    }


}
