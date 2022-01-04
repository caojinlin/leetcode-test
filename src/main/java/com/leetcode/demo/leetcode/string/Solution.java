package com.leetcode.demo.leetcode.string;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isPalindrome("race a car"));
    }

    public boolean isPalindrome(String s) {
        if (s == null || s.trim().isEmpty()) {
            return true;
        }
        byte[] first = s.getBytes();
        StringBuilder sb = new StringBuilder();
        for (byte b : first) {
            if (Character.isLetterOrDigit((char) b)) {
                sb.append((char) b);
            }
        }
        String in = sb.toString().toUpperCase();
        byte[] bytes = in.getBytes();
        for (int i = 0; i < bytes.length / 2; i++) {
            if (bytes[i] != bytes[bytes.length - i - 1]) {
                return false;
            }
        }
        return true;
    }
}
