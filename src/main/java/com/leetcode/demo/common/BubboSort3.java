package com.leetcode.demo.common;

public class BubboSort3 {

    private static void bubboSort(int[] arr){
        //边界值判断
        if (arr == null || arr.length <= 1){
            return;
        }

        //每次相邻的进行对比,做一个标志位防止内部已经俨然有序
        //里面那一层才是两两比较的排序算法，减掉i是因为已经有i个排好序了，然后再减1的原因是 比如三个冒泡，只需要冒泡两次就能把最大的
        //移动到最后面

        boolean flag = true;

        for (int i = 0; i < arr.length && flag; i++) {
            flag = false;

            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]){
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    flag = true;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args){
        int[] arr = new int[]{3,2,1};
        bubboSort(arr);
    }
}
