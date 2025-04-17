package io.dsa.striver.stacksAndQueues;

import java.util.Stack;

public class RemoveKdigits {

    public static void main(String[] args) {
        Solution("1432219", 3);
/*
I have to remove the digits such that the resulting element is the lowest that can be formed
smaller digits at the start and get rid of the larger one -> this is greedy approach
i have to remove the digits so that the order should be preserved so example if there is a digit that is
at the end and it is the largest but that wont affect the outcome or res

So i will start by removing the higher digits from the string and keep the remaining digits in the stack

 */
    }

    private static void Solution(String string, int k) {
        int len = string.length();

        if (len == k) {
            System.out.println("The string is non existent now");
            return;
        }

        for (int i = 0; i < len; i++) {
            char ch = string.charAt(i);
            if (ch == '0') {
                string = string.substring(1);
            } else {
                break;
            }
        }
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            int n = Integer.parseInt(String.valueOf(ch));

            while (!stack.isEmpty() && stack.peek() >= n && k > 0) {
                stack.pop();
                k--;
            }

            stack.push(n);
        }

        System.out.println(stack);
    }
}
