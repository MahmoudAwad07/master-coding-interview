package com.awadinhoo.code.mastercodinginterview.leetcode.challenge75;

public class GreatestCommonDivisorStrings {


    public static String gcdOfStrings(String str1, String str2) {

        int str1Length = str1.length();
        int str2Length = str2.length();

        int minLength = Math.min(str1Length, str2Length);

        for (int i = 1 ; i <= minLength; i++){

            int str1Factor = str1Length / i;
            int str2Factor = str2Length / i;
            String commonString = str1.substring(0, i);

            if(createString(commonString, str1Factor).equals(str1) && createString(commonString, str2Factor).equals(str2)){
                return commonString;
            }
        }

        return "";
    }

    private static String createString(String s, int numberToRepeat){

        StringBuilder newString = new StringBuilder();
        int count = 0;

        while (count < numberToRepeat){
            newString.append(s);
            count++;
        }
        return newString.toString();
    }


    public static String gcdOfStrings_v2(String str1, String str2) {

        int str1Length = str1.length();
        int str2Length = str2.length();

        int minLength = Math.min(str1Length, str2Length);

        for (int i = 1 ; i <= minLength; i++){

            String commonString = str1.substring(0, i);
            if(str1.replace(commonString, "").isEmpty() && str2.replace(commonString,"").isEmpty()){
                return commonString;
            }
        }

        return "";
    }

    public static String gcdOfStrings_v3(String str1, String str2) {

        int str1Length = str1.length();
        int str2Length = str2.length();

        int minLength = Math.min(str1Length, str2Length);

        for (int i = minLength ; i > 0 ; i--){

            String commonString = str1.substring(0, i);
            int commonStringLength = commonString.length();

            if(str1Length % commonStringLength == 0 && str2Length % commonStringLength == 0){
                if(str1.replace(commonString, "").isEmpty() && str2.replace(commonString,"").isEmpty()){
                    return commonString;
                }
            }
        }

        return "";
    }


    public static String gcdOfStrings_v4(String str1, String str2) {
        // Check if concatenated strings are equal or not, if not return ""
        if (!(str1 + str2).equals(str2 + str1))
            return "";
        // If strings are equal than return the substring from 0 to gcd of size(str1), size(str2)
        int gcd = gcd(str1.length(), str2.length());
        return str1.substring(0, gcd);
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {

        System.out.println(gcdOfStrings("ABCABC", "ABC")); // "ABC"
        System.out.println(gcdOfStrings("ABABAB", "ABAB")); // "AB"
        System.out.println(gcdOfStrings("LEET", "CODE")); // ""
        System.out.println("*********************************");
        System.out.println(gcdOfStrings_v2("ABCABC", "ABC")); // "ABC"
        System.out.println(gcdOfStrings_v2("ABABAB", "ABAB")); // "AB"
        System.out.println(gcdOfStrings_v2("LEET", "CODE")); // ""
        System.out.println("*********************************");
        System.out.println(gcdOfStrings_v3("ABCABC", "ABC")); // "ABC"
        System.out.println(gcdOfStrings_v3("ABABAB", "ABAB")); // "AB"
        System.out.println(gcdOfStrings_v3("LEET", "CODE")); // ""
        System.out.println("*********************************");
        System.out.println(gcdOfStrings_v4("ABCABC", "ABC")); // "ABC"
        System.out.println(gcdOfStrings_v4("ABABAB", "ABAB")); // "AB"
        System.out.println(gcdOfStrings_v4("LEET", "CODE")); // ""

    }
}
