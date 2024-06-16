package org.anderson.curso_ada.bst;

public class BST {

    private Node root;

    class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public int getValue() {
            return value;
        }

        public Node getRight() {
            return right;
        }
    }

    public void insert(int value) {
        if (root == null) root = new Node(value);
        else insert(root, value);
    }

    private void insert(Node root, int value) {
        if (root == null) return;
        if (root.value == value) return;
        if (value > root.value) {
            if(root.right == null) root.right = new Node(value);
            else insert(root.right, value);
        } else {
            if(root.left == null) root.left = new Node(value);
            else insert(root.left, value);
        }
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

    public boolean contains(int value) {
        return contains(root, value);
    }

    private boolean contains(Node root, int value) {
        if (root == null) return false;
        if (root.value == value) return true;
        if (value > root.value) return contains(root.right, value);
        else return contains(root.left, value);
    }

    public int minValue(Node currenteNode) {
        while (currenteNode != null) currenteNode = currenteNode.left;

        return minValue(currenteNode);
    }

    public void deleteNode(int value) {
        root = deleteNode(root, value);
    }

    private Node deleteNode(Node root, int value) {
        if(root == null) return null;
        if (value < root.value) root.left = deleteNode(root.left, value);
        else if (value > root.value) root.right = deleteNode(root.right, value);
        else {
            if (isLeaf(root)) return null;
            else if(root.left == null) return root.right;
            else if(root.right == null) return root.left;
            else {
                int minValue = minValue(root.right);
                root.right = deleteNode(root.right, minValue);
            }
        }
        return root;
    }

    public boolean isLeaf(Node root) {
        if(root.right == null && root.left == null) return true;
        return false;
    }
}
