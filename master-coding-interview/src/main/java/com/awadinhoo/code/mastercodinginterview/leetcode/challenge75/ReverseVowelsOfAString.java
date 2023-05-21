package com.awadinhoo.code.mastercodinginterview.leetcode.challenge75;

import java.util.HashMap;
import java.util.HashSet;

public class ReverseVowelsOfAString {


    public static String reverseVowels(String s) {

        // vowels = 'a', 'e', 'i', 'o', and 'u'

        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        char[] chars = s.toCharArray();

        int leftIndex = 0;
        int rightIndex = chars.length - 1;

        while (leftIndex < rightIndex){

            char leftChar = chars[leftIndex];
            char rightChar = chars[rightIndex];
            char tempChar;

            if(vowels.contains(leftChar) && vowels.contains(rightChar)){
                tempChar = leftChar;
                chars[leftIndex] = rightChar;
                chars[rightIndex] = tempChar;
                leftIndex++;
                rightIndex--;

            } else if (vowels.contains(leftChar)) {
                rightIndex--;
            } else if (vowels.contains(rightChar)) {
                leftIndex++;
            }else {
                leftIndex++;
                rightIndex--;
            }
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {

        // Hello
        System.out.println(reverseVowels("Hello")); // Holle
        // leetcode
        System.out.println(reverseVowels("leetcode")); // leotcede
    }
}
