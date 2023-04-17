package com.awadinhoo.code.mastercodinginterview.douglas;

public class Test4 {



    public static int computeCheckDigit(String identificationNumber) {
        // Write your code here
        // To debug: System.err.println("Debug messages...");
        int result = 0;

        for (int i = 0 ; i < identificationNumber.length() ; i = i+2){
            result += Integer.parseInt(String.valueOf(identificationNumber.charAt(i)));
        }

        result *= 3;

        for (int i = 1 ; i < identificationNumber.length() ; i = i+2){
            result += Integer.parseInt(String.valueOf(identificationNumber.indexOf(i)));
        }

        result = result % 10;

        if(result == 0){
            return 0;
        }else {
            result = 10 - result;
            return result;
        }
    }
    public static void main(String[] args) {

        computeCheckDigit("39847");

    }
}
