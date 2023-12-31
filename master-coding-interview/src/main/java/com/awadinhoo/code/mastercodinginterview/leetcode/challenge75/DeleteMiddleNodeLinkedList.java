package com.awadinhoo.code.mastercodinginterview.leetcode.challenge75;

public class DeleteMiddleNodeLinkedList {


    public static ListNode deleteMiddle(ListNode head) {


        // [1,3,4,7,1,2,6] --> 7
        // [1,2,3,4] --> 4
        // [2,1] --> 2
        // [1] --> 1

        int size = 0;
        ListNode current =  head;
        while (current != null){
            size++;
            current = current.next;
        }

        int middle = size / 2 ;

        current = head;
        while(middle > 1){
            current = current.next;
            middle--;
        }

        ListNode deletedNode = current.next;
        if(deletedNode != null){
            current.next = deletedNode.next;
            deletedNode.next = null;
        }else {
            head = deletedNode;
        }

        return head;
    }

    public static ListNode deleteMiddle_enhanced(ListNode head) {


        // [1,3,4,7,1,2,6] --> 7
        // [1,2,3,4] --> 4
        // [2,1] --> 2
        // [1] --> 1

        if(head.next == null){
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;

        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = slow.next;
        slow.next = null;

        return head;
    }


    private class ListNode {
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


    public static void main(String[] args) {

    }
}
