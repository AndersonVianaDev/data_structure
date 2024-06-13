package org.anderson.curso_ada.queue;

public class Queue {

    private Node first;
    private Node last;
    private int size;

    class Node {
        private int value;

        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public Queue(int value) {
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        size = 1;
    }

    public void getFirst() {
        if(first == null) System.err.println("Queue is empty");
        else System.out.println("First: " + first.value);
    }

    public void getLast() {
        if(last == null) System.err.println("Queue is empty");
        else System.out.println("Last: " + last.value);
    }

    public void getLength() {
        System.out.println("Size: " + size);
    }

    public void print() {
        if(size == 0) System.err.println("Queue is empty");

        Node temp = first;

        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);

        if(size == 0) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    public Node dequeue() {
        if(size == 0) System.err.println("Queue is empty");

        Node temp = first;

        if(size == 1) {
            first = null;
            last = null;
        } else {
            first = first.next;
            temp.next = null;
        }
        size--;

        return temp;
    }
}
