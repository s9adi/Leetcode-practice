package io.dsa.striver.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZag {

    static void traversal(TreeNode node) {
        if (node == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        queue.offer(node);
        boolean rightDirection = true;

        while (!queue.isEmpty()) {

           
        }
    }
}
