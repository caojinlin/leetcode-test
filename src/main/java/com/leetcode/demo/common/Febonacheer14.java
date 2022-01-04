package com.leetcode.demo.common;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 递归和非递归方式实现斐波那契函数
 */
public class Febonacheer14 {
    //递归方式的时间复杂度是o（2^n） 空间复杂度是o（n）
    public static int fbnq(int num) {
        //边界值条件判断
        if (num <= 0) {
            throw new RuntimeException();
        }

        if (num == 1 || num == 2) {
            return 1;
        } else {
            return fbnq(num - 1) + fbnq(num - 2);
        }
    }

    //非递归方式
    public static int FDGfbnq(int num) {
        //边界值条件判断
        if (num <= 0) {
            throw new RuntimeException();
        }
        if (num == 1 || num == 2) {
            return 1;
        }
        int pre = 1;
        int ppre = 0;
        int ret = 0;

        for (int i = 2; i <= num; i++) {
            ret = ppre + pre;
            ppre = pre;
            pre = ret;
        }
        return ret;
    }

    //尾递归方式
    public static int WDGfbnq(int num, int ppre, int pre) {
        //边界值条件判断
        if (num <= 0) {
            throw new RuntimeException();
        }
        if (num < 2) {
            return ppre;
        }
        int i = WDGfbnq(num - 1, pre, pre + ppre);
        return i;
    }

    public static void main(String[] args) {
        int fbnq = fbnq(6);
        int i = FDGfbnq(6);
        int i1 = WDGfbnq(6, 1, 1);
        System.out.println(fbnq);
        System.out.println(i);
        System.out.println(i1);
        Map map = new ConcurrentHashMap();
        final String pig = "length: 10";
        final String dog = "length: 10";
        System.out.println(pig == dog);

    }
}
