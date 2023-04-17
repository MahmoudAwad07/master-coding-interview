package com.awadinhoo.code.mastercodinginterview.douglas;

public class Test3 {


    public static String solve(int width, int height, int length, int mass) {
        // Write your code here
        // To debug: System.err.println("Debug messages...");

        int maxMass = 20;
        int maxVolume = 1000000;
        int maxDim = 150;

        boolean heavy = false;
        boolean blucky = false;

        if(mass >= maxMass ){
            heavy = true;
        }

        if(width >= maxDim || height >= maxDim ||  length >= maxDim){
            blucky = true;
        }

        if(width * height * length >= maxVolume){
            blucky = true;
        }

        if( heavy && blucky ){
            return "REJECTED";
        }else if( heavy || blucky){
            return "SPECIAL";
        }

        return "STANDARD";
    }

    public static void main(String[] args) {

        System.out.println(solve(170,150,120,20));

    }
}
