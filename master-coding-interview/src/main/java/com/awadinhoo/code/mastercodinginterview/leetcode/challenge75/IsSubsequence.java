package com.awadinhoo.code.mastercodinginterview.leetcode.challenge75;

public class IsSubsequence {


    public static boolean isSubsequence_enhanced(String s, String t) {

        // case1 : s = "ace" , t = "ahbgdc" --> true
        // case2 : s = "axc", t = "ahbgdc"	--> fale

        int leftPointer = 0;
        int rightPointer = 0;

        while (leftPointer < s.length() && rightPointer < t.length()){

            if(s.charAt(leftPointer) == t.charAt(rightPointer)){
                leftPointer++;
                rightPointer++;
            }else{
                rightPointer++;
            }
        }

        return leftPointer == s.length();

    }

    public static boolean isSubsequence(String s, String t) {

        // case1 : s = "ace" , t = "ahbgdc" --> true
        // case2 : s = "axc", t = "ahbgdc"	--> false

        int lastIndex = Integer.MIN_VALUE;
        boolean isFound = false;
        int foundIndex = 0;

        for (int i = 0 ; i < s.length() ; i++){

            isFound = false;
            for (int j = 0 ; j < t.length(); j++){

                if(s.charAt(i) == t.charAt(j)){
                    isFound = true;
                    foundIndex = j;
                    break;
                }
            }

            if (!isFound || (isFound && foundIndex < lastIndex) ) {
                return false;
            }
            lastIndex = foundIndex;
        }

        return true;
    }

    public static void main(String[] args) {


        System.out.println(isSubsequence("ace" , "ahbgdc"));
        System.out.println(isSubsequence_enhanced("ace" , "ahbgdc"));

        System.out.println(isSubsequence("aec" , "ahbgdc"));
        System.out.println(isSubsequence_enhanced("aec" , "ahbgdc"));

        System.out.println(isSubsequence("axe" , "ahbgdc"));
        System.out.println(isSubsequence_enhanced("axe" , "ahbgdc"));

        System.out.println(isSubsequence("abc" , "ahbgdc"));
        System.out.println(isSubsequence_enhanced("abc" , "ahbgdc"));
    }

}
