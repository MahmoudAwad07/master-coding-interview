package com.awadinhoo.code.mastercodinginterview.bigO;

public class NestedLoopWithMultiplication {



    // Solution :
        // Time Complexity : O(n)
        // Explanation : O(1+1+1+1 + log n (1 + 1) + 2n + 1) = 5 +  2 log n + 2n
        // Remove the constants = O( log n + n )
        // Remove the non-dominant expressions = O(n)
    public static void main(String[] args) {
        int n = 10; // O(1)
        int sum = 0; //O(1)
        double pie = 3.14; //O(1)
        int var = 1; //O(1)

        while(var < n) { // O(log n)
            System.out.println("Pie: " + pie); //O(1)
            for (int j = 0; j < var; j++) { // O(2n)
                sum++; //O(1)
            }
            var *= 2;  //O(1)
        }
        System.out.println("Sum: " + sum); //O(1)
    }
}
