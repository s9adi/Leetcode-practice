package io.dsa.DP.subsequences;

public class DP_16_Partition_in_2_Subsets {
    public static void main(String[] args) {

    }

    static int TabulationSolution(int[] arr) {
        // We get the array -> we calculate the sum of elements
        int sum = 0;
        for (int i = 0; i < arr.length; i++) sum += arr[i];
        if (sum % 2 != 0) return -1;
        sum = sum / 2;
        // dp calculate
        int len = arr.length;
        boolean[][] dp = new boolean[len][sum + 1];
        // base case
        // 1. if the index is 0
        dp[0][arr[0]] = true;
        // 2. if the sum is 0 we dont care of the index , we will put true against each
        for (int i = 0; i < len; i++) {
            dp[i][0] = true;
        }
        // now fill the dp
        for (int index = 1; index < len; index++) {
            for (int target = 0; target <= sum; target++) {
                // take and not take policy here
                boolean notTake = dp[index - 1][target];
                boolean take = false;
                if (arr[index] <= target) take = dp[index - 1][target - arr[index]];
                dp[index][target] = take || notTake;
            }
        }

        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < sum + 1; i++) {
            if (dp[dp.length - 1][i]) {
                int s1 = i;
                int s2 = sum - i;
                minDiff = Math.min(minDiff, Math.abs(s2 - s1));
            }
        }

        return minDiff;
    }
}
