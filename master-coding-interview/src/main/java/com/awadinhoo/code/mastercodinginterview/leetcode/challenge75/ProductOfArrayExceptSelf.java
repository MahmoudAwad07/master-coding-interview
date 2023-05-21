package com.awadinhoo.code.mastercodinginterview.leetcode.challenge75;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {


    public static int[] productExceptSelf(int[] nums) {

        int length = nums.length;
        int[] result = new int[length];
        int prevProduct = 1;
        int currentProduct = 1;

        for (int i = 0 ; i < length; i++ ){
            currentProduct = 1;
            for(int j = i+1 ; j < length ; j++){
                currentProduct *= nums[j];
            }
            currentProduct *= prevProduct;
            result[i] = currentProduct;
            prevProduct *= nums[i];
        }

        return result;
    }

    public static int[] productExceptSelf_v2(int[] nums) {

        int length = nums.length;
        int[] result = new int[length];
        int prevProduct = 1;
        int nextProduct = 1;
        int currentProduct = 1;

        //  [1,2,3,4]
        for (int i = 0 ; i < length; i++ ){
            result[i] = prevProduct;
            prevProduct *= nums[i];
        }

        // [1,1,2,6]
        for (int i = length - 1 ; i >= 0 ; i--){
            result[i] *= nextProduct;
            nextProduct *= nums[i];
        }

        return result;
    }

    public static void main(String[] args) {

        // [1,2,3,4]
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4}))); // [24,12,8,6]
        // [-1,1,0,-3,3]
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1,1,0,-3,3}))); // [0,0,9,0,0]
        System.out.println("*********************************************");
        System.out.println(Arrays.toString(productExceptSelf_v2(new int[]{1,2,3,4})));
        System.out.println(Arrays.toString(productExceptSelf_v2(new int[]{-1,1,0,-3,3})));

    }
}
