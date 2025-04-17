package io.dsa.striver.Arrays.Matrix;

public class SpiralMatrix {
    static void Solution(int[][] matrix) {

        int left = 0;
        int right = matrix[0].length;
        int bottom = matrix.length;
        int top = 0;

        while (true) {
            // print left to right
            // print top to bottom
            // print right to left
            // print bottom to left

            for (int i = left; i < right; i++) {
                System.out.println(matrix[i][top]);
            }
            top++;

            for (int i = top; i < bottom; i++) {
                System.out.println(matrix[i][right]);
            }
            right--;
        }

    }
}
