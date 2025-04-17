package io.dsa.DP.subsequences;

public class DP_19_Knapsack {
    public static void main(String[] args) {
        int[] itemWeight = {3, 4, 5};
        int[] itemValue = {30, 50, 60};
        int weight = 8;
        int max = recursiveSolution(itemWeight, itemValue, weight, 2);
        System.out.println("Max  " + max);
    }

    static int recursiveSolution(int[] itemWeight, int[] itemValue, int weight, int index) {
        // we return the max
        // base case 1. if index == 0 , we can pick or not pick
        if (index == 0) {
            // not pick or pick
            // for picking we have to check if the current weight> = item-weight
            if (itemWeight[index] <= weight) return itemValue[index];
            else return 0;
        }

        // now pick or not pick
        int notPick = recursiveSolution(itemWeight, itemValue, weight, index - 1);
        int pick = 0;
        if (weight >= itemWeight[index])
            pick = recursiveSolution(itemWeight, itemValue, weight - itemWeight[index], index - 1) + itemValue[index];

        return Math.max(pick, notPick);
    }

    static int memoization(int[] itemWeight, int[] itemValue, int[][] dp, int weight, int index) {
        if (index == 0) {
            if (weight >= itemValue[index]) {
                return itemValue[index];
            } else {
                return 0;
            }
        }
        if (dp[index][weight] != -1) return dp[index][weight];
        // now take or not take
        int notTake = memoization(itemWeight, itemValue, dp, weight, index - 1);
        int take = Integer.MIN_VALUE;
        if (weight >= itemWeight[index]) {
            take = memoization(itemWeight, itemValue, dp, weight - itemWeight[index], index - 1) + itemValue[index];
        }

        return dp[index][weight] = Math.max(take, notTake);
    }

    static void tabulation(int[] itemWeight , int[] itemValue , int weight){

    }
}
