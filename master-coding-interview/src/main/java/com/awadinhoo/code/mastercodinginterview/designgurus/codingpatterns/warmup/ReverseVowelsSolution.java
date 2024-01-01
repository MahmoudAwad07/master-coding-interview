package com.awadinhoo.code.mastercodinginterview.designgurus.codingpatterns.warmup;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsSolution {


    public static String reverseVowels(String s) {


        // TIme Complexity --> O(n)
        // Space Complexity --> O(n)

        // s= "hello"
        Set<Character> vowels = new HashSet<>();
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

        int leftIndex = 0;
        int rightIndex = s.length() - 1;

        char[] charArray = s.toCharArray();

        while (leftIndex < rightIndex) {

            char leftChar = charArray[leftIndex];
            char rightChar = charArray[rightIndex];
            char tempChar;

            if (vowels.contains(leftChar) && vowels.contains(rightChar)) {
                tempChar = leftChar;
                charArray[leftIndex] = rightChar;
                charArray[rightIndex] = tempChar;

                leftIndex++;
                rightIndex--;
            } else if (vowels.contains(leftChar)) {
                rightIndex--;
            } else if (vowels.contains(rightChar)) {
                leftIndex++;
            } else {
                leftIndex++;
                rightIndex--;
            }
        }

        return String.valueOf(charArray);
    }


    public static String reverseVowels_v2(String s) {


        // TIme Complexity --> O(n)
        // Space Complexity --> O(n)

        // s= "hello"
        Set<Character> vowels = new HashSet<>();
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

        int leftIndex = 0;
        int rightIndex = s.length() - 1;

        char[] charArray = s.toCharArray();

        while (leftIndex < rightIndex) {

            while (leftIndex < rightIndex && !vowels.contains(charArray[leftIndex])) {
                leftIndex++;
            }

            while (leftIndex < rightIndex && !vowels.contains(charArray[rightIndex])) {
                rightIndex--;
            }

            char tempChar = charArray[leftIndex];
            charArray[leftIndex] = charArray[rightIndex];
            charArray[rightIndex] = tempChar;
            leftIndex++;
            rightIndex--;
        }
        return String.valueOf(charArray);
    }

    public static void main(String[] args) {

        System.out.println(reverseVowels("hello"));
        System.out.println(reverseVowels("AEIOU"));
        System.out.println(reverseVowels("DesignGUrus"));

        System.out.println("****************************************");

        System.out.println(reverseVowels_v2("hello"));
        System.out.println(reverseVowels_v2("AEIOU"));
        System.out.println(reverseVowels_v2("DesignGUrus"));

    }
}
