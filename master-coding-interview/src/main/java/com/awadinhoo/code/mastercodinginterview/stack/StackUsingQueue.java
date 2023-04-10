package com.awadinhoo.code.mastercodinginterview.stack;

import java.util.ArrayDeque;
import java.util.NoSuchElementException;
import java.util.Queue;

public class StackUsingQueue {

    private Queue<Integer> queueStorage;

    public StackUsingQueue() {
        queueStorage = new ArrayDeque<>();
    }

    // push - pop - peek - top - isEmpty
    public void push(int val) {
        queueStorage.add(val);
    }

    public int pop() {

        if (isEmpty()) {
            throw new NoSuchElementException("Stack is Empty");
        }

        for (int i = 0; i < queueStorage.size() - 1; i++) {
            queueStorage.add(queueStorage.remove());
        }


        return queueStorage.remove();
    }

    public int peek() {

        if (isEmpty()) {
            throw new NoSuchElementException("Stack is Empty");
        }


        for (int i = 0; i < queueStorage.size() - 1; i++) {
            queueStorage.add(queueStorage.remove());
        }

        return queueStorage.peek();
    }

    public boolean isEmpty() {
        return queueStorage.isEmpty();
    }


    @Override
    public String toString() {
        return "StackUsingQueue{" +
                "queueStorage=" + queueStorage +
                '}';
    }
}
