package com.awadinhoo.code.mastercodinginterview.linkedlist;

import java.util.Arrays;

public class TestLinkedList {


    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(5);
        linkedList.addLast(6);
        linkedList.addLast(7);
        System.out.println("Linked List Size: " + linkedList.size());
        linkedList.printLinkList();
        linkedList.addLast(10);
        linkedList.deleteFirst();
        linkedList.deleteLast();
        System.out.println("Linked List Size: " + linkedList.size());
        linkedList.printLinkList();
        linkedList.addLast(15);
        linkedList.printLinkList();
        System.out.println(linkedList.contains(10));
        System.out.println(linkedList.indexOf(15));
        System.out.println(linkedList.indexOf(7));
        System.out.println(linkedList.contains(6));
        linkedList.addLast(50);
        linkedList.addFirst(20);
        linkedList.printLinkList();
        System.out.println(Arrays.toString(linkedList.toArray()));
        System.out.println(Arrays.toString(linkedList.reverse().toArray()));

    }
}
