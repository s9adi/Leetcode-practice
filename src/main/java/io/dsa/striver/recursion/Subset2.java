package io.dsa.striver.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset2 {
    /*
    Input: nums = [1,2,2]
    Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]


Array may contain the duplicates and the subset should not be duplicate

The easiest way of doing it to maybe Have a Set of List and the List needs to be sorted here

The Other way is that we sort the array first this will make all the same nums together
Now we can either take this current element or not to form a subset.
     */
    public static void main(String[] args) {
        List<List<Integer>> solution = Solution(new int[]{1, 2, 3});
        System.out.println(solution);
    }

    static List<List<Integer>> Solution(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        helper(arr, 0, new ArrayList<>(), res);
        return res;
    }

    static void helper(int[] arr, int index, List<Integer> list, List<List<Integer>> res) {
        res.add(new ArrayList<>(list));

// we have to traverse from the index that we are on to the end of the list
        for (int i = index; i < arr.length; i++) {
            // at a particular index we are checking if we can add this to the ds
            if ( i > index && arr[i] == arr[i - 1] )
                continue;
            // the above condition means that if the prev and curr elements are same and the loop has not started with the current element then continue

            list.add(arr[i]);
            helper(arr, index + 1, list, res);
            list.remove(list.size() - 1); // for next recursion call this element should not be there

        }
    }
}
