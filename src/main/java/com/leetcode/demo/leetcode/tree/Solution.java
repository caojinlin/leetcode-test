package com.leetcode.demo.leetcode.tree;

import com.google.common.collect.Lists;
import org.springframework.util.CollectionUtils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(2, null, new TreeNode(3));
        int bottomLeftValue = s.findBottomLeftValue(root);
        System.out.println(bottomLeftValue);
    }

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
     *
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
            if (Math.abs(high(node.right) - high(node.left)) > 1) {
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
     *
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
        return Math.min(minHigh(node.left), minHigh(node.right)) + 1;
    }

    /**
     * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，
     * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和
     *
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
        boolean b = pathSum(node.left, node.val + sum, target);
        return a || b;
    }

    /**
     * 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化
     *
     * @param preorder
     * @return
     */
    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0) {
            return false;
        }
        String[] split = preorder.split(",");
        if ("#".equals(split[0])) {
            if (split.length == 1) {
                return true;
            } else {
                return false;
            }
        }
        Stack<String> stack = new Stack<>();
        stack.push(split[0]);
        stack.push(split[0]);
        for (int i = 1; i < split.length; i++) {
            if (stack.isEmpty()) {
                return false;
            }
            if (!"#".equals(split[i])) {
                stack.pop();
                stack.push(split[i]);
                stack.push(split[i]);
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    /**
     * 二叉树的堂兄弟节点
     *
     * @param root
     * @param x
     * @param y
     * @return
     */
    public boolean isCousins(TreeNode root, int x, int y) {
        return false;
    }

    public boolean isValidSerialization1(String preorder) {
        int n = preorder.length();
        int i = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(1);
        while (i < n) {
            if (stack.isEmpty()) {
                return false;
            }
            if (preorder.charAt(i) == ',') {
                i++;
            } else if (preorder.charAt(i) == '#') {
                int top = stack.pop() - 1;
                if (top > 0) {
                    stack.push(top);
                }
                i++;
            } else {
                // 读一个数字
                while (i < n && preorder.charAt(i) != ',') {
                    i++;
                }
                int top = stack.pop() - 1;
                if (top > 0) {
                    stack.push(top);
                }
                stack.push(2);
            }
        }
        return stack.isEmpty();
    }

    /**
     * 后序遍历
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {return res;}
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                res.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }

    public MutilTreeNode copyTree(MutilTreeNode node) {
        MutilTreeNode copy = new MutilTreeNode();
        copy.setVal(node.getVal());
        copyChild(node, copy);
        return copy;
    }

    public void copyChild(MutilTreeNode parent, MutilTreeNode copyNode) {
        if (CollectionUtils.isEmpty(parent.getChildren())) {
            return;
        }
        for (MutilTreeNode node : parent.getChildren()) {
            MutilTreeNode copy = new MutilTreeNode(node.val);
            List<MutilTreeNode> children = Optional.ofNullable(copyNode.getChildren()).orElseGet(ArrayList::new);
            copyNode.setChildren(children);
            children.add(copy);
            copyChild(node, copy);
        }
    }

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {return 0;}
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            //当前层的所有结点
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                TreeNode curNode = queue.poll();
                if (curNode.left != null) {queue.offer(curNode.left);}
                if (curNode.right != null) {queue.offer(curNode.right);}
                //第一个结点
                if (i == 0) {
                    ans = curNode.val;
                }
            }
        }
        return ans;
    }
}
