package com.awadinhoo.code.mastercodinginterview.designgurus.array;

import java.util.Arrays;

public class RunningSum {



    public static int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        // TODO: Write your code here
        int currentSum = 0;

        for(int i = 0; i < nums.length; i++){
            currentSum += nums[i];
            result[i] = currentSum;
        }

        return result;
    }

    public static void main (String[] args){

        // [3,1,4,2,2] --> [3,4,8,10,12]
        System.out.println(Arrays.toString(runningSum(new int[]{3,1,4,2,2})));

    }
}
