package com.awadinhoo.code.mastercodinginterview.heaps;

import java.util.Arrays;

public class Heap {

    private int[] storage;
    private int size;

    public Heap(){
        storage = new int[10];
        size = 0;
    }

    public void insert(int value){

        // check if the heap is full
        if(isFull())
            throw new IllegalStateException(" Heap is full");
        // insert the new value
        storage[size] = value;
        int newIndex = size;
        // Bubble up the value until the right position
        bubbleUp(newIndex);
        size++;
    }

    public int remove(){

        // check if the heap is empty
        if (isEmpty())
            throw new IllegalStateException(" Heap is empty");

        int removed = storage[0];
        storage[0] = storage[size-1];
        storage[size-1] = 0;
        bubbleDown();
        size--;
        return removed;
    }


    private void bubbleUp(int newIndex){

        while (newIndex > 0 && storage[newIndex] > storage[getParentIndex(newIndex)]){
            // Swap Items
            int parentIndex = getParentIndex(newIndex);
            swapItems(newIndex, parentIndex);
            newIndex = parentIndex;
        }
    }

    private void bubbleDown(){

        int index = 0;
        // is not valid parent
        while (index <= size && !isValidParent(index)){
            int largeChild = getLargeChildIndex(index);
            // Swap Items
            swapItems(index, largeChild);
            index = largeChild;
        }
    }

    private int getLargeChildIndex(int index) {

        if(!hasLeftChild(index))
            return index;

        if(!hasRightChild(index))
            return getLeftChildIndex(index);

        return storage[getLeftChildIndex(index)] > storage[getRightChildIndex(index)] ?
                getLeftChildIndex(index) : getRightChildIndex(index);
    }

    private boolean isValidParent(int index){

        if(!hasLeftChild(index))
            return true;

        boolean isValid = storage[index] >= storage[getLeftChildIndex(index)];

        if(hasRightChild(index))
            isValid &= storage[index] >= storage[getRightChildIndex(index)];

        return isValid;
    }

    private int getLeftChildIndex(int parentIndex){
        return ( parentIndex * 2 ) + 1 ;
    }

    private int getRightChildIndex(int parentIndex){
        return ( parentIndex * 2 ) + 2 ;
    }

    private boolean hasLeftChild(int parentIndex){
        return getLeftChildIndex(parentIndex) <= size;
    }

    private boolean hasRightChild(int parentIndex){
        return getRightChildIndex(parentIndex) <= size;
    }

    private void swapItems(int firstIndex , int secondIndex){

        int temp = storage[firstIndex];
        storage[firstIndex] = storage[secondIndex];
        storage[secondIndex] = temp;
    }

    // parent index =  ( index - 1 ) / 2
    private int getParentIndex(int childIndex){
        return (childIndex - 1) / 2;
    }

    public Boolean isFull(){
        return storage.length == size;
    }

    public Boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }


    @Override
    public String toString() {
        return "Heap{" +
                "storage=" + Arrays.toString(Arrays.copyOf(storage, size)) +
                ", size=" + size +
                '}';
    }
}
