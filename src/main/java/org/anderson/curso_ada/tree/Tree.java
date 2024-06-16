package org.anderson.curso_ada.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {

    public Node root;

    class Node{
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        public boolean isLeaf(){
            return (this.left == null) && (this.right == null);
        }

        public int getValue() {
            return value;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }
    }

    public void insert(int value) {
        if(root == null) root = new Node(value);
        else {
            Node newNode = new Node(value);
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while(!queue.isEmpty()){
                Node currentNode = queue.remove();
                if(currentNode.left == null){
                    currentNode.left = newNode;
                    break;
                } else {
                    queue.add(currentNode.left);
                }

                if(currentNode.right == null){
                    currentNode.right = newNode;
                    break;
                } else {
                    queue.add(currentNode.right);
                }
            }
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if(node == null) return;
        System.out.println(node.getValue());
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if(node == null) return;
        inOrder(node.left);
        System.out.println(node.getValue());
        inOrder(node.right);
    }

    public void posOrder() {
        posOrder(root);
    }

    private void posOrder(Node node) {
        if(node == null) return;
        posOrder(node.left);
        posOrder(node.right);
        System.out.println(node.getValue());
    }

    public void BFS() {
        if(root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);

            System.out.println(node.getValue());
        }
    }
}
