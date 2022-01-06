package com.leetcode.demo.leetcode.string;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.Random;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.simplifyPath("/a//b////c/d//././/.."));
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

    public String modifyString(String s) {
        char[] bytes = s.toCharArray();
        Random random = new Random();
        for (int i = 0; i < bytes.length; i++) {
           if (bytes[i] == '?') {
               bytes[i] = (char) (random.nextInt('z' - 'a' + 1) + 'a');
               while (true) {
                   if (i == 0 && bytes.length == 1) {
                       break;
                   }
                   if (i == 0 && bytes[i] != bytes[i +1]) {
                       break;
                   }
                   if (i ==bytes.length -1 && bytes[i] != bytes[i -1]) {
                       break;
                   }
                   if (bytes[i] != bytes[i +1] && bytes[i] != bytes[i -1]) {
                       break;
                   }
                   bytes[i] =  (char) (random.nextInt('z' - 'a' + 1) + 'a');
               }
           }
        }
        return String.valueOf(bytes);
    }

    public String simplifyPath(String path) {
        Deque<String> lujin = new ArrayDeque<>();
        String[] split = path.split("/");
        for (int i = 0; i < split.length; i++) {
            if (Objects.equals(split[i], "")) {
                continue;
            }
            if (split[i].equals(".")) {
                continue;
            }
            if ("..".equals(split[i])) {
                if ( !lujin.isEmpty()) {
                    lujin.pop();
                }
            } else {
                lujin.push(split[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!lujin.isEmpty()) {
            sb.append("/").append(lujin.pollLast());
        }
        return sb.toString().equals("") ? "/" : sb.toString();
    }
}
