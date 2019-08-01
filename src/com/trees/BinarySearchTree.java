package com.trees;
import java.util.*;

public class BinarySearchTree {

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

    BinarySearchTree() {
        root = null;
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

    void printInOrder(Node node) {
        if(node == null) {
            return;
        }
        printInOrder(node.left);
        System.out.print(node.value + " ");
        printInOrder(node.right);
    }

    void printPreOrder(Node node) {
        if(node == null) {
            return;
        }
        System.out.print(node.value + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    void printPostOrder(Node node) {
        if(node == null) {
            return;
        }
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.value + " ");
    }

    void printBFS(Node node) {
        List<Integer> path = new ArrayList<>();
        List<Node> queue = new ArrayList<>();
        queue.add(node);
        while(queue != null && !queue.isEmpty()) {
            Node currentNode = queue.remove(0);
            System.out.println("Considering the element: "+currentNode.value);
            path.add(currentNode.value);
            if(currentNode.left != null) {
                Node leftChild = currentNode.left;
                queue.add(leftChild);
            }
            if(currentNode.right != null) {
                Node rightChild = currentNode.right;
                queue.add(rightChild);
            }
        }
        System.out.println("BFS path: "+path);
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Printing In Order:");
        tree.printInOrder(tree.root);
        System.out.println();
        System.out.println("Printing Pre Order:");
        tree.printPreOrder(tree.root);
        System.out.println();
        System.out.println("Printing Post Order:");
        tree.printPostOrder(tree.root);

        tree.printBFS(tree.root);
    }

}
