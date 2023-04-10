package com.awadinhoo.code.mastercodinginterview.stack;

public class TestStackUsingQueue {

    public static void main(String[] args) {

        StackUsingQueue stackUsingQueue = new StackUsingQueue();
        stackUsingQueue.push(10);
        stackUsingQueue.push(20);
        stackUsingQueue.push(30);
        stackUsingQueue.push(40);
        stackUsingQueue.push(50);

        System.out.println(stackUsingQueue);
        System.out.println(stackUsingQueue.pop());
        System.out.println(stackUsingQueue);
        System.out.println(stackUsingQueue.pop());
        System.out.println(stackUsingQueue);
        stackUsingQueue.push(60);
        stackUsingQueue.push(70);
        System.out.println(stackUsingQueue);
        System.out.println(stackUsingQueue.pop());

        System.out.println(" Stack using 2 queues ******************************************");

        StackUsingTwoQueues stackUsingTwoQueues = new StackUsingTwoQueues();

        stackUsingTwoQueues.push(10);
        stackUsingTwoQueues.push(20);
        stackUsingTwoQueues.push(30);
        stackUsingTwoQueues.push(40);
        stackUsingTwoQueues.push(50);

        System.out.println(stackUsingTwoQueues);
        System.out.println(stackUsingTwoQueues.pop());
        System.out.println(stackUsingTwoQueues);
        System.out.println(stackUsingTwoQueues.pop());
        System.out.println(stackUsingTwoQueues);
        stackUsingTwoQueues.push(60);
        stackUsingTwoQueues.push(70);
        System.out.println(stackUsingTwoQueues);
        System.out.println(stackUsingTwoQueues.pop());
    }
}
