package com.awadinhoo.code.mastercodinginterview.arrays;

import java.util.Arrays;

public class RemoveEvenNumbers {


    public static int[] removeEven(int[] arr) {

        // Write - Your - Code- Here
        // Time Complexity --> O(n)
        // Space Complexity --> o(2n) -> O(n)

        int[] oddNumbersWithZeros = new int[arr.length];
        int[] oddNumbers ;
        int oddNumbersIndex = 0;
        int oddNumbersCount = 0;

        for (int i =0 ; i < arr.length ; i++) {
            if (arr[i] % 2 != 0){
                oddNumbersWithZeros[oddNumbersIndex] = arr[i];
                oddNumbersIndex++;
                oddNumbersCount++;
            }
        }

        oddNumbers = new int[oddNumbersCount];

        for (int i =0 ; i < oddNumbersCount; i++ ){
            oddNumbers[i] = oddNumbersWithZeros[i];
        }

        return oddNumbers;
    }



    public static int[] removeEven_v2(int[] arr) {

        // Write - Your - Code- Here
        // Time Complexity --> O(n)
        // Space Complexity --> o(2n) -> O(n)

        int[] oddNumbers = new int[arr.length];
        int oddNumbersIndex = 0;
        int oddNumbersCount = 0;

        for (int i =0 ; i < arr.length ; i++) {
            if (arr[i] % 2 != 0){
                oddNumbers[oddNumbersIndex] = arr[i];
                oddNumbersIndex++;
                oddNumbersCount++;
            }
        }

        return Arrays.copyOf(oddNumbers,oddNumbersCount);
    }


    public static int[] removeEven_v3(int[] arr) {

        // Write - Your - Code- Here
        // Time Complexity --> O(n)
        // Space Complexity --> o(n)
        int[] oddNumbers ;
        int oddNumbersIndex = 0;
        int oddNumbersCount = 0;

        for (int i =0 ; i < arr.length ; i++) {
            if (arr[i] % 2 != 0){
                oddNumbersCount++;
            }
        }

        oddNumbers = new int[oddNumbersCount];

        for (int i =0 ; i < arr.length ; i++) {
            if (arr[i] % 2 != 0){
                oddNumbers[oddNumbersIndex] = arr[i];
                oddNumbersIndex++;
            }
        }

        return oddNumbers;
    }

    public static void main (String[] args){
        int[] arr = new int[]{1, 2, 4, 5, 10, 6, 3};
        System.out.println(Arrays.toString(removeEven(arr)));
        System.out.println(Arrays.toString(removeEven_v2(arr)));
        System.out.println(Arrays.toString(removeEven_v3(arr)));

    }
}
