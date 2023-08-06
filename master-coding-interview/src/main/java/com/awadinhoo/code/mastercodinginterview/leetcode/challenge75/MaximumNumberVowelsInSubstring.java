package com.awadinhoo.code.mastercodinginterview.leetcode.challenge75;

import java.util.HashSet;
import java.util.Set;

public class MaximumNumberVowelsInSubstring {



    public static int maxVowels(String s, int k) {


        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        int currentVowels = 0;
        int maxVowels = 0;

        // k = 3
        // 0 1 2 3 4 5 6 7 8
        // a b c i i i d e f

        // get the number of vowels for the first substring
        for(int i = 0 ; i < k ; i++){
            if(vowels.contains(s.charAt(i))){
                currentVowels++;
            }
        }

        // set as the max, to compare it later
        maxVowels = currentVowels;

        for(int i = k ; i < s.length() ; i++){

            // if the added char is vowel , increase the current vowels
            if(vowels.contains(s.charAt(i))){
                currentVowels++;
            }

            // if the removed char is vowel , decrease the current vowels
            if(vowels.contains(s.charAt(i-k))){
                currentVowels--;
            }

            // compare to get the max number of vowels
            if(currentVowels > maxVowels){
                maxVowels = currentVowels;
            }

        }

        return maxVowels;
    }

    public static void main(String[] args) {

    }
}
