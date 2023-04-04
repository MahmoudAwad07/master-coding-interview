package com.awadinhoo.code.mastercodinginterview.linkedlist;

import java.util.LinkedList;

public class LinkedListReverseTwo {


    public static ListNode reverseBetween(ListNode head, int left, int right) {

        // Time Complexity --> O(n)
        // Space Complexity --> O(1)

        if(left == right || head == null){
            return head;
        }

        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode currentNode = head;
        ListNode previousNode = fakeHead;
        ListNode nextNode = head;
        ListNode prevReverse = null;
        ListNode reverseStart = null;

        // set the pointers
        for (int i = 1 ; i < left ; i++ ){
            previousNode = currentNode;
            nextNode = currentNode.next;
            currentNode = nextNode;
        }

        // store the previous and the start of the reverse for later use
        prevReverse = previousNode;
        reverseStart = currentNode;

        for(int i = left ; i <= right ; i++){
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }

        // set the reverse border
        prevReverse.next = previousNode;
        reverseStart.next = currentNode;

        return fakeHead.next;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        ListNode head2 = new ListNode(3);
        ListNode second2 = new ListNode(5);
        head2.next = second2;
        reverseBetween(head2, 1, 2);



    }
}
