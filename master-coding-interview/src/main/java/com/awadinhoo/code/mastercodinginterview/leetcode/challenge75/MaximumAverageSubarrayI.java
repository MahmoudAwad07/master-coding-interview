package com.awadinhoo.code.mastercodinginterview.leetcode.challenge75;

public class MaximumAverageSubarrayI {



    public static double findMaxAverage(int[] nums, int k) {

        // 1,12,-5,-6,50,3
        double maxSum = 0;
        double currentSum = 0;
        int[] sumArray = new int[nums.length];
        sumArray[0] = nums[0];
        for (int i = 1 ; i < nums.length ; i++){
            sumArray[i] = sumArray[i-1] + nums[i];
        }
        // 1,13,8,2,52,53
        maxSum = sumArray[k-1];
        for(int i = k ; i < sumArray.length ; i++){
            currentSum = sumArray[i] - sumArray[i-k];
            if(currentSum > maxSum){
                maxSum = currentSum;
            }
        }

        return maxSum / k;
    }

    public static double findMaxAverage_enhanced(int[] nums, int k) {

        // 1,12,-5,-6,50,3
        double maxSum = 0;
        double currentSum = 0;

        for (int i = 0 ; i < k ; i++){
            currentSum += nums[i];
        }

        maxSum = currentSum;
        for(int i = k ; i < nums.length ; i++){
            currentSum += nums[i] - nums[i-k];

            if(currentSum > maxSum){
                maxSum = currentSum;
            }
        }

        return maxSum / k;
    }

    public static void main(String[] args) {

        System.out.println(findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
        System.out.println(findMaxAverage(new int[]{5}, 1));
        System.out.println(findMaxAverage(new int[]{0,1,1,3,3}, 4));
        System.out.println(findMaxAverage(new int[]{4,0,4,3,3}, 5));
    }
}
