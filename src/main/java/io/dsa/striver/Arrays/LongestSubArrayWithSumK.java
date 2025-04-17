package io.dsa.striver.Arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithSumK {
    static void BruteForce(int[] arr, int k) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) { // starting with this index
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum = sum + arr[j];
                if (sum == k) {
                    count = Math.max(count, (j - i) + 1);
                }
            }
        }
    }

    static void Optimal(int[] arr, int k) {
        // prefix sum -> Called Hashing i dont know why ?
        // we store the sum of the elements till that index there
        // and search for the map[i] - element[i]

        Map<Integer, Integer> prefixSum = new HashMap<>();
        int prefixS = 0;
        int len = 0;

        for (int i = 0; i < arr.length; i++) {
            prefixS += arr[i];

            if (prefixS == k) {
                len = i + 1;
            }

            int rem = prefixS - k;
            if (prefixSum.containsKey(rem)) { // if the remaining sum required is there in the map that means
                len = Math.max(len, i - prefixSum.get(rem));
            }

            if (!prefixSum.containsKey(prefixS)) {
                prefixSum.put(prefixS, i);
            }
        }


    }

    static void TwoPointer(int[] arr, int k) {
        int sum = 0;
        int l = 0;
        int r = 0;
        int len = 0;

       while(r < arr.length){
           while (sum > k && l <= r){
               sum -= arr[l];
               l++;
           }
           if(sum == k){
               len = Math.max(len , r-l+1);
           }
           if(r< arr.length){
               sum += arr[r];
               r++;
           }
       }
    }
}
