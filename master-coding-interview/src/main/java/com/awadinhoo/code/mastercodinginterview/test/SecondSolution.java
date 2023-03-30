package com.awadinhoo.code.mastercodinginterview.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SecondSolution {


    public static String findNumber(List<Integer> arr, int k) {
        // Write your code here

        for(Integer number : arr){
            if(k == number){
                return "YES";
            }
        }

        return "NO";
    }

    public static void main(String[] args){

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println(findNumber(list,3));
    }
}
