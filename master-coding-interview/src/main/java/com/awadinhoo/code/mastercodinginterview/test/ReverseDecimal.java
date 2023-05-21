package com.awadinhoo.code.mastercodinginterview.test;

public class ReverseDecimal {


    public static void solution(int N) {

        int enable_print = N % 10;
        while (N > 0) {
            if (enable_print != 0 ) {
                enable_print = 1;
            }

            if (enable_print == 1) {
                System.out.print(N % 10);
            }
            N = N / 10;
            if(enable_print != 1) enable_print = N % 10;
        }
    }

    public void solution_v2(int N) {
        int enable_print = N % 10;
        while (N > 0) {
            if (enable_print == 0 && N % 10 != 0) {
                enable_print = 1;
            }
            else if (enable_print == 1) {
                System.out.print(N % 10);
            }
            N = N / 10;
        }
    }

    public static void main(String[] args) {

        //solution(100);
        //solution(10011);
        solution(1);

    }
}
