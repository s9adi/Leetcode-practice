package io.dsa.striver.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFS {
    // Iterative
    static List<Integer> preorder(TreeNode treeNode) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (treeNode == null) return res;
        stack.push(treeNode);

        while (!stack.isEmpty()) {
            // 1. store the node in the stack
            // 2. print the root of the current node
            // 3. Go right store it ,
            treeNode = stack.pop();
            res.add(treeNode.val);
            if (treeNode.right != null) stack.push(treeNode.right);
            if (treeNode.left != null) stack.push(treeNode.left);
        }

        return res;
    }

    static List<Integer> inorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;

        while (!stack.isEmpty()) {
            if (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            } else {
                if (stack.isEmpty()) break;
                treeNode = stack.peek();
                res.add(treeNode.val);
                treeNode = treeNode.right;
            }
        }

        return res;
    }

    static List<Integer> postorder(TreeNode root) {
        /*
    In postorder we traverse left , right , root
    Here we use 2 Stacks
    1. We put the first node to be in the stack1
    2. We check stack1 , top element -> stack2, if the left is there store it in the stack1 , if right is there store in stack1
         */
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        List<Integer> res = new ArrayList<>();

        if (root == null) return res;

        s1.push(root);

        while (!s1.isEmpty()) {
            root = s1.peek();
            s2.push(s1.peek());
            if (root.left != null) s1.push(root.left);
            if (root.right != null) s2.push(root.right);
        }

        while (!s2.isEmpty()) res.add(s2.pop().val);
        return res;
    }

    static List<Integer> postorderOneStack(TreeNode root) {
        // i will print the extreme left when there is nothing else left at left
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        List<Integer> res = new ArrayList<>();
        while (!stack.isEmpty() && curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode temp = stack.peek().right; // when right elements are there then the below loop wont be executed
                if (temp == null) { // no elements to the right
                    temp = stack.peek();
                    stack.pop();
                    res.add(temp.val);
                    while (!stack.isEmpty() && stack.peek() == temp.right) {
                        temp = stack.peek();
                        stack.pop();
                        res.add(temp.val);
                    }
                }
            }


        }

        return res;
    }

}
