package com.awadinhoo.code.mastercodinginterview.leetcode.challenge75;

public class PivotIndex {



    public static int pivotIndex(int[] nums) {

        // [1,7,3,6,5,6] --> 3
        // [0,1,8,11,17,23]
        // [27,20,17,11,6,0]
        // [1,2,3] --> -1
        // [1,3,3]
        // [6,5,3]
        // [2,1,-1] --> 0
        // [0,2,3]
        // [0,-1,0]

        int[] preNums = new int[nums.length];
        int[] postNums = new int[nums.length];
        int currentSum = 0;


        for(int i =0; i < nums.length; i++){
            preNums[i] = currentSum;
            currentSum += nums[i];
        }

        currentSum = 0 ;
        for(int i = nums.length - 1 ; i >= 0 ; i--){
            postNums[i] = currentSum;
            currentSum += nums[i];
        }

        for(int i = 0 ; i < nums.length ; i++){
            if(preNums[i] == postNums[i]){
                return i;
            }
        }

        return -1;
    }

    public static int pivotIndex_enhanced(int[] nums) {

        int[] postNums = new int[nums.length];
        int currentSum = 0;

        for(int i = nums.length - 1 ; i >= 0 ; i--){
            postNums[i] = currentSum;
            currentSum += nums[i];
        }


        currentSum = 0 ;
        for(int i = 0 ; i < nums.length ; i++){
            if(currentSum == postNums[i])
                return i;
            currentSum += nums[i];
        }

        return -1;
    }

    public static int pivotIndex_enhanced_v2(int[] nums) {

        int sum = 0;
        int rightSum = 0;
        int leftSum = 0;

        for(int i = 0 ; i < nums.length ; i++)
            sum += nums[i];

        for(int i = 0 ; i < nums.length ; i++){

            rightSum = sum - leftSum - nums[i];
            if(leftSum == rightSum){
                return i;
            }
            leftSum += nums[i];
        }

        return -1;
    }

    public static void main(String[] args) {

        System.out.println(pivotIndex(new int[]{1,7,3,6,5,6}));
        System.out.println(pivotIndex(new int[]{1,2,3}));
        System.out.println(pivotIndex(new int[]{2,1,-1}));

        System.out.println("***********************************");

        System.out.println(pivotIndex_enhanced(new int[]{1,7,3,6,5,6}));
        System.out.println(pivotIndex_enhanced(new int[]{1,2,3}));
        System.out.println(pivotIndex_enhanced(new int[]{2,1,-1}));

        System.out.println("***********************************");

        System.out.println(pivotIndex_enhanced_v2(new int[]{1,7,3,6,5,6}));
        System.out.println(pivotIndex_enhanced_v2(new int[]{1,2,3}));
        System.out.println(pivotIndex_enhanced_v2(new int[]{2,1,-1}));

    }
}
