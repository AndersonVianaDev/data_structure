package org.anderson.curso_ada.linkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList("1");
        list.append("2");
        list.append("3");

        list.print();

        list.getHead();
        list.getTail();
        list.getLength();

        list.set(1, "3");

        list.print();
    }
}
