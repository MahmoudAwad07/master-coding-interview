package com.awadinhoo.code.mastercodinginterview.bigO;

public class NestedLoopWithSubtraction {


    // Solution :
        // Time Complexity : O(n^2)
        // Explanation : O(1+1+1+ n/3(1+n(1))+ 1 ) = 4 +  n/3 + n^2/3
        // Remove the constants = O( n + n^2 )
        // Remove the non-dominant expressions = O(n^2)
    public static void main(String[] args) {
        int n = 10; // O(1)
        int sum = 0; // O(1)
        double pie = 3.14; // O(1)

        for (int var = n; var >= 1; var = var - 3) { // O(n/3)
            System.out.println("Pie: " + pie); // O(1)

            for (int j = n; j >= 0; j = j - 1) { // O(n)
                sum++; // O(1)
            }
        }
        System.out.println("Sum: " + sum); // O(1)
    }
}
