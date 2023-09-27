package com.awadinhoo.code.mastercodinginterview.leetcode.challenge75;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TheDifferenceOfTwoArrays {


    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        // nums1 = [1,2,3], nums2 = [2,4,6] --> [[1,3],[4,6]]
        // nums1 = [1,2,3,3], nums2 = [1,1,2,2] --> [[3],[]]

        List<List<Integer>> differenceList = new ArrayList<>();
        Set<Integer> uniqueNums1 = new HashSet<>();
        Set<Integer> uniqueNums2 = new HashSet<>();

        boolean found = false;

        for (int i = 0; i < nums1.length; i++) {
            found = false;
            for (int j = 0; j < nums2.length; j++) {

                if (nums1[i] == nums2[j]) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                uniqueNums1.add(nums1[i]);
            }
        }

        for (int i = 0; i < nums2.length; i++) {
            found = false;
            for (int j = 0; j < nums1.length; j++) {

                if (nums1[i] == nums2[j]) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                uniqueNums2.add(nums2[i]);
            }
        }


        differenceList.add(new ArrayList<>(uniqueNums1));
        differenceList.add(new ArrayList<>(uniqueNums2));

        return differenceList;

    }


    public static List<List<Integer>> findDifference_enhanced(int[] nums1, int[] nums2) {

        // nums1 = [1,2,3], nums2 = [2,4,6] --> [[1,3],[4,6]]
        // nums1 = [1,2,3,3], nums2 = [1,1,2,2] --> [[3],[]]


        // Time Complexity --> O(n)
        // Space Complexity --> O(1)
        // Test Cases
        // nums1 = null , nums2 = [2,4,6]
        // nums1 = [1,2,3] , nums2 = null
        // nums1 = null , nums2 = null
        // nums1 = [1,2], nums2 = [2,4,6,7]

        List<List<Integer>> differenceList = new ArrayList<>();
        Set<Integer> uniqueNums1 = new HashSet<>();
        Set<Integer> uniqueNums2 = new HashSet<>();


        if (nums1 != null) {
            for (int num : nums1) {
                uniqueNums1.add(num);
            }
        }

        if (nums2 != null) {
            for (int num : nums2) {
                uniqueNums2.add(num);
            }
        }

        if (nums1 != null) {
            for (int num : nums1) {
                if (uniqueNums2.contains(num)) {
                    uniqueNums2.remove(num);
                }
            }
        }

        if (nums2 != null) {
            for (int num : nums2) {
                if (uniqueNums1.contains(num)) {
                    uniqueNums1.remove(num);
                }
            }
        }

        differenceList.add(new ArrayList<>(uniqueNums1));
        differenceList.add(new ArrayList<>(uniqueNums2));

        return differenceList;
    }

    public static void main(String[] args) {

        System.out.println(findDifference_enhanced(new int[]{1,2,3}, new int[]{2,4,6}));
        System.out.println(findDifference_enhanced(new int[]{1,2,3,3}, new int[]{1,1,2,2}));
        System.out.println(findDifference_enhanced(null, new int[]{2,4,6}));
        System.out.println(findDifference_enhanced(new int[]{1,2,3,3},null));
        System.out.println(findDifference_enhanced(null,null));
        System.out.println(findDifference_enhanced(new int[]{1,2},new int[]{2,4,6,7}));

    }
}
