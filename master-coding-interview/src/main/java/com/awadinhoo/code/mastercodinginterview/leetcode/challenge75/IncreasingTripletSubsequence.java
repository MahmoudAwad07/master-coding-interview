package com.awadinhoo.code.mastercodinginterview.leetcode.challenge75;

import java.util.Arrays;

public class IncreasingTripletSubsequence {


    public static boolean increasingTriplet(int[] nums) {

        int left = 0;
        int mid = 1;

        for (int i = 0; i < nums.length ; i++){
            for (int j = i+1 ; j < nums.length ; j++){

                if(nums[i] < nums[j]){
                    for (int k = j+1 ; k < nums.length ; k++ ){
                        if(nums[j] < nums[k]) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    public static boolean increasingTriplet_v2(int[] nums) {

        int left = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;
        int current = 0;

        for (int i = 0 ; i < nums.length ; i++){
            current = nums[i];

            if(current <= left) {
                left = current;
            } else if (current <= mid) {
                mid = current;
            }else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        // [1,2,3,4,5]
        System.out.println(increasingTriplet(new int[]{1,2,3,4,5})); // true
        // [5,4,3,2,1]
        System.out.println(increasingTriplet(new int[]{5,4,3,2,1})); // false
        // [2,1,5,0,4,6]
        System.out.println(increasingTriplet(new int[]{2,1,5,0,4,6})); // true
        //[20,100,10,12,5,13]
        System.out.println(increasingTriplet(new int[]{20,100,10,12,5,13})); // true

        System.out.println("********************************************************");

        System.out.println(increasingTriplet_v2(new int[]{1,2,3,4,5})); // true
        System.out.println(increasingTriplet_v2(new int[]{5,4,3,2,1})); // false
        System.out.println(increasingTriplet_v2(new int[]{2,1,5,0,4,6})); // true
        System.out.println(increasingTriplet_v2(new int[]{20,100,10,12,5,13})); // true
    }
}
