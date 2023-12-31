package com.awadinhoo.code.mastercodinginterview.designgurus.codingpatterns.warmup;

import java.util.*;

public class ContainsDuplicateSolution {


    public static boolean containsDuplicate(int[] nums) {
        // Time Complexity --> O(n^2)
        // Space Complexity --> O(1)

        for(int i = 0 ; i < nums.length ; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean containsDuplicate_v1(int[] nums) {
        // Time Complexity --> O(n Log n)
        // Space Complexity --> O(1)

        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length - 1 ; i++) {

            if(nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }


    public static boolean containsDuplicate_v2(int[] nums) {
        // Time Complexity --> O(n)
        // Space Complexity --> O(n)

        Set<Integer> uniqueNumbers = new HashSet<>();

        for(int i = 0 ; i < nums.length; i++) {

            if(!uniqueNumbers.add(nums[i])){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        // [1,2,3,4]
        System.out.println(containsDuplicate(new int[]{1,2,3,4}));
        System.out.println(containsDuplicate_v1(new int[]{1,2,3,4}));
        System.out.println(containsDuplicate_v2(new int[]{1,2,3,4}));

        System.out.println("*************************************************");

        System.out.println(containsDuplicate(new int[]{1,2,3,4,2}));
        System.out.println(containsDuplicate_v1(new int[]{1,2,3,4,2}));
        System.out.println(containsDuplicate_v2(new int[]{1,2,3,4,2}));


    }
}
