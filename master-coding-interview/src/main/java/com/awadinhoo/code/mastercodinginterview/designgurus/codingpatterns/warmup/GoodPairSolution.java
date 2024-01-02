package com.awadinhoo.code.mastercodinginterview.designgurus.codingpatterns.warmup;

import java.util.HashSet;
import java.util.Set;

public class GoodPairSolution {


    public static int numGoodPairs(int[] nums) {
        int pairCount = 0;

        Set<Integer> uniqueNums = new HashSet<>();

        for(Integer num : nums){

            if(!uniqueNums.add(num)){
                pairCount++;
            }
        }
        return pairCount;
    }


    public static void main(String[] args) {

        // [1,2,3,1,1,3]
        System.out.println(numGoodPairs(new int[] {1,2,3,1,1,3}));
        System.out.println(numGoodPairs(new int[] {1,1,1,1}));
        System.out.println(numGoodPairs(new int[] {1,2,3}));

    }
}
