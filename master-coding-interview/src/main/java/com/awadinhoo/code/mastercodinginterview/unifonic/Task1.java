package com.awadinhoo.code.mastercodinginterview.unifonic;

import java.math.BigInteger;

public class Task1 {


    public static int solution(String S) {
        // Implement your solution here

        // get the Decimal representation
        // check if it is even , divide it by 2
        // else minus it by 1

        long currentTime = System.currentTimeMillis();

        int operationsCount = 0;
        BigInteger decimalValue = new BigInteger(S, 2);
        BigInteger two = new BigInteger("2");

        while (decimalValue.compareTo(BigInteger.ZERO) > 0){

            if(decimalValue.remainder(two).compareTo(BigInteger.ZERO) == 0){
                decimalValue = decimalValue.divide(two);
            }else {
                decimalValue = decimalValue.subtract(BigInteger.ONE);
            }
            operationsCount++;
        }

        System.out.println("Time Consumed using normal operations in Ms :" + (System.currentTimeMillis() - currentTime));

        return operationsCount;
    }

    public static int solution_enhanced(String S) {
        // Implement your solution here

        // get the Decimal representation
        // check if it is even , divide it by 2
        // else minus it by 1

        long currentTime = System.currentTimeMillis();

        int operationsCount = 0;
        BigInteger decimalValue = new BigInteger(S, 2);

        while (decimalValue.compareTo(BigInteger.ZERO) > 0){

            // check if the number is odd
            if(decimalValue.testBit(0)){
                // number is odd
                decimalValue = decimalValue.subtract(BigInteger.ONE);
            }else {
                // number is even
                decimalValue = decimalValue.shiftRight(1);
            }
            operationsCount++;
        }

        System.out.println("Time Consumed using Bit operations in Ms :" + (System.currentTimeMillis() - currentTime));

        return operationsCount;
    }

    public static void main(String[] args) {

        System.out.println(solution("011100")); // 7
        System.out.println(solution("111")); // 5
        System.out.println(solution("1111010101111")); // 22


        StringBuilder stringBuilder = new StringBuilder(); // 799,999
        for (int i = 1 ; i <= 400000; i++){
            stringBuilder.append("1");
        }

        System.out.println(solution(stringBuilder.toString()));
        System.out.println(solution_enhanced(stringBuilder.toString()));

    }
}
