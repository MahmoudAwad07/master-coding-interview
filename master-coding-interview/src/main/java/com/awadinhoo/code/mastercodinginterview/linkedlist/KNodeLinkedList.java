package com.awadinhoo.code.mastercodinginterview.linkedlist;

public class KNodeLinkedList {


    public static int getKNodeFromLast(LinkedList linkedList, int K){

        // check for invalid input
        if(K < 0 ){
            throw new IllegalArgumentException();
        }

        // we will use 2 pointers
        // left will be on the start
        Node leftNode = linkedList.getFirst();
        // right will be on the node on k-1 distance of left
        Node rightNode = linkedList.getFirst();

        // set the pointers
        for (int i = 1 ; i < K ; i++){
            rightNode = rightNode.getNext();

            if(rightNode == null){
                throw new IllegalArgumentException();
            }
        }

        // move the pointers until the right pointer reach the end
        while (rightNode != linkedList.getLast()){
            leftNode = leftNode.getNext();
            rightNode = rightNode.getNext();
        }

        // return the left pointer
        return leftNode.getValue();
    }
    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(20);
        linkedList.addLast(40);
        linkedList.addLast(50);
        linkedList.addLast(10);
        System.out.println(getKNodeFromLast(linkedList, 2));
        System.out.println(getKNodeFromLast(linkedList, 3));
        System.out.println(getKNodeFromLast(linkedList, -1));
        System.out.println(getKNodeFromLast(linkedList, 0));
        System.out.println(getKNodeFromLast(linkedList, 6));

    }
}
