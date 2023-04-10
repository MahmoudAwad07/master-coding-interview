package com.awadinhoo.code.mastercodinginterview.queue;

public class TestArrayQueue {

    public static void main(String[] args) {

        ArrayQueue arrayQueue = new ArrayQueue(5);
        arrayQueue.enqueue(10);
        arrayQueue.enqueue(20);
        arrayQueue.enqueue(30);
        System.out.println(arrayQueue);
        System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue);
        arrayQueue.enqueue(40);
        arrayQueue.enqueue(50);
        arrayQueue.enqueue(60);
        arrayQueue.enqueue(70);
        System.out.println(arrayQueue);
        arrayQueue.enqueue(80);

    }

}
