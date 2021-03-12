package com.leetcode.demo.leetcode.list;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode(0);
        ListNode next = head;
        while (l1 != null || l2 != null) {
            if (com(l1, l2) > 0) {
                next.next = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                next.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            next = next.next;
        }
        return head.next;
    }

    public Integer com(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return 1;
        }
        if (l2 == null) {
            return -1;
        }
        return l1.val - l2.val;
    }

    /**
     * 翻转链表
     *  1 -> 2 -> 3 -> 4 -> 5 -> null
     *  5 -> 4 -> 3 -> 2 -> 1 -> null
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return  pre;
    }

    /**
     *  输入: 1->2
     *  输出: false
     *
     *  示例 2:
     *  输入: 1->2->2->1
     *  输出: true
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        List<Integer> result= new ArrayList<>();
        while(head != null) {
            result.add(head.val);
            head = head.next;
        }
        int end = result.size() -1 ;
        int start = 0;
        while (start < end) {
            if (result.get(start++).equals(result.get(end--))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int a = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i + a == nums.length -1) {
                break;
            }
            if (nums[i] == 0) {
                for (int j = i+1; j < nums.length; j++) {
                    int tmp = nums[j];
                    nums[j] = nums[j -1];
                    nums[j -1] = tmp;
                }
                a ++;
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
