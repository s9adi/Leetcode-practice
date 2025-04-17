package io.dsa.striver.trees;

import java.util.ArrayList;
import java.util.List;

public class Root2Node {

    static List<Integer> printRoot2Node(TreeNode root, int x) {
        List<Integer> res = new ArrayList<>();
        if (getPath(root, x, res))
            return res;
        else
            return null;
    }

    static boolean getPath(TreeNode node, int x, List<Integer> res) {
        if (node == null) return false;
        res.add(node.val);
        if (node.val == x) return true;
        if (getPath(node.left, x, res) || getPath(node.right, x, res)) return true;
        res.remove(res.size() - 1);
        return false;
    }
}
