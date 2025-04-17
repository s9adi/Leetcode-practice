package io.dsa.striver.trees;

public class checkBalancedTree {

    static boolean BruteForce(TreeNode root) {
        if (root == null) {
            return true;
        }

        int lh = MaxDepth.depthOfTree(root.left);
        int rh = MaxDepth.depthOfTree(root.right);

        if (Math.abs(lh - rh) > 1) return false;

        boolean left = BruteForce(root.left);
        boolean right = BruteForce(root.right);


        if (left || right) return false;
        return true;

    }

    static boolean Optimized(TreeNode root) {
        return dfsHeight(root) == -1;
    }

    static int dfsHeight(TreeNode root) {
        if (root == null) return 0;

        int leftH = dfsHeight(root.left);
        if (leftH == -1) return -1;
        int rightH = dfsHeight(root.right);
        if (rightH == -1) return -1;

        if(Math.abs(leftH - rightH) > 1) return -1;
        return Math.max(leftH , rightH);
    }
}
