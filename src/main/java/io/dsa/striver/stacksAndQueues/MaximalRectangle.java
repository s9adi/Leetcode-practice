package io.dsa.striver.stacksAndQueues;

public class MaximalRectangle {
    /*
    Maximal rectangle that has all one's
    it can be reimagined as the problem of histogram where each layer of the 2-d matrix
    we create a function that accepts this layer and then operate on the 2-d matrix we also create a function
    we create a prefixSum array whose layers are we going to pass to the histogram function
     */
    private static void Solution(int[][] arr) {
        int maxArea = 0;
        int m = arr.length;
        int n = arr[0].length;
        int prefix[][] = new int[m][n];
        for (int j = 0; j < n; j++) {
            int sum = 0;
            for (int i = 0; i < m; i++) {
                sum += arr[i][j];
                if (arr[i][j] == 0) {
                    sum = 0;
                }
                prefix[i][j] = sum;
            }
        }

        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, Histogram(arr[i]));
        }
    }

    private static int Histogram(int[] arr) {
        return -1;
    }


}
