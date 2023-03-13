package com.awadinhoo.code.mastercodinginterview.arrays;

import java.util.Arrays;

public class MergeSortedArrays {


    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        // write your code here
        // Time Complexity --> O(n + m)
        // Space Complexity -->  O( n + m )
        int array1Size = arr1.length;
        int array2Size = arr2.length;

        int array1Index = 0;
        int array2Index = 0;
        int mergedIndex = 0;

        int[] mergedArray = new int[array1Size + array2Size];

        while (array1Index < array1Size && array2Index < array1Size){

            if(arr1[array1Index] < arr2[array2Index]){
                mergedArray[mergedIndex] = arr1[array1Index];
                array1Index++;
            }else {
                mergedArray[mergedIndex] = arr2[array2Index];
                array2Index++;
            }
            mergedIndex++;
        }

        while (array1Index < array1Size){
            mergedArray[mergedIndex] = arr1[array1Index];
            array1Index++;
            mergedIndex++;
        }

        while (array2Index < array2Size){
            mergedArray[mergedIndex] = arr2[array2Index];
            array2Index++;
            mergedIndex++;
        }

        return mergedArray;
    }

    public static void main (String[] args ){

        int[] array1 = new int[]{1, 3, 4, 5};
        int[] array2 = new int[]{2, 6, 7, 8};

        System.out.println(Arrays.toString(mergeArrays(array1, array2)));

    }
}
