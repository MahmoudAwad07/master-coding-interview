package com.awadinhoo.code.mastercodinginterview.arrays;

import java.util.Arrays;

public class RearrangePositiveAndNegativeValues {


    public static void reArrange(int[] arr) {

        //Write - Your - Code
        // Time Complexity --> O(n)
        // Space Complexity --> O(1)

        int leftIndex = 0;
        int rightIndex = arr.length - 1;
        int temp = 0 ;

        while (leftIndex < rightIndex){

            // Case1 : the left element is positive && right element is negative
            // Swap the 2 elements
            if(arr[leftIndex] > 0 && arr[rightIndex] < 0){
                // Swap the 2 numbers
                temp = arr[leftIndex];
                arr[leftIndex] = arr[rightIndex];
                arr[rightIndex] = temp;
                leftIndex++;
                rightIndex--;

            // case 2 : the left element is positive && right element is positive
            // move the right index
            }else if(arr[leftIndex] > 0 && arr[rightIndex] > 0){
                rightIndex--;

            // case 3 : the left element is negative  && right element is negative
            // move the left index
            }else if(arr[leftIndex] < 0 && arr[rightIndex] < 0 ){
                leftIndex++;

            // case 4 : the left element is negative && right element is positive
            // move the left & right index
            }else if(arr[leftIndex] < 0 && arr[rightIndex] > 0 ){
                leftIndex++;
                rightIndex--;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void reArrange_v2(int[] arr) {

        //Write - Your - Code
        // Time Complexity --> O(n)
        // Space Complexity --> O(1)

        int temp = 0;
        int swapTrackIndex = 0 ;

        for(int i = 0 ; i < arr.length ; i++){

            if(arr[i] < 0){
                temp = arr[swapTrackIndex];
                arr[swapTrackIndex] = arr[i];
                arr[i] = temp;
                swapTrackIndex++;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void main (String[] args ){

        int[] array = new int []{10, -1, 20, 4, 5, -9, -6};
        int[] array2 = new int []{10, -1, 20, 4, 5, -9, -6};
        reArrange(array);
        reArrange_v2(array2);
    }
}
