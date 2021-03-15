package com.leetcode.demo.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class Solution {


    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] m = new int[10][2];
        for (int i = 0; i < m.length; i++) {
            for (int i1 = 0; i1 < m[i].length; i1++) {
                m[i][i1] = i + i1 +1 + 3 * i;
            }
        }
        System.out.println(s.spiralOrder(m));
    }


    /**
     * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * //输出：[1,2,2,3,5,6]
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] leftArr = new int[m];
        int li = 0;
        int le = m;
        int ri = 0;
        int re = n;
        int ai = 0;
        int ae = m + n;
        for (int i = 0; i < leftArr.length; i++) {
            leftArr[i] = nums1[i];
        }
        while (ai < ae) {
            if (ri < re && (li >= le || nums2[ri] < leftArr[li])) {
                nums1[ai++] = nums2[ri++];
            } else {
                nums1[ai++] = leftArr[li++];
            }
        }
    }

    /**
     * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
     *
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

    /**
     * 54 : 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        int high = matrix.length;
        int weight = matrix[0].length;
        int hindex = 0;
        int windex = 0;
        while (high > hindex && weight > windex) {
            for (int i = windex; i < weight; i++) {
                result.add(matrix[hindex][i]);
            }
            if (high - hindex == 1) {
                break;
            }
            for (int i = hindex + 1; i < high - 1; i++) {
                result.add(matrix[i][weight -1]);
            }
            for (int i = weight - 1; i >= windex; i--) {
                result.add(matrix[high -1][i]);
            }
            if (weight - windex  == 1) {
                break;
            }
            for (int i = high - 2; i >= hindex + 1; i--) {
                result.add(matrix[i][windex]);
            }
            hindex++;
            windex++;
            high--;
            weight--;
        }
        return result;
    }
}
