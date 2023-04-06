package com.awadinhoo.code.mastercodinginterview.stack;

import java.util.Arrays;
import java.util.Stack;

public class StringReverser {

    public static String reverse(String str){

        // Time Complexity --> O(2n) --> O(n)
        // Space Complexity --> O(n)
        Stack<Character> characterStack = new Stack<>();
        StringBuilder newString = new StringBuilder();

        for (char ch :str.toCharArray()){
            characterStack.push(ch);
        }

        while (!characterStack.isEmpty()){
            newString.append(characterStack.pop());
        }

        return newString.toString();
    }

    public static String reverse_v1(String str){

        // Time Complexity --> O(n)
        // Space Complexity --> O(1)
        StringBuilder newString = new StringBuilder();
        for (int i = str.length()-1 ; i >= 0 ; i--){
            newString.append(str.charAt(i));
        }

        return newString.toString();
    }

    public static void reverse_v2_inPlace(char[] s){

        // Time Complexity --> O(n)
        // Space Complexity --> O(1)

        int leftPointer = 0;
        int rightPointer = s.length - 1;

        while (leftPointer < rightPointer){
            char temp = s[leftPointer];
            s[leftPointer] = s[rightPointer];
            s[rightPointer] = temp;
            leftPointer++;
            rightPointer--;
        }

        System.out.println(Arrays.toString(s));
    }




    public static void main(String[] args) {

        System.out.println(reverse("Hello Awad"));
        System.out.println(reverse_v1("Hello Awad"));
        reverse_v2_inPlace("Hello Awad".toCharArray());

    }
}
