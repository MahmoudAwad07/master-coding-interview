package com.awadinhoo.code.mastercodinginterview.queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {


    public static Queue<Integer> reverseQueue(Queue<Integer> queue){

        if(queue == null || queue.isEmpty()){
            return queue;
        }

       Stack<Integer> stack = new Stack<>();

       while (!queue.isEmpty()){
           stack.push(queue.remove());
       }

       while(!stack.isEmpty()){
            queue.add(stack.pop());
       }

       return queue;
    }

    public static void main(String[] args) {

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        System.out.println(reverseQueue(queue));
    }
}
