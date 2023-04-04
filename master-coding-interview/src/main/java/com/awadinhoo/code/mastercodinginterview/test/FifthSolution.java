package com.awadinhoo.code.mastercodinginterview.test;

public class FifthSolution {


    public static String newPassword(String a, String b) {

        StringBuilder newPassword = new StringBuilder();
        int leftIndex = 0;
        int rightIndex = 0;

        while (leftIndex < a.length() && rightIndex < b.length()){
            newPassword.append(a.charAt(leftIndex));
            newPassword.append(b.charAt(rightIndex));
            leftIndex++;
            rightIndex++;
        }

        while(leftIndex < a.length()){
            newPassword.append(a.charAt(leftIndex));
            leftIndex++;
        }

        while(rightIndex < b.length()){
            newPassword.append(b.charAt(rightIndex));
            rightIndex++;
        }

        return newPassword.toString();
    }

    public static void main(String[] args) {

        // craatbbit
        System.out.println(newPassword("cat", "rabbit"));

    }
}
