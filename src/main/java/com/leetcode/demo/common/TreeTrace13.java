package com.leetcode.demo.common;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeTrace13 {
    //存放前序+中序+后序排列的集合
    private static List<Node> list = new ArrayList<Node>();

    //定义节点类：
    private static class Node{
        private String data;
        private Node lchid;//定义指向左子树的指针
        private Node rchild;//定义指向右子树的指针
        public Node(String data,Node lchild,Node rchild){
            this.data=data;
            this.lchid=lchild;
            this.rchild=rchild;
        }
    }

    //前序  根-》左-》右
    public static void preOrder(Node node){
        if (node == null){
            return;
        }
        list.add(node);
        if (node.lchid != null){
            preOrder(node.lchid);
        }
        if (node.rchild != null){
            preOrder(node.rchild);
        }
    }

    //中序 左-》根-》右
    public static void midOrder(Node node){
        if (node.lchid != null){
            midOrder(node.lchid);
        }
        list.add(node);
        if (node.rchild != null){
            midOrder(node.rchild);
        }
    }

    //后序 左-》右-》根
    public static void afterOrder(Node node){
        if (node.lchid != null){
            afterOrder(node.lchid);
        }
        if (node.rchild != null){
            afterOrder(node.rchild);
        }
        list.add(node);
    }

    /*1、如果一棵树只有一个结点，它的深度为1。
    2、如果根结点只有左子树而没有右子树，那么树的深度是其左子树的深度加1；
    3、如果根结点只有右子树而没有左子树，那么树的深度应该是其右子树的深度加1；
    4、如果既有右子树又有左子树，那该树的深度就是其左、右子树深度的较大值再加1。*/

    public static int getTreeDeepth(Node node){
        if (node.lchid == null && node.rchild == null){
            return 1;
        }

        int left = 0; int right = 0;
        if (node.lchid != null){
            left = getTreeDeepth(node.lchid);
        }
        if (node.rchild != null){
            right = getTreeDeepth(node.rchild);
        }
        return left > right ? left + 1 : right + 1;
    }

    public static class Solution {
        public List<String> PrintFromTopToBottom(Node root) {

            List<String> result = new ArrayList<>();
            if (root == null){
                return result;
            }

            Queue<Node> q = new LinkedList();
            q.offer(root);

            while (!q.isEmpty()){
                Node poll = q.poll();
                if (poll.lchid != null){
                    q.offer(poll.lchid);
                }
                if (poll.rchild != null){
                    q.offer(poll.rchild);
                }
                result.add(poll.data);
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Node x=new Node("X",null,null);
        Node y=new Node("Y",null,null);
        Node d=new Node("d",x,y);
        Node e=new Node("e",null,null);
        Node f=new Node("f",null,null);
        Node c=new Node("c",e,f);
        Node b=new Node("b",d,null);
        Node a=new Node("a",b,c);

        preOrder(a);
        for (Node node : list) {
            System.out.println(node.data);
        }

    }
}
