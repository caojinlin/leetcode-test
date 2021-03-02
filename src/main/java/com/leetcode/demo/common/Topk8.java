package com.leetcode.demo.common;

import java.util.*;

/**
 * TopK算法
 */
public class Topk8 {
    //1.输入数组的元素是输入数组中出现频率大于k次的元素
    //2.输出数组需要按照元素出现频率的高低进行排序


    public static List<Integer> topKFrequent(int[] nums, int k){
        //边界值筛选
        if (nums == null || nums.length <= 0){
            throw new RuntimeException();
        }
        if (k < 0){
            throw new RuntimeException("当前频率k不能小于0");
        }

        //先统计出每个元素出现的频率
        HashMap<Integer,Integer> map = new HashMap(nums.length);

        for (int num : nums) {
            Integer integer = map.get(num);
            if (integer == null){
                map.put(num,1);
            }else {
                map.put(num,integer + 1);
            }
        }

        //将次数当成下标构建成一个数组
        List[] frequenceList = new ArrayList[nums.length];
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            frequenceList[value] = new ArrayList();
            frequenceList[value].add(key);
        }

        //将已经按照次数存放的arryList倒序遍历，取出前K个里面包含的arryList
        List<Integer> result = new ArrayList<>();
        for (int i = frequenceList.length - 1; i > k; i--) {
            if (frequenceList[i] == null){
                continue;
            }
            result.addAll(frequenceList[i]);
        }
        return result;
    }
    public static void main(String[] args) {
        List<Integer> integers = topKFrequent(new int[]{8, 8, 8, 8,7, 7, 7, 2, 2}, 1);
        for (int i = 0; i < integers.size(); i++) {
            System.out.println(integers.get(i));
        }
    }
}
