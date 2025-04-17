package io.dsa.striver.Arrays;

import java.util.ArrayList;
import java.util.List;

public class Leaders {

    public static void main(String[] args) {
        Optimal(new int [] {10,22,12,3,0,6});
    }

    static void BruteForce(int[] arr) {
        // we have to check if there is any large bigger element on the right if yes , it is not leader
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            boolean leader = true;
            int element = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > element) leader = false;
            }
            if (leader) res.add(element);
        }

        System.out.println(res);
    }

    static void Optimal(int[] arr){
        // i am thinking i will start the iteration from the right and calculated max till the index from the right
        // and if i encounter a number greater than the max that will be leader and update max

        int n = arr.length;
        int i = n-1;
        int max = Integer.MIN_VALUE;
        List<Integer> res = new ArrayList<>();

        while (i>=0 ){
            if (arr[i] > max){
                res.add(arr[i]);
                max = arr[i];
            }
            i--;
        }
        System.out.println(res);
    }
}
