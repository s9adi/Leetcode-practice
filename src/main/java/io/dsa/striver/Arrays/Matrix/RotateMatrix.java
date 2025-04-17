package io.dsa.striver.Arrays.Matrix;

import java.util.Collection;

public class RotateMatrix {
    static void BruteForce(int[] arr) {
// We can have extra matrix and then fill each record
    }

    static void Optimal(int[][] matrix) {

        // Transpose the matrix

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                swap(matrix, i, j);
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            int j = 0;
            while (j < matrix.length) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - j - 1];
                matrix[i][matrix.length - j - 1] = temp;
            }
        }
    }

    private static void swap(int[][] matrix, int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }


}
