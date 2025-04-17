package io.dsa.striver.stacksAndQueues;

import java.util.Arrays;
import java.util.Stack;

public class SumOfSubArrayMins {
    /*
    find the min of all the subarray that exists for the array , sum
    BruteForce -> Generating all subarrays and then finding min of all
    [3124] -> first subarray will start with 3 , then with 1  then with 2 and then with 4
    as we generate all the subarrays from the 3 we keep appending the minvalue


    {3,1,2,4} -> starting from three -> 3 , 31, 312 , 3124
         starting from 1 -> 1 , 12 , 124
         starting from 2 -> 2 , 24
         starting from 4 -> 4

example array - {1,9,10 ,11, 5,3,2,1,}
     */
    public static void main(String[] args) {
        Optimized(new int[] {3,1,2,4});
        BruteForce(new int[] {3,1,2,4});
    }

    private static int BruteForce(int[] arr) {

        int sum = 0;
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int minForThisLoop = arr[i];
            for (int j = i; j < len; j++) {
                minForThisLoop = Math.min(arr[j], minForThisLoop);
                sum = sum + minForThisLoop;
            }
        }

        return sum;


    }

    /*
We are creating the functions that would give us the index of
nextSmallerElement -> (for next smaller element we need to iterate from the back)
from current index
and previous smaller element
leftelements  = i - pse
rightelements = nse - 1
total = right * left * array[i]


we will be storing indexes in stack because we have to find the total elements that are smaller
than our current one , basically we are doing operations on the indexes and not the element itself
for a particular element we are checking what is the next smaller element or previous smaller smaller element
and where is it how far it it as we need to find the total subarrays for which the current element is the smaller one
and we do that by multiplying the elements at right and left
     */

    private static int[] findNextSmallerElement(int[] arr) {
        // we are storing indexes in the stack
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] nse = new int[n]; // we are going to fill this array with the nse indexes

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) { // this essentially is checking that the
                stack.pop();
            }
            nse[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        return nse;
    }

    private static int[] findPreviousSmallerElement(int[] arr) {

        int n = arr.length;
        Stack<Integer> stack = new Stack<>(); // to store in indices
        int[] pse = new int[n];

        // we
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        return pse;
    }

    protected static int Optimized(int[] arr) {
/*
so far we have the indexes of the last and next smaller elements for a particular element
 */
        int pse[] = findPreviousSmallerElement(arr);
        int nse[] = findNextSmallerElement(arr);

        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            int leftElements = i - pse[i];
            int rightElements = nse[i] - i;

            sum += leftElements * rightElements * arr[i];
        }
       return sum;
    }
}
