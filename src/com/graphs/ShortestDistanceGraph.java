package com.graphs;

import java.util.*;

public class ShortestDistanceGraph {

    Map<Integer, List<List<Integer>>> adjacencyList;
    int shortestDistance;

    ShortestDistanceGraph() {
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

    void calculateDistance(int end) {
        List<Integer> visited;
        List<Integer> path;
        for(int eachNode:adjacencyList.keySet()) {
            visited = new ArrayList<>();
            path = new ArrayList<>();
            visited.add(eachNode);
            path.add(eachNode);
            shortestDistance = Integer.MAX_VALUE;
            System.out.println(">>>>>>>> Calculating distance to " + end + " from " +eachNode);
            int distance = distanceFromAllNodes(eachNode, end, visited, path, 0);
            System.out.println("******** Final shortest distance from "+eachNode + " to " +end + " is "+distance);
            printGraph();
        }
    }

    int distanceFromAllNodes(int current, int end, List<Integer> visited, List<Integer> path, int currentDistance) {
        System.out.println("Is the current node the final node? "+current);
        if(current == end) {
            System.out.println("Yes");
            System.out.println("Path: "+path);
            if(currentDistance < shortestDistance) {
                System.out.println("currentDistance "+currentDistance + " < shortestDistance "+shortestDistance);
                shortestDistance = currentDistance;
            }
            return shortestDistance;
        }
        System.out.println("No");
        System.out.println("All adjacents: "+adjacencyList.get(current));
        for(List<Integer> adjacents: adjacencyList.get(current)) {
            System.out.println("Considering current adjacents: "+adjacents);
            int nextNode = adjacents.get(0);
            System.out.println("Is the adjacent node visited? "+nextNode);
            if(visited.contains(nextNode)) {
                System.out.println("Yes");
                continue;
            }
            System.out.println("No");
            System.out.println("Previous distance: "+currentDistance);
            currentDistance += adjacents.get(1);
            System.out.println("Updated distance: "+currentDistance);
            visited.add(nextNode);
            path.add(nextNode);
            distanceFromAllNodes(nextNode, end, visited, path, currentDistance);
            path.remove(path.size()-1);
            visited.remove(visited.size()-1);
            currentDistance -= adjacents.get(1);
        }
        return shortestDistance;
    }


    public static void main(String[] args) {
        ShortestDistanceGraph graph = new ShortestDistanceGraph();
        graph.insert(0, 2, 10);
        graph.insert(1, 3, 1);
        graph.insert(2, 0, 1);
        graph.insert(2, 4, 100);
        graph.insert(3, 2, 5);
        graph.insert(3, 4, 5);
        graph.insert(4, 1, 5);
        graph.insert(4, 0, 5);

        graph.printGraph();
        graph.calculateDistance(4);
    }

}
