package io.dsa.striver.trees;

public class MaxPath {
    // we are using a global variable to store the maxSum
    static int maxSum = 0;

    public static void main(String[] args) {
        TreeNode head = TreeNodeUtil.getTreeNode();
        int max = driver(head);

        System.out.println("Max" + " " + max);
    }

    static int maxPathSum(TreeNode node) {
        if (node == null) return 0;

        int leftSum = maxPathSum(node.left);
        int rightSum = maxPathSum(node.right);

        maxSum = Math.max(maxSum, node.val + leftSum + rightSum);

        return node.val + Math.max(leftSum, rightSum);
    }

    static int driver(TreeNode head) {
        maxSum = Integer.MIN_VALUE;
        maxPathSum(head);
        return maxSum;
    }
}
