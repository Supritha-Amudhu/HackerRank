package com.LinkedList;

public class SinglyLinkedList {

    class Node {
        int value;
        Node next;

        Node() {
            this.value = 0;
            this.next = null;
        }

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    Node root;
    Node reverse;
    int size;

    SinglyLinkedList() {
        root = null;
        reverse = null;
        size = 0;
    }

    void printLinkedList(Node node) {
        if(node == null) {
            return;
        }
        while(node.next != null) {
            System.out.print(node.value + " -> ");
            node = node.next;
        }
        if(node.next == null) {
            System.out.print(node.value);
        }
    }

    void insert(int value) {
        root = insert(root, value);
    }

    Node insert(Node node, int value) {
        if(node == null) {
            Node newNode = new Node(value);
            node = newNode;
            size++;
            return node;
        }
        else {
            node.next = insert(node.next, value);
        }
        return node;
    }

    Node insertAfter(Node node, int position, int value) {
        System.out.println("Position: "+position);
        if(position != 0) {
            node = insertAfter(node.next, position-1, value);
        }
        else {
            Node newNode = new Node(value);
            newNode.next = node.next;
            node.next = newNode;
        }
        return node;
    }

    Node getElement(Node node, int position) {
        while(position != 0 && node.next != null) {
            node = node.next;
            position--;
        }
        return node;
    }

    Node deleteEnd(Node node) {
        if(node == null) {
            return node;
        }
        while(node.next.next != null) {
            node = node.next;
        }
        Node deletedNode = node.next;
        node.next = null;
        size--;
        return deletedNode;
    }

    int deleteAt(Node node, int position) {
        if(node == null) {
            return 0;
        }
        while(position != 1) {
            deleteAt(node.next, position-1);
        }
        Node deletedNode = node.next;
        node.next = deletedNode.next;
        int deletedNodeValue = deletedNode.value;
        size--;
        return deletedNodeValue;
    }

    Node reverseLinkedList(Node node, Node reverse, int nodeSize) {
        if(node == null) {
            return null;
        }
        if(nodeSize >= 0) {
            reverse = insert(reverse, getElement(node, nodeSize).value);
            reverseLinkedList(node, reverse, nodeSize-1);
        }

        return reverse;
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        list.insertAfter(list.root,2, 7);
        System.out.println("Original List size: "+list.size);
//        list.deleteEnd(list.root);
//        list.deleteEnd(list.root);
        list.deleteAt(list.root, 1);
        System.out.println("List size after removing an element: " +list.size);

        list.printLinkedList(list.root);
        System.out.println();
        System.out.println("Element at position 2: "+list.getElement(list.root,2).value);

        list.reverse = list.reverseLinkedList(list.root, list.reverse, list.size);
        list.printLinkedList(list.reverse);
    }


}
