package com.awadinhoo.code.mastercodinginterview.leetcode.challenge75;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Dota2Senate {




    public static String predictPartyVictory(String senate) {

        Queue<Character> senateQueue = new LinkedList<>();
        int rCount = 0;
        int dCount = 0;

        for (char ch : senate.toCharArray()){
            senateQueue.add(ch);
        }

        while (rCount <= senateQueue.size() && dCount <= senateQueue.size()){

            Character senateTurn = senateQueue.remove();

            if(senateTurn.equals('R')){

                if(dCount > 0){
                    dCount--;
                }else {
                    rCount++;
                    if(senateQueue.isEmpty()){
                        break;
                    }
                    senateQueue.add(senateTurn);
                }
            }else {

                if(rCount > 0){
                    rCount--;
                }else {
                   dCount++;
                    if(senateQueue.isEmpty()){
                        break;
                    }
                   senateQueue.add(senateTurn);
                }
            }

        }

        if(rCount > senateQueue.size()){
            return "Radiant";
        }else{
            return "Dire";
        }
    }


    public static String predictPartyVictory_enhanced(String senate) {

        Queue<Integer> rQueue = new LinkedList<>();
        Queue<Integer> dQueue = new LinkedList<>();
        int stringSize = senate.length();
        
        for (int i = 0 ; i < senate.length() ; i++){
            char ch = senate.charAt(i);
            if( ch == 'R'){
               rQueue.add(i);
           }else {
               dQueue.add(i);
           }
        }

        while (!rQueue.isEmpty() && !dQueue.isEmpty()){

            Integer rTurn = rQueue.remove();
            Integer dTurn = dQueue.remove();

            if(rTurn < dTurn){
                rQueue.add(rTurn + stringSize);
            }else {
                dQueue.add(dTurn + stringSize);
            }
        }

        if(!rQueue.isEmpty()){
            return "Radiant";
        }

        return "Dire";
    }


    public static void main(String[] args){

        System.out.println(predictPartyVictory("RD"));
        System.out.println(predictPartyVictory("RDD"));
        System.out.println(predictPartyVictory("RRRDDDD"));

        System.out.println("********************************************");

        System.out.println(predictPartyVictory_enhanced("RD"));
        System.out.println(predictPartyVictory_enhanced("RDD"));
        System.out.println(predictPartyVictory_enhanced("RRRDDDD"));

    }
}
