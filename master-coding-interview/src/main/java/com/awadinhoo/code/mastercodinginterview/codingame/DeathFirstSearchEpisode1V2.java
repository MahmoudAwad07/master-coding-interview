package com.awadinhoo.code.mastercodinginterview.codingame;

import java.util.*;

public class DeathFirstSearchEpisode1V2 {
        public static void main(String args[]) {
            Scanner in = new Scanner(System.in);
            int N = in.nextInt(); // the total number of nodes in the level, including the gateways
            int L = in.nextInt(); // the number of links
            int E = in.nextInt(); // the number of exit gateways

            List<Integer> gateways = new ArrayList<>();
            Map<Integer, List<Integer>> graph = new HashMap<>();

            for (int i = 0; i < L; i++) {
                int N1 = in.nextInt(); // N1 and N2 defines a link between these nodes
                int N2 = in.nextInt();

                // add nodes to the graph
                if (!graph.containsKey(N1)) {
                    graph.put(N1, new ArrayList<>());
                }
                if (!graph.containsKey(N2)) {
                    graph.put(N2, new ArrayList<>());
                }

                // add edges to the graph
                graph.get(N1).add(N2);
                graph.get(N2).add(N1);
            }

            for (int i = 0; i < E; i++) {
                int EI = in.nextInt(); // the index of a gateway node
                gateways.add(EI);
            }

            // game loop
            while (true) {
                int SI = in.nextInt(); // The index of the node on which the Bobnet agent is positioned this turn

                // find the gateways that are reachable from the current node
                List<Integer> reachableGateways = new ArrayList<>();
                for (int gateway : gateways) {
                    if (isReachable(graph, SI, gateway)) {
                        reachableGateways.add(gateway);
                    }
                }

                // choose a link to sever
                if (!reachableGateways.isEmpty()) {
                    int gateway = reachableGateways.get(0);
                    List<Integer> shortestPath = null;
                    int nodeToSever = -1;
                    for (int gw : reachableGateways) {
                        List<Integer> path = findPath(graph, SI, gw);
                        if (shortestPath == null || path.size() < shortestPath.size()) {
                            shortestPath = path;
                            nodeToSever = path.get(1);
                        }
                    }
                    System.out.println(SI + " " + nodeToSever);
                } else {
                    // if there are no reachable gateways, sever any random link
                    int node1 = graph.keySet().iterator().next();
                    int node2 = graph.get(node1).get(0);
                    System.out.println(node1 + " " + node2);
                }
            }
        }

        // check if there is a path from start to end using DFS
        private static boolean isReachable(Map<Integer, List<Integer>> graph, int start, int end) {
            Set<Integer> visited = new HashSet<>();
            Stack<Integer> stack = new Stack<>();
            stack.push(start);

            while (!stack.isEmpty()) {
                int node = stack.pop();
                visited.add(node);

                if (node == end) {
                    return true;
                }

                for (int neighbor : graph.get(node)) {
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }

            return false;
        }

        // find the shortest path from start to end using BFS
        private static List<Integer> findPath(Map<Integer, List<Integer>> graph, int start, int end) {

            Queue<List<Integer>> queue = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();
            queue.offer(Arrays.asList(start));
            visited.add(start);

            while (!queue.isEmpty()) {
                List<Integer> path = queue.poll();
                int node = path.get(path.size() - 1);
                if (node == end) {
                    return path;
                }
                for (int neighbor : graph.getOrDefault(node, Collections.emptyList())) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        List<Integer> newPath = new ArrayList<>(path);
                        newPath.add(neighbor);
                        queue.offer(newPath);
                    }
                }
            }

            return null; // no path found

        }

}
