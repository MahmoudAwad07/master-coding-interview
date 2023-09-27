package com.awadinhoo.code.mastercodinginterview.leetcode.challenge75;

public class LongestAltitude {


    public static int largestAltitude(int[] gain) {

        // [-5,1,5,0,-7] --> -5, -4 , 1, 1 , -6
        // [-4,-3,-2,-1,4,3,2] --> -4, -7, -9 , -10, -6 , -3 , -1

        // current Height
        int currentHeight = 0;
        // max Height
        int maxHeight = 0;

        for (int i = 0 ; i < gain.length ; i++){
            currentHeight += gain[i];
            maxHeight = Math.max(currentHeight, maxHeight);
        }
        return maxHeight;
    }

    public static void main(String[] args) {
        System.out.println(largestAltitude(new int[] {-5,1,5,0,-7}));
        System.out.println(largestAltitude(new int[] {-4,-3,-2,-1,4,3,2}));
    }
}
