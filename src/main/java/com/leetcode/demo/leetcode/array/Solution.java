package com.leetcode.demo.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class Solution {


    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        merge(nums1, 3, nums2,3);
    }



    /**
     * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * //输出：[1,2,2,3,5,6]
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] leftArr = new int[m];
        int li = 0; int le = m;
        int ri = 0; int re = n;
        int ai = 0; int ae = m + n;
        for (int i = 0; i < leftArr.length; i++) {
            leftArr[i] = nums1[i];
        }
        while(ai < ae) {
            if (ri < re && (li >= le || nums2[ri] < leftArr[li])) {
                nums1[ai++] = nums2[ri ++];
            } else {
                nums1[ai ++] = leftArr[li ++];
            }
        }
    }

    /**
     * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; ++i) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                }
            }
            ret.add(row);
        }
        return ret;
    }
}
