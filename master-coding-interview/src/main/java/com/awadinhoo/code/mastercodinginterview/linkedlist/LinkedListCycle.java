package com.awadinhoo.code.mastercodinginterview.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {


    public static boolean hasCycle(ListNode head) {

        Set<ListNode> visitedNodes = new HashSet<>();
        ListNode currentNode = head;

        while (currentNode != null){

            if(visitedNodes.contains(currentNode)){
                return true;
            }else {
                visitedNodes.add(currentNode);
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    public static boolean hasCycle_v2(ListNode head) {

        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while (fastPointer != null && fastPointer.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

            if(slowPointer == fastPointer)
                return true;

        }
        return false;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(5);
        ListNode second = new ListNode(10);
        ListNode third = new ListNode(10);
        ListNode fourth = new ListNode(30);
        head.next = second;
        second.next = third;
        third.next = fourth;
        //fourth.next = second;
        System.out.println(hasCycle_v2(head));

    }
}
