package com.leetcode.demo.leetcode.tree;

public class TreeNode {
    int      val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public String toString(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        toString(sb, root, "");
        return sb.toString();
    }

    private void toString(StringBuilder sb, TreeNode node, String prefix) {
        if (node == null) {
            return;
        }
        sb.append(prefix).append("[").append(node.val).append("]").append("\n");

        toString(sb, node.left, prefix + "[L]");
        toString(sb, node.right, prefix + "[R]");
    }
}
