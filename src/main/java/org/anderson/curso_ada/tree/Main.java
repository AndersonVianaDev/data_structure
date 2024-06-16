package org.anderson.curso_ada.tree;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(37);
        tree.insert(11);
        tree.insert(66);
        tree.insert(8);
        tree.insert(17);
        tree.insert(42);
        tree.insert(72);

        System.out.println("###############################");
        tree.BFS();
        System.out.println("###############################");

        /*System.out.println(tree.root.getValue());
        System.out.println(tree.root.getLeft().getValue());
        System.out.println(tree.root.getRight().getValue());*/
    }
}
