package com.leetcode.demo.common;

/**
 * 翻转链表
 */
public class ReverListNode6 {
    /**
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */
    public static ListNode reverse(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }

        //链表反转的意思也就是反转 指针的过程
        // 1-->2-->3-->null
        // 3-->2-->1-->null

        ListNode cur = head;
        ListNode pre = null;
        ListNode next = null;

        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static class ListNode {

        private int val;

        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "next=" + next +
                    "val=" + val +
                    '}';
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.setNext(l2);
        l2.setNext(l3);
        l3.setNext(null);

        ListNode reverse = reverse(l1);
        System.out.println(reverse);

        while (reverse.getNext() != null) {
            System.out.println(reverse.getVal());
            reverse = reverse.next;
        }
    }
}
