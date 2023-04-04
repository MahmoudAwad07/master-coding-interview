package com.awadinhoo.code.mastercodinginterview.bigO;

public class NestedLoopWithMultiplication3 {



    // Solution :
        // Time Complexity : O(n log n)
        // Explanation : O( 1+1+1+1 + n/3 (1 + 1 + log n (1+1) ) +  1) = 5 + n + 2n/3 log n
        // Remove the constants = O( n + n log n )
        // Remove the non-dominant expressions = O(n log n)
        // noted the log base is 3 in this case, and can be converted to base 2 without any change in time complexity
    public static void main(String[] args) {

        int n = 10;    // O(1)
        int sum = 0;  // O(1)
        int j = 1;   // O(1)
        double pie = 3.14;  // O(1)

        for (int var = 1; var < n; var += 3) { // O(n/3)

            System.out.println("Pie: " + pie); // O(1)
            j = 1; // O(1)
            while (j < n) { // O(log n)
                sum += 1; // O(1)
                j *= 3; // O(1)
            }
        }
        System.out.println("Sum: " + sum); // O(1)
    }
}
