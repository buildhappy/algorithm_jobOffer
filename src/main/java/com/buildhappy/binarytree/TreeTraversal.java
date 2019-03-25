package com.buildhappy.binarytree;

import com.buildhappy.factory.BinaryTreeFactory;
import com.buildhappy.bean.BinaryTreeNode;

import java.util.*;

import static com.buildhappy.util.LogUtils.println;

public class TreeTraversal {
    private static final List<Integer> PRE_ORDER_RESULT = new LinkedList();
    private static final List<Integer> IN_ORDER_RESULT = new LinkedList();
    private static final List<Integer> POST_ORDER_RESULT = new LinkedList();

    public static void main(String[] args) {
        // 构造二叉树
        BinaryTreeNode root = BinaryTreeFactory.getFullBinaryTree();
        preOrder(root);
        println("Preorder traversal result: " + PRE_ORDER_RESULT);
        clear();

        nonRecursiveInOrder(root);
        println("Non recursive in order: " + IN_ORDER_RESULT);
        clear();

        println("Level traversal result: " + levelTraversal(root));
    }

    /**
     * 前序遍历
     * @param head
     */
    public static void preOrder(BinaryTreeNode head) {
        if (head == null) {
            return;
        }
        PRE_ORDER_RESULT.add(head.getVal());
        preOrder(head.getLeft());
        preOrder(head.getRight());
    }

    /**
     * 中序遍历
     * @param head
     */
    public static void inOrder(BinaryTreeNode head) {
        if (head == null) {
            return;
        }
        preOrder(head.getLeft());
        IN_ORDER_RESULT.add(head.getVal());
        preOrder(head.getRight());
    }

    /**
     * 后序遍历
     * @param head
     */
    public static void postOrder(BinaryTreeNode head) {
        if (head == null) {
            return;
        }
        preOrder(head.getLeft());
        preOrder(head.getRight());
        POST_ORDER_RESULT.add(head.getVal());
    }

    /**
     * 非递归实现中序遍历
     * @param root
     */
    public static void nonRecursiveInOrder(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        Stack<BinaryTreeNode> stack = new Stack();
        BinaryTreeNode dummyRoot = root;
        while (dummyRoot != null || !stack.isEmpty()) {
            if(dummyRoot != null) {
                stack.push(dummyRoot);
///                 将visit函数放到此处可以实现前序遍历
///                PRE_ORDER_RESULT.add(dummyRoot.getVal());
                dummyRoot = dummyRoot.getLeft();
            } else {
                dummyRoot = stack.pop();
                // visit node
                IN_ORDER_RESULT.add(dummyRoot.getVal());
                dummyRoot = dummyRoot.getRight();
            }
        }
    }

    /**
     * 层序遍历二叉树
     * @param root
     */
    public static List<Integer> levelTraversal(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<BinaryTreeNode> traversalQueue = new LinkedList<BinaryTreeNode>();
        traversalQueue.offer(root);

        List<Integer> traversalResult = new LinkedList<Integer>();
        while (!traversalQueue.isEmpty()) {
            BinaryTreeNode node = traversalQueue.poll();
            traversalResult.add(node.val);
            if (node.left != null) {
                traversalQueue.offer(node.left);
            }
            if (node.right != null) {
                traversalQueue.offer(node.right);
            }
        }
        // 从最后一层往前遍历
        Collections.reverse(traversalResult);
        return traversalResult;
    }

    private static void clear() {
        PRE_ORDER_RESULT.clear();
        IN_ORDER_RESULT.clear();
        POST_ORDER_RESULT.clear();
    }

}
