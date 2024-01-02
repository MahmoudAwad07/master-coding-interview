package com.awadinhoo.code.mastercodinginterview.designgurus.codingpatterns.warmup;

public class SqrtSolution {


    public static int mySqrt(int x) {


        // Time Complexity --> O( Log n)
        // Space Complexity --> O(1)

        if(x < 2){
            return x;
        }else if(x == 2){
            return 1;
        }

        int left = 0;
        int right = x;
        int pivot = 0;
        int sqrt = 0;
        long num = 0;

        while (left <= right){

            pivot = left + (right - left) / 2;
            num = (long) pivot * pivot;

            if(num < x){
                left = pivot + 1;
                sqrt = pivot;
            }else if(num > x){
                right = pivot - 1;
            }else {
                sqrt = pivot;
                break;
            }
        }
        return sqrt;
    }

    public static void main(String[] args) {

        System.out.println(mySqrt(8));
        System.out.println(mySqrt(4));
        System.out.println(mySqrt(2));


    }
}
