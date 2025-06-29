package data_structure;

import java.util.ArrayList;

/**
 * Your LinkedList class should support the following operations:
 *
 * LinkedList() will initialize an empty linked list.
 * int get(int i) will return the value of the ith node (0-indexed). If the index is out of bounds, return -1.
 * void insertHead(int val) will insert a node with val at the head of the list.
 * void insertTail(int val) will insert a node with val at the tail of the list.
 * bool remove(int i) will remove the ith node (0-indexed). If the index is out of bounds, return false, otherwise return true.
 * int[] getValues() return an array of all the values in the linked list, ordered from head to tail.
 */
class LinkedList {

    private static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1; // Index out of bounds
        }
        Node current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    public void insertHead(int val) {
        Node newNode = new Node(val);
        if (this.head == null){
            // Empty List
            this.head = this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head = newNode;
        }
        this.size++;
    }

    public void insertTail(int val) {
        Node newNode = new Node(val);
        if (this.tail == null) {
            // Empty List
            this.head = this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.size++;
    }

    public boolean remove(int index) {
        if (index < 0 || index >= size) {
            return false;
        }

        // Case 1: Remove head
        if (index == 0) {
            if (this.head == this.tail){
                this.head = this.tail = null;
            } else {
                this.head = this.head.next;
            }
            size--;
            return true;
        }

        // Case 2: Find the node before the one to remove
        Node prev = this.head;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }

        // Node to remove is prev.next
        Node nodeToRemove = prev.next;

        // Case 3: Remove Tail
        if (nodeToRemove == this.tail) {
            this.tail = prev;
            prev.next = null;
        } else {
            // Case 4: Remove from middle
            prev.next = nodeToRemove.next;
        }
        size--;
        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> values = new ArrayList<>(this.size);
        Node current = this.head;

        // Empty list check
        if (current == null) {
            return values;
        }

        // Process all nodes including tail
        while (current != null) {
            values.add(current.value);
            current = current.next;
        }
        return values;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        System.out.println("insertHead(1)");
        list.insertHead(1);

        System.out.println("insertTail(2)");
        list.insertTail(2);

        System.out.println("insertHead(0)");
        list.insertHead(0);

        System.out.println("remove(1): " + list.remove(1));

        System.out.print("getValues(): [");
        ArrayList<Integer> values = list.getValues();
        for (int i = 0; i < values.size(); i++) {
            System.out.print(values.get(i) + (i < values.size() - 1 ? ", " : ""));
        }
        System.out.println("]");
    }
}

