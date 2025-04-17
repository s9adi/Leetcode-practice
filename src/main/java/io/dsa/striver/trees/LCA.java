package io.dsa.striver.trees;

public class LCA {
    /*
    We have to traverse through the Tree
    if the one of the node is found then return that node
    if nothing is found return null
    if one is a number and one is a null return the number
     */
    static TreeNode findLCA(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) return node;
        if (node == p || node == q) return node;

        // We have to traverse to the Left Root Right

        TreeNode left = findLCA(node.left, p, q);
        TreeNode right = findLCA(node.right, p, q);

        if (left == null) return right;
        if (right == null) return left;

        else return node;
    }
}
