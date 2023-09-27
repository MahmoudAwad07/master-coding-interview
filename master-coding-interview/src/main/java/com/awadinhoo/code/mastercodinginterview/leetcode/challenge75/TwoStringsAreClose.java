package com.awadinhoo.code.mastercodinginterview.leetcode.challenge75;

import java.util.*;
import java.util.stream.Collectors;

public class TwoStringsAreClose {


    public static boolean closeStrings(String word1, String word2) {

        Map<Character, Integer> occurrencesWord1 = new HashMap<>();
        Map<Character, Integer> occurrencesWord2 = new HashMap<>();

        if(word1.length() != word2.length()){
            return false;
        }

        for(int i = 0; i < word1.length() ; i++){

            char ch1 = word1.charAt(i);
            char ch2 = word2.charAt(i);
            occurrencesWord1.merge(ch1, 1 , Integer::sum);
            occurrencesWord2.merge(ch2, 1 , Integer::sum);
        }

        for(int i = 0; i < word1.length() ; i++){

            char ch1 = word1.charAt(i);
            char ch2 = word2.charAt(i);

            if(occurrencesWord2.get(ch1) == null
                    || occurrencesWord1.get(ch2) == null ){
                return false;
            }
        }
        List<Integer> occurrenceValues1 = new ArrayList<>(occurrencesWord1.values());
        List<Integer> occurrenceValues2 = new ArrayList<>(occurrencesWord2.values());

        Collections.sort(occurrenceValues1);
        Collections.sort(occurrenceValues2);

        return occurrenceValues1.equals(occurrenceValues2);
    }

    public static void main (String[] args){

        // word1 = "abc", word2 = "bca" --> true
        //  word1 = "a", word2 = "aa"  --> false
        // word1 = "cabbba", word2 = "abbccc" --> true
        System.out.println(closeStrings( "abc", "bca"));
        System.out.println(closeStrings( "a", "aa"));
        System.out.println(closeStrings( "cabbba", "abbccc"));

    }
}
