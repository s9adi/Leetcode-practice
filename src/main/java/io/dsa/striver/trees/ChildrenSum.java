package io.dsa.striver.trees;

public class ChildrenSum {

    static void changeTree(TreeNode node) {
        // we have to traverse first left and then right
        if (node == null) return;
        int child = 0;
        if (node.left != null) child += node.left.val;
        if (node.right != null) child += node.right.val;
        if (child > node.val) node.val = child;
        else {
            if (node.left != null) node.left.val = node.val;
            else if (node.right != null) node.right.val = node.val;
        }

        changeTree(node.left);
        changeTree(node.right);

        // while returning
        int tot = 0;
        if (node.left != null) tot += node.left.val;
        if (node.right != null) tot += node.right.val;
        if (node.left != null || node.right != null) node.val = tot;
    }
}
