package io.dsa.striver.trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BurnTree {

    static int timeToBurnTree(TreeNode root, int start) {
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        TreeNode target = bfsToMapParents(root, start, map);
        int max = findMaxDistance(map, target);
        return max;
    }

    private static int findMaxDistance(HashMap<TreeNode, TreeNode> parents, TreeNode target) {
        // we have to find the maxDistance that means that we have to see how many times it takes to burn down the whole tree
        // one node will burn all the adjacent nodes that is it will burn parent and both child (if any)
        // we will have to keep a map to see if it is visited or not (burnt or not)

        HashMap<TreeNode, Boolean> burntNodes = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        burntNodes.put(target, true);
        int distance = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            int fl = 0;
            TreeNode currentNode = q.poll();
            for (int i = 0; i < size; i++) {
                // we go left , right , top
                if (currentNode.left != null && burntNodes.get(currentNode.left) == null) {
                    fl = 1;
                    burntNodes.put(currentNode.left, true);
                    q.offer(currentNode.left);
                }
                if (currentNode.right != null && burntNodes.get(currentNode.right) == null) {
                    fl = 1;
                    burntNodes.put(currentNode.right, true);
                    q.offer(currentNode.right);
                }
                if (parents.get(currentNode) != null && burntNodes.get(parents.get(currentNode)) == null) {
                    fl = 1;
                    burntNodes.put(parents.get(currentNode), true);
                    q.offer(parents.get(currentNode));
                }

            }
            if (fl == 1) distance++;
        }
        return distance;
    }

    private static TreeNode bfsToMapParents(TreeNode root, int start, HashMap<TreeNode, TreeNode> map) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode target = null;
        // We are going to store the root of the nodes
        // and find the target Node
        while (!q.isEmpty()) {
            int size = q.size();
            TreeNode currentNode = q.poll();
            if (currentNode.val == start) target = currentNode;
            for (int i = 0; i < size; i++) {
                if (currentNode.left != null) {
                    map.put(currentNode.left, currentNode);
                    q.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    map.put(currentNode.right, currentNode);
                    q.offer(currentNode.right);
                }
            }
        }
        return target;
    }
}
