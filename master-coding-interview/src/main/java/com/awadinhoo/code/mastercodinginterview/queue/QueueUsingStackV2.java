package com.awadinhoo.code.mastercodinginterview.queue;

import java.util.Stack;

public class QueueUsingStackV2 {

    // the main stack that holds the original data
    private Stack<Integer> queueStack;

    // the temp stack that holds the data to be reversed
    private Stack<Integer> reversedStack;

    public QueueUsingStackV2() {
        queueStack = new Stack<>();
        reversedStack = new Stack<>();
    }

    public void push(int val) {

        if(isEmpty()){
            queueStack.push(val);
        }else {

            // shift all the elements on the other stack
            while (!queueStack.isEmpty()){
                reversedStack.push(queueStack.pop());
            }

            // push the latest element
            reversedStack.push(val);

            // shift the elements again back to the original stack
            while(!reversedStack.isEmpty()){
                queueStack.push(reversedStack.pop());
            }
        }

    }

    public int pop() {

        if(queueStack.isEmpty()){
            throw new IllegalStateException("Queue is Empty");
        }
        return queueStack.pop();
    }

    public int peek() {
        if(queueStack.isEmpty()){
            throw new IllegalStateException("Queue is Empty");
        }

        return queueStack.peek();

    }

    public boolean isEmpty() {
        return queueStack.isEmpty();

    }
}
