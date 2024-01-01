package com.awadinhoo.code.mastercodinginterview.designgurus.codingpatterns.warmup;

import java.util.Arrays;

public class ValidAnagramSolution {



    public boolean isAnagram(String s, String t) {

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

    public static void main(String[] args) {

    }
}
