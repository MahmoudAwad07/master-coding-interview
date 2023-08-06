package com.awadinhoo.code.mastercodinginterview.graphs;

import java.util.*;

public class WeightedGraph {
    private Map<String , WeightedGraphNode> nodes = new HashMap<>();

    private int size;

    public void addNode(String node){
        nodes.putIfAbsent(node, new WeightedGraphNode(node));
        size++;
    }

    public void addEdge(String fromNodeLabel, String toNodeLabel, int weight){

        WeightedGraphNode fromNode = getNode(fromNodeLabel);
        WeightedGraphNode toNode = getNode(toNodeLabel);

        fromNode.addEdge(toNode, weight);
        toNode.addEdge(fromNode, weight);
    }

    public int getSize(){
        return size;
    }

    public int getShortestDistance(String fromNodeLabel, String toNodeLabel){

        WeightedGraphNode fromNode = getNode(fromNodeLabel);
        WeightedGraphNode toNode = getNode(toNodeLabel);
        Map<WeightedGraphNode, Integer>  distances = new HashMap<>();
        Set<WeightedGraphNode> visited = new HashSet<>();

        for(WeightedGraphNode node :nodes.values()){
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.replace(fromNode, 0);

        PriorityQueue<NodePriority> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(np -> np.priority));
        priorityQueue.add(new NodePriority(fromNode, 0));

        while(!priorityQueue.isEmpty()){

            WeightedGraphNode current = priorityQueue.remove().node;
            visited.add(current);

            for(Edge edge : current.edges.values()){

                WeightedGraphNode neighbour = edge.toNode;

                if(visited.contains(neighbour))
                    continue;

                int newDistance = distances.get(current) + edge.weight;

                if(newDistance < distances.get(neighbour)){
                    distances.put(neighbour, newDistance);
                    priorityQueue.add(new NodePriority(neighbour, newDistance));
                }
            }
        }

        return distances.get(toNode);
    }



    public List<String> getShortestPath(String fromNodeLabel, String toNodeLabel){

        WeightedGraphNode fromNode = getNode(fromNodeLabel);
        WeightedGraphNode toNode = getNode(toNodeLabel);
        Map<WeightedGraphNode, Integer>  distances = new HashMap<>();
        Map<WeightedGraphNode, WeightedGraphNode> previous = new HashMap<>();
        Set<WeightedGraphNode> visited = new HashSet<>();

        for(WeightedGraphNode node :nodes.values()){
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.replace(fromNode, 0);

        PriorityQueue<NodePriority> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(np -> np.priority));
        priorityQueue.add(new NodePriority(fromNode, 0));

        while(!priorityQueue.isEmpty()){

            WeightedGraphNode current = priorityQueue.remove().node;
            visited.add(current);

            for(Edge edge : current.edges.values()){

                WeightedGraphNode neighbour = edge.toNode;

                if(visited.contains(neighbour))
                    continue;

                int newDistance = distances.get(current) + edge.weight;

                if(newDistance < distances.get(neighbour)){
                    distances.put(neighbour, newDistance);
                    priorityQueue.add(new NodePriority(neighbour, newDistance));
                    previous.put(neighbour,current);
                }
            }
        }
        System.out.println("Previous Nodes:" + previous);
        return buildPath(previous, toNode);
    }

    private List<String> buildPath(Map<WeightedGraphNode, WeightedGraphNode> previousNodes , WeightedGraphNode targetNode){

        Stack<WeightedGraphNode> nodes = new Stack<>();
        List<String> path = new ArrayList<>();
        nodes.push(targetNode);
        WeightedGraphNode previousNode = previousNodes.get(targetNode);
        while (previousNode != null){
            nodes.push(previousNode);
            previousNode = previousNodes.get(previousNode);
        }

        while(!nodes.isEmpty()){
            path.add(nodes.pop().label);
        }

        return path;
    }

    private WeightedGraphNode getNode(String nodeLabel){

        WeightedGraphNode node = nodes.get(nodeLabel);
        if(node == null)
            throw new IllegalArgumentException();

        return node;
    }


    public boolean hasCycle(){

        Set<WeightedGraphNode> visited = new HashSet<>();
        Set<WeightedGraphNode> visiting = new HashSet<>();

        for ( WeightedGraphNode node  : nodes.values()){
            if( !visited.contains(node) && hasCycle(node, null ,visited, visiting))
                return true;
        }
        return false;
    }


    private boolean hasCycle(WeightedGraphNode current, WeightedGraphNode parent, Set<WeightedGraphNode> visited, Set<WeightedGraphNode> visiting){

        visiting.add(current);

        for( Edge edge : current.edges.values()){

            WeightedGraphNode neighbour = edge.toNode;

            if(visited.contains(neighbour))
                continue;

            if(neighbour.equals(parent))
                continue;

            // reach the node from a cycle, but it is not the parent
            if (visiting.contains(neighbour) || hasCycle(neighbour, current, visited, visiting))
                return true;
        }

        visiting.remove(current);
        visited.add(current);
        return false;
    }

    public WeightedGraph getMinimumSpanningTree(){

        WeightedGraph spanningTree = new WeightedGraph();

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));

        if(nodes.isEmpty())
            return spanningTree;

        WeightedGraphNode currentNode = nodes.values().iterator().next();

        spanningTree.addNode(currentNode.label);
        priorityQueue.addAll(currentNode.edges.values());

        while (spanningTree.size < size){

            Edge edge = priorityQueue.remove();
            WeightedGraphNode toNode = edge.toNode;

            if(spanningTree.containsNode(toNode.label))
                continue;

            spanningTree.addNode(toNode.label);
            spanningTree.addEdge(edge.fromNode.label, toNode.label, edge.weight);

            for(Edge toEdge : toNode.edges.values()){
                if(!spanningTree.containsNode(toEdge.toNode.label)){
                    priorityQueue.add(toEdge);
                }
            }
        }
        return spanningTree;
    }

    public boolean containsNode(String node){
        return nodes.containsKey(node);
    }

    @Override
    public String toString() {
        return "WeightedGraph{" +
                "nodes=" + nodes +
                '}';
    }

    private class NodePriority {
        private WeightedGraphNode node;
        private int priority;

        public NodePriority(WeightedGraphNode node, int priority) {
            this.node = node;
            this.priority = priority;
        }
    }

    private class WeightedGraphNode{
        private String label;
        private Map<String , Edge> edges = new HashMap<>();
        public WeightedGraphNode(String label) {
            this.label = label;
        }

        public void addEdge(WeightedGraphNode toNode, int weight){
            edges.putIfAbsent(toNode.label, new Edge(this, toNode, weight));
        }

        @Override
        public String toString() {
            return "WeightedGraphNode{" +
                    "label='" + label + '\'' +
                    ", edges=" + edges +
                    '}';
        }
    }

    private class Edge {

        private WeightedGraphNode fromNode;
        private WeightedGraphNode toNode;
        private int weight;

        public Edge(WeightedGraphNode fromNode, WeightedGraphNode toNode, int weight) {
            this.fromNode = fromNode;
            this.toNode = toNode;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "fromNode=" + fromNode.label +
                    ", toNode=" + toNode.label +
                    ", weight=" + weight +
                    '}';
        }
    }
}
