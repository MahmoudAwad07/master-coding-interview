package com.awadinhoo.code.mastercodinginterview.graphs;

import java.util.*;

public class PathExistsInGraph {


    public static boolean validPath(int n, int[][] edges, int source, int destination) {

        HashMap<Integer, List<Integer>> adjacencyList = buildGraph(edges);
        System.out.println(adjacencyList);
        return validPath(adjacencyList, source, destination, new HashSet<>());
    }


    private static boolean validPath(HashMap<Integer, List<Integer>> adjacencyList , int source, int destination,
                                     Set<Integer> visited){

        if(source == destination){
            return true;
        }

        visited.add(source);
        for (int neighbour : adjacencyList.get(source)){

            if(!visited.contains(neighbour)){
                if(validPath(adjacencyList, neighbour, destination, visited)){
                    return true;
                }
            }
        }
        return false;
    }


    public static boolean validPathDFSIterative(int n, int[][] edges, int source, int destination) {

        HashMap<Integer, List<Integer>> adjacencyList = buildGraph(edges);
        System.out.println(adjacencyList);
        return validPathDFSIterative(adjacencyList, source, destination, new HashSet<>());
    }


    private static boolean validPathDFSIterative(HashMap<Integer, List<Integer>> adjacencyList , int source, int destination,
                                                 Set<Integer> visited){

        Stack<Integer> nodesStack = new Stack<>();

        nodesStack.push(source);
        while (!nodesStack.isEmpty()){

            int current = nodesStack.pop();

            if(current == destination){
                return true;
            }

            if(visited.contains(current)){
                continue;
            }

            visited.add(current);
            for (int neighbour : adjacencyList.get(current)){
                if(!visited.contains(neighbour)){
                   nodesStack.push(neighbour);
                }
            }
        }

        return false;
    }


    public static boolean validPathBFS(int n, int[][] edges, int source, int destination) {

        HashMap<Integer, List<Integer>> adjacencyList = buildGraph(edges);
        System.out.println(adjacencyList);
        return validPathBFS(adjacencyList, source, destination, new HashSet<>());
    }


    private static boolean validPathBFS(HashMap<Integer, List<Integer>> adjacencyList , int source, int destination,
                                        Set<Integer> visited){

        Queue<Integer> nodesQueue = new ArrayDeque<>();

        nodesQueue.add(source);
        while (!nodesQueue.isEmpty()){

            int current = nodesQueue.remove();

            if(current == destination){
                return true;
            }

            if(visited.contains(current)){
                continue;
            }

            visited.add(current);
            for (int neighbour : adjacencyList.get(current)){
                if(!visited.contains(neighbour)){
                    nodesQueue.add(neighbour);
                }
            }

        }
        return false;
    }


     //   0 , 1
    // [
     //  [0,1],
     //  [1,2],
     //  [2,0]
     //  ]
    private static HashMap<Integer, List<Integer>> buildGraph (int[][] edges){

        HashMap<Integer, List<Integer>> adjacencyList = new HashMap<>();

        for(int i = 0 ; i < edges.length ; i++){

            int firstNode = edges[i][0];
            int secondNode = edges[i][1];

            if(!adjacencyList.containsKey(firstNode)){
                adjacencyList.put(firstNode, new ArrayList<>());
            }

            if(!adjacencyList.containsKey(secondNode)){
                adjacencyList.put(secondNode, new ArrayList<>());
            }

            adjacencyList.get(firstNode).add(secondNode);
            adjacencyList.get(secondNode).add(firstNode);
        }

        return adjacencyList;
    }

    private static HashMap<Integer, List<Integer>> buildGraph_v2(int[][] edges){

        HashMap<Integer, List<Integer>> adjacencyList = new HashMap<>();

        for(int i = 0 ; i < edges.length ; i++){

            int firstNode = edges[i][0];
            int secondNode = edges[i][1];

            adjacencyList.computeIfAbsent(firstNode, val -> new ArrayList<>()).add(secondNode);
            adjacencyList.computeIfAbsent(secondNode, val -> new ArrayList<>()).add(firstNode);
        }

        return adjacencyList;
    }

    public static void main(String[] args) {

        int[][] edges = new int[3][2];
        int[] firstEdge = new int[] {0,1};
        int[] secondEdge = new int[] {1,2};
        int[] thirdEdge = new int[] {2,0};
        edges[0] = firstEdge;
        edges[1] = secondEdge;
        edges[2] = thirdEdge;


        // [
        // [4,3],
        // [1,4],
        // [4,8],
        // [1,7],
        // [6,4],
        // [4,2],
        // [7,4],
        // [4,0],
        // [0,9],
        // [5,4]
        // ]
        int[][] edges2 = new int[10][2];
        int[] edge1 = new int[] {4,3};
        int[] edge2 = new int[] {1,4};
        int[] edge3 = new int[] {4,8};
        int[] edge4 = new int[] {1,7};
        int[] edge5 = new int[] {6,4};
        int[] edge6 = new int[] {4,2};
        int[] edge7 = new int[] {7,4};
        int[] edge8 = new int[] {4,0};
        int[] edge9 = new int[] {0,9};
        int[] edge10 = new int[] {5,4};
        edges2[0] = edge1;
        edges2[1] = edge2;
        edges2[2] = edge3;
        edges2[3] = edge4;
        edges2[4] = edge5;
        edges2[5] = edge6;
        edges2[6] = edge7;
        edges2[7] = edge8;
        edges2[8] = edge9;
        edges2[9] = edge10;

        System.out.println(validPath(10 , edges2, 5, 9));
        System.out.println(validPath(3 , edges, 0, 2));
        System.out.println(validPathDFSIterative(10 , edges2, 5, 9));
        System.out.println(validPathDFSIterative(3 , edges, 0, 2));
        System.out.println(validPathBFS(10 , edges2, 5, 9));
        System.out.println(validPathBFS(3 , edges, 0, 2));
    }
}
