package com.awadinhoo.code.mastercodinginterview.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class SinglyLinkedListPalindrome {

    public static boolean isPalindrome(ListNode head) {

        // Time Complexity --> O(n)
        // Space Complexity --> O(n)

        List<Integer> list = new ArrayList<>();
        int leftIndex = 0;
        int rightIndex = 0;
        ListNode currentNode = head;

        // copy elements to arraylist
        while (currentNode != null){
            list.add(currentNode.val);
            currentNode = currentNode.next;
        }

        // update the right Index
        rightIndex = list.size() - 1;

        // check by both pointers
        while (leftIndex < rightIndex){
            if(!list.get(leftIndex).equals(list.get(rightIndex)))
                return false;
            leftIndex++;
            rightIndex--;
        }

        return true;
    }

    public static boolean isPalindrome_v2(ListNode head) {

        // Time Complexity --> O(n)
        // Space Complexity --> O(1)

        ListNode slowPointer = head;
        ListNode fastPointer = head;

        // set the pointer on the middle
        while (fastPointer.next != null && fastPointer.next.next != null){
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }

        // [1,2,3,2,1]
        // [1,2,3]
        // [1,2]
        // reverse linked list from the middle
        ListNode prev = null;
        slowPointer = slowPointer.next;
        while (slowPointer != null ){
            ListNode next = slowPointer.next;
            slowPointer.next = prev;
            prev = slowPointer;
            slowPointer = next;
        }

        // check the list is palindrome or not
        ListNode startPointer = head;
        ListNode endPointer = prev;
        while (endPointer != null){
            if(startPointer.val != endPointer.val){
                return false;
            }
            startPointer = startPointer.next;
            endPointer = endPointer.next;
        }

        return true;
    }

    public static void main(String[] args) {

        // [1,2,3,2,1] --> [1,2,3,1,2]
        // [1,2,2,1]   --> [1,2,1,2]
        // [1,2,3]

        ListNode head = new ListNode(5);
        ListNode second = new ListNode(10);
        ListNode third = new ListNode(10);
        ListNode fourth = new ListNode(5);
        ListNode fifth = new ListNode(6);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        ListNode head2 = new ListNode(1);
        ListNode second2 = new ListNode(2);
        ListNode third2 = new ListNode(3);
        ListNode fourth2 = new ListNode(2);
        ListNode fifth2 = new ListNode(1);
        head2.next = second2;
        second2.next = third2;
        third2.next = fourth2;
        fourth2.next = fifth2;

        System.out.println(isPalindrome(head));
        System.out.println(isPalindrome_v2(head2));

    }
}
