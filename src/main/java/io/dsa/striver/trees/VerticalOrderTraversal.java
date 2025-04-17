package io.dsa.striver.trees;


import java.util.*;

class Tuple {
    TreeNode node;
    int row;
    int column;

    Tuple(TreeNode node, int i, int j) {
        this.node = node;
        this.row = i;
        this.column = j;
    }
}

public class VerticalOrderTraversal {

    static List<List<Integer>> traversal(TreeNode node) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();

        q.offer(new Tuple(node, 0, 0));

        while (!q.isEmpty()) {
            Tuple tuple = q.poll();
            TreeNode curr = tuple.node;

            int x = tuple.row;
            int y = tuple.column;

            if (!map.containsKey(x)) map.put(x, new TreeMap<>());

            if (!map.get(x).containsKey(y)) map.get(x).put(y, new PriorityQueue<>());
            map.get(x).get(y).offer(node.val);

            if (node.left != null) q.offer(new Tuple(node.left, x - 1, y + 1));

            if (node.right != null) q.offer(new Tuple(node.left, x + 1, y + 1));

        }

        List<List<Integer>> list = new ArrayList<>();
// I have to store the output in the list now iterate over the queue and store them in the list
        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
            list.add(new ArrayList<>());
            for (PriorityQueue<Integer> nodes : ys.values()) {
                while (!nodes.isEmpty()) {
                    System.out.println("Value ->" + " " + nodes.peek());
                    list.get(list.size() - 1).add(nodes.poll());
                }
            }
        }


        return list;
    }
}
