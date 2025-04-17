package io.dsa.striver.recursion;

import java.util.ArrayList;
import java.util.List;

public class PermutuationsOfArray {
    public static void main(String[] args) {
/*
Input: arr[] = {1, 2, 3}
Output: {1, 2, 3}, {1, 3, 2}, {2, 1, 3}, {2, 3, 1}, {3, 2, 1}, {3, 1, 2}

We can have the first element to be taken by either of the given array
Then once that is picked then we can chose other elements.

The moment we reach where all the elements are picked then the base case is reached and then go back and unmark the element
and throw that out
 */
    }

    static List<List<Integer>> Solution(int[] array) {
        boolean[] freq = new boolean[array.length];
        List<List<Integer>> res = new ArrayList<>();

        helper(array, res, new ArrayList<>(), freq);

        return res;
    }

    static void helper(int[] arr, List<List<Integer>> res, List<Integer> list, boolean[] freq) {
        if (list.size() == arr.length) {
            res.add(list);
            return;
        }

        for (int i = 0; i <arr.length ; i++) {
            if(freq[i] != true){
                // that means this particular element is not yet used
                // so first mark it as true
                freq[i] = true;

                list.add(arr[i]);
                helper(arr , res , list , freq);
                list.remove(list.size() - 1);

                freq[i] = false;
            }
        }
    }
}


class PermutuationOfString {
    static void Solution(int[] arr){

    }

    static void backTrack(int[] arr , boolean[] freq , List<List<Integer>> res , List<Integer> list){
        if (list.size() == arr.length){
            res.add(new ArrayList<>(list));
            return; // to explore more
        }
/*
We iterate over the elements that we can add to the current set(ds) and then we add that element and start the recursion
with that element in. Once the recursion comes back we remove that element from the ds and the unmark that element
                A    B    C    D
               /
              /
         AB AC AD
         (Returning can it explore more yes , ABD)
         /  |  \
        /   |   \
      ABC  ACB  ADB
     (when returns can it explore more ? , No Return )
     (Along with others)
       |
       |
       ABCD (Base Case Reached , return )


       loop is basically to explore what next can we put or pick , recursive call is to explore the next elements
       that can be added in the current ds and backtrack is to remove what we added so that we can explore without the current
       element that we added

 */
        for (int i = 0 ; i < arr.length ; i++){
            if (freq[i] == false){ // that means that we can use it
                // first mark it as true
                freq[i] = true;
                list.add(i);
                backTrack(arr, freq , res , list);
                list.remove(list.size() - 1);
                freq[i] = false;
            }
        }
    }
}