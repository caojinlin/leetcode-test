package com.leetcode.demo.leetcode.array;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        //[2,7,11,15], nums2 = [1,10,4,11]
        int[] nums1 = new int[]{0, 3, 5, 8, 9};
        int[] nums2 = new int[]{2, 1, 4, 6, 9};
        int ints = s.minSwap(nums1, nums2);
        System.out.println(ints);
    }

    /**
     * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * //输出：[1,2,2,3,5,6]
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] leftArr = new int[m];
        int li = 0;
        int le = m;
        int ri = 0;
        int re = n;
        int ai = 0;
        int ae = m + n;
        for (int i = 0; i < leftArr.length; i++) {
            leftArr[i] = nums1[i];
        }
        while (ai < ae) {
            if (ri < re && (li >= le || nums2[ri] < leftArr[li])) {
                nums1[ai++] = nums2[ri++];
            } else {
                nums1[ai++] = leftArr[li++];
            }
        }
    }

    /**
     * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; ++i) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                }
            }
            ret.add(row);
        }
        return ret;
    }

    /**
     * 54 : 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        int high = matrix.length;
        int weight = matrix[0].length;
        int hindex = 0;
        int windex = 0;
        while (high > hindex && weight > windex) {
            for (int i = windex; i < weight; i++) {
                result.add(matrix[hindex][i]);
            }
            if (high - hindex == 1) {
                break;
            }
            for (int i = hindex + 1; i < high - 1; i++) {
                result.add(matrix[i][weight - 1]);
            }
            for (int i = weight - 1; i >= windex; i--) {
                result.add(matrix[high - 1][i]);
            }
            if (weight - windex == 1) {
                break;
            }
            for (int i = high - 2; i >= hindex + 1; i--) {
                result.add(matrix[i][windex]);
            }
            hindex++;
            windex++;
            high--;
            weight--;
        }
        return result;
    }

    /**
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
     * 复的三元组。
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        if (nums == null || length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int L = i + 1;
            int R = length - 1;
            while (R > L) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L + 1]) {
                        L++;
                    }
                    while (R > L && nums[R] == nums[R - 1]) {
                        R--;
                    }
                    L++;
                    R--;
                } else if (sum > 0) {
                    R--;
                } else {
                    L++;
                }
            }
        }
        return result;
    }

    public static int findPairs(int[] nums, int k) {
        Map<Integer, Integer> charMap = new HashMap<>();
        int result = 0;
        Set<Integer> res = new HashSet<>();
        for (int num : nums) {
            if (charMap.containsKey(Math.abs(num - k)) && (!res.contains(num) && !res.contains(charMap.get(Math.abs(num - k))))) {
                res.add(num);
                res.add(charMap.get(Math.abs(num - k)));
                result++;
            }
            if (charMap.containsKey(Math.abs(num + k)) && (!res.contains(num) && !res.contains(charMap.get(Math.abs(num + k))))) {
                res.add(num);
                res.add(charMap.get(Math.abs(num + k)));
                result++;
            }
            charMap.put(Math.abs(num - k), num);
            charMap.put(num + k, num);
        }
        return result;
    }

    /**
     * 给定两个大小相等的数组 nums1 和 nums2，nums1 相对于 nums2 的优势可以用满足 nums1[i] > nums2[i] 的索引 i 的数目来描述。
     * <p>
     * 返回 nums1 的任意排列，使其相对于 nums2 的优势最大化。
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] advantageCount(int[] nums1, int[] nums2) {
        List<Pair<Integer, Integer>> num1p = new ArrayList<>(nums1.length);
        for (int i = 0; i < nums1.length; i++) {
            num1p.add(new Pair<>(nums1[i], i));
        }
        num1p = num1p.stream().sorted((p1, p2) -> Integer.compare(p2.getKey(), p1.getKey())).collect(Collectors.toList());
        List<Pair<Integer, Integer>> num2p = new ArrayList<>(nums1.length);
        for (int i = 0; i < nums2.length; i++) {
            num2p.add(new Pair<>(nums2[i], i));
        }
        num2p = num2p.stream().sorted((p1, p2) -> Integer.compare(p2.getKey(), p1.getKey())).collect(Collectors.toList());
        List<Pair<Integer, Integer>> result = new ArrayList<>();
        int right = 0, left = num2p.size() - 1;
        int num2length = 0;
        while (num2length < nums2.length) {
            Pair<Integer, Integer> num1 = num1p.get(right);
            Pair<Integer, Integer> num2 = num2p.get(num2length);
            if (num1.getKey() > num2.getKey()) {
                result.add(new Pair<>(num1.getValue(), num2.getValue()));
                right++;
            } else {
                Pair<Integer, Integer> numleft = num1p.get(left);
                result.add(new Pair<>(numleft.getValue(), num2.getValue()));
                left--;
            }
            num2length++;
        }
        result = result.stream().sorted(Comparator.comparingInt(Pair::getValue)).collect(Collectors.toList());
        int[] res = new int[nums1.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = nums1[result.get(i).getKey()];
        }
        return res;
    }

    public int[] advantageCount2(int[] nums1, int[] nums2) {
        Integer[] orderPos = new Integer[nums2.length];
        for (int i = 0; i < nums2.length; i++) {
            orderPos[i] = i;
        }
        Arrays.sort(orderPos, Comparator.comparingInt(i -> nums2[i]));
        // 对nums2的“元素位置”进行排序
        Arrays.sort(nums1);
        int head = 0, tail = nums1.length - 1;
        for (int i = orderPos.length - 1; i >= 0; i--) {
            if (nums1[tail] > nums2[orderPos[i]]) {
                nums2[orderPos[i]] = nums1[tail--];
            } else {
                nums2[orderPos[i]] = nums1[head++];
            }
            // 否则，将“当前最小值”赋值给它
        }
        return nums2;
    }

    class Pair<L, R> {

        private L left;

        public L getLeft() {
            return left;
        }

        public void setLeft(L left) {
            this.left = left;
        }

        public R getRight() {
            return right;
        }

        public L getKey() {
            return left;
        }

        public R getValue() {
            return right;
        }

        public void setRight(R right) {
            this.right = right;
        }

        private R right;

        public Pair(L left, R right) {
            this.left = left;
            this.right = right;
        }

    }

    public int minSwap(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][2];
        dp[0][0] = 0;
        dp[0][1] = 1;
        for (int i = 1; i < nums1.length; i++) {
            int a1 = nums1[i - 1], a2 = nums1[i], b1 = nums2[i - 1], b2 = nums2[i];
            if ((a1 < a2 && b1 < b2) && (b1 < a2 && a1 < b2)) {
                // 如果i【不互换】，则i-1可【互换】也可【不互换】
                dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]);
                // 如果i【互换】，则i-1可【互换】也可【不互换】
                dp[i][1] = dp[i][0] + 1;
            } else if (a1 < a2 && b1 < b2) {
                // 如果i【不互换】，则i-1必须【不互换】
                dp[i][0] = dp[i - 1][0];
                // 如果i【互换】，则i-1必须【互换】
                dp[i][1] = dp[i - 1][1] + 1;
            } else {
                // 如果i【不互换】，则i-1必须【互换】
                dp[i][0] = dp[i - 1][1];
                // 如果i【互换】，则i-1必须【不互换】
                dp[i][1] = dp[i - 1][0] + 1;
            }
        }
        return Math.min(dp[nums1.length - 1][0], dp[nums1.length - 1][1]);
    }

    public int totalFruit(int[] fruits) {
        int[] pickRecords = new int[fruits.length];
        int result = 0, startIndex = 0, diffIndex = 0, pickNums = 0, curFruit = 0;
        for (int i = 0; i < fruits.length; i++) {
            if (pickRecords[fruits[i]] == 0) {
                if (pickNums == 2) {
                    result = Math.max(result, i - startIndex);
                    pickRecords[fruits[diffIndex - 1]] = 0;
                    // 将水果设置为“未被选择”
                    startIndex = diffIndex;
                    // 记录“窗口”的开始index
                    pickNums--;
                    // 已选择的水果种类-1
                }
                pickNums++;
                // 已选择的水果种类+1
                pickRecords[fruits[i]] = 1;
                // 将水果设置为“被选择”
            }
            if (curFruit != fruits[i]) {
                curFruit = fruits[i];
                // 当前水果类型
                diffIndex = i; // 记录水果类型变换时的index
            }
        }
        return Math.max(result, fruits.length - startIndex);
    }
}
