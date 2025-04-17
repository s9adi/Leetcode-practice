package io.dsa.striver.trees;

import java.util.*;

public class KDistanceNodes {
    static void markParents(TreeNode root, Map<TreeNode, TreeNode> parents, int k) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr.left != null) {
                parents.put(curr.left, curr);
                q.offer(curr.left);
            }
            if (curr.right != null) {
                parents.put(curr.right, curr);
                q.offer(curr.right);
            }
        }
    }

    static void nodesAtK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        markParents(root, map, k);
        Queue<TreeNode> q = new LinkedList<>();
        Map<TreeNode, Boolean> visited = new HashMap<>();
        visited.put(root, true);
        int currentDistance = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            TreeNode currentNode = q.poll();
            if (currentDistance == k) break;
            currentDistance++;

            for (int i = 0; i < size; i++) {
                if (currentNode.left != null && visited.get(currentNode.left) == null) {
                    q.offer(currentNode.left);
                    visited.put(currentNode, true);
                }
                if (currentNode.right != null && visited.get(currentNode.right) == null) {
                    q.offer(currentNode.right);
                    visited.put(currentNode.right, true);
                }
                if (map.get(currentNode) != null && visited.get(map.get(currentNode)) == null) {
                    q.offer(map.get(currentNode));
                    visited.put(map.get(currentNode), true);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < q.size(); i++) {
            res.add(q.poll().val);
        }
    }
}
