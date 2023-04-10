package com.awadinhoo.code.mastercodinginterview.stack;

import java.util.NoSuchElementException;
import java.util.Stack;

public class MinStack {

    Stack<Integer> storageStack;
    Stack<Integer> minStack;

    public MinStack() {
        storageStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {


        if(this.storageStack.isEmpty()){
            // first step, the 2 stacks are empty
            this.minStack.push(val);
        }else {

            int prevMin = this.minStack.peek();
            // check to know the new Min
            if(val < prevMin ){
                this.minStack.push(val);
            }else {
                this.minStack.push(prevMin);
            }
        }
        this.storageStack.push(val);

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
