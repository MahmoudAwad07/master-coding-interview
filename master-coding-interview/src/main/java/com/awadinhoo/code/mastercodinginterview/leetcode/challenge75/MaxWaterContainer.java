package com.awadinhoo.code.mastercodinginterview.leetcode.challenge75;

public class MaxWaterContainer {



    public static int maxArea(int[] height) {

        int maxArea = 0;
        int leftPointer = 0;
        int rightPointer = height.length - 1;
        int minHeight = 0;
        int width = 0;
        int currentArea = 0;

        while (leftPointer < rightPointer){

            width = rightPointer - leftPointer;
            minHeight = Math.min(height[leftPointer] , height[rightPointer]);
            currentArea = width * minHeight;

            if(currentArea > maxArea){
                maxArea = currentArea;
            }

            if(height[leftPointer] > height[rightPointer]){
                rightPointer --;
            }else{
                leftPointer ++;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {

        // [1,8,6,2,5,4,8,3,7] --> 49
        // [1,1] --> 1
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(maxArea(new int[] {1,1}));

    }
}
