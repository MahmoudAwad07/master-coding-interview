package com.awadinhoo.code.mastercodinginterview.douglas;

public class Test2 {


    public static int computeClosestToZero(int[] ts) {
        // Write your code here

        if(ts == null || ts.length == 0 ){
            return 0;
        }
        int closest = Math.abs(ts[0]);
        int closestIndex = 0;

        for (int i = 1; i < ts.length ; i++){

            int temp = Math.abs(ts[i]);
            if(temp < closest){
                closest = temp;
                closestIndex = i;
            }else if(temp == closest){

                if(ts[i] > 0){
                    closest = temp;
                    closestIndex = i;
                }
            }
        }

        return ts[closestIndex];
    }

    public static void main(String[] args) {



    }
}
