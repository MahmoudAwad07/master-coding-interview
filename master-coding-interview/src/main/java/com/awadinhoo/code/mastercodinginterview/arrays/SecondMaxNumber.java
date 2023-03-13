package com.awadinhoo.code.mastercodinginterview.arrays;

public class SecondMaxNumber {


    public static int findSecondMaximum(int[] arr)
    {
        // Write - Your - Code
        // Time Complexity --> O(2n) --> O(n)
        // Space Complexity --> O(1)
        int secondMax ;
        int maxIndex = 0;
        int max = arr[0];
        int i = 1;

        // Get the Max
        while (i < arr.length){

            if(max < arr[i]){
                max = arr[i];
                maxIndex = i;
            }
            i++;
        }

        if(maxIndex == 0){
            secondMax = arr[1];
            i = 2;
        }else{
            secondMax = arr[0];
            i = 1;
        }

        while (i < arr.length){
            if(secondMax < arr[i] && i != maxIndex){
                secondMax = arr[i];
            }
            i++;
        }

        return secondMax;
    }

    public static int findSecondMaximum_v2(int[] arr)
    {
        // Write - Your - Code
        // Time Complexity --> O(n)
        // Space Complexity --> O(1)
        int max = arr[0];
        int secondMax = arr[1];

        for (int i = 2; i < arr.length ; i++){

            if(arr[i] > max){
                secondMax = max;
                max = arr[i];
            }else if(arr[i] > secondMax && arr[i] != max){
                secondMax = arr[i];
            }
        }

        return secondMax;
    }


    public static void main (String[] args) {

       // {9,2,3,6} return --> 6
        int[] arr = new int[]{9,2,3,6};
        System.out.println(findSecondMaximum(arr));
        System.out.println(findSecondMaximum_v2(arr));

    }
}
