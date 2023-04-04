package com.awadinhoo.code.mastercodinginterview.linkedlist;

import java.util.NoSuchElementException;

public class LinkedList {

    private Node first;
    private Node last;
    private int size;

    public void addFirst(int value) {

        // create the new node
        Node firstNode = new Node(value);

        // check length and first node, if this is the first value
        if (size == 0 && first == null) {
            first = firstNode;
            last = firstNode;
        }
        // the linked list contains values
        else {

            // set the next of the first element with the old first
            firstNode.setNext(first);
            // make the first element is the new node
            first = firstNode;
        }
        size++;
    }

    public void addLast(int value) {

        // create the new node
        Node lastNode = new Node(value);

        // check length and first node, if this is the first value
        if (size == 0 && first == null) {
            first = lastNode;
            last = lastNode;
        }
        // the linked list contains values
        else {

            // set the last element next pointer to the node
            last.setNext(lastNode);
            // set the last node be the new one
            last = lastNode;
        }
        size++;
    }

    public int size() {
        return size;
    }

    public void deleteFirst() {

        // check length and first node, if linked list is empty
        if (size == 0 && first == null) {
            throw new NoSuchElementException();
        }
        // the linked list contains values
        else {

            // the linked list contains one element
            if (first == last) {
                first = last = null;
            } else {
                // the first element will be the second element
                Node second = first.getNext();
                first.setNext(null);
                first = second;
            }
            size--;
        }
    }

    public void deleteLast() {

        // check length and first node, if linked list is empty
        if (size == 0 && first == null) {
            throw new NoSuchElementException();
        }
        // the linked list contains values
        else {

            // the linked list contains one element
            if (first == last) {
                first = last = null;
            } else {
                Node currentNode = first;
                while (currentNode != null) {

                    // the before last element
                    if (currentNode.getNext().getNext() == null) {
                        // set the next of the
                        currentNode.setNext(null);
                        // set the last element with the current
                        last = currentNode;
                    }
                    currentNode = currentNode.getNext();
                }
            }
            size--;
        }
    }

    public boolean contains(int value) {

        // the linked list is empty
        if (size == 0 && first == null) {
            return false;
        }
        // the linked list contains values
        else {

            Node currentNode = first;
            while (currentNode != null) {

                // element found
                if (currentNode.getValue() == value) {
                    return true;
                }
                currentNode = currentNode.getNext();
            }
        }

        // element is not found
        return false;
    }

    public int indexOf(int value) {

        // the linked list is empty
        if (size == 0 && first == null) {
            return -1;
        }
        // the linked list contains values
        else {

            int index = 0;
            Node currentNode = first;
            while (currentNode != null) {

                // element found
                if (currentNode.getValue() == value) {
                    return index;
                }
                currentNode = currentNode.getNext();
                index++;
            }
        }

        // element is not found
        return -1;
    }

    public int[] toArray(){

        int[] array = new int[this.size()];
        int index = 0;

        Node currentNode = this.first;
        while (currentNode != null){
            array[index] = currentNode.getValue();
            currentNode = currentNode.getNext();
            index++;
        }

        return array;
    }

    public LinkedList reverse(){

        Node currentNode = this.first;
        Node previousNode = null;
        Node nextNode = null;

        while (currentNode != null){
            // store the next element to keep track of it
            nextNode = currentNode.getNext();
            // set the next element to be the previous
            currentNode.setNext(previousNode);
            // move the pointers
            previousNode = currentNode;
            currentNode = nextNode;
        }

        // set the first and last
        last = this.first;
        first = previousNode;

        return this;
    }

    public void printLinkList() {

        if (size == 0) {
            System.out.println("Linked List is empty");
        }
        Node currentNode = first;
        System.out.print("[");
        while (currentNode != null) {
            System.out.print(currentNode.getValue());
            currentNode = currentNode.getNext();
            if (currentNode != null) System.out.print(",");
        }
        System.out.print("]");
        System.out.println();
    }

    public void addCycle(int pos){

        int index = 0;
        Node currentNode = this.first;
        while (index < pos){
            currentNode = currentNode.getNext();
            index++;
        }


    }

    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }
}
