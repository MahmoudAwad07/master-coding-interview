package com.awadinhoo.code.mastercodinginterview.amazon.test;

public class Solution1 {



    public static String password( String[] passwords, String checkString ) {
        //Insert your code here

        for(int i = 0 ; i < passwords.length; i++ ){

            String pass = passwords[i];
            if(checkPass (pass, checkString)){
                return pass;
            }
        }

        return "";
    }

    private static boolean checkPass(String password , String checkString){

        int sum = 0;
        int noOfUpperLetters = 0;
        int passLength = password.length();
        String lastThree = checkString.substring(1, checkString.length() - 1);
        StringBuilder sb = new StringBuilder();


        for(int i = passLength - 1  ; i >= 0 ; i--){

            char ch = password.charAt(i);

            if(Character.isDigit(ch)){
                sum += Integer.parseInt(String.valueOf(ch));

            }else {

                if(Character.isUpperCase(ch)){
                    noOfUpperLetters++;
                }
            }

            if(i == passLength - 1 || i == passLength - 2 || i == passLength - 3){
                sb.append(ch);
            }
        }

        return noOfUpperLetters == Integer.parseInt(String.valueOf(checkString.charAt(0)))
                && lastThree.equals(sb.toString())
                && sum == Integer.parseInt(String.valueOf(checkString.charAt(checkString.length() -1)));

    }


    public static void main(String[] args) {

    }
}
