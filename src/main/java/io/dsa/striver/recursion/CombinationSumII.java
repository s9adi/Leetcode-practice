package io.dsa.striver.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    /*
arr =  [10,1,2,7,6,1,5], target = 8
We can start from either of the index and once we start from the index we have to take account of the furthur elements that are
going to come.
At each position we can either include that index element or not
At each index we have to loop from that index to the len of the array
If you picked up a particular element then you will call the BackTrack for i+1 not i as you have picked up the element
     */
    public static void main(String[] args) {

    }

    static void Solution(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        BackTrack(arr, target, 0, res, new ArrayList<>());
    }


    static void BackTrack(int[] arr, int target, int index, List<List<Integer>> res, List<Integer> list) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
        }

        for (int i = index; i < arr.length; i++) {
            if (arr[i] == arr[i - 1] && i > index)
                continue; // we are putting this check because if it is the first element then it will be picked irrespective but this check is for the second repeating element
            if (arr[i] > target) break;

            list.add(arr[i]);
            // now we explore more
            BackTrack(arr, target - arr[i], i + 1, res, list);
            list.remove(list.size() - 1);
        }
    }
}
