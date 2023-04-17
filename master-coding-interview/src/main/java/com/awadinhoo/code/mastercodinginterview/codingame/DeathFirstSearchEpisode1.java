package com.awadinhoo.code.mastercodinginterview.codingame;

import java.util.*;

public class DeathFirstSearchEpisode1 {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // the total number of nodes in the level, including the gateways
        int L = in.nextInt(); // the number of links
        int E = in.nextInt(); // the number of exit gateways

        Map<Integer, List<Integer>> connections = new HashMap<>();
        List<Integer> gateways = new ArrayList<>();


        for (int i = 0; i < L; i++) {
            int N1 = in.nextInt(); // N1 and N2 defines a link between these nodes
            int N2 = in.nextInt();

            List<Integer> neighbours = connections.get(N1);
            if( neighbours == null){
                List<Integer> newNeighbours1 = new ArrayList<>();
                newNeighbours1.add(N2);
                connections.put(N1,newNeighbours1);
            }else {
                neighbours.add(N2);
                connections.replace(N1, neighbours);
            }

            List<Integer> neighbours2 = connections.get(N2);
            if( neighbours2 == null){
                List<Integer> newNeighbours2 = new ArrayList<>();
                newNeighbours2.add(N1);
                connections.put(N2,newNeighbours2);
            }else {
                neighbours2.add(N1);
                connections.replace(N2, neighbours2);
            }

        }
        for (int i = 0; i < E; i++) {
            int EI = in.nextInt(); // the index of a gateway node
        }

        // game loop
        while (true) {
            int SI = in.nextInt(); // The index of the node on which the Bobnet agent is positioned this turn

            List<Integer> paths = connections.get(SI);


            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");


            // Example: 0 1 are the indices of the nodes you wish to sever the link between
            System.out.println();
        }
    }
}
