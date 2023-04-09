package com.awadinhoo.code.mastercodinginterview.stack;

import java.util.NoSuchElementException;
import java.util.Stack;

public class MinStack {

    Stack<Integer> storageStack;
    Stack<Integer> minStack;
    int min;

    public MinStack() {
        storageStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {

        if(this.storageStack.isEmpty()){
            this.min = val;
        }else {
            if(val < min){
                this.min = val;
            }
        }

        this.storageStack.push(val);
        this.minStack.push(this.min);
    }

    public void pop() {

        if(this.storageStack.isEmpty()){
            System.out.println("Stack is empty");
            return;
        }
        this.storageStack.pop();
        this.minStack.pop();
    }

    public int top() {
        return this.storageStack.peek();
    }

    public int getMin() {
        return this.minStack.peek();
    }

    @Override
    public String toString() {
        return "MinStack{" +
                "storageStack=" + storageStack +
                ", minStack=" + minStack +
                '}';
    }
}
