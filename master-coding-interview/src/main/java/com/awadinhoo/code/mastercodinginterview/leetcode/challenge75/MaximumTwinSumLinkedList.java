package com.awadinhoo.code.mastercodinginterview.leetcode.challenge75;

import java.util.ArrayList;
import java.util.List;

public class MaximumTwinSumLinkedList {


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


    public static int pairSum(ListNode head) {

        ListNode current = head ;
        List<Integer> values = new ArrayList<>();
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0 ;
        int leftIndex = 0 ;
        int rightIndex = 0;

        while (current != null){
            values.add(current.val);
            current = current.next;
        }
        
        rightIndex = values.size() - 1;
        
        while (leftIndex < rightIndex){
            
            currentSum = values.get(leftIndex) + values.get(rightIndex);
            
            if(currentSum > maxSum){
                maxSum = currentSum;
            }
            leftIndex++;
            rightIndex--;
        }
        
        return maxSum;

    }


    public static void main(String[] args){

        ListNode head = new ListNode(5);
        ListNode node1 = new ListNode(4);
        head.next = node1;
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(1);
        node2.next = node3;

        System.out.println(pairSum(head));


    }
}
