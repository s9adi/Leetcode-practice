package io.dsa.leetcodeList.trees;

import io.dsa.striver.trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    // BFS
    static void Solution(TreeNode node) {
        // Queue to store the levels
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> res = new ArrayList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                assert queue.peek() != null;
                if (queue.peek().left != null) queue.offer(queue.peek().left);
                assert queue.peek() != null;
                if (queue.peek().right != null) queue.offer(queue.peek().right);

                list.add(queue.poll().val);
            }
            res.add(list);
        }
    }
}
