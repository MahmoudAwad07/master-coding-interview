package com.awadinhoo.code.mastercodinginterview.test;

public class StringGenerator2 {



    public static String solution(int AA, int AB, int BB) {
        StringBuilder result = new StringBuilder(); // initialize the output string
        while (AA > 0 && BB > 0) { // while there are both "AA" and "BB" left
            if (AA > BB) { // if "AA" is larger, append it
                result.append("AA");
                AA--;
                if (AA > AB) { // if appending "AA" violates the constraint, append "AB" instead
                    result.append("AB");
                    AB--;
                }
            } else { // if "BB" is larger or equal, append it
                result.append("BB");
                BB--;
                if (BB > AB) { // if appending "BB" violates the constraint, append "AB" instead
                    result.append("AB");
                    AB--;
                }
            }
        }
        // if there are any "AA" or "BB" left, append them
        while (AA > 0) {
            result.append("AA");
            AA--;
        }
        while (BB > 0) {
            result.append("BB");
            BB--;
        }
        // append the remaining "AB" strings
        while (AB > 0) {
            result.append("AB");
            AB--;
        }
        return result.toString(); // return the output string
    }

    public static void main(String[] args) {

        System.out.println(solution(5,0,2));
        System.out.println(solution(1,2,1));
        System.out.println(solution(0,2,0));
        System.out.println(solution(0,0,10));

    }
}
