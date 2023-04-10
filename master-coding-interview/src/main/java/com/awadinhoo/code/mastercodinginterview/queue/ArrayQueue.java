package com.awadinhoo.code.mastercodinginterview.queue;

import java.util.Arrays;

public class ArrayQueue {

    private int[] arrayOfStorage;
    private int size;
    private int front;
    private int tail;

    public ArrayQueue(int capacity) {
        arrayOfStorage = new int[capacity];
        size = 0;
        front = 0;
        tail = 0;
    }

    // [10, 20, 30, 40, 50]

    public void enqueue(int val){

        if(size == arrayOfStorage.length){
            throw new IllegalStateException("Queue is Full");
        }
        arrayOfStorage[tail] = val;
        // circular arrays
        tail = (tail + 1) % arrayOfStorage.length;
        size++;
    }

    public int dequeue(){
        int dequeued = arrayOfStorage[front];
        arrayOfStorage[front] = 0;
        front = (front + 1) % arrayOfStorage.length;
        size--;
        return dequeued;
    }

    public int peek(){
        return arrayOfStorage[front];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == arrayOfStorage.length;
    }

    @Override
    public String toString() {
        return "ArrayQueue{" +
                "arrayOfStorage=" + Arrays.toString(arrayOfStorage) +
                ", size=" + size +
                ", front=" + front +
                ", tail=" + tail +
                '}';
    }
}
