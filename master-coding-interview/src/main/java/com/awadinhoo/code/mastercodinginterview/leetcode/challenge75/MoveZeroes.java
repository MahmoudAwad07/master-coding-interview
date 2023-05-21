package com.awadinhoo.code.mastercodinginterview.leetcode.challenge75;

import java.util.Arrays;

public class MoveZeroes {


    public static void moveZeroes(int[] nums) {

        int currentSwap = 0;
        int current = 0;

        for(int i = 0 ; i < nums.length ; i++){
            current = nums[i];
            if(current != 0){
                nums[i] = nums[currentSwap];
                nums[currentSwap] = current;
                currentSwap++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {

        // [0,1,0,3,12]
        moveZeroes(new int[]{0,1,0,3,12}); // [1,3,12,0,0]
        // [0]
        moveZeroes(new int[]{0}); // [0]
        // [1]
        moveZeroes(new int[]{1}); // [1]
    }
}
