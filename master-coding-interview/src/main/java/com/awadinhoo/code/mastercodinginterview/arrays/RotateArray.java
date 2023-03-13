package com.awadinhoo.code.mastercodinginterview.arrays;

import java.util.Arrays;

public class RotateArray {


    public static void rotateArrayByOneIndexRight(int[] arr){

        // Write - Your - Code
        // Time Complexity --> O(n)
        // Space Complexity --> O(1)

        int arraySize =  arr.length;
        int temp = arr[arraySize-1];

        for (int i = arraySize - 1; i > 0 ; i-- ){
            arr[i] = arr[i - 1];
        }
        arr[0] = temp;

        System.out.println(Arrays.toString(arr));
    }
    public static void main (String[] args){

        // {1, 2, 3, 4, 5} return --> {5, 1, 2, 3, 4}
        int[] arr = new int[] {1, 2, 3, 4, 5};
        rotateArrayByOneIndexRight(arr);

    }
}
