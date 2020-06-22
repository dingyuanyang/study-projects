package com.note.xbd.geekbang.tree;

public abstract class AbstractBinaryTree {
    protected Node tree;

    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    abstract void insert(int data);

    abstract void delete(int data);

    abstract Node search(int data);

    abstract int level();

    public void preOrder() {
        Node p = tree;
        preOrder(p);
        System.out.println("");
    }

    private void preOrder(Node p) {
        if (p == null) {
            return;
        }
        System.out.print(p.data + "\t");
        preOrder(p.left);
        preOrder(p.right);
    }
    public void inOrder() {
        Node p = tree;
        inOrder(p);
        System.out.println("");
    }

    private void inOrder(Node p) {
        if (p == null) {
            return;
        }
        inOrder(p.left);
        System.out.print(p.data + "\t");
        inOrder(p.right);
    }
    public void postOrder() {
        Node p = tree;
        postOrder(p);
        System.out.println("");
    }

    private void postOrder(Node p) {
        if (p == null) {
            return;
        }
        inOrder(p.left);
        inOrder(p.right);
        System.out.print(p.data + "\t");
    }

}
