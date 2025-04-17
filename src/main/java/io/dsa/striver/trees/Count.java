package io.dsa.striver.trees;

public class Count {
    static int completeTreeNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // Calculate left and right heights
        int left = getLeftHeight(root);
        int right = getRightHeight(root);

        // If left and right heights are equal, it is a complete binary tree
        if (left == right) {
            return (1 << left) - 1; // Corrected formula for 2^left - 1
        }

        // Otherwise, recursively calculate the number of nodes
        return completeTreeNodes(root.left) + completeTreeNodes(root.right) + 1;
    }

    private static int getLeftHeight(TreeNode root) {
        int count = 0;
        while (root != null) {
            count++;
            root = root.left;
        }
        return count;
    }

    private static int getRightHeight(TreeNode root) {
        int count = 0;
        while (root != null) {
            count++;
            root = root.right;
        }
        return count;
    }
}