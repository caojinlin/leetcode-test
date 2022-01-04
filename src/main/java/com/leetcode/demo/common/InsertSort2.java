package com.leetcode.demo.common;

public class InsertSort2 {
    // i = 1 i < length j = i j > 0 j --   arr[j - 1]和arr [j]比较
    //插入排序思想：就像打牌时整理牌，小的插到左边，大的插到右边
    // 算法特点：最坏情况下时间复杂度O(N^2)
    // 依赖于初始排列顺序，特别适合于部分有序的数组，完全有序的情况下
    // 复杂度能达到O(N),但是逆序时效率降到O(N^2)

    // tips:第一点，边界检查的方式变为 如果为空或者只有一个，那么说明直接返回

    // tips:第二点：插入排序的特点是，数组没往前推进一个，就要和前面的整个 部分有序数组进行比较替换

    public static void sortIntegers(int[] arr) {

        if (arr == null || arr.length <= 1) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {

            for (int j = i; j > 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[] {8, 9, 5, 12, 3, 1};
        sortIntegers(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
