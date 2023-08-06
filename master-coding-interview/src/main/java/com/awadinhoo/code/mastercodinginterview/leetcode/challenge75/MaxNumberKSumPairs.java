package com.awadinhoo.code.mastercodinginterview.leetcode.challenge75;

import java.util.Arrays;

public class MaxNumberKSumPairs {

    public static int maxOperations(int[] nums, int k) {

        int counter = 0;
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        int sum = 0;
        Arrays.sort(nums);

        while(leftIndex < rightIndex){

            sum = nums[leftIndex] + nums[rightIndex];
            if(sum == k){
                counter++;
                leftIndex++;
                rightIndex--;
            }else if(sum < k){
                leftIndex++;
            }else{
                rightIndex--;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        System.out.println(maxOperations(new int[]{1,2,3,4}, 5)); // 2
        System.out.println(maxOperations(new int[]{3,1,3,4,3}, 6)); // [1,3,3,3,4]1
    }
}
