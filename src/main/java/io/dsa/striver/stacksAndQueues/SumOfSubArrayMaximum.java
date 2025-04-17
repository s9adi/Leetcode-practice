package io.dsa.striver.stacksAndQueues;

import java.util.Stack;

public class SumOfSubArrayMaximum {
    public static void main(String[] args) {

    }

    // example array - {13,2,3,4,1,2,7,10,15,9,12}
    // in mins we were trying to find the smaller elements that this element and for max will have to find the
    // greater element than this one

    private static int BruteForce(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int max = arr[i];
            for (int j = i; j < arr.length; j++) {
                max = Math.max(max, arr[j]);
                sum += max;
            }
        }

        return sum;
    }

    protected static int Optimized(int[] arr) {
        int sum = 0;
        int[] NGE = getNextGreaterElement(arr);
        int[] PGE = getPreviousGreaterElement(arr);

        for (int i = 0; i < arr.length; i++) {
            int left = i - NGE[i];
            int right = PGE[i] - i;

            sum += left * right * arr[i];
        }

        return sum;

    }

    private static int[] getPreviousGreaterElement(int[] arr) {
        int n = arr.length;
        int[] PGE = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            PGE[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        return PGE;
    }

    private static int[] getNextGreaterElement(int[] arr) {
        int n = arr.length;
        int[] NGE = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            NGE[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        return NGE;
    }
}
