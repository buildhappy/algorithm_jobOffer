package com.buildhappy.swordoffer;

import com.buildhappy.bean.BinaryTreeNode;
import com.buildhappy.constant.TreeConsts;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 面试题39：二叉树的深度
 * 题目大致为：
 * 输入一棵二叉树的根结点，求该树的深度。
 * 其中，从根结点到叶结点一次经过的结点形成树的一条路径，最长路径的长度为树的深度。
 * 思路：
 * 树的遍历可以利用递归实现，查找深度其实也是遍历的一种，分别遍历左右子树，找到左右子树中结点的个数。
 *
 * @author dell
 */
public class _039_BinaryDepth {

    public static void main(String args[]) {
        BinaryTreeNode root = TreeConsts.BINARY_TREE;

        // 计算深度
        System.out.println("二叉树的深度为(递归)：" + treeDepth_iterator(root));
        // 计算深度
        System.out.println("二叉树的深度为(非递归)：" + treeDepth(root));
        inOrder(root);
    }

    /**
     * 计算二叉树的深度（递归实现），广度优先遍历
     * 注意与19题的深度优先遍历的比较
     *
     * @param root 根结点
     * @return深度
     */
    public static int treeDepth_iterator(BinaryTreeNode root) {
        //先判断树是否存在
        if (root == null) {
            return 0;
        }

        //递归实现左右子树的深度
        int leftDepth = treeDepth_iterator(root.getLeft());
        int rightDepth = treeDepth_iterator(root.getRight());

        //找到最大值
        return (leftDepth > rightDepth ? (leftDepth + 1) : (rightDepth + 1));
    }

    /**
     * 计算二叉树的深度（非递归），广度优先遍历
     * 注意与19题的深度优先遍历的比较
     *
     * @param root
     */
    public static int treeDepth(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();
            int leftDepth = depth;
            int rightDepth = depth;
            //rightDepth = depth;
            if (node.getLeft() != null) {
                queue.offer(node.getLeft());
                leftDepth++;
            }
            if (node.getRight() != null) {
                queue.offer(node.getRight());
                rightDepth++;
            }
            depth = Math.max(rightDepth, leftDepth);
        }
        return depth;
    }

    //非递归实现前序遍历
    public static void inOrder(BinaryTreeNode tree) {
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        BinaryTreeNode p = tree;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                System.out.print(p.getVal() + " ");//前序遍历
                p = p.getLeft();
            } else {
                BinaryTreeNode q = stack.pop();
                //System.out.print(q.getVal() + " ");中序遍历
                p = q.getRight();
            }
        }
    }

    /**
     * 层次遍历（广度优先）
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
}
