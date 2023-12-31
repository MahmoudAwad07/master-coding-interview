package com.awadinhoo.code.mastercodinginterview.leetcode.challenge75;

import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {

    Queue<Integer> calls;
     public RecentCounter() {
         calls = new LinkedList<>();
     }

    public int ping(int t) {

        calls.add(t);
        while (!calls.isEmpty() && calls.peek() < t - 3000) {
            calls.remove();
        }
        return calls.size();
    }

    public static void main(String[] args){

    }
}
