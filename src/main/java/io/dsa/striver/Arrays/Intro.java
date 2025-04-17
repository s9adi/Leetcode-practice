package io.dsa.striver.Arrays;

import java.util.Arrays;

public class Intro {

    public static void main(String[] args) {
        //int[] arr = new int[]{1, 4, 6, 1, 2, 4, 6, 8, 5, 7, 2};
        int[] arr = new int[]{1, 2, 2, 2, 2, 2, 3, 5, 7, 8};
        //SecondLargestBest(arr);
        RemoveDupFromSorted(arr);
    }

    static void SecondLargestBruteForce(int[] arr) {
        Arrays.sort(arr);
        int i = arr.length - 1;
        while (i >= 0 && arr[i] == arr[i - 1]) {
            i--;
        }
        System.out.println(arr[i - 1]);
    }

    static void SecondLargestOptimized(int[] arr) {
        int second = Integer.MIN_VALUE;
        int first = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) first = Math.max(first, arr[i]);
        for (int i = 0; i < arr.length; i++) if (arr[i] > second && arr[i] < first) second = arr[i];
        System.out.println(second);
    }

    static void SecondLargestBest(int[] arr) {
        int f = arr[0];
        int s = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++)
            if (arr[i] > f) {
                s = f;
                f = arr[i];
            } else if (arr[i] > s && arr[i] < f) {
                s = arr[i];
            }
        System.out.println(s);
    }

    static void RemoveDupFromSorted(int[] arr) {
        int n = arr.length;
        if( n == 0 ) return ;
        System.out.println("Before");
        System.out.println("========");
        Arrays.stream(arr).forEach(s -> System.out.print(s + " "));
        int k = 1;
        for (int i = 1; i < n; i++)
            if (arr[i] != arr[i - 1]) {
                arr[k++] = arr[i];
            }
        for (int i = k; i < n; i++) arr[i] = 0;
        System.out.println("\nAfter");
        System.out.println("=========");
        Arrays.stream(arr).forEach(s -> System.out.print(s + " "));
    }


}