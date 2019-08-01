package com.trees;
import java.util.*;

public class BinarySearchTreeZigZag {

    class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    Node root;
    Map<Integer, Integer> levelOfNode;
    Map<Integer, List<Integer>> nodesInALevel;

    BinarySearchTreeZigZag() {
        root = null;
        levelOfNode = new HashMap<>();
        nodesInALevel = new HashMap<>();
    }

    void insert(int value) {
        root = insertNode(root, value);
    }

    Node insertNode(Node node, int value) {
        if(node == null) {
            node = new Node(value);
        }
        else {
            if(value < node.value) {
                node.left = insertNode(node.left, value);
            }
            else {
                node.right = insertNode(node.right, value);
            }
        }
        return node;
    }

    void printBFS(Node node) {
        int level = 0;
        List<Integer> path = new ArrayList<>();
        List<Node> queue = new ArrayList<>();
        queue.add(node);
        path.add(node.value);
        List<Integer> nodes;
        levelOfNode.put(node.value, level);
        if(nodesInALevel.containsKey(level)) {
            nodes = nodesInALevel.get(level);
        }
        else {
            nodes = new ArrayList<>();
        }
        nodes.add(node.value);
        nodesInALevel.put(level, nodes);

        while(!queue.isEmpty()) {
            Node removedNode = queue.remove(0);

            if(removedNode.left != null) {
                int levelLeft = levelOfNode.get(removedNode.value)+1;
                Node leftChild = removedNode.left;
                queue.add(leftChild);
                levelOfNode.put(leftChild.value, levelLeft);
                if(nodesInALevel.containsKey(levelLeft)) {
                    nodes = nodesInALevel.get(levelLeft);
                }
                else {
                    nodes = new ArrayList<>();
                }
                nodes.add(leftChild.value);
                nodesInALevel.put(levelLeft, nodes);
            }
            if(removedNode.right != null) {
                int levelRight = levelOfNode.get(removedNode.value)+1;
                Node rightChild = removedNode.right;
                queue.add(rightChild);
                levelOfNode.put(rightChild.value, levelRight);
                if(nodesInALevel.containsKey(levelRight)) {
                    nodes = nodesInALevel.get(levelRight);
                }
                else {
                    nodes = new ArrayList<>();
                }
                nodes.add(rightChild.value);
                nodesInALevel.put(levelRight, nodes);
            }
        }
        System.out.println("Level of nodes: "+levelOfNode);
        System.out.println("Nodes in a level: "+nodesInALevel);

        printZigZag();
    }

    void printZigZag() {
        int level = 0;
        for(int key:nodesInALevel.keySet()) {
            if(level % 2 != 0) {
                List<Integer> nodes = nodesInALevel.get(key);
                Collections.reverse(nodes);
                System.out.println(nodes);
            }
            else {
                System.out.println(nodesInALevel.get(key));
            }
            level++;
        }
    }

    public static void main(String[] args) {
        BinarySearchTreeZigZag tree = new BinarySearchTreeZigZag();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        tree.printBFS(tree.root);
    }

}
