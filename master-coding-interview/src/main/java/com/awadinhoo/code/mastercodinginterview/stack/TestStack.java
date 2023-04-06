package com.awadinhoo.code.mastercodinginterview.stack;

public class TestStack {

    public static void main(String[] args) {
        StackUsingArray stackUsingArray = new StackUsingArray();
        stackUsingArray.push(10);
        stackUsingArray.push(20);
        stackUsingArray.push(30);
        stackUsingArray.push(40);
        System.out.println(stackUsingArray);
        System.out.println(stackUsingArray.pop());
        System.out.println(stackUsingArray.peek());
        System.out.println(stackUsingArray);
        System.out.println(stackUsingArray.pop());
        System.out.println(stackUsingArray);
        System.out.println(stackUsingArray.isEmpty());
        System.out.println(stackUsingArray.size());

        System.out.println("*************************************");

        StackUsingLinkedList stackUsingLinkedList = new StackUsingLinkedList();
        stackUsingLinkedList.push(10);
        stackUsingLinkedList.push(20);
        stackUsingLinkedList.push(30);
        stackUsingLinkedList.push(40);
        System.out.println(stackUsingLinkedList);
        System.out.println(stackUsingLinkedList.pop());
        System.out.println(stackUsingLinkedList.peek());
        System.out.println(stackUsingLinkedList);
        System.out.println(stackUsingLinkedList.pop());
        System.out.println(stackUsingLinkedList);
        System.out.println(stackUsingLinkedList.isEmpty());
        System.out.println(stackUsingLinkedList.size());
    }
}
