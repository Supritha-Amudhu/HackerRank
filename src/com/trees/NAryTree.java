package com.trees;
import java.util.*;

public class NAryTree {

    class Node {
        int value;
        List<Node> children;

        Node(int value) {
            this.value = value;
            this.children = new ArrayList<>();
        }
    }

    Node root;

    NAryTree() {
        root = null;
    }

    void insert(int value) {
        root = new Node(value);
    }

    Node insertOneNode(int value) {
        return new Node(value);
    }

    Node insertNode(Node node, int value) {
        node = new Node(value);
        return node;
    }

    void insertLikeGraph(Node node, int value) {
        List<Node> childNodes;
        if(!node.children.isEmpty()) {
            childNodes = node.children;
        }
        else {
            childNodes = new ArrayList<>();
        }
        Node child = new Node(value);
        childNodes.add(child);
        node.children.clear();
        node.children.addAll(childNodes);
    }

    void printTree(Node node) {
        if(node == null) {
            return;
        }
        System.out.println(node.value);
        for(Node child:node.children) {
            printTree(child);
        }
    }

    public static void main(String[] args) {
        NAryTree tree = new NAryTree();
        tree.insert(5);
//        tree.root.children.add(tree.insertOneNode( 7));
        tree.insertLikeGraph(tree.root, 8);

//        children.add(tree.insertNode(tree.root.children.get(0)), 7);
//        children.add(7);
//        children.add();

        tree.printTree(tree.root);
    }


}
