package com.awadinhoo.code.mastercodinginterview.test;

import java.util.ArrayDeque;
import java.util.Queue;

public class StringGenerator {


    public static String solution(int AA, int AB, int BB) {
        // Implement your solution here
        String AAString = "AA";
        String BBString = "BB";
        String ABString = "AB";

        StringBuilder result = new StringBuilder();
        String prevString = "";

        int max = AA;
        if(AA < AB){
            max = AB;
        }
        if(max < BB){
            max = BB;
        }

        for (int i = 0 ; i < max ; i++){

            if(AA > 0  && AA > BB){

                if(prevString.isEmpty() || !prevString.equals(AAString)){
                    result.append(AAString);
                    prevString = AAString;
                }
                AA--;
            }

            if(BB > 0 ){

                if(prevString.isEmpty() || (!prevString.equals(ABString) && !prevString.equals(BBString))){
                    result.append(BBString);
                    prevString = BBString;
                }
                BB--;
            }

            if(AB > 0 ){

                if(prevString.isEmpty() || !prevString.equals(AAString)){
                    result.append(ABString);
                    prevString = ABString;
                }
                AB--;
            }
        }

        return result.toString();

    }

    public static void main(String[] args) {

        //System.out.println(solution(5,0,2));
        //System.out.println(solution(1,2,1));
        //System.out.println(solution(0,2,0));
        //System.out.println(solution(0,0,10));
        //System.out.println(solution(0,0,0));
        System.out.println(solution(3,3,5));

    }
}
