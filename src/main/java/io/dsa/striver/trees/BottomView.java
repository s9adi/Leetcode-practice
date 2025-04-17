package io.dsa.striver.trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BottomView {
    static class Pair {
        TreeNode node;
        int level;

        Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    static void printBottomView(TreeNode node) {
        Queue<Pair> q = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        q.offer(new Pair(node, 0));

        while (!q.isEmpty()) {
            Pair pair = q.poll();
            TreeNode current = pair.node;
            int level = pair.level;

            map.put(level, current.val);
            if (current.left != null) q.offer(new Pair(current.left, level - 1));
            if (current.right != null) q.offer(new Pair(current.right, level + 1));

        }
    }
}
