package com.LinkedList;

public class AddLinkedList {

    class Node {
        int value;
        Node next;
        int size;

        Node() {
            this.value = 0;
            this.size = 0;
            this.next = null;
        }

        Node(int value) {
            this.value = value;
            this.next = null;
            this.size = 1;
        }
    }

    Node root;
    Node reverse;
    Node summedList;

    AddLinkedList() {
        root = null;
        reverse = null;
        summedList = null;
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
            node.size++;
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
        node.size--;
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
        node.size--;
        return deletedNodeValue;
    }

    Node addLinkedLists(Node first, Node second) {
        if(first == null) {
            return second;
        }
        if(second == null) {
            return first;
        }
        summedList = new Node();
        while(first.next != null) {
            insert(summedList, first.value + second.value);
        }

        return summedList;
    }

    public static void main(String[] args) {
        AddLinkedList list = new AddLinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        list.insertAfter(list.root,2, 7);
        System.out.println("Original List size: "+list.root.size);
        list.deleteEnd(list.root);
        list.deleteEnd(list.root);
        list.deleteAt(list.root, 1);
        System.out.println("List size after removing an element: " +list.root.size);

        list.printLinkedList(list.root);
        System.out.println();
        System.out.println("Element at position 2: "+list.getElement(list.root,2).value);
    }


}
