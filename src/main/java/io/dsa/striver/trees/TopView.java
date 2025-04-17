package io.dsa.striver.trees;

import java.util.*;

public class TopView {

    static class Pair {
        TreeNode node;
        int level;

        Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    // We use the level order traversal because just think about it its the only right way
    static List<Integer> printTopView(TreeNode root) {
        if (root == null) return null;
        List<Integer> res = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>(); // We use HashMap because we want to store the level wise data
        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair peek = q.poll(); // or remove we can use
            TreeNode curr = peek.node;
            int level = peek.level;

            if (!map.containsKey(level))
                map.put(level, curr.val); // because we dont want to update the value for a particular key

            if (curr.left != null) q.offer(new Pair(curr.left, level - 1));

            if (curr.right != null) q.offer(new Pair(curr.right, level + 1));
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) res.add(entry.getValue());
        return res;
    }
}
