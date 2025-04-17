package io.dsa.striver.stacksAndQueues;

import java.util.Stack;

public class NextGreaterElement0 {
    private static int[] Solution(int[] nums1) {

        int len = nums1.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[len];

        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums1[i]) {
                stack.pop();
            }
            // if the stack is empty now , all the elements in the stack were lesser
            if (stack.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = stack.pop();
            }

            stack.push(nums1[i]);
        }

        return res;
    }
}
