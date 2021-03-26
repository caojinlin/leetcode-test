package com.leetcode.demo.leetcode.other;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedIterator implements Iterator<Integer> {
    
    private List<NestedInteger> list;
    
    private int index = 0;

    private int pindex = 0;

    private int cindex = 0;

    private List<NestedInteger> nList;

    private Stack<NestedInteger> stack = new Stack();

    public NestedIterator(List<NestedInteger> nestedList) {
        list = nestedList;
        stack.push(nestedList.get(0));
    }

    @Override
    public Integer next() {
        NestedInteger nInt = stack.peek();
        while (!nInt.isInteger()) {
            NestedInteger cInt = nInt.getList().get(pindex);
            if (cInt.isInteger()) {
                nInt = cInt;
                break;
            } else {
                stack.push(cInt);
            }
        }
        return nInt.getInteger();

    }

    @Override
    public boolean hasNext() {
        if (list.size() < index + 1) {
            return false;
        }
        return true;
    }
}