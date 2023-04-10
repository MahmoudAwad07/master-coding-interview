package com.awadinhoo.code.mastercodinginterview.queue;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class QueueLinkedList {

    LinkedList<Integer> linkedListStorage;

    public QueueLinkedList() {
        linkedListStorage = new LinkedList<>();
    }

    // enqueue -dequeue -peek -size -isEmpty
    public void enqueue(int val){
        linkedListStorage.addLast(val);
    }

    public int dequeue(){

        if(linkedListStorage.isEmpty()){
            throw new NoSuchElementException("Queue is empty");
        }
        return linkedListStorage.removeFirst();
    }

    public int peek(){

        if(isEmpty()){
            throw new NoSuchElementException("Queue is empty");
        }
        return linkedListStorage.peek();
    }

    public boolean isEmpty(){
        return linkedListStorage.isEmpty();
    }

    public int size(){
        return linkedListStorage.size();
    }

}
