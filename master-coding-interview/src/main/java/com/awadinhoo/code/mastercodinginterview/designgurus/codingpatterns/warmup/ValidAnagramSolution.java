package com.awadinhoo.code.mastercodinginterview.designgurus.codingpatterns.warmup;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagramSolution {



    public static boolean isAnagram(String s, String t) {

        if(s.length() != t.length())
            return false;

        char[] charArrayOfS = s.toCharArray();
        char[] charArrayOfT = t.toCharArray();

        Arrays.sort(charArrayOfS);
        Arrays.sort(charArrayOfT);

        s = String.valueOf(charArrayOfS);
        t = String.valueOf(charArrayOfT);

        return s.contentEquals(t);
    }

    public static boolean isAnagram_v2(String s, String t) {

        if(s.length() != t.length())
            return false;

        Map<Character, Integer> charOccurrence = new HashMap<>();

        for(int i = 0 ; i < s.length() ; i++){

            charOccurrence.put(s.charAt(i), charOccurrence.getOrDefault(s.charAt(i) , 0) + 1);

            charOccurrence.put(t.charAt(i), charOccurrence.getOrDefault(t.charAt(i) , 0) - 1);
        }

        for(Character ch : charOccurrence.keySet()){

            if(charOccurrence.get(ch) != 0){
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(isAnagram("listen", "slient" ));

        System.out.println("***************************************");

        System.out.println(isAnagram_v2("listen", "slient" ));

    }
}
