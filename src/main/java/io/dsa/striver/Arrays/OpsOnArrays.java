package io.dsa.striver.Arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OpsOnArrays {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 4, 4, 5};
        int[] arr2 = new int[]{3, 3, 4, 5, 6, 6, 8};


    }

    static void BruteForceUnion(int[] arr, int[] arr2) {

// 2 sorted arrays - union meaning what element that are there in both

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            set.add(arr[i]);
        }

        // This Set is the union
    }

    static List<Integer> OptimalUnion(int[] arr, int[] arr2) {
        int i = 0;
        int j = 0;
        List<Integer> res = new ArrayList<>();

        while (i < arr.length && j < arr2.length) {
            if (arr[i] >= arr2[j]) {
                if (res.isEmpty() || res.get(res.size() - 1) != arr2[j]) {
                    res.add(arr2[j]);
                }
                j++;
            } else {
                if (res.isEmpty() || res.get(res.size() - 1) != arr[i]) {
                    res.add(arr[i]);
                }
                i++;
            }
        }

        while (i < arr.length) {
            if (res.get(res.size() - 1) != arr[i]) {
                res.add(arr[i]);
            }
            i++;
        }

        while (j < arr2.length) {
            if (res.get(res.size() - 1) != arr2[j]) {
                res.add(arr2[j]);
            }
            j++;
        }

        return res;
    }

    static void BruteForceIntersection(int[] arr, int[] arr2) {
        int n1 = arr.length;
        int n2 = arr2.length;
        int[] visited = new int[n2];

        List<Integer> ds = new ArrayList<>();

        for (int i = 0; i < n2; i++) arr[i] = 0;

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                // check if the element is there , if it is mark it as visited and if not
                // then
                if (arr[i] == arr2[j] && visited[j] == 0) {
                    visited[j] = 1;
                    ds.add(arr2[j]);
                    break;
                }
                if (arr[j] > arr[i]) {
                    break;
                }
            }
        }
    }

    static List<Integer> IntersectionOptimal(int[] arr, int[] arr2) {
        int n1 = 0;
        int n2 = 0;
        List<Integer> ds = new ArrayList<>();

        while (n1 < arr.length && n2 < arr.length) {
            if (arr[n1] > arr2[n2]) {
                n2++;
            } else if (arr[n1] < arr[n2]) {
                n1++;
            } else {
                ds.add(arr[n1]);
                n1++;
                n2++;
            }
        }

        return ds;
    }


}
