package com.awadinhoo.code.mastercodinginterview.bigO;

public class NestedLoopWithMultiplication2 {



    // Solution :
        // Time Complexity : O(n log n)
        // Explanation : O(1+1+1+1 + log n (1 + 1 + n/2(1) ) +  1) = 5 +  2 log n + n log n /2
        // Remove the constants = O( log n + n log n )
        // Remove the non-dominant expressions = O(n log n)
        // noted the log base is 3 in this case, and can be converted to base 2 without any change in time complexity
    public static void main(String[] args) {
        int n = 10; //  O(1)
        int sum = 0; // O(1)
        double pie = 3.14; // O(1)
        int var = 1; // O(1)

        while(var < n) { // O(log n)
            System.out.println("Pie: " + pie); // O(1)
            for (int j = 1; j < n; j = j + 2) { // O(n/2)
                sum++; // O(1)
            }
            var *= 3; // O(1)
        }
        System.out.println("Sum: " + sum); // O(1)
    }
}
