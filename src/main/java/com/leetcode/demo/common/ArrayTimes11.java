package com.leetcode.demo.common;

/**
 * 给定有序数组中 给定元素出现次数 要求Logn
 */
public class ArrayTimes11 {
    public static int sortTimes(int[] arr, int tartget, boolean flag) {
        //边界条件判断
        if (arr == null || arr.length <= 0) {
            return 0;
        }

        int start = 0;
        int end = arr.length - 1;
        int mid = 0;

        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (arr[mid] == tartget) {
                if (flag) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else if (arr[mid] < tartget) {
                start = mid;
            } else if (arr[mid] > tartget) {
                end = mid;
            }
        }

        if (arr[start] == tartget) {
            return start;
        }

        if (arr[end] == tartget) {
            return end;
        }

        return start;

    }

    public static void main(String[] args) {
        int f = sortTimes(new int[] {1, 222, 222, 222, 2345, 7891, 7891, 6666}, 222, true);
        int end = sortTimes(new int[] {1, 222, 222, 222, 2345, 7891, 7891, 6666}, 222, false);
        System.out.println("一共出现了" + (end - f + 1));
    }
}
