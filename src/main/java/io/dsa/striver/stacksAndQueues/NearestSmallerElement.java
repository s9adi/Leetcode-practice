package io.dsa.striver.stacksAndQueues;

import java.util.Stack;

public class NearestSmallerElement {
    private static int[] Solution(int[] array) {
        // we have to find the nearest smaller element that has come
        // so stack should be used
        // how ? -> we put the smaller element in the stack and then we just check

        Stack<Integer> stack = new Stack<>();
        int res[] = new int[array.length];
        res[0] = -1;
        stack.push(array[0]);
        for (int i = 1; i < array.length; i++) {

            // we have to check if the top is the lower element or not
            // if not then we just pop till we find the lesser element and then we put the current element in the stack
            // and else we put -1 if we dont find in the stack

            while (!stack.isEmpty() && stack.peek() >= array[i]) {
                stack.pop();
            }

            res[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(array[i]);

        }

        return res;
    }
}
