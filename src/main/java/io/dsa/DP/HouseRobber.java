package io.dsa.DP;

public class HouseRobber {
    /*
    Input: nums = [2,3,2]
    Output: 3
    Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
    We have to resolve the circular house constraint here rest is easy either we can create an array of n+1 and keep the
    element first one to last but that is brute force
    what else ?? can we add the constraint check in the start itself of the function ??
     */
    static int recursiveSolution(int[] nums, int len) {
        int pickFirst = helper(nums, 0, len - 1, 0);
        int pickLast = helper(nums, 1, len, 1);

        return Math.max(pickFirst, pickLast);
    }

    static int helper(int[] nums, int startIndex, int lastIndex, int index) {
        if (index == 0) return nums[0];
        int max = Integer.MIN_VALUE;
        if (index >= startIndex && index <= lastIndex) {
            int pickCurrent = helper(nums, startIndex, lastIndex, index - 2) + nums[index];
            int notPickCurrent = helper(nums, startIndex, lastIndex, index - 1);
            max = Math.max(pickCurrent, notPickCurrent);
        }
        return max;

    }
}
