package com.leetcode.demo.leetcode.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * 给你单链表的头节点 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
     *     表节点，返回 反转后的链表 。
     *
     *
     *      示例 1：
     *
     *
     *     输入：head = [1,2,3,4,5], left = 2, right = 4
     *     输出：[1,4,3,2,5]
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode start = head;
        ListNode pre = new ListNode(0, head);
        boolean flag = false;
        for (int i = 1; i < right; i ++) {
            if (i == left-1) {
                pre = start;
                flag = true;
            }
            if (i<left) {
                start = start.next;
            } else {
                ListNode tmp = start.next;
                start.next = tmp.next;
                tmp.next = pre.next;
                pre.next = tmp;
            }
        }
        if (!flag) {
            return pre.next;
        }
        return head;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode one = head;
        ListNode two = head;
        for (int i =0; i<n; i++) {
            if (two == null) {
                return head;
            }
            two = two.next;
        }
        while (two.next != null) {
            one = one.next;
            two = two.next;
        }
        ListNode tmp = one.next;
        one.next = tmp.next;
        tmp.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3, new ListNode(5, new ListNode(6)));
        Solution solution = new Solution();
        System.out.println(solution.removeNthFromEnd(head,  3));
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> temp = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            if (temp.containsKey(target - numbers[i])) {
                result[0] = temp.get(target - numbers[i]);
                result[1] = i +1;
                return result;
            } else {
                temp.put(numbers[i], i+1);
            }
        }
        return result;
    }
}
