package com.note.xbd.geekbang.tree;

class BinarySearchTreeTest {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        int[] array = new int[]{
                33, 16, 50, 13, 18, 34, 58, 15, 17, 25, 51, 66, 19, 27, 55
        };
        for (int i : array) {
            System.out.print(i+"\t");
            tree.insert(i);
        }
        System.out.println("");
        System.out.println(tree.level());
        System.out.println(tree.search(13));
        System.out.println(tree.max());
        System.out.println(tree.min());
        System.out.println("前序、中序、后序打印树");
        tree.preOrder();
        tree.inOrder();
        tree.postOrder();
        System.out.println("-----------------------------------------");
        tree.delete(13);
        System.out.println("删除13后");
        tree.preOrder();
        tree.delete(18);
        System.out.println("删除18后");
        tree.preOrder();
        tree.delete(55);
        System.out.println("删除55后");
        tree.preOrder();
    }

}