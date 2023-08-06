package com.awadinhoo.code.mastercodinginterview.graphs;

public class TestGraph {


    public static void main(String[] args) {

        Graph graph = new Graph();
        graph.addNode("Mahmoud");
        graph.addNode("Pep");
        graph.addNode("Luis Diaz");
        graph.addNode("Klop");
        graph.addNode("Salah");

        graph.addEdge("Mahmoud", "Pep");
        graph.addEdge("Klop", "Salah");
        graph.addEdge("Klop", "Luis Diaz");

        System.out.println(graph);

        graph.removeNode("Luis Diaz");
        graph.removeEdge("Mahmoud", "Pep");
        System.out.println(graph);

        Graph graph2 = new Graph();
        graph2.addNode("A");
        graph2.addNode("B");
        graph2.addNode("C");
        graph2.addNode("D");
        graph2.addNode("E");

        graph2.addEdge("A", "B");
        graph2.addEdge("A", "E");
        graph2.addEdge("C", "A");
        graph2.addEdge("C", "B");
        graph2.addEdge("C", "D");
        graph2.addEdge("B", "E");
        graph2.addEdge("D", "E");

        System.out.println(graph2);
        // [C, A, B, E, D]
        System.out.println(graph2.traverseDFS("C"));
        // [E]
        System.out.println(graph2.traverseDFS("E"));
        // [A, B, E]
        System.out.println(graph2.traverseDFS("A"));
        System.out.println(graph2.traverseDFSIterative("C"));
        System.out.println(graph2.traverseDFSIterative("A"));
        System.out.println(graph2.traverseBFSIterative("C"));
        System.out.println(graph2.traverseBFSIterative("A"));


        Graph graph3 = new Graph();
        graph3.addNode("A");
        graph3.addNode("B");
        graph3.addNode("X");
        graph3.addNode("P");

        graph3.addEdge("X", "A");
        graph3.addEdge("X", "B");
        graph3.addEdge("A", "P");
        graph3.addEdge("B", "P");

        System.out.println(graph3);
        System.out.println(graph3.topologicalSort());
        System.out.println(graph3.revisitedTopologicalSort());

        System.out.println(graph3.hasCycle());
        graph3.addEdge("P", "X");
        System.out.println(graph3.hasCycle());








    }
}
