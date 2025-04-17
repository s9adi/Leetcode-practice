package io.dsa.striver.Arrays;

import java.util.Arrays;

public class MoveAll0s {
    public static void main(String[] args) {
        optimal(new int[]{1, 2, 4, 5, 6, 0, 0, 1, 0, 14, 0});
    }

    static void brute(int[] arr) {

        int[] arr2 = new int[arr.length];
        int count = 0;
        int start = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr2[start++] = arr[i];
            } else {
                count++;
            }
        }

        while (count > 0) {
            arr2[start++] = 0;
            count--;
        }
        Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
        System.out.println();
        Arrays.stream(arr2).forEach(x -> System.out.print(x + " "));
    }

    static void optimal(int[] arr) {
        int pointer = 0;
        Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
        System.out.println();

        /*
        We Keep left pointer at the first 0 position and the right pointer at the very next element
        and then just swap
         */
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[j++] = temp;
            }
        }

        Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
    }

    static void swap(int[] arr, int k, int v) {

        int temp = arr[k];
        arr[k] = arr[v];
        arr[v] = temp;
    }
}
