package io.dsa.striver.trees;

public class MaxPathSunLeafNodes {

    public static void main(String[] args) {

    }

    static void maxPathSum(TreeNode head) {
        // we have to find the max path sum between 2 leaf nodes
        // at any node the pax path Sum will be equal to the max-leftSum and the max-rightSum
        // if the node is null then we can just return 0
        // if the left is null and right is null then we can return the value ?
        int[] maxSum = new int[1];
        maxSum[0] = Integer.MAX_VALUE;
        helper(head, maxSum);
    }

    static int helper(TreeNode node, int[] arr) {
        if (node == null) return 0;
        // at a particular location we can either go left and either go right
        int leftSum = helper(node.left, arr);
        int rightSum = helper(node.right, arr);

        arr[0] = Math.max(arr[0], rightSum + leftSum + node.val);
        return node.val + Math.max(rightSum, leftSum);
    }
}
