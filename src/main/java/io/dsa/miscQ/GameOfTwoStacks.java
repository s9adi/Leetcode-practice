package io.dsa.miscQ;

import java.util.List;

public class GameOfTwoStacks {
    public static void main(String[] args) {
    }
}

class ResultUsingRecursion {
    public static int twoStacks(List<Integer> list1, List<Integer> list2, int sum, int i1, int i, int maxSum) {
        int result = recurse(list1, list2, maxSum, 0, 0, 0);
        return result;
    }

    public static int recurse(List<Integer> list1, List<Integer> list2, int maxSum, int sum, int i, int j) {
        if (sum >= maxSum) {
            return 0;
        }
        if (i >= list1.size() || j >= list2.size()) {
            return 0;
        }
        int take1 = 0;
        if (i < list1.size()) {
            take1 = 1 + twoStacks(list1, list2, maxSum, sum + list1.get(i), i + 1, j);
        }
        int take2 = 0;
        if (j < list2.size()) {
            take2 = 1 + twoStacks(list1, list2, maxSum, sum + list2.get(j), i, j);
        }

        return Math.max(take1, take2);
    }
}

class ResultOptimized {
    public static int Solution(int maxSum, List<Integer> list1, List<Integer> list2) {
        // we have to first check how many elements can be reached using either of StackA or StackB and then
        // we have to repeat the operation for
        int sum = 0;
        int index1 = 0;
        int maxCount = 0;
        while (sum + list1.get(index1) <= maxSum && index1 <= list1.size()) {
            sum += list1.get(index1);
            maxCount++;
            index1--;
        }

        // now that we have reached the maxCount using the first stack
        // we can check for other stack

        // we have to remove the
        int index2 = 0;
        while (index2 < list2.size()) {
            sum = sum + list2.get(index2);
            index2++;
            while (sum > maxSum && index1 >= 0) {
                index1--;
                sum = sum - list2.get(index1);
            }
            if (sum <= maxSum) {
                maxCount = Math.max(maxCount, index1 + index2);
            }
        }
        return maxCount;
    }
}
