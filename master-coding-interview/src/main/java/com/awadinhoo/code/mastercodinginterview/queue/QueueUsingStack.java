package com.awadinhoo.code.mastercodinginterview.queue;

import java.util.Stack;

public class QueueUsingStack {

    Stack<Integer> enqueueStack;
    Stack<Integer> dequeueStack;

    public QueueUsingStack() {
        enqueueStack = new Stack<>();
        dequeueStack = new Stack<>();
    }

    public void enqueue(int val){
        enqueueStack.push(val);
    }

    public int dequeue(){

        if(isEmpty()) {
            System.out.println("Queue is Empty");
            return 0;
        }

        moveElementsFromEnqueueStackToDequeueStack();

        return dequeueStack.pop();
    }

    public int peek(){

        if(isEmpty()) {
            System.out.println("Queue is Empty");
            return 0;
        }

        moveElementsFromEnqueueStackToDequeueStack();

        return dequeueStack.peek();
    }


    public boolean isEmpty(){
        return enqueueStack.isEmpty() && dequeueStack.isEmpty();
    }

    private void moveElementsFromEnqueueStackToDequeueStack() {
        if(dequeueStack.isEmpty()){
            while (!enqueueStack.isEmpty()){
                dequeueStack.push(enqueueStack.pop());
            }
        }
    }

    @Override
    public String toString() {
        return "QueueUsingStack{" +
                "enqueueStack=" + enqueueStack +
                ", dequeueStack=" + dequeueStack +
                '}';
    }
}
