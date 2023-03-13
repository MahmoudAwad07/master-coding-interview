package com.awadinhoo.code.mastercodinginterview.arrays;

public class ArrayMinimumValue {


    public static int findMinimum(int[] arr) {
        // Write your code here
        // Time Complexity --> O(n)
        // Space Complexity --> O(1)

        int minValue = arr[0];

        for (int i = 0; i < arr.length ; i++){
            if(minValue > arr[i]){
                minValue = arr[i];
            }
        }
        return minValue;
    }


    public static void main(String[] args ){
        int[] array = new int[] {9,2,3,6};
        System.out.println(findMinimum(array));

    }
}
