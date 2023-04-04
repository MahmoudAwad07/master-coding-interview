package com.awadinhoo.code.mastercodinginterview.bigO;

public class ProblemSet1 {


    // Solution :
        // input : sorted array
        // Time Complexity : O(n^2)
        // Explanation : the time complexity here is quadratic
        // because the check doesn't break the loop it touches all the previous values even if they are smaller.
    void sort(int[] input) {

        for (int i = 1; i < input.length; i++) { // O(n)

            int key = input[i]; // O(1)

            for (int j = i - 1; j >= 0; j--) { // O(n)
                if (input[j] > key) { // O(1)
                    int tmp = input[j]; // O(1)
                    input[j] = key; // O(1)
                    input[j + 1] = tmp; // O(1)
                }
            }
        }
    }

    static Double getPow(Integer number, Integer exp ){
        return Math.pow(number,exp);
    }

    static Integer getModules (Integer n , Integer m){
        return m % n;
    }

    public static void main(String[] args) {
        System.out.println(getPow(-2, 2));
        System.out.println(getPow(-3, 3));

        // when n > m return m
        System.out.println(getModules(10, 5));
        // when n == m return 0
        System.out.println(getModules(10, 10));
        // when n < m return number from 1 to n-1
        System.out.println(getModules(5, 12));
    }
}
