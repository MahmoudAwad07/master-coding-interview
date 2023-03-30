package com.awadinhoo.code.mastercodinginterview.arrays;

public class SumOfMaximumSumSubArray {


    public static int findMaxSumSubArray(int[] arr) {
        // Write - Your - Code
        // Brute Force Solution --> O(n^2)
        // Space Complexity --> O(1)

        int maxSum = Integer.MIN_VALUE;
        int startIndex  = 0; // start Index and end Index if you want to return the sub array
        int endIndex = 0;
        int tempSum = Integer.MIN_VALUE;

        for (int i =0 ; i < arr.length ; i++){
            tempSum = arr[i];

            // if the max sum is one element
            if(tempSum > maxSum){
                maxSum = tempSum;
                startIndex = i;
                endIndex = i;
            }

            for (int j = i + 1; j < arr.length ; j++){
                tempSum += arr[j];
                if(tempSum > maxSum){
                    maxSum = tempSum;
                    startIndex = i;
                    endIndex = j;
                }
            }
        }
        return maxSum;
    }

    public static int findMaxSumSubArray_v2(int[] arr) {
        // Write - Your - Code
        // Brute Force Solution --> O(n)
        // Space Complexity --> O(1)

        int currentSum = 0;
        int maxSum = arr[0];

         for (int i = 0 ; i < arr.length ; i++){

             if (currentSum < 0){
                 currentSum = arr[i];
             }else {
                 currentSum += arr[i];
             }

             if(maxSum < currentSum){
                 maxSum = currentSum;
             }
         }

        return maxSum;
    }


    public static int findMaxSumSubArray_v3(int[] arr) {
        // Write - Your - Code
        // Brute Force Solution --> O(n)
        // Space Complexity --> O(1)

        int maxSoFar = arr[0]; // Initialize maximum sum seen so far
        int maxEndingHere = arr[0]; // Initialize maximum sum ending at current index

        for (int i = 1; i < arr.length; i++) {
            // Take the maximum between the current element and the current element plus
            // the maximum sum ending at the previous index
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);

            // Update the maximum sum seen so far
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

    public static void main (String[] args) {

        int[] array = new int[] {1, 7, -2, -5, 10, -1};

        System.out.println(findMaxSumSubArray(array));
        System.out.println(findMaxSumSubArray_v2(array));
        System.out.println(findMaxSumSubArray_v3(array));

    }
}
