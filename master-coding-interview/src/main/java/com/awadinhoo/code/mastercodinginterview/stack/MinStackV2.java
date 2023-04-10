package com.awadinhoo.code.mastercodinginterview.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinStackV2 {

    List<Integer> listStack = new ArrayList<>();
    Stack<Integer> minValueContainer = new Stack();
    public MinStackV2() {

    }

    public void push(int val) {
        if (minValueContainer.size() == 0 || minValueContainer.peek() >= val)
        {
            minValueContainer.push(val);
        }
        listStack.add(val);
    }

    public void pop() {
        int removed = listStack.get(listStack.size() - 1);
        if(minValueContainer.size() > 0 && removed == minValueContainer.peek()) {
            minValueContainer.pop();
        }
        listStack.remove(listStack.size() - 1);
    }

    public int top() {
        return listStack.get(listStack.size() - 1);
    }

    public int getMin() {
        return minValueContainer.peek();
    }
}
