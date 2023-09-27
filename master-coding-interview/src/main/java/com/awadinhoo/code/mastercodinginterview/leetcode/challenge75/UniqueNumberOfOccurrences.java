package com.awadinhoo.code.mastercodinginterview.leetcode.challenge75;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOfOccurrences {


    public static boolean uniqueOccurrences(int[] arr) {


        // arr = [1,2,2,1,1,3] --> true
        // arr = [1,2] --> false
        // arr = [-3,0,1,-3,1,1,1,-3,10,0] --> true

        // hashMap --> {1 --> 3, 2 --> 2 , 3 --> 1} --> true
        // hashMap --> {1 --> 1, 2 --> 1 } --> false

        // Time Complexity --> O(n)
        // Space Complexity --> O(n)

        Map<Integer, Integer> occurrences = new HashMap<>();
        Set<Integer> uniqueValues = new HashSet<>();

        if(arr == null){
            return true;
        }

        for (int num : arr){
            if(occurrences.get(num) == null){
                occurrences.put(num, 1);
            }else {
                occurrences.put(num, occurrences.get(num) + 1);
            }
        }

        uniqueValues.addAll(occurrences.values());

        return occurrences.values().size() == uniqueValues.size();
    }


    public static void main (String[] args){

        System.out.println(uniqueOccurrences(new int[] {1,2,2,1,1,3}));
        System.out.println(uniqueOccurrences(new int[] {1,2}));
        System.out.println(uniqueOccurrences(new int[] {-3,0,1,-3,1,1,1,-3,10,0}));
        System.out.println(uniqueOccurrences(null));


    }
}
