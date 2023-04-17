package com.awadinhoo.code.mastercodinginterview.graphs;

import java.util.*;

public class Graph {

    private Map<String, Node> nodes;
    private Map<Node, List<Node>> adjacencyList;

    public Graph() {
        nodes = new HashMap<>();
        adjacencyList = new HashMap<>();
    }

    public void addNode(String label){

        Node newNode = new Node(label);
        nodes.putIfAbsent(label , newNode);
        adjacencyList.putIfAbsent(newNode, new ArrayList<>());
    }

    public void addEdge(String fromNode, String toNode){

        Node oldFrom = nodes.get(fromNode);
        if(oldFrom == null){
            throw new IllegalStateException("From Node is not found");
        }

        Node oldTo = nodes.get(toNode);
        if(oldTo == null){
            throw new IllegalStateException("To Node is not found");
        }

        adjacencyList.get(oldFrom).add(oldTo);
    }

    public void removeNode(String label){

        Node oldNode = nodes.get(label);
        if(oldNode == null){
            throw new IllegalStateException("Node is not found");
        }
        nodes.remove(label);
        adjacencyList.remove(oldNode);

        for (Node node : adjacencyList.keySet()) {
            adjacencyList.get(node).remove(oldNode);
        }
    }

    public void removeEdge(String fromNode, String toNode){

        Node oldFrom = nodes.get(fromNode);
        if(oldFrom == null){
            throw new IllegalStateException("From Node is not found");
        }

        Node oldTo = nodes.get(toNode);
        if(oldTo == null){
            throw new IllegalStateException("To Node is not found");
        }

        adjacencyList.get(oldFrom).remove(oldTo);
    }

    public List<String> traverseDFS(String start){
        List<String> traversedNodes = new ArrayList<>();
        traverseDFS(start, new HashSet<>(), traversedNodes);
        return traversedNodes;
    }


    public List<String> traverseDFSIterative(String start){

        List<String> traversedNodes = new ArrayList<>();
        Stack<Node> nodesStack = new Stack<>();
        Set<Node> visited = new HashSet<>();

        Node current = nodes.get(start);
        if (current == null) {
            return traversedNodes;
        }

        nodesStack.push(current);
        while(!nodesStack.isEmpty()){

            current = nodesStack.pop();

            if (visited.contains(current)){
                continue;
            }

            traversedNodes.add(current.label);
            visited.add(current);

            for (Node neighbour: adjacencyList.get(current)) {
                if(!visited.contains(neighbour)){
                    nodesStack.push(neighbour);
                }
            }

        }

        return traversedNodes;
    }


    public List<String> traverseBFSIterative(String start){

        List<String> traversedNodes = new ArrayList<>();
        Queue<Node> nodesQueue = new ArrayDeque<>();
        Set<Node> visited = new HashSet<>();

        Node current = nodes.get(start);
        if (current == null) {
            return traversedNodes;
        }

        nodesQueue.add(current);
        while(!nodesQueue.isEmpty()){

            current = nodesQueue.remove();

            if (visited.contains(current)){
                continue;
            }

            traversedNodes.add(current.label);
            visited.add(current);

            for (Node neighbour: adjacencyList.get(current)) {
                if(!visited.contains(neighbour)){
                    nodesQueue.add(neighbour);
                }
            }
        }
        return traversedNodes;
    }



    private void traverseDFS(String node , Set<Node> visited, List<String> traversedNodes){

        Node startNode = nodes.get(node);
        if(startNode == null){
            return;
        }

        traversedNodes.add(node);
        visited.add(startNode);

        List<Node> neighbours = adjacencyList.get(startNode);
        for (Node neighbour: neighbours) {
            if(!visited.contains(neighbour)){
                traverseDFS(neighbour.label , visited, traversedNodes);
            }
        }
    }

    public List<String> topologicalSort(){
        List<String> traversedNodes = new ArrayList<>();
        Stack<String> sortedNodes = new Stack<>();
        Set<Node> visited = new HashSet<>();

        for (String nodeLabel: nodes.keySet()) {
            Node currentNode = nodes.get(nodeLabel);
            topologicalSort(currentNode, visited , sortedNodes);
        }

        while (!sortedNodes.isEmpty()){
            traversedNodes.add(sortedNodes.pop());
        }

        return traversedNodes;
    }

    private void topologicalSort(Node node , Set<Node> visited, Stack<String> sortedNodes){


        List<Node> neighbours = adjacencyList.get(node);
        for (Node neighbour: neighbours) {
            if(!visited.contains(neighbour)){
                topologicalSort(neighbour , visited, sortedNodes);
            }
        }

        if(!visited.contains(node)){
            sortedNodes.push(node.label);
            visited.add(node);
        }
    }




    private class Node{
        String label;
        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "label='" + label + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Graph{" +
                "nodes=" + nodes + "\n" +
                ", adjacencyList=" + adjacencyList +
                '}';
    }
}
