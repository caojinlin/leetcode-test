package com.leetcode.demo.leetcode.other;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.hammingWeight(10));
    }

    /**
     * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        byte[] bytes = String.valueOf(n).getBytes();
        int weight = 0;
        for (byte b : bytes) {
            if (b== 1) {
                weight ++;
            }
        }
        return weight;
    }
}