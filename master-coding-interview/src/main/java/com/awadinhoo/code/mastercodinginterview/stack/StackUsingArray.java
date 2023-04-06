package com.awadinhoo.code.mastercodinginterview.stack;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class StackUsingArray {

    private int[] arrayOfStorage;
    private int size;

    public StackUsingArray() {
        this.arrayOfStorage = new int[1];
        size = 0;
    }

    public void push (int value){

        // check if the capacity reaches the limit
        if(size == arrayOfStorage.length){
            int[] newArrayOfStorage = new int[arrayOfStorage.length * 2];

            for (int i = 0 ; i < arrayOfStorage.length ; i++){
                newArrayOfStorage[i] = arrayOfStorage[i];
            }
            this.arrayOfStorage = newArrayOfStorage;
        }

        this.arrayOfStorage[size] = value;
        this.size++;
    }

    public int pop(){

        if(size == 0){
            throw new NoSuchElementException();
        }

        int popValue = arrayOfStorage[size - 1];
        arrayOfStorage[size - 1] = 0;
        this.size--;
        return popValue;
    }

    public int peek(){

        if(this.size == 0){
            throw new NoSuchElementException();
        }

        return arrayOfStorage[size - 1];
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public int size(){
        return this.size;
    }

    @Override
    public String toString() {
        int[] content = Arrays.copyOfRange(arrayOfStorage, 0, size);
        return "StackUsingArray{" +
                "content=" + Arrays.toString(content) +
                ", size=" + size +
                '}';
    }
}
