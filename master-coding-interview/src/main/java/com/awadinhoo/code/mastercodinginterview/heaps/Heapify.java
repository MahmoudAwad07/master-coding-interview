package com.awadinhoo.code.mastercodinginterview.heaps;

import java.util.Arrays;

public class Heapify {


    public int[] heapify(int[] array){

        int lastParentIndex = array.length / 2 - 1;
        for (int index = lastParentIndex ; index >= 0  ; index--){
            heapify(index , array);
        }
        return array;
    }

    private void heapify(int index , int[] array){

        // check if current index is valid parent
        // if it is valid return
        // if it is not valid parent swap it with the larger value
        // recursive swap the value if it is not on the right position.
        if (isValidParent(index, array))
            return;

        int largerChildIndex = getLargerChildIndex(index, array);
        swap(array, index, largerChildIndex);
        heapify(largerChildIndex, array);
    }

    private boolean isValidParent(int index, int[] array){

        if(!hasLeftChild(index, array))
            return true;

        boolean isValid = array[index] >= array[getLeftChildIndex(index)];

        if(hasRightChild(index, array))
            isValid &=  array[index] >= array[getRightChildIndex(index)];

        return isValid;
    }

    private void swap(int[] array, int first , int second){
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    private int getLargerChildIndex(int index, int[] array){

        if(!hasRightChild(index,array))
           return getLeftChildIndex(index);

        return array[getLeftChildIndex(index)] > array[getRightChildIndex(index)] ?
                    getLeftChildIndex(index) : getRightChildIndex(index);

    }


    private boolean hasRightChild(int parentIndex , int[] array){
        return getRightChildIndex(parentIndex) < array.length ;
    }

    private boolean hasLeftChild(int parentIndex, int[] array){
        return getLeftChildIndex(parentIndex) < array.length ;
    }
    private int getRightChildIndex(int parentIndex){
        return ( parentIndex * 2 ) + 2 ;
    }

    private int getLeftChildIndex(int parentIndex){
        return ( parentIndex * 2 ) + 1 ;
    }

    public static void main(String[] args) {

        Heapify heapify = new Heapify();
        System.out.println(Arrays.toString(heapify.heapify(new int[]{5,3,8,4,1,2})));
        System.out.println(Arrays.toString(heapify.heapify(new int[]{4, 10, 3, 5, 1})));

    }
}
