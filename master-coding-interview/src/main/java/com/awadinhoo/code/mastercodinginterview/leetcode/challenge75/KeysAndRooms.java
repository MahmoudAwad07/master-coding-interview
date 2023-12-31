package com.awadinhoo.code.mastercodinginterview.leetcode.challenge75;

import java.util.*;

public class KeysAndRooms {





    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {

        Set<Integer> haveAccess = new HashSet<>();
        haveAccess.add(0);

        Stack<Integer> keys = new Stack<>();
        keys.push(0);

        while (!keys.isEmpty()){
            List<Integer> newKeys = rooms.get(keys.pop());

            for( int newKey : newKeys){
                if(!haveAccess.contains(newKey)){
                    haveAccess.add(newKey);
                    keys.push(newKey);
                }
            }
        }


        return haveAccess.size() == rooms.size();
    }

    public static void main (String[] args ){

        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> room1 = Arrays.asList(1);
        List<Integer> room2 = Arrays.asList(2);
        List<Integer> room3 = Arrays.asList(3);
        List<Integer> room4 = Arrays.asList();
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        rooms.add(room4);

        System.out.println(canVisitAllRooms(rooms));

        List<List<Integer>> rooms2 = new ArrayList<>();
        List<Integer> room10 = Arrays.asList(1,3);
        List<Integer> room11 = Arrays.asList(3,0,1);
        List<Integer> room12 = Arrays.asList(2);
        List<Integer> room13 = Arrays.asList(0);
        rooms.add(room10);
        rooms.add(room11);
        rooms.add(room12);
        rooms.add(room13);

        System.out.println(canVisitAllRooms(rooms));


    }
}
