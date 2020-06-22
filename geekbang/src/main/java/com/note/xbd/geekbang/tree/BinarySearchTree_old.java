package com.note.xbd.geekbang.tree;

/**
 * 二叉查找树
 */
public class BinarySearchTree_old {

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
    }

    private Node tree;

    public void insert(int data) {
        if (tree == null) {
            tree = new Node(data);
            return;
        }
        Node p = tree;
        while (p != null) {
            if (data > p.data) {
                //数据比节点大，放入右子树
                if (p.right == null) {
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            } else {
                //数据比当前节点小，放入左子树
                if (p.left == null) {
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }
        }
    }

    public Node search(int val) {
        Node p = tree;
        while (p != null) {
            if (val > p.data) {
                //要查找的值大于节点，遍历右子树
                p = p.right;
            } else if (val < p.data) {
                p = p.left;
            } else {
                return p;
            }
        }
        return null;
    }

    public void prePrint() {
        Node p = tree;
        prePrint(p);
        System.out.println("");
    }

    private void prePrint(Node p) {
        if (p == null) {
            return;
        }
        System.out.print(p.data + "->");
        prePrint(p.left);
        prePrint(p.right);
    }

    public void delete(int val) {
        //要删除的节点，初始化是根节点
        Node del = tree;
        //记录父节点
        Node parent = null;
        while (del != null && del.data != val) {
            parent = del;
            if (val > del.data) {
                del = del.right;
            } else {
                del = del.left;
            }
        }
        if (del == null) {
            System.out.println("没有找到删除的节点");
            return;
        }
        //删除的节点有左右子节点
        if(del.left!=null && del.right!=null){
            //查找右子树的最小节点
            Node rightMin = del.right;
            Node rightMinParent = null;
            while (rightMin.left !=null){
                rightMinParent = rightMin;
                rightMin = rightMin.left;
            }
            del.data = rightMin.data;
            //删除子节点
            del = rightMin;
            parent = rightMinParent;
        }
        Node child ;
        if(del.left !=null){
            child = del.left;
        }else if(del.right != null){
            child = del.right;
        }else{
            child =null;
        }
        if(parent == null){
            tree = child;
        }else if(parent.left == del){
            parent.left = child;
        }else{
            parent.right = child;
        }
    }
}
