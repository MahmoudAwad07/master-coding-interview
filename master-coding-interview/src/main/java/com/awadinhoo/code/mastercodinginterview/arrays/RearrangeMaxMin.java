package com.awadinhoo.code.mastercodinginterview.arrays;

import java.util.Arrays;

public class RearrangeMaxMin {


    public static void maxMin(int[] arr) {

        // Write - Your - Code

        int[] newArray = new int[arr.length];
        int leftIndex = 0;
        int rightIndex = arr.length - 1;
        int newArrayIndex = 0;

        while (leftIndex < rightIndex){
            newArray[newArrayIndex] = arr[rightIndex];
            newArray[newArrayIndex + 1 ] = arr[leftIndex];
            rightIndex--;
            leftIndex++;
            newArrayIndex += 2;
        }

        if(arr.length % 2 != 0){
            newArray[newArrayIndex] = arr[leftIndex];
        }


        for (int i = 0 ; i < newArray.length ; i++){
            arr[i] = newArray[i];
        }

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(newArray));

    }

    public static void maxMin_v2(int[] arr) {
        int maxIdx = arr.length - 1;
        int minIdx = 0;
        int maxElem = arr[maxIdx] + 1; // store any element that is greater than the maximum element in the array
        for( int i = 0; i < arr.length; i++) {
            // at even indices we will store maximum elements
            if (i % 2 == 0){
                int num = arr[maxIdx] % maxElem;
                arr[i] += num * maxElem;
                maxIdx -= 1;
            }
            else { // at odd indices we will store minimum elements
                arr[i] += (arr[minIdx] % maxElem ) * maxElem;
                minIdx += 1;
            }
        }
        // dividing with maxElem to get original values.
        for( int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] / maxElem;
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void main (String[] args) {

        // {1, 2, 3, 4, 5} return --> {5, 1, 4, 2, 3}
        int[] array = new int[]{1, 2, 3, 4, 5};
        int[] array2 = new int[]{1, 2, 3, 4, 5};

        int[] array3 = new int[]{2, 5, 8, 10, 13};
        maxMin(array);
        maxMin_v2(array2);
        maxMin_v2(array3);

    }
}
