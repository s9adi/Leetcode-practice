package io.dsa.striver.trees;

import java.util.LinkedList;
import java.util.Queue;

public class Width {
    static class Pair {
        TreeNode node;
        int level;

        Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    static int maxWidthOfTree(TreeNode node) {
//  if the node is null we can just return 0
        if (node == null) return 0;
        int width = 0;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(node, 0));
// we add the first element in the queue
// so while the q is not empty we have to add the elements in the list and update the level
// now run the loop will the queue is empty to fill the whole queue
        while (!q.isEmpty()) {
            int size = q.size();
            int min = q.peek().level;
            int first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                int currentId = q.peek().level - min;
                TreeNode treeNode = q.peek().node;
                q.poll();
        // if the nodes is the first we can assign the first to be the current id
        // to assign the last we wait for the i to be size - 1 last =currentId
                if (i == 0) first = currentId;
                if (i == size - 1) last = currentId;
                if (node.left != null) q.offer(new Pair(node.left, currentId * 2 + 1));
                if (node.right != null) q.offer(new Pair(node.left, currentId * 2 + 2));
            }
            width = Math.max(width, last - first + 1);
        }
        return width;
    }
}
