package com.awadinhoo.code.mastercodinginterview.designgurus.codingpatterns.warmup;

import java.util.Stack;

public class ValidPalindromeSolution {




    public static boolean isPalindrome(String s) {

        // Time Complexity --> O(n)
        // Space Complexity --> O(n)

        StringBuilder alphabetString = new StringBuilder();
        int leftIndex = 0 ;
        int rightIndex = 0;

        for(char ch : s.toLowerCase().toCharArray()){
            if(Character.isLetterOrDigit(ch)){
                alphabetString.append(ch);
            }
        }

        rightIndex = alphabetString.length() - 1;

        while (leftIndex < rightIndex){

            if(alphabetString.charAt(leftIndex) != alphabetString.charAt(rightIndex)){
                return false;
            }
            leftIndex++;
            rightIndex--;
        }

        return true;
    }

    public static boolean isPalindrome_v2(String s) {

        // Time Complexity --> O(n)
        // Space Complexity --> O(n)

        StringBuilder alphabetString = new StringBuilder();
        StringBuilder reversedString = new StringBuilder();
        Stack<Character> characterStack = new Stack<>();

        for(char ch : s.toLowerCase().toCharArray()){
            if(Character.isLetterOrDigit(ch)){
                alphabetString.append(ch);
                characterStack.push(ch);
            }
        }

        while (!characterStack.isEmpty()){
            reversedString.append(characterStack.pop());
        }

        return alphabetString.toString().contentEquals(reversedString);
    }


    public static void main(String[] args) {


        // amanaplanacanalpanama -->
        // wasitacaroracatisaw
        System.out.println(isPalindrome("A man, a plan, a canal, Panama!"));
        System.out.println(isPalindrome("Was it a car or a cat I saw?"));

        System.out.println("********************************************");

        System.out.println(isPalindrome_v2("A man, a plan, a canal, Panama!"));
        System.out.println(isPalindrome_v2("Was it a car or a cat I saw?"));

    }
}
