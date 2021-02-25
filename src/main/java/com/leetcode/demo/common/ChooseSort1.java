package com.leetcode.demo.common;

/**
 * 选择排序
 */
public class ChooseSort1 {

    // i = 0 i < arr.length   j = i + 1; j < arr.length
    //选择排序思想：每次选择一个数，然后遍历其后的每一个数，和这个数比较
    //时间复杂度：O(N^2)
    //算法特点：排序时间和初始顺序无关，即使初始已经排好序了，也要耗费O(N^2)的时间
    public static void sortIntegers(int[] arr) {

        //边界值判断
        if (arr == null || arr.length <= 0){
            return;
        }

        for (int i = 0; i < arr.length; i++) {

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }

            }
        }
        for (int q = 0; q <arr.length ;q++){
            System.out.println(arr[q]);
        }

    }
    public static void main(String[] args){
        int arr[] = new int[]{9,8,6,3,4};
        sortIntegers(arr);
    }
}
