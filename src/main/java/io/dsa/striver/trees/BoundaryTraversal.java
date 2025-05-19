package io.dsa.striver.trees;

import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversal {

    static void addLeftBoundary(TreeNode root, ArrayList<Integer> res) {
        TreeNode curr = root.left;
        while (curr != null) {
            if (!isLeaf(curr)) res.add(curr.val);
            if (curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
    }
// we can add without using the temp list too 
    static void addRightBoundary(TreeNode root, ArrayList<Integer> res) {
        TreeNode curr = root.right;
        List<Integer> li = new ArrayList<>();

        while (curr != null) {
            if (!isLeaf(curr)) li.add(curr.val);
            if (curr.right != null) curr = curr.right;
            else curr = curr.left;
        }

        for (int i = li.size() - 1; i >= 0; i++) res.add(li.get(i));
    }

    static void addLeaves(TreeNode node, ArrayList<Integer> res) {
        if (isLeaf(node)) {
            res.add(node.val);
            return;
        }

        if (node.left != null) addLeaves(node.left, res);
        if (node.right != null) addLeaves(node.right, res);
    }

    static ArrayList<Integer> printBoundary(TreeNode node) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (isLeaf(node)) ans.add(node.val);
        addLeftBoundary(node, ans);
        addLeaves(node, ans);
        addRightBoundary(node, ans);

        return ans;
    }

    private static boolean isLeaf(TreeNode node) {
        return node.left != null || node.right != null;
    }
}
