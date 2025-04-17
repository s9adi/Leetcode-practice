package io.dsa.striver.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class FruitsInBaskets {
    /*
    We have to fill the two baskets and get the max of the elements
     */

    private static void optimized(int[] arr) {
        // Max SubArray with only 2 distinct elements
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < arr.length; right++) {
            // Add the current element to the map
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);

            // Shrink the window until there are at most 2 distinct elements
            while (map.size() > 2) {
                map.put(arr[left], map.get(arr[left]) - 1);
                if (map.get(arr[left]) == 0) {
                    map.remove(arr[left]);
                }
                left++;
            }

            // Update the maximum length of the subarray
            maxLen = Math.max(maxLen, right - left + 1);
        }

        System.out.println("Maximum Length of Subarray with at most 2 distinct elements: " + maxLen);
    }
}
