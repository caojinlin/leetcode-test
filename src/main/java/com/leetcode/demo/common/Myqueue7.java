package com.leetcode.demo.common;

import java.util.Stack;

public class Myqueue7 {
    private Stack<Integer> stack1 = new Stack<>();

    private Stack<Integer> stack2 = new Stack<>();

    public void push(Integer ele) {

        stack1.push(ele);
    }

    public Integer pop() {
        if (stack1.isEmpty() && stack2.isEmpty()){
            throw new RuntimeException();
        }

        if (!stack2.isEmpty()){
            return stack2.pop();
        }else {
            while (stack1.size() != 1){
                stack2.push(stack1.pop());
            }
            return stack1.pop();
        }

    }

    public static void main(String[] args) {
        Myqueue7 q = new Myqueue7();
        q.push(1);q.push(2);q.push(3);q.push(4);q.push(5);

        Integer pop1 = q.pop();
        System.out.println(pop1);
        q.push(6);
        Integer pop2 = q.pop();
        System.out.println(pop2);
        Integer pop3 = q.pop();
        System.out.println(pop3);
        Integer pop4 = q.pop();
        System.out.println(pop4);
        Integer pop5 = q.pop();
        System.out.println(pop5);
        Integer pop6 = q.pop();
        System.out.println(pop6);
    }
}

