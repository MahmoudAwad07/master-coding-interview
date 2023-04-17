package com.awadinhoo.code.mastercodinginterview.douglas;

public class Test {


    public static int solve(int weight0, int weight1, int weight2) {
        // Write your code here

        int heaviest = weight0;
        int result = 0;

        if(heaviest < weight1){
            heaviest = weight1;
            result = 1;
        }

        if(heaviest < weight2) {
            heaviest = weight2;
            result = 2;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
