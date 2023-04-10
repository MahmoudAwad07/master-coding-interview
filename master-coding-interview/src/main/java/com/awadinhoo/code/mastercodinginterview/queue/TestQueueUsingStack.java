package com.awadinhoo.code.mastercodinginterview.queue;

public class TestQueueUsingStack {

    public static void main(String[] args) {

        QueueUsingStack queueUsingStack = new QueueUsingStack();
        queueUsingStack.enqueue(10);
        queueUsingStack.enqueue(20);
        queueUsingStack.enqueue(30);
        System.out.println(queueUsingStack);
        System.out.println(queueUsingStack.dequeue());
        System.out.println(queueUsingStack.dequeue());
        System.out.println(queueUsingStack);
        queueUsingStack.enqueue(40);
        queueUsingStack.enqueue(50);
        System.out.println(queueUsingStack.dequeue());
        System.out.println(queueUsingStack);

    }
}
