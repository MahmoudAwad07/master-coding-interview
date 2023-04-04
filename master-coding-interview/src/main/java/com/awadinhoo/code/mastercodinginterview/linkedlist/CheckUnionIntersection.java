package com.awadinhoo.code.mastercodinginterview.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class CheckUnionIntersection {

    //performs union of two lists
    public static <T> SinglyLinkedList<T> union(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        SinglyLinkedList<T> result = new SinglyLinkedList<T>();
        // Write -- Your -- Code
        // Time Complexity --> O(2(n * m))
        // Space Complexity --> O(1)

        SinglyLinkedList.Node currentNodeList1 = list1.getHeadNode();
        SinglyLinkedList.Node currentNodeList2 = list2.getHeadNode();
        SinglyLinkedList.Node compareNode = result.getHeadNode();
        boolean found = false;

        while (currentNodeList1 != null){

            compareNode = result.getHeadNode();
            found = false;
            while (compareNode != null){
                if(currentNodeList1.data.equals(compareNode.data)){
                    found = true;
                    break;
                }
                compareNode = compareNode.nextNode;
            }

            if(!found){
                result.insertAtEnd((T) currentNodeList1.data);
            }
            currentNodeList1 = currentNodeList1.nextNode;
        }


        while (currentNodeList2 != null){

            compareNode = result.getHeadNode();
            found = false;
            while (compareNode != null){
                if(currentNodeList2.data.equals(compareNode.data)){
                    found = true;
                    break;
                }
                compareNode = compareNode.nextNode;
            }

            if(!found){
                result.insertAtEnd((T) currentNodeList2.data);
            }
            currentNodeList2 = currentNodeList2.nextNode;
        }

        result.printList();
        return result;
    }

    //performs union of two lists
    public static <T> SinglyLinkedList<T> union_v2(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        SinglyLinkedList<T> result = new SinglyLinkedList<T>();
        // Write -- Your -- Code
        // Time Complexity --> O(n + m )
        // Space Complexity --> O(n + m )

        SinglyLinkedList.Node currentNodeList1 = list1.getHeadNode();
        SinglyLinkedList.Node currentNodeList2 = list2.getHeadNode();

        Set<Integer> visitedNodes = new HashSet<>();

        while (currentNodeList1 != null){

            if(!visitedNodes.contains((Integer) currentNodeList1.data)){
                visitedNodes.add((Integer) currentNodeList1.data);
                result.insertAtEnd((T) currentNodeList1.data);
            }
            currentNodeList1 = currentNodeList1.nextNode;
        }


        while (currentNodeList2 != null){

            if(!visitedNodes.contains((Integer) currentNodeList2.data)){
                visitedNodes.add((Integer) currentNodeList2.data);
                result.insertAtEnd((T) currentNodeList2.data);
            }
            currentNodeList2 = currentNodeList2.nextNode;
        }

        result.printList();
        return result;
    }

    //performs intersection between list
    public static <T> SinglyLinkedList<T> intersection(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        SinglyLinkedList<T> result = new SinglyLinkedList<T>();
        // Write -- Your -- Code
        // Time Complexity --> O(n * m )
        // Space Complexity --> O(1)

        SinglyLinkedList.Node currentNode = list1.getHeadNode();
        SinglyLinkedList.Node compareNode = list2.getHeadNode();

        while (currentNode != null ){
            // reset compare node
            compareNode = list2.getHeadNode();
            while (compareNode != null){
                // intersection
                if(currentNode.data.equals(compareNode.data)){
                    result.insertAtEnd((T) currentNode.data);
                }
             compareNode = compareNode.nextNode;
            }
            currentNode = currentNode.nextNode;
        }
        result.printList();
        return result;
    }

    //performs intersection between list
    public static <T> SinglyLinkedList<T> intersection_v2(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        SinglyLinkedList<T> result = new SinglyLinkedList<T>();
        // Write -- Your -- Code
        // Time Complexity --> O(n + m)
        // Space Complexity --> O(n)
        Set<Integer> visitedNodes = new HashSet<>();

        SinglyLinkedList.Node currentNodeList1 = list1.getHeadNode();
        SinglyLinkedList.Node currentNodeList2 = list2.getHeadNode();

        while (currentNodeList1 != null ){
            visitedNodes.add((Integer) currentNodeList1.data);
            currentNodeList1 = currentNodeList1.nextNode;
        }

        while (currentNodeList2 != null ){
            if(visitedNodes.contains((Integer) currentNodeList2.data))
                result.insertAtEnd((T) currentNodeList2.data);

            currentNodeList2 = currentNodeList2.nextNode;
        }

        result.printList();
        return result;
    }


    public static void main(String[] args) {

        SinglyLinkedList<Integer> list1 = new SinglyLinkedList<>();
        list1.insertAtEnd(15);
        list1.insertAtEnd(22);
        list1.insertAtEnd(8);

        SinglyLinkedList<Integer> list2 = new SinglyLinkedList<>();
        list2.insertAtEnd(7);
        list2.insertAtEnd(14);
        list2.insertAtEnd(22);

        intersection(list1, list2);
        intersection_v2(list1, list2);
        union(list1, list2);
        union_v2(list1, list2);

    }
}
