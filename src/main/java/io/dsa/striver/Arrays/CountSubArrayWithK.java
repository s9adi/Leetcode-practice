package io.dsa.striver.Arrays;

import java.util.HashMap;
import java.util.Map;

public class CountSubArrayWithK {
    static void Optimal(int[] arr, int k) {

        Map<Integer, Integer> pSum = new HashMap<>();
        int sum = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum == k) {
                count++;
            }

            int req = sum - k;


            if (pSum.containsKey(req)) {
                count += pSum.get(req);
            }

            pSum.put(sum, pSum.getOrDefault(sum, 0) + 1);
        }
    }
}
