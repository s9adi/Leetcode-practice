package io.dsa.leetcodeList.trees;

import io.dsa.striver.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LevelOrderTraversal2 {
    public static void main(String[] args) {

    }
    static void Solution(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        List<List<Integer>> res = new ArrayList<>();

        while (!stack.isEmpty()){
            int size = stack.size();
            List<Integer> subList = new ArrayList<>();

            for (int i = 0 ; i < size ; i++){
                if(stack.peek().left != null) stack.push(stack.pop())
            }
        }
    }
}
