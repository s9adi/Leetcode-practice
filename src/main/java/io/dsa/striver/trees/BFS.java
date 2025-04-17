package io.dsa.striver.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
// For BFS we use Queue because we need to take out the elements that we are adding in the same order
public class BFS {

    static List<List<Integer>> levelOrderTraversal(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> list = new ArrayList<>();

        if (root == null) return list;
        queue.offer(root);

        while (!queue.isEmpty()) {

            // we remove the element from the queue top and if left exist put that in the queue
            // if right exists put that in queue

            int levelNum = queue.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < levelNum; i++) {
                if (queue.peek().left != null) queue.offer(queue.peek().left);
                if (queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            list.add(subList);
        }
        return list;
    }
}
