package io.dsa.striver.SlidingWindow;

public class BinarySubArraysWithSumK {
    /*
    The Problem is we have to give the count of all the subArrays with sum == k

    example - Input: nums = [1,0,1,0,1], goal = 2

(Optimized)-> The problem with the traditional 2 pointer is that we cannot generate subarrays since the elements are 0s and 1s
when we reach a situation where we need to have subArrays with 0 in it when we remove the 0s the sum will be unaffected and
therefore will be difficult to keep track of the two pointer. Basically we are not sure whether to move l or r

The solution for this problem is that we can search for the subArrays with sum smaller than and equal to goal.
This can be done as we itherate through the array we add all the subArrays that are smaller than equal to k
now that can be done using length formula as we iterate through the array we update the count to be the count +
length of the subarray ehere sum is smaller than k , it will include all the subArrays having count smaller than k

This works because the subArrays with sum == k are goinf to subArrays with sum k - subArrays with sum k-1
     */
    public static void main(String[] args) {
        BruteForce(new int[]{1, 0, 1, 0, 1}, 2);
    }

    private static void BruteForce(int[] arr, int k) {
/*
Brute Force again here we will have to generate all sorts of SubArrays and then count those subArrays that have the sum to be k
 */
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == k) {
                    count++;
                }
                if (sum > k) {
                    break;
                }
            }
        }

        System.out.println("Count is " + count);
    }

    static void Optimized(int[] arr, int k) {
        int count = 0;
        int sum = 0;
        int left = 0;
        int right = 0;

        if(k < 0){
            System.out.println("Answer " + 0);
            return;
        }

        while (right < arr.length) {
            sum += arr[right];
            while (sum > k) {
                sum -= arr[left];
                left++;
            }
            count = count + (right - left + 1);
            right = right + 1;
        }
    }
}
