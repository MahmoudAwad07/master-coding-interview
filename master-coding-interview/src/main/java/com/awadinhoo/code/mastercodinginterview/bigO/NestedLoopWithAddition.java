package com.awadinhoo.code.mastercodinginterview.bigO;

public class NestedLoopWithAddition {


    // Solution :
        // Time Complexity : O(n^2)
        // Explanation : O(1+1+1+ n/3(1+ n/2( 1+ 1) ) = 3 +  n/3(1+n) = 3 + n/3 + n^2/3
        // Remove the constants = O( n + n^2 )
        // Remove the non-dominant expressions = O(n^2)
    public static void main(String[] args) {
        int n = 10; // O(1)
        int sum = 0; // O(1)
        double pie = 3.14; // O(1)

        for (int var = 0; var < n; var = var + 3) { // O(n/3)
            System.out.println("Pie: " + pie); // O(1)
            for (int j = 0; j < n; j = j + 2) { // O(n/2)
                sum++; // O(1)
                System.out.println("Sum = " + sum); // O(1)
            }
        }
    }

}
