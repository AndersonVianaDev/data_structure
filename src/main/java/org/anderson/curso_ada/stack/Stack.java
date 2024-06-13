package org.anderson.curso_ada.stack;

public class Stack {

    private Node top;

    private int height;

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

    public Stack(int value) {
        Node newNode = new Node(value);
        top = newNode;
        height = 1;
    }

    public void getHeight() {
        if(top == null) System.err.println("Stack is empty");
        else System.out.println("Height: " + height);
    }

    public void getTop() {
        if(top == null) System.err.println("Stack is empty");
        else System.out.println("Top: " + top.value);
    }

    public void push(int value) {
        Node newNode = new Node(value);
        if (height == 0) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        height++;
    }

    public Node pop() {
        if(top == null) {
            System.err.println("Stack is empty");
            System.out.println("Entrou aqui !");
            return null;
        }

        Node temp = top;

        if(top.next == null) {
            top = null;
            height = 0;
            return temp;
        }

        top = temp.next;
        top.next = null;

        height--;

        if(height == 0) top = null;

        return temp;
    }

    public void print() {
        if(top == null) System.err.println("Stack is empty");

        Node temp = top;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }
}
