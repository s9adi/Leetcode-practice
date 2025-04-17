package io.dsa.neetcode150.Arrays;

import java.util.*;

public class LC_15_3Sum {
    public static void main(String[] args) {

    }

    private static void Solution(int[] nums) {
        // nums = [-1,0,1,2,-1,-4]
        // Output: [[-1,-1,2],[-1,0,1]]
        // return all the triplets such that the sum is 0
        // solution must not contain the duplicate triplets
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = i + 1; j < nums.length - 1; j++) {
                int complement = -(nums[i] + nums[j]);
                if (list.contains(complement)) {
                    set.add(Arrays.asList(nums[i], nums[j], complement));
                }
                list.add(nums[j]);

            }
        }

    }
}

