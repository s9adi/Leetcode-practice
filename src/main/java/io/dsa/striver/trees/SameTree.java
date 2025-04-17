package io.dsa.striver.trees;

public class SameTree {
    static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) return p == q;

        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.left, q.left);
    }
}
