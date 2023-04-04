package com.awadinhoo.code.mastercodinginterview.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {


    public static boolean hasCycle(LinkedList linkedList){

        Set<Node> visitedNodes = new HashSet<>();

        Node currentNode = linkedList.getFirst();
        while(currentNode != null){

            if(visitedNodes.contains(currentNode))
                return true;
            else
                visitedNodes.add(currentNode);

            currentNode = currentNode.getNext();
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(20);
        linkedList.addLast(40);
        linkedList.addLast(50);
        linkedList.addLast(10);

    }
}
