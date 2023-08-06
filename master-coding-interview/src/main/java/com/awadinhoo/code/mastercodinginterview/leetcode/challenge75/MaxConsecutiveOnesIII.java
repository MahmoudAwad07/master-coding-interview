package com.awadinhoo.code.mastercodinginterview.leetcode.challenge75;

public class MaxConsecutiveOnesIII {



    public static int longestOnes(int[] nums, int k) {

        int i = 0;
        int j = 0;
        int zerosCount = 0;
        int longestOnes = 0;

        while (j < nums.length){

            if(nums[j] == 0){
                zerosCount++;
            }

            while (zerosCount > k){
                if(nums[i] == 0){
                    zerosCount--;
                }
                i++;
            }
            longestOnes = Math.max(longestOnes, j-i+1);
            j++;
        }

        return longestOnes;
    }

    public static void main(String[] args) {
        System.out.println(longestOnes(new int[] {1,1,1,0,0,0,1,1,1,1,0}, 2));
        System.out.println(longestOnes(new int[] {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
    }
}
