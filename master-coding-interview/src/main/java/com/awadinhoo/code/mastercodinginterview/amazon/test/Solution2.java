package com.awadinhoo.code.mastercodinginterview.amazon.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution2 {

    public static int findMinimumNumberOfPages_v1(List<Integer> pages, int days) {
        // Write your code here

        int minNumberOfPages = Integer.MAX_VALUE;
        boolean minFound = false;
        int readDays = 0;
        int numOfDaysForChapter = 0;
        int pagesToReadDaily = 0;

        for (int i = 0; i < pages.size(); i++) {
            pagesToReadDaily = pages.get(i);
            readDays = 0;

            for (int j = 0; j < pages.size(); j++) {
                numOfDaysForChapter = pages.get(j) / pagesToReadDaily;
                numOfDaysForChapter += pages.get(j) % pagesToReadDaily != 0 ? 1 : 0;
                readDays += numOfDaysForChapter;
            }

            if (readDays <= days &&  pagesToReadDaily < minNumberOfPages) {
                minFound = true;
                minNumberOfPages = pagesToReadDaily;
            }
        }

        return minFound ? minNumberOfPages : -1;

    }


    public static int findMinimumNumberOfPages_v2(List<Integer> chapters, int maxDays) {

        int leftIndex = 0 ;
        int rightIndex = chapters.size();
        int minNumOfPages = -1 ;

        Collections.sort(chapters);

        while (leftIndex < rightIndex){

            int mid = (leftIndex + rightIndex) / 2 ;

            if(canReadInMaxDays(chapters, chapters.get(mid) , maxDays)){
                minNumOfPages = chapters.get(mid);
                rightIndex = mid;
            }else {
                leftIndex = mid + 1;
            }
        }

        return minNumOfPages;
    }

    private static boolean canReadInMaxDays(List<Integer> chapters, int maxPagesPerDay, int maxDays) {

        int readDays = 0;

        for (Integer ch : chapters) {

            if(ch % maxPagesPerDay != 0){
                readDays ++;
            }
            readDays += ch / maxPagesPerDay ;
        }

        return readDays <= maxDays;
    }


    public static void main(String[] args) {

        System.out.println(findMinimumNumberOfPages_v1(Arrays.asList(2, 4, 3), 4));
        System.out.println(findMinimumNumberOfPages_v1(Arrays.asList(2, 3, 4, 5), 5));
        System.out.println(findMinimumNumberOfPages_v1(Arrays.asList(3, 1, 5, 3, 2), 2));

        System.out.println("*************************************************************");
        System.out.println(findMinimumNumberOfPages_v2(Arrays.asList(2, 4, 3), 4));
        System.out.println(findMinimumNumberOfPages_v2(Arrays.asList(2, 3, 4, 5), 5));
        System.out.println(findMinimumNumberOfPages_v2(Arrays.asList(3, 1, 5, 3, 2), 2));
    }
}
