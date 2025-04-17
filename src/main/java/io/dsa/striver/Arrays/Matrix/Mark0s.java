package io.dsa.striver.Arrays.Matrix;

public class Mark0s {
    /*
    Mark 0 the whole row and column with 0 int it
     */
    static void BruteForce(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    MarkRows(matrix, i);
                    MarkColumns(matrix, j);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    static void MarkRows(int[][] arr, int row) {
        for (int j = 0; j < arr[row].length; j++) {
            if (arr[row][j] != 0) {
                arr[row][j] = -1;
            }
        }
    }

    static void MarkColumns(int[][] arr, int column) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][column] != 0) {
                arr[i][column] = -1;
            }
        }
    }

    /*
    Brute Force is 0(n3) but what if we can just eliminate the marking part
    if there is even a single 0 in the row and column we can just mark it , and later update the
    values
    We can have 2 arrays one column array and one row array to keep track of this to mark it
    1. Iterate the matrix and search for 0 and when there is a zero -> mark the column and the row
    2. Re-iterate the array and mark if only if the row or the column is marked to be zero then we can marke the
       respective cell to be 0


    More Optimized Approach
    instead of Taking the row and column outside we can take it inside
    This makes the first row and column intersection as common for both , we can take the column variable instead
     */

    static void Optimal(int[][] matrix) {
        int[] rows = new int[matrix.length];
        int[] columns = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = 0;
                    columns[j] = 0;
                }
            }

        for (int i = 0 ; i < matrix.length ; i++)
            for (int j = 0 ; j < matrix[0].length ; j++){
                if (rows[i] == 0 || columns[j] == 0){
                    matrix[i][j] = 0;
                }
            }
    }
}
