package com.leetcode.demo.common;

public class GBSort4 {

    // 归并排序
    // 归并排序:空间复杂度O(N)
    // 归并排序是稳定排序，它也是一种十分高效的排序，
    // 能利用完全二叉树特性的排序一般性能都不会太差。
    // java中Arrays.sort()采用了一种名为TimSort的排序算法，
    // 就是归并排序的优化版本。从上文的图中可看出，
    // 每次合并操作的平均时间复杂度为O(n)，
    // 而完全二叉树的深度为|log2n|。总的平均时间复杂度为O(nlogn)。
    // 而且，归并排序的最好，最坏，平均时间复杂度均为O(nlogn)

    // tips:注意几点归纳：
    // 1.不论sort还是merge方法 都是四个参数  （原数组，起始位置，终止位置，新开辟的数组）
    // 2.在merge方法中需要将已经部分排好序的数组 copy过去
    // 3.merge方法中的四个条件，推进游标，都是赋值给arr[k]
    /*public static void GBSort4(int[] arr) {
        //边界值条件判断
        if (arr == null || arr.length <= 1) {
            return;
        }
        int N = arr.length;

        //辅助用的aux函数，额外开辟的N空间的
        int[] aux = new int[N];

        sort(arr, 0, N - 1, aux);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }*/

    public static void main(String[] args) {
        GBSort(new int[]{4, 3, 2, 1});
    }

    public static void GBSort(int[] arr) {
        //边界值判断
        if (arr == null || arr.length <= 1){
            return;
        }

        int N = arr.length;
        //借助额外的N长度的空间
        int[] newArr = new int[N];

        sort(arr,0,N - 1,newArr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }


    private static void sort(int[] arr, int start, int end, int[] newArr) {

        if (start >= end){
            return;
        }

        int mid = start + (end - start) / 2;
        sort(arr,start,mid,newArr);
        sort(arr,mid + 1,end,newArr);
        merge(arr,start,end,newArr);
    }

    //归并方法
    private static void merge(int[] arr, int start, int end, int[] newArr) {
        int leftIndex = start;
        int mid = start + (end - start) / 2;
        int rightIndex = mid + 1;

        for (int i = start; i <= end; i++){
            newArr[i] = arr[i];
        }

        for (int j = start;j <= end; j++){
            if (leftIndex > mid){
                arr[j] = newArr[rightIndex++];
            }else if (rightIndex > end){
                arr[j] = newArr[leftIndex++];
            }else if (newArr[leftIndex] < newArr[rightIndex]){
                arr[j] = newArr[leftIndex++];
            }else {
                arr[j] = newArr[rightIndex++];
            }
        }
    }
}
