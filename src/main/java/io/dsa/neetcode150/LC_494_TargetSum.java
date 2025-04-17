package io.dsa.neetcode150;

public class LC_494_TargetSum {
    public static void main(String[] args) {

    }

    private static int Solution(int[] nums, int target) {
/*
    Input: nums = [1,1,1,1,1], target = 3
    Output: 5
    Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
    -1 + 1 + 1 + 1 + 1 = 3
    +1 - 1 + 1 + 1 + 1 = 3
    +1 + 1 - 1 + 1 + 1 = 3
    +1 + 1 + 1 - 1 + 1 = 3
    +1 + 1 + 1 + 1 - 1 = 3
 */
        return helper(nums, 0, target, 0);
    }

    private static int helper(int[] array, int index, int target, int sum) {
        if (index >= array.length) {
            return sum == target ? 1 : 0;
        }

        int substract = helper(array, index + 1, target, sum - array[index]);
        int plus = helper(array, index + 1, target, sum + array[index]);

        return substract + plus;
    }
}
