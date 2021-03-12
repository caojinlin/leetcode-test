package com.leetcode.demo.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {

    /**
     * 翻转二叉树
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        Queue<TreeNode> stack = new LinkedList<>();
        stack.offer(root);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.poll();
            TreeNode left = treeNode.left;
            if (left != null) {
                stack.offer(left);
            }
            TreeNode right = treeNode.right;
            if (right != null) {
                stack.offer(right);
            }
            treeNode.left = right;
            treeNode.right = left;
        }
        return root;
    }

    /**
     * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
     *
     * @param nums
     * @return
     */
    public TreeNode SortedArrayToBST(int[] nums) {
        return Helper(nums, 0, nums.length - 1);
    }

    public TreeNode Helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // 总是选择中间位置左边的数字作为根节点
        int mid = (left + right) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = Helper(nums, left, mid - 1);
        root.right = Helper(nums, mid + 1, right);
        return root;
    }

    /**
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (Math.abs(high(node.right) - high(node.left)) >1) {
                return false;
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return true;
    }

    public int high(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(high(node.left), high(node.right)) + 1;
    }

    /**
     * 给定一个二叉树，找出其最小深度。
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return minHigh(root);
    }

    public int minHigh(TreeNode node) {
        if (node.left == null && node.right == null) {
            return 1;
        }
        if (node.left == null) {
            return minHigh(node.right);
        }
        if (node.right == null) {
            return minHigh(node.left);
        }
        return Math.min(minHigh(node.left), minHigh(node.right)) +1;
    }

    /**
     * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，
     * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return pathSum(root, 0, targetSum);
    }

    public boolean pathSum(TreeNode node, int sum, int target) {
        if (node == null) {
            return false;
        }
        if (node.left == null && node.right == null) {
            return sum + node.val == target;
        }
        boolean a = pathSum(node.right, node.val + sum, target);
        boolean b= pathSum(node.left, node.val + sum, target);
        return a || b;
    }
}
