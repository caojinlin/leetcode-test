package com.leetcode.demo.leetcode.other;

import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.trailingZeroes(15));
    }

    /**
     * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int ret = 0;
        while (n != 0) {
            n &= n - 1;
            ret++;
        }
        return ret;
    }

    /**
     * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
     *
     * @param columnNumber
     * @return
     */
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber != 0) {
            int ci = columnNumber % 26 == 0 ? 26 : columnNumber % 26;
            char c = (char) (ci + 64);
            sb.insert(0, c);
            columnNumber -= ci;
            columnNumber = columnNumber / 26;
        }
        return sb.toString();
    }

    /**
     * 给定一个Excel表格中的列名称，返回其相应的列序号。
     *
     * @param columnTitle
     * @return
     */
    public int titleToNumber(String columnTitle) {
        byte[] bytes = columnTitle.getBytes();
        int index = 0;
        int sum = 0;
        for (int i = bytes.length - 1; i >= 0; i--) {
            sum += ((bytes[i] - 'A') + 1) * Math.pow(26, index);
            index++;
        }
        return sum;
    }

    /**
     * 给定一个整数 n，返回 n! 结果尾数中零的数量。
     *
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int zeroCount = 0;
        // We need to use long because currentMultiple can potentially become
        // larger than an int.
        long currentMultiple = 5;
        while (n >= currentMultiple) {
            zeroCount += (n / currentMultiple);
            currentMultiple *= 5;
        }
        return zeroCount;
    }
}
