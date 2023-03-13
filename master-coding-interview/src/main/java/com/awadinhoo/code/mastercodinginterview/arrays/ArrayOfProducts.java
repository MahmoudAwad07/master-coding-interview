package com.awadinhoo.code.mastercodinginterview.arrays;

import java.util.Arrays;

public class ArrayOfProducts {


    public static int[] findProduct(int[] arr)
    {

        // write your code here
        // Time Complexity --> O(n^2)
        // Space Complexity --> O(1)

        int previousElementsProduct = 1;
        int nextElementsProduct = 1;
        int elementProduct = 1;

        for (int i= 0 ; i < arr.length ; i++ ){

            for(int j = i + 1 ; j < arr.length ; j++){
                nextElementsProduct *= arr[j];
            }

            elementProduct = previousElementsProduct * nextElementsProduct;
            nextElementsProduct = 1;
            previousElementsProduct = previousElementsProduct * arr[i];
            arr[i] = elementProduct;
        }

        return arr;
    }


    public static int[] findProduct_v2(int[] arr)
    {

        // write your code here
        // Time Complexity --> O(3n) --> O(n)
        // Space Complexity --> O(3n) --> O(n)

        int arraySize = arr.length;
        int[] beforeProductArr = new int[arraySize];
        int[] afterProductArr = new int[arraySize];
        int[] productArray= new int[arraySize];

        beforeProductArr[0] = 1;
        afterProductArr[arraySize-1] = 1;


        // [1,2,3,4]
        //[1,1,2,6]
        // calculate before Product Array
        for (int i= 1 ; i < arraySize ; i++ ){
            beforeProductArr[i] = beforeProductArr[i-1] * arr[i-1];
        }

        System.out.println("Before Product Array:" + Arrays.toString(beforeProductArr));

        // [1,2,3,4]
        // [24,12,4,1]
        for (int j = arraySize - 2 ; j >= 0 ; j-- ){
            afterProductArr[j] = afterProductArr[j+1] * arr[j+1];
        }

        System.out.println("After Product Array:" + Arrays.toString(afterProductArr));

        //[1,1,2,6]
        //[24,12,4,1]
        for(int i=0 ; i < arraySize; i++){
            productArray[i] = beforeProductArr[i] * afterProductArr[i];
        }

        return productArray;
    }


    public static int[] findProduct_v3(int[] arr)
    {

        // write your code here
        // Time Complexity --> O(n)
        // Space Complexity --> O(n)

        int arraySize = arr.length;
        int[] result = new int[arraySize];
        int temp = 1;


        // calculate Before Product Array
        // [1,2,3,4]
        // [1,1,2,6]
        for (int i = 0 ; i < arraySize ; i++ ){
            result[i] = temp;
            temp *= arr[i];
        }

        temp = 1;

        // calculate After Product Array
        // [1,2,3,4]
        // [1,1,2,6]
        // [24,12,8,6]
        for(int j = arraySize-1 ; j >= 0 ; j--){
            result[j] = temp * result[j];
            temp *= arr[j];
        }

        return result;
    }

    public static void main (String[] args ){

        int[] arr = new int[] {1,2,3,4};
        int[] arr2 = new int[] {1,2,3,4};
        System.out.println(Arrays.toString(findProduct(arr)));
        System.out.println(Arrays.toString(findProduct_v2(arr2)));
        System.out.println(Arrays.toString(findProduct_v3(arr2)));

    }
}
