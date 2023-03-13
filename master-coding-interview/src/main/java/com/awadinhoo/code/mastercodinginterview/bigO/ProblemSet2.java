package com.awadinhoo.code.mastercodinginterview.bigO;

public class ProblemSet2 {


    public static void main(String[] args) {
        char[] array = new char[] { 'a', 'b', 'c', 'd' };
        permutate(array, 0);
    }

    private static void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    static void permutate(char[] str, int index) {

        // base case
        if (index == str.length) {
            System.out.println(str);
            return;
        }

        // regular case
        for (int i = index; i < str.length; i++) {
            swap(str, index, i);
            permutate(str, index + 1);
            swap(str, index, i);
        }
    }
}
