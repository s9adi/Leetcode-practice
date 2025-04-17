package io.dsa.striver.stacksAndQueues;

public class SumOfSubArrayRanges {
    /*
    [1 4 3 2]
     */
    private static int BruteForce(int[] arr) {
// range means the difference in highest and the lowest elements
// that can mean that Sum of all the highest elements and sum of all the lowest elements for all the sub-arrays

        int sumOfMins = SumOfSubArrayMins.Optimized(arr);
        int sumOfMaxs = SumOfSubArrayMaximum.Optimized(arr);

        return sumOfMaxs - sumOfMins;
    }

}

class BruteForce {
    private static int Solution(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int smallest = arr[i];
            int largest = arr[i];
            for (int j = i; j < arr.length; j++) {
                smallest = Math.min(smallest, arr[j]);
                largest = Math.max(largest, arr[j]);

                int diff = largest - smallest;
                sum += sum = diff;
            }
        }
        return sum;
    }
}
