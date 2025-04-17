package io.dsa.striver.stacksAndQueues;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AsteroidCollision {
    /*
collision will happen when the asteroids are moving in opposite direction
The asteroid with the smaller size (less value) will get destroyed
Thinking - i will traverse from the left and will see for the next negative elements and will store all the
positive in the stack as i need to check for the LIFO model
whenever there is positive just put in stack , and when there is negative then we have to check for the elements
stored in out stack
     */

    private static List<Integer> Optimized(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > 0) {
                stack.push(arr[i]);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(arr[i])) {
                    stack.pop();
                }

                if (!stack.isEmpty() && stack.peek() == Math.abs(arr[i])) {
                    stack.pop();
                } else if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(arr[i]);
                }
            }
        }
        List<Integer> res = new ArrayList<>();

        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }
}
