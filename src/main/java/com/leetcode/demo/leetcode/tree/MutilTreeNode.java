/*
 * Ant Group
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.leetcode.demo.leetcode.tree;

import java.util.List;

/**
 * @author 司灵
 * @version MutilTreeNode.java, v 0.1 2022年03月30日 23:22 司灵
 */
public class MutilTreeNode {
    int val;
    private List<MutilTreeNode> children;

    MutilTreeNode() {
    }

    MutilTreeNode(int val) {
        this.val = val;
    }

    MutilTreeNode(int val, List<MutilTreeNode> treeNodes) {
        this.val = val;
        this.children = treeNodes;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public List<MutilTreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<MutilTreeNode> children) {
        this.children = children;
    }

    public String toString(MutilTreeNode root) {
        StringBuilder sb = new StringBuilder();
        toString(sb, root, "");
        return sb.toString();
    }

    private void toString(StringBuilder sb, MutilTreeNode node, String prefix) {
        if (node == null) {
            return;
        }
        sb.append(prefix).append("[").append(node.val).append("]").append("\n");
        node.children.forEach(c -> {
            toString(sb, c, prefix + "[c]");
        });
    }
}