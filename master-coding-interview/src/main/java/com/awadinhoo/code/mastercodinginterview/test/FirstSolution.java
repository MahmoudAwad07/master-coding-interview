package com.awadinhoo.code.mastercodinginterview.test;

import java.util.ArrayList;
import java.util.List;

public class FirstSolution {



    public static List<Integer> oddNumbers(int l, int r) {
        // Write your code here
        List<Integer> oddNumbers = new ArrayList<>();

        for (int i = l ; i <= r ; i++){
            if(i % 2 != 0){
                oddNumbers.add(i);
            }
        }

        return oddNumbers;
    }

    public static void main(String[] args){

        System.out.println(oddNumbers(2,5));

    }
}
