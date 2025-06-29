package data_structure;

/**
 * Design a Double-ended Queue class.
 *
 * Your Deque class should support the following operations:
 *
 * Deque() will initialize an empty queue.
 * bool isEmpty() will return whether the queue is empty or not.
 * void append(int value) will insert value at the end of the queue.
 * void appendleft(int val) will insert value at the beginning of the queue.
 * int pop() will remove and return the value at the end of the queue. If the queue is empty, return -1.
 * int popleft() will remove and return the value at the beginning of the queue. If the queue is empty, return -1.
 */
class Deque {

    private static class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public Deque() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (this.tail == null) {
            this.head = this.tail = newNode;
        } else {
            // Case1: Tail and head is same element
            newNode.prev = this.tail;
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.size++;
    }

    public void appendleft(int value) {
        Node newNode = new Node(value);
        if (this.head == null) {
            this.head = this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
        }
        this.size++;
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        int value = this.tail.value;
        if (this.tail.prev != null) {
            this.tail = this.tail.prev;
            this.tail.next = null;
        } else {
            // If there was only one element
            this.head = this.tail = null;
        }
        size--;
        return value;
    }

    public int popleft() {
        if (isEmpty()) {
            return -1;
        }
        int value = this.head.value;
        if (this.head.next != null) {
            this.head = this.head.next;
            this.head.prev = null;
        } else {
            // If there was only one element
            this.head = this.tail = null;
        }
        size--;
        return value;
    }
}
