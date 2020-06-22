package com.note.xbd.geekbang.tree;

public class BinarySearchTree extends AbstractBinaryTree {
    @Override
    void insert(int data) {
        if (tree == null) {
            tree = new Node(data);
            return;
        }
        Node p = tree;
        while (p != null) {
            if (data > p.getData()) {
                //数据比节点大，放入右子树
                if (p.getRight() == null) {
                    p.setRight(new Node(data));
                    return;
                }
                p = p.getRight();
            } else {
                //数据比当前节点小，放入左子树
                if (p.getLeft() == null) {
                    p.setLeft(new Node(data));
                    return;
                }
                p = p.getLeft();
            }
        }
    }

    @Override
    void delete(int val) {
        //要删除的节点，初始化是根节点
        Node del = tree;
        //记录父节点
        Node parent = null;
        while (del != null && del.getData() != val) {
            parent = del;
            if (val > del.getData()) {
                del = del.getRight();
            } else {
                del = del.getLeft();
            }
        }
        if (del == null) {
            System.out.println("没有找到删除的节点");
            return;
        }
        //删除的节点有左右子节点
        if (del.getLeft() != null && del.getRight() != null) {
            //查找右子树的最小节点
            Node rightMin = del.getRight();
            Node rightMinParent = null;
            while (rightMin.getLeft() != null) {
                rightMinParent = rightMin;
                rightMin = rightMin.getLeft();
            }
            del.setData(rightMin.getData());
            //删除子节点
            del = rightMin;
            parent = rightMinParent;
        }
        Node child;
        if (del.getLeft() != null) {
            child = del.getLeft();
        } else if (del.getRight() != null) {
            child = del.getRight();
        } else {
            child = null;
        }
        if (parent == null) {
            tree = child;
        } else if (parent.getLeft() == del) {
            parent.setLeft(child);
        } else {
            parent.setRight(child);
        }
    }

    @Override
    Node search(int val) {
        Node p = tree;
        while (p != null) {
            if (val > p.getData()) {
                //要查找的值大于节点，遍历右子树
                p = p.getRight();
            } else if (val < p.getData()) {
                p = p.getLeft();
            } else {
                return p;
            }
        }
        return null;
    }


    @Override
    int level() {
        if (tree == null) {
            return 0;
        }
        Node p = tree;
        int height = maxLevel(p);
        return height;
    }

    private int maxLevel(Node p) {
        if (p == null) {
            return 0;
        }
        int leftLevel = maxLevel(p.getLeft());
        int rightLevel = maxLevel(p.getRight());
        return Math.max(leftLevel, rightLevel)+1;
    }

    Node max() {
        if (tree == null) {
            return null;
        }
        Node p = tree;
        while (p.getRight() != null) {
            p = p.getRight();
        }
        return p;
    }

    Node min() {
        if (tree == null) {
            return null;
        }
        Node p = tree;
        while (p.getLeft() != null) {
            p = p.getLeft();
        }
        return p;
    }
}
