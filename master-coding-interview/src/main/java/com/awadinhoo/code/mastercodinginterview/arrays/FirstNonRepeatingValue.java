package com.awadinhoo.code.mastercodinginterview.arrays;

import java.util.*;

public class FirstNonRepeatingValue {


    public static int findFirstUnique(int[] arr) {

        // write your code here
        // Time Complexity --> O(n^2)
        // Space Complexity --> O(1)
        boolean unique;
        int firstUnique = 0;

        for (int i = 0 ; i < arr.length ; i++){
            unique = true;
            for (int j = 0 ; j < arr.length ; j++ ){
                if(arr[i] == arr[j] && i != j){
                    unique = false;
                    break;
                }
            }

            if(unique){
                firstUnique = arr[i];
                return firstUnique;
            }
        }

        return -1;
    }


    public static int findFirstUnique_v2(int[] arr) {

        // write your code here
        // Time Complexity --> O(n)
        // Space Complexity --> O(n)

        Map<Integer, Integer>  occurrenceNumberForValues = new LinkedHashMap<>();

        for (int i = 0 ; i < arr.length ; i++){
            int number = arr[i];
            Integer numberOfOccurrence = occurrenceNumberForValues.get(number);
           if( numberOfOccurrence != null){
               occurrenceNumberForValues.put(arr[i] , ++numberOfOccurrence);
           }else {
               occurrenceNumberForValues.put(arr[i] , 1);
           }
        }

        for (Map.Entry<Integer, Integer> entry : occurrenceNumberForValues.entrySet()) {
            if(entry.getValue().equals(1)){
                return entry.getKey();
            }
        }

        return -1;
    }

    public static int findFirstUnique_v3(int[] arr) {

        // write your code here
        // Time Complexity --> O(n)
        // Space Complexity --> O(n)

        Map<Integer, Integer>  occurrenceNumberForValues = new HashMap<>();
        int uniqueNumber ;

        for (int i = 0 ; i < arr.length ; i++){
            int number = arr[i];
            Integer numberOfOccurrence = occurrenceNumberForValues.get(number);
            if( numberOfOccurrence != null){
                occurrenceNumberForValues.put(arr[i] , ++numberOfOccurrence);
            }else {
                occurrenceNumberForValues.put(arr[i] , 1);
            }
        }

        for (int i = 0 ; i < arr.length ; i++){
            if(occurrenceNumberForValues.get(arr[i]).equals(1)){
                return arr[i];
            }
        }
        return -1;
    }

    public static void main (String[] args){

        int[] array = new int[]{9,2,3,2,6,6};
        int[] array2 = new int[]{4,5,1,2,0,4};

        System.out.println(findFirstUnique(array));
        System.out.println(findFirstUnique(array2));
        System.out.println(findFirstUnique_v2(array));
        System.out.println(findFirstUnique_v2(array2));
        System.out.println(findFirstUnique_v3(array));
        System.out.println(findFirstUnique_v3(array2));
    }
}
