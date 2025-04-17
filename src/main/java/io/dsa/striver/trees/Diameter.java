package io.dsa.striver.trees;

public class Diameter {

    static int diameter = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int diameter = calculateDiameterBruteForce(root);
        System.out.println(diameter);

    }

    static int calculateDiameterBruteForce(TreeNode root) {
        if (root == null) return 0;

        int leftH = MaxDepth.depthOfTree(root.left);
        int rightH = MaxDepth.depthOfTree(root.right);

        diameter = Math.max(leftH + rightH, diameter);

        return 1 + Math.max(leftH, rightH);
    }

    static int helperBruteForce(TreeNode root) {
        calculateDiameterBruteForce(root);
        return diameter;
    }

    static int Optimized(TreeNode head) {
        int[] diameter = new int[1];
        helperOptimized(head, diameter);
        return diameter[0];
    }

    static int helperOptimized(TreeNode node, int[] diameter) {
        if (node == null) return 0;

        int lh = helperOptimized(node.left, diameter);
        int rh = helperOptimized(node.right, diameter);

        diameter[0] = Math.max(diameter[0], lh + rh);
        return 1 + Math.max(lh, rh);
    }

}
