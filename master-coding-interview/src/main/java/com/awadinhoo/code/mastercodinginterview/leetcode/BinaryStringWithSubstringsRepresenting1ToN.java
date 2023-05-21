package com.awadinhoo.code.mastercodinginterview.leetcode;

public class BinaryStringWithSubstringsRepresenting1ToN {


    public static boolean queryString(String s, int n) {

        for(int i = 1 ; i <= n ; i++){
            String binary = Integer.toBinaryString(i);
            if(!s.contains(binary)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        // "0110", n = 3
        System.out.println(queryString("0110", 3)); // true
        // "0110", n = 4
        System.out.println(queryString("0110", 4)); // false

    }
}
