package com.leetcode.demo.common;

public class LinkedSort10 {

    //指针结构
    private static class Node {
        //链表节点的数据
        int data;
        //链表指向的下一个节点的指针
        Node next = null;
        public Node(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public static Node quickSort(Node head){
        //边界值判断
        if (head == null || head.next == null){
            return head;
        }

        Node cur = head;
        int temp = 0;
        while (cur != null){
            int curData = cur.data;
            Node nextNode = cur.next;
            while (nextNode != null){
                int nextData = nextNode.data;
                if (curData > nextData){
                    temp = curData;
                    curData = nextData;
                    nextData = temp;

                    cur.data = curData;
                    nextNode.data = nextData;
                }
                nextNode = nextNode.next;
            }
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node node1 = new Node(5);
        Node node2 = new Node(4);
        Node node3 = new Node(3);
        Node node4= new Node(2);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        Node node = quickSort(node1);

        while (node != null){
            System.out.println(node.data);
            node = node.next;
        }
    }
}
