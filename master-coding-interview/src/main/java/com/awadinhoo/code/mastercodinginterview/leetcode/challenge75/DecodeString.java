package com.awadinhoo.code.mastercodinginterview.leetcode.challenge75;

import java.util.Stack;

public class DecodeString {


    public String decodeString(String s) {


        // Time Complexity --> O(n)
        // Space Complexity --> O(n)
        Stack<String> stringStack = new Stack<>();
        StringBuilder decodedString = new StringBuilder();

        for(int i = 0 ; i < s.length() ; i++){

            char ch = s.charAt(i);

            if (ch != ']'){
                stringStack.push(String.valueOf(ch));
            }else {

                StringBuilder substring = new StringBuilder();
                String popedString = stringStack.pop();
                while (!popedString.equals("[")){
                    substring.insert(0,popedString);
                    popedString = stringStack.pop();
                }

                StringBuilder repetitionNumber = new StringBuilder();
                popedString = stringStack.pop();
                while(popedString.matches("[0-9]")){
                    repetitionNumber.insert(0, popedString);

                    if(stringStack.isEmpty())
                        break;

                    popedString = stringStack.pop();
                }

                if(!stringStack.isEmpty())
                    stringStack.push(popedString);

                int counter = Integer.parseInt(repetitionNumber.toString());
                while (counter > 0 ){
                    stringStack.push(substring.toString());
                    counter--;
                }
            }
        }

        for (String str : stringStack){
            decodedString.append(str);
        }

        return decodedString.toString();
    }


    public String decodeString_v2(String s) {
        Stack<Integer> is = new Stack<>();
        Stack<StringBuilder> ss = new Stack<>();

        int n = s.length();
        int num = 0;
        StringBuilder str = new StringBuilder();

        for(char ch : s.toCharArray()) {

            // There will be 4 types of characters --> number, [ , ], character
            if(Character.isDigit(ch)) {
                num = (num * 10) + ch - '0';
            } else if(ch == '[') {
                ss.push(str);
                str = new StringBuilder();

                is.push(num);
                num = 0;
            } else if(ch == ']') {
                StringBuilder temp = str;
                str = ss.pop();
                int count = is.pop();

                while(count-- > 0) {
                    str.append(temp);
                }
            } else {
                str.append(ch);
            }
        }
        return str.toString();
    }

    public static void main (String[] args){

//        System.out.println(decodeString("3[a]2[bc]"));
//        System.out.println(decodeString("3[a2[c]]"));
//        System.out.println(decodeString("2[abc]3[cd]ef"));
//        System.out.println(decodeString_v2("3[a2[c]]"));


    }
}
