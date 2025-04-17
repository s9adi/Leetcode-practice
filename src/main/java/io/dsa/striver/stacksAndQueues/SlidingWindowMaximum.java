package io.dsa.striver.stacksAndQueues;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SlidingWindowMaximum {
    public static void main(String[] args) {

    }

    private static void BruteForce(int[] arr, int k) {
        int n = arr.length;
        int max = arr[0];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n - k; i++) {
            for (int j = i; j < i + k - 1; j++) {
                max = Math.max(max, arr[j]);
            }
            list.add(max);
        }
    }

    /*
What we can do is we keep track of K elements at once and trim off the rest , i need a data structure that adds and
deletes , imagine i am at a window in the array and to get the max i will have to scan through all the elements
and that is what was taking time , we dont want that we want a data structure that can add and delete from both ends
We have to store the elements in  decreasing order , whenever we have to find the elements like greatest or the smallest
that where we need monotonic stack.

what we are going to be doing is that we store the index of the elements in decreasing order (for the lookup)
and as soon as the element is not required in the window we skip that element remove that element.
Also when we get an element that is larger than we can remove the smaller numbers(indexes) from the stack
we remove elements that are out of boundary
     */
    private static void Optimized(int[] arr, int k) {
        int n = arr.length;
        int[] r = new int[n - k + 1];
        int ri = 0;

        Deque<Integer> deck = new ArrayDeque<>();

        for (int i = 0; i < arr.length; i++) {
            // remove nums out of range
            if (!deck.isEmpty() && deck.peek() == i - k) {
                deck.poll();
            }
            // remove smaller elements

            while (!deck.isEmpty() && arr[deck.peekLast()] < arr[i]) {
                deck.pollLast();
            }

            deck.offer(i);

            if (i>=k-1){
                r[ri++] = deck.peekFirst();
            }

        }
    }
}
