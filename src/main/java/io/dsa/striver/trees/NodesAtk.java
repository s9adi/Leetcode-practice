package io.dsa.striver.trees;

import java.util.*;

public class NodesAtk {
    static void markParents(TreeNode root, Map<TreeNode, TreeNode> parent, TreeNode target) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode current = q.poll();
            if (current.left != null) {
                parent.put(current.left, current);
                q.offer(current.left);
            }
            if (current.right != null) {
                parent.put(current.right, current);
                q.offer(current.right);
            }
        }
    }

    static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentsTrack = new HashMap<>();
        markParents(root, parentsTrack, target);
        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        visited.put(target, true);
        int curr_level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            if (curr_level == k) break;
            curr_level++;
            for (int i = 0; i < size; i++) {
                TreeNode current = q.poll();
                if (current.left != null && visited.get(current.left) == null) {
                    q.offer(current.left);
                    visited.put(current.left, true);
                }
                if (current.right != null && visited.get(current.right) == null) {
                    q.offer(current.right);
                    visited.put(current.right, true);
                }
                if (parentsTrack.get(current) != null && visited.get(parentsTrack.get(current)) == null) {
                    q.offer(parentsTrack.get(current));
                    visited.put(parentsTrack.get(current), true);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < q.size(); i++) {
            res.add(q.poll().val);
        }

        return res;
    }
}
