package com.awadinhoo.code.mastercodinginterview.designgurus.codingpatterns.twopointers;

public class NonDuplicateNumbersSolution {


    public static int remove(int[] arr) {

        if(arr.length == 0){
            return 0;
        }

        int nextNonDuplicate = 1;
        for(int i = 1 ; i < arr.length ; i++){
            if(arr[nextNonDuplicate - 1] != arr[i]){
                arr[nextNonDuplicate] = arr[i];
                nextNonDuplicate++;
            }
        }
        return nextNonDuplicate;
    }

    public static void main(String[] args) {

        // [2, 3, 3, 3, 6, 9, 9] --> [2, 3, 6, 9, 3, 3, 9]
        System.out.println(remove(new int[]{2, 3, 3, 3, 6, 9, 9}));
        System.out.println(remove(new int[]{2, 2, 2, 11}));


    }
}
