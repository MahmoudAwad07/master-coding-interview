package com.awadinhoo.code.mastercodinginterview.linkedlist;

public class LinkedListMiddle {


    public static void printMiddle(LinkedList linkedList){

        Node leftNode = linkedList.getFirst();
        Node rightNode = linkedList.getFirst();

        while (rightNode.getNext() != null // in case of the list is odd
                && rightNode.getNext().getNext() != null){ // in case of the list is even
            leftNode = leftNode.getNext();
            rightNode = rightNode.getNext().getNext();
        }

        if (rightNode == linkedList.getLast()){
            System.out.println(leftNode.getValue());
        }else {
            System.out.println(leftNode.getValue() + ", " + leftNode.getNext().getValue());
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(20);
        linkedList.addLast(40);
        linkedList.addLast(50);
        linkedList.addLast(10);
        linkedList.addLast(60);
        printMiddle(linkedList);
    }
}
