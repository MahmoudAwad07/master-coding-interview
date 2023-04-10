package com.awadinhoo.code.mastercodinginterview.stack;

import java.util.ArrayDeque;
import java.util.NoSuchElementException;
import java.util.Queue;

public class StackUsingTwoQueues {

    Queue<Integer> originalQueue ;
    Queue<Integer> tempQueue;

    public StackUsingTwoQueues() {
        originalQueue = new ArrayDeque<>();
        tempQueue = new ArrayDeque<>();
    }

    public void push(int val) {
        originalQueue.add(val);
    }

    public int pop() {

        if (isEmpty()) {
            throw new NoSuchElementException("Stack is Empty");
        }

        while (originalQueue.size() > 1){
            tempQueue.add(originalQueue.remove());
        }

        while (!tempQueue.isEmpty()){
            originalQueue.add(tempQueue.remove());
        }

        return originalQueue.remove();
    }

    public int peek() {

        if (isEmpty()) {
            throw new NoSuchElementException("Stack is Empty");
        }

        while (originalQueue.size() > 1){
            tempQueue.add(originalQueue.remove());
        }

        while (!tempQueue.isEmpty()){
            originalQueue.add(tempQueue.remove());
        }

        return originalQueue.peek();

    }

    public boolean isEmpty() {
        return originalQueue.isEmpty();
    }

    @Override
    public String toString() {
        return "StackUsingTwoQueues{" +
                "originalQueue=" + originalQueue +
                ", tempQueue=" + tempQueue +
                '}';
    }
}
