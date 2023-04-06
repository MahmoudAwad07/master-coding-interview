package com.awadinhoo.code.mastercodinginterview.stack;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class StackUsingLinkedList {

    private LinkedList<Integer> storage;

    private int size;

    public StackUsingLinkedList() {
        storage = new LinkedList<>();
        size = 0;
    }

    public void push (int value){
        storage.add(value);
        this.size++;
    }

    public int pop(){
        this.size--;
        return storage.removeLast();
    }

    public int peek(){
        return storage.getLast();
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public int size(){
        return this.size;
    }

    @Override
    public String toString() {
        return "StackUsingLinkedList{" +
                "content=" + storage +
                ", size=" + size +
                '}';
    }
}
