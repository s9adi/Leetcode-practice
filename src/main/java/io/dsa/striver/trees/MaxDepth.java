package io.dsa.striver.trees;

public class MaxDepth {

    static int depthOfTree(TreeNode root) {
        /*
Max height is 1+ Max(left , right)  1 for the current node
         */
        if (root == null) {
            return 0;
        }

        int lh = depthOfTree(root.left);
        int rh = depthOfTree(root.right);

        return 1 + Math.max(lh, rh);
    }
}
