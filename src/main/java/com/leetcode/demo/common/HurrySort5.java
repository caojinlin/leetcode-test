package com.leetcode.demo.common;


/**
 * 快速排序
 */
public class HurrySort5 {
    public static void main(String[] args){
        sortIntegers2(new int[]{5,4, 2, 3,1});
    }

    public static void sortIntegers2(int[] arr) {

        //边界值判断
        if (arr == null || arr.length <= 1){
            return;
        }

        int N = arr.length - 1;
        hurrySort(arr,0,N);

        //结果输出
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void hurrySort(int[] arr, int s, int e) {

        if (s >= e){
            return;
        }

        int partition = partition(arr,s,e);
        hurrySort(arr,s,partition - 1);
        hurrySort(arr,partition + 1,e);
    }

    private static int partition(int[] arr, int s, int e) {

        int leftIndex = s;
        int rightIndex = e;

        //首次partition比较位置
        int temp = arr[s];

        while (leftIndex < rightIndex){
            while (leftIndex < rightIndex && arr[rightIndex] > temp){
                rightIndex --;
            }

            arr[leftIndex] = arr[rightIndex];

            while (leftIndex < rightIndex && arr[leftIndex] <temp){
                leftIndex ++;
            }
            arr[rightIndex] = arr[leftIndex];
        }

        arr[leftIndex] = temp;
        return leftIndex;
    }

}
