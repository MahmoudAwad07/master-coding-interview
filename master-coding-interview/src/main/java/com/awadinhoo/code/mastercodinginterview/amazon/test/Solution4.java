package com.awadinhoo.code.mastercodinginterview.amazon.test;

import java.util.*;

public class Solution4 {




    public static List<Integer> maximumBookCopies(List<Integer> portalUpdate) {
        // Write your code here

        Map<Integer, Integer> books = new HashMap<>();
        int maxCopy = Integer.MIN_VALUE;
        int maxValue = 0;
        int secondMaxCopy = Integer.MIN_VALUE;
        int secondMaxValue = 0;
        boolean remove = false;
        List<Integer> maxCopies = new ArrayList<>();

        for( int bookId : portalUpdate){

            if (bookId < 0){
                remove = true;
                bookId = Math.abs(bookId);
            }

            Integer noOfCopies = books.get(bookId);

            if(noOfCopies != null && remove){
                books.put(bookId, noOfCopies - 1);
            }else if(!remove){
                books.merge(bookId , 1 , Integer::sum);
            }

            noOfCopies = books.get(bookId);

            if(noOfCopies > maxCopy){

                if(bookId != maxValue){
                    secondMaxValue = maxValue;
                    secondMaxCopy = maxCopy;
                    maxValue = bookId;
                }
                maxCopy = noOfCopies;
            }else if(noOfCopies < maxCopy) {

                if(bookId == maxValue && noOfCopies < secondMaxCopy){
                    maxValue = secondMaxValue;
                    maxCopy = secondMaxCopy;
                    secondMaxValue = bookId;
                    secondMaxCopy = noOfCopies;
                }else if(bookId != maxValue && noOfCopies > secondMaxCopy){
                    secondMaxValue = bookId;
                    secondMaxCopy = noOfCopies;
                }
            }
            maxCopies.add(maxCopy);
        }

        return maxCopies;
    }

    public static void main(String[] args) {

        List<Integer> portalUpdate1 = Arrays.asList(6,6,2,-6,-2,-6);
        List<Integer> portalUpdate2 = Arrays.asList(1,2,-1,2);
        List<Integer> portalUpdate3 = Arrays.asList(6,-6,6,-6);
        List<Integer> portalUpdate4 = Arrays.asList(6,6,2,-6,-6,3,2);

        System.out.println(maximumBookCopies(portalUpdate1));
        System.out.println(maximumBookCopies(portalUpdate2));
        System.out.println(maximumBookCopies(portalUpdate3));
        System.out.println(maximumBookCopies(portalUpdate4));


    }
}
