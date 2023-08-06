package com.awadinhoo.code.mastercodinginterview.graphs;

public class TestWeightedGraph {


    public static void main(String[] args) {

        WeightedGraph weightedGraph = new WeightedGraph();

        weightedGraph.addNode("A");
        weightedGraph.addNode("B");
        weightedGraph.addNode("C");
        weightedGraph.addNode("D");
        weightedGraph.addNode("E");

        weightedGraph.addEdge("A","B", 3);
        weightedGraph.addEdge("A","D", 2);
        weightedGraph.addEdge("A","C", 4);
        weightedGraph.addEdge("B","D", 6);
        weightedGraph.addEdge("B","E", 1);
        weightedGraph.addEdge("C","D", 1);
        weightedGraph.addEdge("D","E", 5);

        System.out.println(weightedGraph);

        System.out.println(weightedGraph.getShortestDistance("A", "E"));
        System.out.println(weightedGraph.getShortestDistance("B", "C"));

        System.out.println(weightedGraph.getShortestPath("A", "E"));
        System.out.println(weightedGraph.getShortestPath("B", "C"));

        System.out.println(weightedGraph.hasCycle());
        System.out.println(weightedGraph.getMinimumSpanningTree());

    }
}
