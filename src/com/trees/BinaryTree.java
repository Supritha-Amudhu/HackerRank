package com.trees;

public class BinaryTree {

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

    BinaryTree() {
        root = null;
    }

    void insert(int value) {
        root = insertNode(root, value);
    }

    Node insertNode(Node node, int value) {
        node = new Node(value);
        return node;
    }

    void printTree(Node node) {
        if(node == null) {
            return;
        }
        printTree(node.left);
        System.out.println(node.value);
        printTree(node.right);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(5);
        tree.root.left = tree.insertNode(tree.root.left, 6);
        tree.root.right = tree.insertNode(tree.root.right, 7);

        tree.printTree(tree.root);
    }
}
