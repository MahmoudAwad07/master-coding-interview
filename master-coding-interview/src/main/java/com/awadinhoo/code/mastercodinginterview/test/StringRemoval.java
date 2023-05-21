package com.awadinhoo.code.mastercodinginterview.test;

import java.util.HashMap;
import java.util.Stack;

public class StringRemoval {


    public static String solution(String S) {
        // Implement your solution here

        while (!S.isEmpty()){

            if(S.contains("AB")){
                S = S.replace("AB", "");
            }else if(S.contains("BA")){
                S = S.replace("BA", "");
            }else if(S.contains("CD")){
                S = S.replace("CD", "");
            }else if(S.contains("DC")){
                S = S.replace("DC", "");
            }else {
                break;
            }
        }

        return S;

    }


    public static String solution_v4(String S) {
        // Implement your solution here

        // Remove "AB"
        S = S.replace("AB", "");

        // Remove "BA"
        S = S.replace("BA", "");

        // Remove "CD"
        S = S.replace("CD", "");

        // Remove "DC"
        S = S.replace("DC", "");

        return S;

    }


    public static String solution_v2(String S) {
        // Implement your solution here

        boolean replaced;

        while (!S.isEmpty()){

            replaced = false;

            if(S.contains("AB")){
                S = S.replace("AB", "");
                replaced = true;
            }

            if(S.contains("BA")){
                S = S.replace("BA", "");
                replaced = true;
            }

            if(S.contains("CD")){
                S = S.replace("CD", "");
                replaced = true;
            }

            if(S.contains("DC")){
                S = S.replace("DC", "");
                replaced = true;
            }

            if(!replaced){
                break;
            }
        }

        return S;

    }

    public static void main(String[] args) {

//        System.out.println(solution("CBACD"));
//        System.out.println(solution("CABABD"));
//        System.out.println(solution("ACBDACBD"));

        System.out.println("***************************************");
        System.out.println(solution_v2("CBACD"));
        System.out.println(solution_v2("CABABD"));
        System.out.println(solution_v2("ACBDACBD"));
        System.out.println(solution_v2("AABB"));


        //System.out.println(solution_v4("CBACD"));
        //System.out.println(solution_v4("CABABD"));
        //System.out.println(solution_v4("ACBDACBD"));
        //System.out.println(solution("AABB"));
    }
}
