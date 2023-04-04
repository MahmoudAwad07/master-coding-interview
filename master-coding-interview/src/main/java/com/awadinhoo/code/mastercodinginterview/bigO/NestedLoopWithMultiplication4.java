package com.awadinhoo.code.mastercodinginterview.bigO;

public class NestedLoopWithMultiplication4 {


    // Solution :
        // Time Complexity : O(n log n)
        // Explanation : O( 1+1+1+1 + n (1 + 1 + log n (1+1) ) +  1) = 5 + n + 2n log n
        // Remove the constants = O( n + n log n )
        // Remove the non-dominant expressions = O(n log n)
    public static void main(String[] args) {

        int n = 10; // O(1)
        int sum = 0; // O(1)
        double pie = 3.14; // O(1)

        for (int var = 0; var < n; var++) { // O(n)

            int j = 1; // O(1)
            System.out.println("Pie: " + pie); // O(1)

            while(j < var) { // O(log n)
                sum += 1; // O(1)
                j *= 2; // O(1)
            }
        }

        System.out.println("Sum: " + sum); // O(1)
    }

}
