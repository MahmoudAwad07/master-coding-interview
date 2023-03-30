package com.awadinhoo.code.mastercodinginterview.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ThirdSolution {

    public static List<String> fetchItemsToDisplay(List<List<String>> items, int sortParameter, int sortOrder, int X) {

        List<String> temp;

        List<String> result = new ArrayList<>();

        for(int i = 0 ; i < items.size() ; i++){
            for (int j = i+ 1 ; j < items.size() ; j++){

                if(sortParameter == 0){
                    if(items.get(i).get(sortParameter).compareTo(items.get(j).get(sortParameter)) > 0){
                        temp = items.get(i);
                        items.set(i, items.get(j));
                        items.set(j, temp);
                    }
                }else {

                    if(Integer.parseInt(items.get(i).get(sortParameter)) > (Integer.parseInt(items.get(j).get(sortParameter)))){
                        temp = items.get(i);
                        items.set(i, items.get(j));
                        items.set(j, temp);
                    }
                }
            }
        }

        System.out.println(items);

        if(sortOrder == 0){

            for (int i =0 ; i < X ; i++){
                result.add(items.get(i).get(0));
            }

        }else {

            for (int i = items.size() - 1 ; i > items.size() - X ; i--){
                result.add(items.get(i).get(0));
            }
        }

        return result;
    }


    public static List<String> fetchItemsToDisplay_v2(List<List<String>> items, int sortParameter, int sortOrder, int X) {


        List<String> result = new ArrayList<>();

        Collections.sort(items, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                if(sortParameter == 0) {
                    return o1.get(sortParameter).compareTo(o2.get(sortParameter));
                } else {
                    return Integer.parseInt(o1.get(sortParameter)) >  Integer.parseInt(o2.get(sortParameter)) ? 1 : -1;
                }
            }
        });

        System.out.println(items);

        if(sortOrder == 0){

            for (int i =0 ; i < X ; i++){
                result.add(items.get(i).get(0));
            }

        }else {

            for (int i = items.size() - 1 ; i > items.size() - X ; i--){
                result.add(items.get(i).get(0));
            }
        }

        return result;
    }
    public static void main(String[] args) {

        List<List<String>> array = new ArrayList<>();



        List<String> array1 = new ArrayList<>();
        array1.add("p1");
        array1.add("10");
        array1.add("15");

        List<String> array2 = new ArrayList<>();
        array2.add("p2");
        array2.add("3");
        array2.add("4");

        List<String> array3 = new ArrayList<>();
        array3.add("p3");
        array3.add("17");
        array3.add("8");

        array.add(array1);
        array.add(array2);
        array.add(array3);

        System.out.println(array);

        // System.out.println(fetchItemsToDisplay(array, 1 , 0 , 2));
        System.out.println(fetchItemsToDisplay_v2(array, 1 , 0 , 2));
    }
}
