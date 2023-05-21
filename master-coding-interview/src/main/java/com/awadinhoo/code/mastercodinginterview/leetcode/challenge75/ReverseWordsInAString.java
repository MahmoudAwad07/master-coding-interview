package com.awadinhoo.code.mastercodinginterview.leetcode.challenge75;

public class ReverseWordsInAString {


    public static String reverseWords(String s) {

        StringBuilder reversedString = new StringBuilder();
        String[] words = s.trim().split("\\s+");

        for (int i = words.length - 1 ; i >= 0 ; i--){
            reversedString.append(words[i]).append(" ");

        }
        return reversedString.toString().trim();
    }

    public static void main(String[] args) {

        // "the sky is blue"
        System.out.println(reverseWords("the sky is blue")); // "blue is sky the"
        // "  hello world  "
        System.out.println(reverseWords("  hello world  ")); // "world hello"
        // "a good   example"
        System.out.println(reverseWords("a good   example")); // "example good a"

    }
}
