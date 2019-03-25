package com.buildhappy.factory;

import com.buildhappy.bean.BinaryTreeNode;

public class BinaryTreeFactory {
    /**
     * 构造满二叉树
     *
     *            8
     *        6      10
     *     5            11
     * @return
     */
    public static BinaryTreeNode getBinaryTree() {
        BinaryTreeNode root = new BinaryTreeNode(8);
        BinaryTreeNode t1 = new BinaryTreeNode(6);
        BinaryTreeNode t2 = new BinaryTreeNode(10);
        BinaryTreeNode t3 = new BinaryTreeNode(5);
        BinaryTreeNode t6 = new BinaryTreeNode(11);
        root.setLeft(t1);
        root.setRight(t2);
        t1.setLeft(t3);
        t2.setRight(t6);
        return root;
    }

    /**
     * 构造满二叉树
     *
     *            8
     *        6      10
     *     5    7  9    11
     * @return
     */
    public static BinaryTreeNode getFullBinaryTree() {
        BinaryTreeNode root = new BinaryTreeNode(8);
        BinaryTreeNode t1 = new BinaryTreeNode(6);
        BinaryTreeNode t2 = new BinaryTreeNode(10);
        BinaryTreeNode t3 = new BinaryTreeNode(5);
        BinaryTreeNode t4 = new BinaryTreeNode(7);
        BinaryTreeNode t5 = new BinaryTreeNode(9);
        BinaryTreeNode t6 = new BinaryTreeNode(11);
        root.setLeft(t1);
        root.setRight(t2);
        t1.setLeft(t3);
        t1.setRight(t4);
        t2.setLeft(t5);
        t2.setRight(t6);
        return root;
    }
}
