package com.awadinhoo.code.mastercodinginterview.stack;

import java.util.*;

public class ValidParentheses {


    public static boolean isValid(String str){

        // Time Complexity --> O(n)
        // Space Complexity --> O(n)

        Stack<Character> characterStack = new Stack<>();

        for (char ch :str.toCharArray()){

            // check if the character is open bracket
            if(ch == '(' || ch == '{' || ch == '['){
                characterStack.push(ch);
            }

            // check if the character is close bracket
            if(ch == ')' || ch == '}' || ch == ']'){
                // the stack is empty
                if(characterStack.isEmpty()){
                    return false;
                }else {
                    // check if the characters are matched
                   if(!isCharMatch(ch, characterStack.pop())){
                       return false;
                   }
                }
            }
        }
        return characterStack.isEmpty();
    }

    private static boolean isCharMatch(char ch, Character pop) {

        return ( ch == ')' && pop == '(' ) ||
                ( ch == '}' && pop == '{' ) ||
                ( ch == ']' && pop == '[' );
    }

    public static boolean isValid_v2(String str){

        // Time Complexity --> O(n)
        // Space Complexity --> O(n)

        Stack<Character> characterStack = new Stack<>();
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put(')','(');
        brackets.put('}','{');
        brackets.put(']','[');

        for (char ch :str.toCharArray()){

            // get the bracket to check if the character is open bracket
            Character bracket = brackets.get(ch);
            if(bracket == null){
                characterStack.push(ch);
            }

            // close bracket
            if(bracket != null){
                if(characterStack.isEmpty()){
                    return false;
                }else {
                    // the value in the hashmap should equal the first value on the stack :)
                    if(bracket != characterStack.pop()){
                        return false;
                    }
                }
            }
        }
        return characterStack.isEmpty();
    }


    public static boolean isValid_v3(String str){

        // Time Complexity --> O(n)
        // Space Complexity --> O(n)

        Stack<Character> characterStack = new Stack<>();
        List<Character> leftBrackets = Arrays.asList('(', '{', '[');
        List<Character> rightBrackets = Arrays.asList(')','}',']');

        for (char ch :str.toCharArray()){

            // check if the character is on the left brackets list
            if(isOnBracketList(leftBrackets, ch)){
                characterStack.push(ch);
            }

            // check if the character is on the right brackets list
            if(isOnBracketList(rightBrackets, ch)){
                // the stack is empty
                if(characterStack.isEmpty()){
                    return false;
                }else {
                    // check the brackets is matched
                    if(!isBracketMatch(leftBrackets, rightBrackets, ch, characterStack.pop())){
                        return false;
                    }
                }
            }
        }
        return characterStack.isEmpty();
    }

    private static boolean isBracketMatch(List<Character> leftBrackets, List<Character> rightBrackets, char ch, char pop) {
        // check if the index of the character on the left is equal to the index of the character on the right
        return leftBrackets.indexOf(pop) == rightBrackets.indexOf(ch);
    }

    public static boolean isOnBracketList(List<Character> brackets , char ch){
        // check if the bracket is on the list
        return brackets.contains(ch);
    }



    public static void main(String[] args) {

        System.out.println(isValid("{{]}"));
        System.out.println(isValid_v2("{{]}"));
        System.out.println(isValid_v3("{{]}"));
        System.out.println("************************");
        System.out.println(isValid("{{[]()}}"));
        System.out.println(isValid_v2("{{[]()}}"));
        System.out.println(isValid_v3("{{[]()}}"));
    }
}
