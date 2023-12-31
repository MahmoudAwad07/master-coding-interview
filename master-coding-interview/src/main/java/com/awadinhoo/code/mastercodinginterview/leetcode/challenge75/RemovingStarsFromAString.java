package com.awadinhoo.code.mastercodinginterview.leetcode.challenge75;

import java.util.Stack;

public class RemovingStarsFromAString {



    public static String removeStars(String s) {

        while (s.contains("*")){
            int starIndex = s.indexOf("*");
            s = s.substring(0,starIndex - 1) + s.substring(starIndex + 1);
        }
        return s;
    }

    public static String removeStars_enhanced(String s) {

        Stack<Character> reversedCharacters = new Stack<>();
        Stack<Character> characters = new Stack<>();
        StringBuilder resultString = new StringBuilder();

        for (Character ch : s.toCharArray()){
            if(ch.equals('*')){
                if(!reversedCharacters.isEmpty()) {
                    reversedCharacters.pop();
                }
            }else {
                reversedCharacters.push(ch);
            }
        }


        while (!reversedCharacters.isEmpty()){
            characters.push(reversedCharacters.pop());
        }

        while(!characters.isEmpty()){
            resultString.append(characters.pop());
        }

        return resultString.toString();
    }


    public static String removeStars_enhanced_v2(String s) {

        Stack<Character> characters = new Stack<>();
        StringBuilder resultString = new StringBuilder();

        for (Character ch : s.toCharArray()){
            if(ch.equals('*')){
                if(!characters.isEmpty()) {
                    characters.pop();
                }
            }else {
                characters.push(ch);
            }
        }

        for(char ch : characters){
            resultString.append(ch);
        }

        return resultString.toString();
    }

    public static String removeStars_enhanced_v3(String s) {

        StringBuilder resultString = new StringBuilder();

        for (Character ch : s.toCharArray()){
            if(ch.equals('*')){
               resultString.deleteCharAt(resultString.length() - 1);
            }else {
               resultString.append(ch);
            }
        }
        return resultString.toString();
    }

    public static void main (String[] args){

        System.out.println(removeStars("leet**cod*e"));
        System.out.println(removeStars("erase*****"));

        System.out.println("****************************************");

        System.out.println(removeStars_enhanced("leet**cod*e"));
        System.out.println(removeStars_enhanced("erase*****"));

        System.out.println("****************************************");

        System.out.println(removeStars_enhanced_v2("leet**cod*e"));
        System.out.println(removeStars_enhanced_v2("erase*****"));

        System.out.println("****************************************");

        System.out.println(removeStars_enhanced_v3("leet**cod*e"));
        System.out.println(removeStars_enhanced_v3("erase*****"));


    }
}
