package io.dsa.striver.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class SubArraysWithKDifferentInteger {
    public static void main(String[] args) {

    }

    static void BruteForce(int[] arr, int k) {
        /*
Generate All SubArrays
         */
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i; j < arr.length; j++) {
                if (map.size() == k) {
                    count = count + 1;
                }
                if (map.size() > k) {
                    break;
                }
            }
        }

        System.out.println("Count" + " " + count);
    }

    static void Optimized(int[] arr, int k) {
        /*
 Typical 2 pointer won't work here as we might have sum duplicate integers
         */

        int right = 0;
        int left = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while (right < arr.length) {
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);
            while (map.size() > k) {
                map.put(arr[left], map.getOrDefault(arr[left], 0) - 1);

                if (map.get(arr[left]) < 0) {
                    map.remove(arr[left]);
                }

                left++;
            }

            if (map.size() <= k) {
                count = count + (right - left + 1);
            }
            right++;
        }
    }
}
