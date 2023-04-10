package com.awadinhoo.code.mastercodinginterview.queue;

import java.util.*;

public class QueueReverser {

    public static Queue<Integer> reverse(Queue<Integer> queue , int K){

        int index = 0;
        Stack<Integer> reverseStack = new Stack<>();
        List<Integer> restOfElements = new ArrayList<>();

        while (!queue.isEmpty() && index < K){
            reverseStack.push(queue.remove());
            index++;
        }

        while(!queue.isEmpty() && index >= K){
            restOfElements.add(queue.remove());
            index++;
        }

        while (!reverseStack.isEmpty()){
            queue.add(reverseStack.pop());
        }

        /*
        for (int i = 0; i < restOfElements.size() ; i++){
            queue.add(restOfElements.get(i));
        }
         */
        queue.addAll(restOfElements);

        return queue;

    }

    public static Queue<Integer> reverse_v2(Queue<Integer> queue , int K){

        int index = 0;
        Stack<Integer> reverseStack = new Stack<>();

        while (!queue.isEmpty() && index < K){
            reverseStack.push(queue.remove());
            index++;
        }

        while (!reverseStack.isEmpty()){
            queue.add(reverseStack.pop());
        }

        for(int i = 0 ; i < queue.size() - K ; i++){
            queue.add(queue.remove());
        }

        return queue;

    }

    public static void main(String[] args) {


        // [10, 20, 30, 40, 50], K = 3

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);

        System.out.println(reverse(queue,3));

        Queue<Integer> queue2 = new ArrayDeque<>();
        queue2.add(10);
        queue2.add(20);
        queue2.add(30);
        queue2.add(40);
        queue2.add(50);

        System.out.println(reverse_v2(queue2, 3));
    }
}
