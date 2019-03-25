package com.buildhappy.binarytree;

import com.buildhappy.factory.BinaryTreeFactory;
import com.buildhappy.bean.BinaryTreeNode;

import java.util.LinkedList;
import java.util.List;

import static com.buildhappy.util.LogUtils.println;

public class TreeOptions {
    private static final List<Integer> PRE_ORDER_RESULT = new LinkedList();
    public static void main(String[] args) {
        // 构造二叉树
        BinaryTreeNode root = BinaryTreeFactory.getFullBinaryTree();

        println("Tree depth: " + depth(root));
        println("Degree is one: " + count1(BinaryTreeFactory.getBinaryTree()));

        exchangeTreeNode(root);
        PRE_ORDER_RESULT.clear();
        TreeTraversal.preOrder(root);
        println("Exchange tree node: " + PRE_ORDER_RESULT);
    }

    /**
     * 二叉树的深度
     * @param root
     * @return
     */
    public static int depth(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = depth(root.getLeft());
        int rightDepth = depth(root.getLeft());
        return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
    }

    /**
     * 统计树种度为1的节点数量
     * @param root
     * @return
     */
    public static int count1(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }

        int count = 0;
        if ((root.getLeft() == null) != (root.getRight() == null)) {
            count = 1;
        }
        return count + count1(root.getLeft()) + count1(root.getRight());
    }

    /**
     * 交互二叉树左右的节点
     * @param root
     */
    public static void exchangeTreeNode(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        BinaryTreeNode leftChild = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(leftChild);
        exchangeTreeNode(root.getRight());
        exchangeTreeNode(root.getLeft());
    }
}
