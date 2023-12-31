package com.awadinhoo.code.mastercodinginterview.designgurus.codingpatterns.warmup;

import java.util.HashSet;
import java.util.Set;

public class PangramSentenceSolution {



    public static boolean checkIfPangram(String sentence) {

        // Time Complexity --> O(n)
        // Space Complexity --> O(1)
        int[] chars = new int[26];

        // mark each corresponding index with 1, if found
        for(char ch : sentence.toLowerCase().toCharArray()){
            if(Character.isLetter(ch)){
                int index = ch - 'a';
                chars[index] = 1;
            }
        }

        for(int i = 0; i < chars.length ; i++){
            if(chars[i] == 0){
                return false;
            }
        }
        return true;
    }


    public static boolean checkIfPangram_enhanced_v1(String sentence) {

        // Time Complexity --> O(n)
        // Space Complexity --> O(1)
        Set<Character> uniqueChars = new HashSet<>();

        for(char ch : sentence.toLowerCase().toCharArray()){
            if(Character.isLetter(ch)){
                uniqueChars.add(ch);
            }
        }
        return uniqueChars.size() == 26;
    }

    public static void main(String[] args) {

    }
}
