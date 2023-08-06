package com.awadinhoo.code.mastercodinginterview.leetcode.challenge75;

public class StringCompression {



    public static int compress(char[] chars) {

        // chars = ["a","a","b","b","c","c","c"]
        // chars = ["a"]
        // chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]

        String s = "";
        char currentChar = chars[0];
        int count = 1;

        for(int i = 1 ; i < chars.length ; i++){

            if(currentChar == chars[i]) {
                count++;
            }else {
                s += currentChar;
                if(count > 1){
                    s += count;
                }
                currentChar = chars[i];
                count = 1;
            }
        }

        s += currentChar;
        if(count > 1)
            s+= count;

        for(int i = 0 ; i < s.length() ; i++){
            chars[i] = s.charAt(i);
        }
        System.out.println(s);
        return s.length();
    }


    public static int compress_enhanced(char[] chars) {

        // chars = ["a","a","b","b","c","c","c"]
        // chars = ["a"]
        // chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]

        int index = 0;
        int i = 0;
        int j = i;
        int count = 0;

        while (i < chars.length){

            while(j < chars.length && chars[i] == chars[j]){
                j++;
            }

            chars[index++] = chars[i];
            count = j - i;
            if(count > 1){
                for (char ch :(count+"").toCharArray()){
                    chars[index++] = ch;
                }
            }

            i = j;
        }
        return index;
    }
    public static void main(String[] args) {
        System.out.println(compress(new char[]{'a','a','b','b','c','c','c'}));
        System.out.println(compress(new char[]{'a'}));
        System.out.println(compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'}));

        System.out.println("********************************************");
        System.out.println(compress_enhanced(new char[]{'a','a','b','b','c','c','c'}));
        System.out.println(compress_enhanced(new char[]{'a'}));
        System.out.println(compress_enhanced(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'}));
    }
}
