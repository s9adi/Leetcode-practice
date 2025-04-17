package io.dsa.striver.Arrays.Matrix;

import java.util.Arrays;

public class SpiralMatrix2 {
    public static void main(String[] args) {
       generate(3);
    }
    static void generate(int n) {
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        int[][] matrix = new int[n][n];
        int count = 1;
        while (left <= right && top<=bottom) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = count;
                count++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = count;
                count++;
            }
            right--;
            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = count++;
            }
            bottom--;

            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = count++;
            }
            left++;

        }

        System.out.println(Arrays.deepToString(matrix));
    }
}
