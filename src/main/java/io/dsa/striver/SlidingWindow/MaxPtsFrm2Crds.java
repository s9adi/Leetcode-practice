package io.dsa.striver.SlidingWindow;

public class MaxPtsFrm2Crds {

    public static void main(String[] args) {
        BruteForce(new int[]{1, 2, 3, 4, 12, 4, 4, 5}, 3);
    }

    static void BruteForce(int[] arr, int k) {
        // maxSum to store the maximum sum
        int maxSum = 0;

        // Variables to keep track of left and right sums
        int rSum = 0;
        int lSum = 0;

        // Initialize variables for left and right pointers
        int l = k - 1; // Left pointer starts at the kth index
        int r = arr.length - 1; // Right pointer starts at the end of the array
        int n = arr.length; // Length of the array

        // Calculate the initial left sum for the first k elements
        for (int i = 0; i < k; i++) {
            lSum += arr[i];
        }

        maxSum = lSum; // Initialize maxSum with the initial left sum

        // Add elements from the right while removing elements from the left
        while (r >= n - k) {
            rSum += arr[r]; // Add the element from the right to rSum
            lSum -= arr[l]; // Remove the element from the left side of lSum
            l--; // Move left pointer one step back
            r--; // Move right pointer one step back

            // Update maxSum with the maximum of the current sums
            maxSum = Math.max(maxSum, rSum + lSum);
        }

        System.out.println("maxSum - " + maxSum); // Print the maximum sum
    }
}
