package com.awadinhoo.code.mastercodinginterview.leetcode.challenge75;

public class OddEvenLinkedList {


    private static class ListNode {
        int val;
       ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public static ListNode oddEvenList(ListNode head) {

         // odd  even
        // [ 1 , 2 , 3 , 4 , 5 ]

        if(head == null){
            return null ;
        }else  if(head.next == null || head.next.next == null){
            return head;
        }

        ListNode oddNode = head ;
        ListNode evenNode = head.next;
        ListNode firstEvenNode = evenNode;

        while (evenNode != null && evenNode.next != null){

            oddNode.next = evenNode.next;
            oddNode = oddNode.next;
            evenNode.next = oddNode.next;
            evenNode = evenNode.next;
        }

        oddNode.next = firstEvenNode;
        return head;
    }

    public static void main (String[] args){

        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        head.next = node1;
        ListNode node2 = new ListNode(3);
        node1.next = node2;
        ListNode node3 = new ListNode(4);
        node2.next = node3;
        ListNode node4 = new ListNode(5);
        node3.next = node4;

        ListNode orderedLinkedList = oddEvenList(head);


    }
}
