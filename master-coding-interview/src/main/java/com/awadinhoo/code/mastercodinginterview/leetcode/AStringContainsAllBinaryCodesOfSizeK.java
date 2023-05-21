package com.awadinhoo.code.mastercodinginterview.leetcode;

import java.util.HashSet;

public class AStringContainsAllBinaryCodesOfSizeK {


    public static boolean hasAllCodes(String s, int k) {

        HashSet<String> codes = new HashSet<>();
        int codeEnd;

        for(int i = 0 ; i <= s.length() - k ; i++){
            codeEnd = i+k;
            codes.add(s.substring(i,codeEnd));
        }

        return codes.size() == Math.pow(2,k);
    }

    public static void main(String[] args) {

        // "00110110", k = 2
        System.out.println(hasAllCodes("00110110", 2 )); // true
        // "0110", k = 1
        System.out.println(hasAllCodes("0110", 1 )); // true
        //  "0110", k = 2
        System.out.println(hasAllCodes("0110", 2 )); // false
        // 00110, k = 2
        System.out.println(hasAllCodes("00110", 2 )); // true
    }
}
