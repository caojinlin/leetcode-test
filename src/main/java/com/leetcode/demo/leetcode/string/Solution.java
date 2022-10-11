package com.leetcode.demo.leetcode.string;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.areAlmostEqual("abcd", "dcba"));
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
                    if (i == 0 && bytes[i] != bytes[i + 1]) {
                        break;
                    }
                    if (i == bytes.length - 1 && bytes[i] != bytes[i - 1]) {
                        break;
                    }
                    if (bytes[i] != bytes[i + 1] && bytes[i] != bytes[i - 1]) {
                        break;
                    }
                    bytes[i] = (char) (random.nextInt('z' - 'a' + 1) + 'a');
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
                if (!lujin.isEmpty()) {
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

    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int secondStart = 1; secondStart < n - 1; ++secondStart) {
            if (num.charAt(0) == '0' && secondStart != 1) {
                break;
            }
            for (int secondEnd = secondStart; secondEnd < n - 1; ++secondEnd) {
                if (num.charAt(secondStart) == '0' && secondStart != secondEnd) {
                    break;
                }
                if (valid(secondStart, secondEnd, num)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean valid(int secondStart, int secondEnd, String num) {
        int n = num.length();
        int firstStart = 0, firstEnd = secondStart - 1;
        while (secondEnd <= n - 1) {
            String third = stringAdd(num, firstStart, firstEnd, secondStart, secondEnd);
            int thirdStart = secondEnd + 1;
            int thirdEnd = secondEnd + third.length();
            if (thirdEnd >= n || !num.substring(thirdStart, thirdEnd + 1).equals(third)) {
                break;
            }
            if (thirdEnd == n - 1) {
                return true;
            }
            firstStart = secondStart;
            firstEnd = secondEnd;
            secondStart = thirdStart;
            secondEnd = thirdEnd;
        }
        return false;
    }

    public String stringAdd(String s, int firstStart, int firstEnd, int secondStart, int secondEnd) {
        StringBuffer third = new StringBuffer();
        int carry = 0, cur = 0;
        while (firstEnd >= firstStart || secondEnd >= secondStart || carry != 0) {
            cur = carry;
            if (firstEnd >= firstStart) {
                cur += s.charAt(firstEnd) - '0';
                --firstEnd;
            }
            if (secondEnd >= secondStart) {
                cur += s.charAt(secondEnd) - '0';
                --secondEnd;
            }
            carry = cur / 10;
            cur %= 10;
            third.append((char) (cur + '0'));
        }
        third.reverse();
        return third.toString();
    }

    public int scoreOfParentheses(String s) {
        char left = '(';
        char[] chars = s.toCharArray();
        Stack<Character> theses = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == left) {
                theses.push(chars[i]);
            } else {
                Character pop = theses.pop();
                if (pop == '(') {
                    theses.push('1');
                } else {
                    int sum = pop - '0';
                    while ((pop = theses.pop()) != '(') {
                        sum += pop - '0';
                    }
                    theses.push((char) ((sum << 1) + '0'));
                }
            }
        }
        int result = 0;
        while (!theses.isEmpty()) {
            result += theses.pop() - '0';
        }
        return result;
    }

    public int scoreOfParentheses1(String s) {
        Deque<Character> deque = new ArrayDeque();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                deque.addLast('(');
            }
            else {
                char c = deque.removeLast();
                if (c == '(') {
                    deque.addLast('1');
                } else {
                    int sum = c - '0';
                    while ((c = deque.removeLast()) != '(') sum += c - '0';
                    deque.addLast((char) ((sum << 1) + '0'));
                }
            }
        }
        int result = 0;
        while (!deque.isEmpty()) {
            result += deque.removeLast() - '0';
        }
        return result;
    }

    /**
     * 给你长度相等的两个字符串 s1 和 s2 。一次 字符串交换 操作的步骤如下：选出某个字符串中的两个下标（不必不同），并交换这两个下标所对应的字符。
     * 如果对 其中一个字符串 执行 最多一次字符串交换 就可以使两个字符串相等，返回 true ；否则，返回 false 。
     * @param s1
     * @param s2
     * @return
     */
    public boolean areAlmostEqual(String s1, String s2) {
        char[] s1c = s1.toCharArray();
        char[] s2c = s2.toCharArray();
        int conflict = 0;
        int first = -1;
        for (int i = 0; i < s1c.length; i++) {
            if (s1c[i] != s2c[i]) {
                conflict ++;
                if (conflict >2) {
                    return false;
                }
                if (first == -1) {
                    first = i;
                } else {
                    if (s2c[first] != s1c[i] || s2c[i] != s1c[first]) {
                        return false;
                    }
                }
            }
        }
        if (conflict == 1) {
            return false;
        }
        return true;
    }
}
