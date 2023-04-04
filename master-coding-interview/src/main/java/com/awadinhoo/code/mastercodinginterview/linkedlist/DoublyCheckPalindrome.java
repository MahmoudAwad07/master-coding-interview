package com.awadinhoo.code.mastercodinginterview.linkedlist;

public class DoublyCheckPalindrome {

    public static <T> boolean isPalindrome(DoublyLinkedList<T> list) {
        //Write Your Code Here
        // Time Complexity --> O(n)
        // Space Complexity --> O(1)

        DoublyLinkedList.Node leftNode = list.getHeadNode();
        DoublyLinkedList.Node rightNode = list.getTailNode();

        while (leftNode != rightNode){

            if(!leftNode.data.equals(rightNode.data)){
                return false;
            }
            leftNode = leftNode.nextNode;
            rightNode = rightNode.prevNode;
        }
        return true;
    }

    public static void main(String[] args) {

        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.insertAtEnd(1);
        doublyLinkedList.insertAtEnd(2);
        doublyLinkedList.insertAtEnd(3);
        doublyLinkedList.insertAtEnd(2);
        doublyLinkedList.insertAtEnd(1);
        doublyLinkedList.printList();
        System.out.println(isPalindrome(doublyLinkedList));
        DoublyLinkedList<Integer> doublyLinkedList2 = new DoublyLinkedList<>();
        doublyLinkedList2.insertAtEnd(1);
        doublyLinkedList2.insertAtEnd(2);
        doublyLinkedList2.insertAtEnd(3);
        doublyLinkedList2.printList();
        System.out.println(isPalindrome(doublyLinkedList2));
    }
}
