package com.awadinhoo.code.mastercodinginterview.leetcode.challenge75;

import java.util.ArrayList;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandies {


    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        List<Boolean> result = new ArrayList<>();
        int maxCandies = candies[0];

        // Get Max Candies
        for (int i = 0 ; i < candies.length ; i++){
            if(candies[i] > maxCandies){
                maxCandies = candies[i];
            }
        }

        for (int i =0 ; i < candies.length ; i++){

            if(candies[i] + extraCandies >= maxCandies ){
                result.add(true);
            }else {
                result.add(false);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        // candies = [2,3,5,1,3], extraCandies = 3
        System.out.println(kidsWithCandies(new int[]{2,3,5,1,3}, 3)); // [true,true,true,false,true]
        // candies = [4,2,1,1,2], extraCandies = 1
        System.out.println(kidsWithCandies(new int[]{4,2,1,1,2}, 1)); // [true,false,false,false,false]
        // candies = [12,1,12], extraCandies = 10
        System.out.println(kidsWithCandies(new int[]{12,1,12}, 10)); // [true,false,true]

    }
}
