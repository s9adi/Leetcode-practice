package io.dsa.neetcode150.BitManipulation;

/*
Initialize result to 0.

Iterate through the array nums.

XOR result with each element in the array.

Since XORing a number with itself is 0 and XORing a
number with 0 is the number itself, pairs of numbers will cancel each other out, leaving only the single number.
 */
public class LC_136_SingleNumber {
    private static int Solution(int nums[]) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }
}
