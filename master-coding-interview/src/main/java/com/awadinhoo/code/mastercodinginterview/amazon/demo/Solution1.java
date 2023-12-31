package com.awadinhoo.code.mastercodinginterview.amazon.demo;

import java.util.*;

public class Solution1 {



    public static int countGroups(List<String> related) {
        // Write your code here
        int rows = related.size();
        int columns = related.get(0).length();
        Set<Integer> visited = new HashSet<>();

        Map<Integer, List<Integer>> adjacent = new HashMap<>();

        for(int i = 0 ; i < rows ; i++){

            adjacent.put(i, new ArrayList<>());

            for(int j = 0 ; j < columns ; j++){

                if(i == j){
                    continue;
                }else {

                    if(related.get(i).charAt(j) == '1'){
                        adjacent.get(i).add(j);
                    }
                }
            }
        }

        return countGroups(adjacent , visited);
    }

    public static int countGroups(Map<Integer, List<Integer>> adjacencyList, Set<Integer> visited){

        Queue<Integer> usersQueue = new LinkedList<>();
        int groups = 0;

        for(Integer userId : adjacencyList.keySet()){

            if(!visited.contains(userId)){
                groups++;
                usersQueue.add(userId);
            }

            while (!usersQueue.isEmpty()){

                Integer polledUserId = usersQueue.poll();
                if(!visited.contains(polledUserId)){
                    visited.add(polledUserId);
                    usersQueue.addAll(adjacencyList.get(polledUserId));
                }
            }
        }

       return groups;
    }

    public static void main(String[] args) {

        System.out.println(countGroups(Arrays.asList("1100","1110","0110","0001")));
        System.out.println(countGroups(Arrays.asList("110","110","001")));
        System.out.println(countGroups(Arrays.asList("1000","0100","0010","0001")));


    }
}
