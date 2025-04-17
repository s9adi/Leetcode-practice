package io.dsa.striver.stacksAndQueues;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement2 {

    public static void main(String[] args) {
        Optimized(new int[]{2, 10, 12, 1, 11});
    }

    private static int[] BruteForce(int[] nums) {
        int length = nums.length;
        int res[] = new int[length];

        // {2,10,12,1,11} -> {2,10,12,1,11 , 2,10,12,1,11}

        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < i + length - 1; j++) {
                int index = j % length;
                if (nums[j] >= nums[i]) {
                    res[i] = nums[j];
                    break;
                }
            }
        }

        return res;
    }

    private static int[] Optimized(int[] nums) {
        int l = nums.length;
        Stack<Integer> stack = new Stack<>();
// int this approach we are again creating a virtual array
        int[] nums1 = new int[2 * l];
        int[] res = new int[l];
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = nums[i % l];
        }

        // we have elements in stack now we have to create result array

        for (int i = 2 * l - 1; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek() >= nums[i % l]) {
                stack.pop();
            }
            if (i <= l - 1) {
                res[i] = stack.peek() >= nums[i] ? stack.peek() : -1;
            }
            stack.push(nums1[i]);
        }

        return res;
    }
}
