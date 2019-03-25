package com.buildhappy.swordoffer;

import com.buildhappy.bean.BinaryTreeNode;
import com.buildhappy.factory.BinaryTreeFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 查找树中，路径和为某个值得所有路径
 *
 * @author buildhappy
 */
public class _025_PathInTree {

    /**
     * 按层次遍历树
     */
    private static void levelPrintTree(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        // 把根节点入队
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();
            System.out.print(node.getVal() + "\t");

            // 把树的所有直接子节点入队,如果是棵任意树，需要遍历所有直接子节点
            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.add(node.getRight());
            }
        }
        System.out.println();
    }

    /**
     * 查找二叉树中和为某一值的路径, 剑指offer P146
     */
    public static void findPath(BinaryTreeNode root, int expectSum, Stack<Integer> stack,
                                int currentSum) {
        if (root == null) {
            return;
        }
        //把当前结点进栈
        stack.push(root.val);
        currentSum += root.val;
        //如果是叶子结点，而且和为给定的值，则打印路径
        boolean isLeaf = (root.left == null) && (root.right == null);
        //如果是叶子节点并且满足路径和的要求，则将其打印出来
        if (isLeaf && currentSum == expectSum) {
            for (Integer e : stack) {
                System.out.print(e + "\t");
            }
            System.out.println();
        }

        //如果不是叶子结点，则遍历它的子结点
        if (root.left != null) {
            findPath(root.left, expectSum, stack, currentSum);
        }
        if (root.right != null) {
            findPath(root.right, expectSum, stack, currentSum);
        }
        //在返回到父结点之前，在路径上删除当前结点
        stack.pop();
    }

    /**
     * 从二叉树中寻找从root到nodeNum的路径,路径保存在path中
     */
    public static boolean findPath(BinaryTreeNode root, int nodeNum, List<Integer> path) {
        if (root == null) {
            return false;
        }
        if (root.val == nodeNum) {
            path.add(nodeNum);
            return true;
        }

        if (findPath(root.left, nodeNum, path)) {
            path.add(0, root.val);
            return true;
        }
        if (findPath(root.right, nodeNum, path)) {
            path.add(0, root.val);
            return true;
        }
        return false;
    }

    /**
     * 该方法更容易理解
     */
    public static void findPath(BinaryTreeNode root, int expectSum, List<Integer> path, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && root.val == expectSum) {
            path.add(root.val);
            result.add(path);
//            return;
        }

        if (root.left != null) {
            List<Integer> leftPath = new LinkedList<>(path);
            leftPath.add(root.val);
            findPath(root.left, expectSum - root.val, leftPath, result);
        }

        if (root.right != null) {
            List<Integer> rightPath = new LinkedList<>(path);
            rightPath.add(root.val);
            findPath(root.right, expectSum - root.val, rightPath, result);
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode root = BinaryTreeFactory.getBinaryTree();

        System.out.println("Level print:");
        levelPrintTree(root);
//        Stack<Integer> stack = new Stack<Integer>();
//        findPath(root, expectSum, stack, 0);

        // 方法二，更容易理解
        int expectSum = 19;
        System.out.println("The paths of all node sum is " + expectSum);
        List<Integer> path = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        findPath(root, expectSum, path, result);
        System.out.println(result);

        // 查找从root到指定节点的路径
        System.out.println();
        int node = 6;
        System.out.println("Path from root to " + node);

        path.clear();
        findPath(root, node, path);
        System.out.println(path);

    }
}
