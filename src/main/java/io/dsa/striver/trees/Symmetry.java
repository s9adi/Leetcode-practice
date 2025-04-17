package io.dsa.striver.trees;

public class Symmetry {

    static boolean checkForSymmetricTree(TreeNode head) {
        // We will do Root Left Right
        // and Root Right Left all together and if the nodes does not match then
        return head == null || helper(head.left, head.right);

    }

    static boolean helper(TreeNode left, TreeNode right) {
        if (left == null || right == null) return left == right;

        if (left.val != right.val) return false;

        return helper(left.left, right.right) || helper(left.right, right.left);
    }
}
