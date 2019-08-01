package com.graphs;

import java.util.*;

public class BFSGraph {

    Map<Integer, List<List<Integer>>> adjacencyList;

    BFSGraph() {
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

    void printBFS(int current, int start) {
        List<Integer> visited = new ArrayList<>();
        List<Integer> queue = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        queue.add(start);
        visited.add(start);
        path.add(start);
        while(!queue.isEmpty()) {
            int removedNode = queue.remove(0);
            System.out.println("Removed node is: " + removedNode);
            List<List<Integer>> children = adjacencyList.get(removedNode);
            System.out.println("Adjacents: "+children);
            for(List<Integer> eachChild: children) {
                System.out.println("Considering the child: "+eachChild);
                System.out.println("Has "+eachChild + " been visited?");
                if(visited.contains(eachChild.get(0))) {
                    System.out.println("Yes");
                    continue;
                }
                path.add(eachChild.get(0));
                visited.add(eachChild.get(0));
                System.out.println("No");
                queue.add(eachChild.get(0));
            }
        }
        System.out.println("Final path: "+path);
    }

    public static void main(String[] args) {
        BFSGraph graph = new BFSGraph();
        graph.insert(0, 2, 10);
        graph.insert(1, 3, 1);
        graph.insert(2, 0, 1);
        graph.insert(2, 4, 100);
        graph.insert(3, 2, 5);
        graph.insert(3, 4, 5);
        graph.insert(4, 1, 5);
        graph.insert(4, 0, 5);

        graph.printGraph();
        graph.printBFS(0, 0);
    }

}
