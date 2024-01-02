package com.awadinhoo.code.mastercodinginterview.designgurus.codingpatterns.warmup;

import java.util.Stack;

public class ShortestDistanceSolution {


    public int shortestDistance(String[] words, String word1, String word2) {

        int shortestPath = words.length;
        int word1Index = -1 ;
        int word2Index = -1 ;

        for(int i = 0 ; i < words.length ; i++){

            if(word1.contentEquals(words[i])){
                word1Index = i;
            }

            if(word2.contentEquals(words[i])){
                word2Index = i;
            }

            if(word1Index != -1 && word2Index != -1){
                shortestPath = Math.min(shortestPath, Math.abs(word1Index - word2Index));
            }
        }

        return shortestPath;
    }

    public static void main(String[] args) {

    }
}
