package com.awadinhoo.code.mastercodinginterview.designgurus.codingpatterns.warmup;

import java.util.HashMap;
import java.util.Map;

public class GoodNumbersSolution {



    public static int numGoodPairs(int[] nums) {

        // Time Complexity --> O(n)
        // Space Complexity --> O(n)

        Map<Integer, Integer> numsOccurrence = new HashMap<>();
        int numPairs = 0;

        for(Integer num : nums){

            Integer occurrence = numsOccurrence.get(num);
            if(occurrence != null){
                numPairs += occurrence;
                numsOccurrence.put(num, occurrence + 1);
            }else {
                numsOccurrence.put(num , 1);
            }
        }
        return numPairs;
    }

    public static void main(String[] args) {


        System.out.println(numGoodPairs(new int[] {1,2,3,1,1,3}));
        System.out.println(numGoodPairs(new int[] {1,1,1,1}));
        System.out.println(numGoodPairs(new int[] {1,2,3}));
    }
}
