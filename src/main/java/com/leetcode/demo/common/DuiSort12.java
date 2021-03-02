package com.leetcode.demo.common;

/**
 * 堆排序
 */
public class DuiSort12 {

    /**
     * N代表数组的长度，i代表当做一个根节点然后开始进行堆话
     */
    public static void treeBinfy(int arr[] ,int N, int i){

        //递归的跳出函数
        if (i >= N){
            return;
        }

        int left = 2 * i + 1;
        int right = 2 * i + 2;

        int max = i;

        if (left < N && arr[left] > arr[max]){
            max = left;
        }
        if (right < N && arr[right] > arr[max]){
            max = right;
        }
        //把大的数据换上去
        if (max != i){
            swap(arr,max,i);
            treeBinfy(arr,N,max);
        }

    }

    //交换出一个堆里面的最大值换到根节点上
    private static void swap(int[] arr,int max, int i) {
        int temp = arr[i];
        arr[i] = arr[max];
        arr[max] = temp;
    }

    private static void buildTree(int[] arr,int N){

        int lastNode = N - 1;
        int parentNode = (lastNode - 1) / 2;

        for (int i = parentNode; i >= 0; i--) {
            treeBinfy(arr,N,i);
        }
    }

    //将构建好的大根堆，每个根节点都与最后一个节点互换，然后砍断（代表树的元素减1）
    public static void heap_sort(int[] arr,int N){
        buildTree(arr,N);

        for (int i = N - 1; i >= 0; i--){
            swap(arr,i,0);
            treeBinfy(arr,i,0);
        }
    }

    public static void main(String[] args) {
        int newTree[] = {2,5,3,1,10,4};
        //treeBinfy(newTree,newTree.length,0);
        heap_sort(newTree,newTree.length);
        for (int i = 0; i < newTree.length; i++) {
            System.out.println(newTree[i]);
        }
    }

    public void treeBinfy1(int[] arr ,int n , int i){
        if (i >= n){
            return;
        }

        int left = 2 * i + 1;
        int right = 2 * i + 2;

        int max = i;

        if (left < n && arr[left] > arr[i]){
            max = left;
        }
        if (right < n && arr[right] >arr[i]){
            max = right;
        }

        if (max != i){
            swap(arr,max,i);
            treeBinfy1(arr,n,max);
        }
    }

    public void biildTree1(int[] arr,int n){
        int lastnode = n - 1;

        int parentnode = (lastnode - 1) / 2;

        for (int i = parentnode;i > 0; i --){
            treeBinfy(arr,n,i);
        }
    }

    public void heap_sort1(int[] arr,int n){
        biildTree1(arr,n);

        for (int i = n - 1; i > 0 ; i--){
            swap(arr,i,0);
            treeBinfy1(arr,i,0);
        }
    }
}
