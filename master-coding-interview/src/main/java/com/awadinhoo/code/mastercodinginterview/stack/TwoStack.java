package com.awadinhoo.code.mastercodinginterview.stack;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class TwoStack {

    private int[] arrayOfStorage;
    private int size1;
    private int size2;
    private int start1;
    private int start2;

    // index    0 ,1 ,2 , 3
    //          []
    public TwoStack() {
        this.arrayOfStorage = new int[4];
        this.size1 = 0;
        this.size2 = 0;
        this.start1 = 0;
        this.start2 = 2;
    }

    public void push1(int value){

        int arrayLength = arrayOfStorage.length;
        int capacity = arrayLength / 2;

        if(size1 == capacity){
            increaseCapacity();
        }

        this.arrayOfStorage[start1] = value;
        this.size1++;
        this.start1++;
    }

    public void push2(int value){

        int arrayLength = arrayOfStorage.length;
        int capacity = arrayLength / 2;

        if(size2 == capacity){
            increaseCapacity();
        }

        this.arrayOfStorage[start2] = value;
        this.size2++;
        this.start2++;

    }

    public int pop1(){
        if(isEmpty1()){
            throw new NoSuchElementException();
        }
        int pop = this.arrayOfStorage[start1 - 1];
        this.size1--;
        this.start1--;
        this.arrayOfStorage[start1] = 0 ;
        return pop;
    }

    public int pop2(){

        if(isEmpty2()){
            throw new NoSuchElementException();
        }

        int pop = this.arrayOfStorage[start2 - 1];
        this.size2--;
        this.start2--;
        this.arrayOfStorage[start2] = 0 ;
        return pop;
    }

    public boolean isEmpty1(){
        return size1 == 0;
    }

    public boolean isEmpty2(){
        return size2 == 0;
    }

    public boolean isFull1(){
        return size1 == arrayOfStorage.length / 2;
    }

    public boolean isFull2(){
        return size2 == arrayOfStorage.length / 2;
    }

    private void increaseCapacity(){

        int storageLength = arrayOfStorage.length;
        int middle = storageLength / 2;
        int[] newArrayOfStorage = new int[storageLength * 2];
        int newMiddle = newArrayOfStorage.length /2;



        for (int i = 0 ; i < size1 ; i++){
            newArrayOfStorage[i] = arrayOfStorage[i];
        }

        for (int i = middle ; i < start2 ; i++){
            newArrayOfStorage[newMiddle] = arrayOfStorage[i];
            newMiddle++;
        }

        this.arrayOfStorage = newArrayOfStorage;
        this.start2 = newMiddle;
    }

    @Override
    public String toString() {
        int middle = arrayOfStorage.length / 2;
        int[] content1 = Arrays.copyOfRange(arrayOfStorage,0, size1);
        int[] content2 = Arrays.copyOfRange(arrayOfStorage,middle, middle + size2);
        return "TwoStack{" +
                "stack1=" + Arrays.toString(content1) +
                "stack2=" + Arrays.toString(content2) +
                ", size1=" + size1 +
                ", size2=" + size2 +
                '}';
    }
}
