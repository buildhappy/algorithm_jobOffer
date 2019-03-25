package com.buildhappy.swordoffer;

import com.buildhappy.factory.BinaryTreeFactory;
import com.buildhappy.bean.BinaryTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 面试题23：从上往下打印二叉树
 * 题目大致为：
 * 层次遍历打印二叉树。
 * 思路：
 * 可以使用队列的方式存储，先将根结点入队，若队列不为空，则取出队列的头，
 * 若这个结点有左孩子，则左孩子入队，若有右孩子，则右孩子入队。
 * 扩展：P140
 */
public class _023_PrintTreeLevel {
    public static void main(String args[]) {
        //构建二叉树
        BinaryTreeNode root = BinaryTreeFactory.getFullBinaryTree();

        //层次遍历
        System.out.println("层次遍历序列：");
        printFromTopToBottom(root);
        System.out.println("\n之字形遍历序列：");
        printTreeZ(root);
    }

    /**
     * 层次遍历
     *
     * @param root 根结点
     */
    public static void printFromTopToBottom(BinaryTreeNode root) {
        //使用队列的形式
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        //根结点入队
        queue.add(root);
        //队列非空
        while (!queue.isEmpty()) {
            //去除队列的头
            BinaryTreeNode treeNode = queue.poll();
            System.out.print(treeNode.getVal() + "、");

            //左孩子不为空,将左子树入队列
            if (treeNode.getLeft() != null) {
                queue.offer(treeNode.getLeft());
            }

            //右孩子不为空,将右子树入队列
            if (treeNode.getRight() != null) {
                queue.offer(treeNode.getRight());
            }
        }
    }

    /**
     * 之字形打印树
     *
     * @param pRoot
     * @return
     */
    public static ArrayList<ArrayList<Integer>> printTreeZ(BinaryTreeNode pRoot) {
        int layer = 1;
        //s1存奇数层节点
        Stack<BinaryTreeNode> s1 = new Stack();
        s1.push(pRoot);
        //s2存偶数层节点
        Stack<BinaryTreeNode> s2 = new Stack();

        ArrayList<ArrayList<Integer>> list = new ArrayList();

        while (!s1.empty() || !s2.empty()) {
            if (layer % 2 != 0) {
                ArrayList<Integer> temp = new ArrayList();
                while (!s1.empty()) {
                    BinaryTreeNode node = s1.pop();
                    if (node != null) {
                        temp.add(node.val);
                        System.out.print(node.val + " ");
                        s2.push(node.left);
                        s2.push(node.right);
                    }
                }
                if (!temp.isEmpty()) {
                    list.add(temp);
                    layer++;
                    System.out.println();
                }
            } else {
                ArrayList<Integer> temp = new ArrayList();
                while (!s2.empty()) {
                    BinaryTreeNode node = s2.pop();
                    if (node != null) {
                        temp.add(node.val);
                        System.out.print(node.val + " ");
                        s1.push(node.right);
                        s1.push(node.left);
                    }
                }
                if (!temp.isEmpty()) {
                    list.add(temp);
                    layer++;
                    System.out.println();
                }
            }
        }
        return list;
    }

}
