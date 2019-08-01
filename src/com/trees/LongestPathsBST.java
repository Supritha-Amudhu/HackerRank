package com.trees;
import java.util.*;

public class LongestPathsBST {

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
    List<List<Integer>> longestPaths;
    int longestValue;

    LongestPathsBST() {
        root = null;
        longestPaths = new ArrayList<>();
        longestValue = 0;
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

    void findLongestPaths(Node node, List<Integer> longestPath) {
        if(node == null) {
            System.out.println("Reached the last level and null.");
            System.out.println("Longest Paths currently: "+longestPaths);
            if(longestPath.size() >= longestValue) {
                longestValue = longestPath.size();
                if(!longestPaths.contains(longestPath)) {
                    longestPaths.add(new ArrayList<>(longestPath));
                }
            }
            return;
        }
        longestPath.add(node.value);
        System.out.println(longestPath);
        findLongestPaths(node.left, longestPath);
        if(node.right != null) {
            findLongestPaths(node.right, longestPath);
        }
        longestPath.remove(longestPath.size()-1);
    }

    public static void main(String[] args) {
        LongestPathsBST tree = new LongestPathsBST();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        tree.findLongestPaths(tree.root, new ArrayList<>());
        System.out.println("Longest paths:");
        System.out.println(tree.longestPaths);
        System.out.println("Longest value: "+tree.longestValue);
    }
}
