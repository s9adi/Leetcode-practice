package io.dsa.striver.trees;

import java.util.LinkedList;
import java.util.Queue;

public class SideView {

    static Queue<TreeNode> q = new LinkedList<>();

    static void rightView(TreeNode root, int level) {
        if (root == null) return;
        // We are going to be traversing from right to left using preorder Traversal that is Root Right Left
        if (level == q.size()) {
            q.offer(root);
        }
        rightView(root.right, level + 1);
        rightView(root.left, level + 1);
    }
}
