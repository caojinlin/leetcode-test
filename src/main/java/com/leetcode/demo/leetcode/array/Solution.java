package com.leetcode.demo.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{-2,0,1,1,2};
        System.out.println(s.threeSum(nums));
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

    /**
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
     * 复的三元组。
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        if (nums == null || length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i != 0 && nums[i] == nums[i -1]) {
                continue;
            }
            int L = i +1;
            int R = length -1;
            while (R > L) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L<R && nums[L] == nums[L +1]) {
                        L ++;
                    }
                    while (R > L &&nums[R] == nums[R-1]) {
                        R --;
                    }
                    L ++;
                    R --;
                } else if (sum>0) {
                    R --;
                } else {
                    L ++;
                }
            }
        }
        return result;
    }
}
