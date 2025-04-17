package io.dsa.striver.Arrays;

import java.util.Arrays;

public class LeftRotateArray {
    public static void main(String[] args) {
        ByKPlace(new int[]{1, 2, 3, 4, 5} , 1);
    }

    static void ByOnePlace(int[] arr) {
        // Left Rotate an array
        // 1 2 3 4 5 -> 2 3 4 5 1

        System.out.println("\nBefore");
        System.out.println("=========");
        Arrays.stream(arr).forEach(s -> System.out.print(s + " "));

        int temp = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = temp;

        System.out.println("\nAfter");
        System.out.println("=========");
        Arrays.stream(arr).forEach(s -> System.out.print(s + " "));
    }

    static void ByKPlace(int[] arr, int k) {
        // k can be anything
        int n = arr.length;
        k = k % n;
        System.out.println("\nBefore");
        System.out.println("=========");
        Arrays.stream(arr).forEach(s -> System.out.print(s + " "));
        int count = 0 ;
        while (count < k){
            count ++;
            int temp = arr[0];
            for (int j = 0 ; j < arr.length - 1 ; j++){
                arr[j] = arr[j+1];
            }
            arr[n-1] = temp ;
        }
        System.out.println("\nAfter");
        System.out.println("=========");
        Arrays.stream(arr).forEach(s -> System.out.print(s + " "));
    }
}
