package com.awadinhoo.code.mastercodinginterview.unifonic;

public class Task2 {


    public static int solution(int[] A) {
        // Implement your solution here

        int prevSum = 0;
        int current = 0;
        int rightIndex = A.length - 1;
        int count = 0;

        for (int i = 0 ; i < A.length ; i++){

            current = A[i];
            if( current + prevSum < 0){
                // SWAP
                A[i] = A[rightIndex];
                A[rightIndex] = current;
                count++;
                rightIndex--;
            }

            prevSum += A[i];
        }

        return count;
    }

    public static void main(String[] args) {

        System.out.println(solution(new int[] {10,-10,-1,-1,10})); // 1
        System.out.println(solution(new int[] {-1,-1,-1,1,1,1,1})); // 3
        System.out.println(solution(new int[] {5,-2,-3,1})); // 0

    }
}
