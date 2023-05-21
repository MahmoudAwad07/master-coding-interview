package com.awadinhoo.code.mastercodinginterview.leetcode.challenge75;

public class MergeStringsAlternately {


    public static String mergeAlternately(String word1, String word2) {

        StringBuilder mergedString = new StringBuilder();
        int word1Index = 0;
        int word2Index = 0;

        while (word1Index < word1.length() && word2Index < word2.length()){

            mergedString.append(word1.charAt(word1Index));
            mergedString.append(word2.charAt(word2Index));
            word1Index++;
            word2Index++;
        }

        while (word1Index < word1.length()){
            mergedString.append(word1.charAt(word1Index));
            word1Index++;
        }

        while (word2Index < word2.length()){
            mergedString.append(word2.charAt(word2Index));
            word2Index++;
        }

        return mergedString.toString();
    }

    public static void main(String[] args) {

        System.out.println(mergeAlternately("abc", "pqr")); // "apbqcr"
        System.out.println(mergeAlternately("ab", "pqrs")); // "apbqrs"
        System.out.println(mergeAlternately("abcd", "pq")); // "apbqcd"

    }
}
