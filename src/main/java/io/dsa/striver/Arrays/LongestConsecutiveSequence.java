package io.dsa.striver.Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        Optimal(new int[]{2, 1, 3, 7, 4, 100, 102, 101});
    }

    static void Better(int[] arr) {

        // Better Approach is we sort the array and then we traverse it
        // we take lastSmaller element to be the first element and then compare it with each
        // if the lastsmaller is equal to current+1 then we can increase the len
        // if not then we can just make it 1 -> start again

        Arrays.sort(arr);
        int len = 1;
        int lastSamller = arr[0];
        int longest = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (lastSamller + 1 == arr[i]) {
                len++;
                lastSamller = arr[i];
            } else if (lastSamller != arr[i]) {
                len = 1;
                lastSamller = arr[i];
            }
            longest = Math.max(len, longest);

        }
        System.out.println("Longest " + longest);
    }

    static void Optimal(int[] arr) {


        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num); // Add all elements to the set
        }

        int maxLen = 0;

        for (int num : set) {
            // Start of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int count = 1;

                // Count consecutive numbers
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }
                maxLen = Math.max(maxLen, count);
            }
        }

        System.out.println("MaxLen: " + maxLen);

    }
}
