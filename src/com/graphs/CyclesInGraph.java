package com.graphs;

import java.util.*;

public class CyclesInGraph {

    Map<Integer, List<List<Integer>>> adjacencyList;

    CyclesInGraph() {
        adjacencyList = new HashMap<>();
    }

    void insert(int start, int end, int distance) {
        List<List<Integer>> parentList;
        List<Integer> childList = new ArrayList<>();
        childList.add(end);
        childList.add(distance);
        if(adjacencyList.containsKey(start)) {
            parentList = adjacencyList.get(start);
        }
        else {
            parentList = new ArrayList<>();
        }
        parentList.add(childList);
        adjacencyList.put(start, parentList);
    }

    void printGraph() {
        for(int key: adjacencyList.keySet()) {
            System.out.println(key + " --> " + adjacencyList.get(key));
        }
    }

    void detectCycles() {
        List<Integer> visited;
        for(int eachNode: adjacencyList.keySet()) {
            visited = new ArrayList<>();
            visited.add(eachNode);
            cyclesFromEachPath(eachNode, eachNode, visited);
        }
    }

    void cyclesFromEachPath(int start, int current, List<Integer> visited) {
        for(List<Integer> adjacents: adjacencyList.get(current)) {
            int nextNode = adjacents.get(0);
            if(visited.contains(nextNode)) {
                System.out.println("Cycle found in: " + start);
                return;
            }
            visited.add(nextNode);
            cyclesFromEachPath(start, nextNode, visited);
            visited.remove(visited.size()-1);
        }
    }

    public static void main(String[] args) {
        CyclesInGraph graph = new CyclesInGraph();
        graph.insert(0, 2, 10);
        graph.insert(1, 3, 1);
        graph.insert(2, 0, 1);
        graph.insert(2, 4, 100);
        graph.insert(3, 2, 5);
        graph.insert(3, 4, 5);
        graph.insert(4, 1, 5);
        graph.insert(4, 0, 5);

        graph.printGraph();
        graph.detectCycles();
    }

}
