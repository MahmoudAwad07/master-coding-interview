package com.awadinhoo.code.mastercodinginterview.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TwoNumbersSum {



    public static int[] findSum(int[] arr, int n) {
        // write your code here
        // Time Complexity --> O(n^2)
        // Space Complexity --> O(1)

        int[] result = new int[2];
        for (int i =0 ; i < arr.length ; i++){
            for (int j = i + 1 ; j < arr.length ; j++){
                if((arr[i] + arr[j] == n)){
                    result[0] = arr[i];
                    result[1] = arr[j];
                    return result;
                }
            }
        }
        return result;
    }


    public static int[] findSum_v2(int[] arr, int n) {
        // write your code here
        // Time Complexity --> O(n log n )
        // Space Complexity --> O(1)

        int[] result = new int[2];

        Arrays.sort(arr); // O(log n)
        int rightIndex = arr.length - 1;
        int leftIndex = 0;

        while (leftIndex < rightIndex){ // O(n)
            if((arr[rightIndex] + arr[leftIndex]) == n){
                result[0] = arr[rightIndex];
                result[1] = arr[leftIndex];
                return result;
            }else if((arr[rightIndex] + arr[leftIndex]) < n ){
                leftIndex++;
            }else {
                rightIndex--;
            }
        }

        return result;
    }


    public static int[] findSum_v3(int[] arr, int n) {
        // write your code here
        // Time Complexity --> O(n)
        // Space Complexity --> O(n)

        int[] result = new int[2];
        Set<Integer> values = new HashSet<>();

        for (int i =0 ; i < arr.length; i++){

            int remaining = n - arr[i];
            if(values.contains(remaining)){
                result[0] = remaining;
                result[1] = arr[i];
                return result;
            }else {
                values.add(arr[i]);
            }
        }
        return result;
    }


    //findSum([9, 4, 7, 2, 6], 17)


    public static void main (String[] args ){

        int[] array = new int[] {1, 21, 3, 14, 5, 60, 7, 6};
        int[] array2 = new int[] {1, 21, 3, 14, 5, 60, 7, 6};
        int[] array3 = new int[] {9, 4, 7, 2, 6};
        System.out.println(Arrays.toString(findSum(array,27)));
        System.out.println(Arrays.toString(findSum_v2(array,27)));
        System.out.println(Arrays.toString(findSum_v3(array2,27)));
    }
}
