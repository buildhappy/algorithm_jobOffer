package com.buildhappy.swordoffer;

import com.buildhappy.bean.BinaryTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 把二元查找树转变成排序的双向链表
 * 题目：
 * 输入一棵二元查找树，将该二元查找树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只调整指针的指向。
 * 10
 * / \
 * 6 14
 * / \ / \
 * 4 8 12 16
 * 转换成双向链表
 * 4=6=8=10=12=14=16
 */
public class _027_BSTToList {
    public static void main(String[] args) {
        _027_BSTToList bn = new _027_BSTToList();
        //这些数据是按二叉查找树的层次遍历存放
        int[] data = {10, 6, 14, 4, 8, 12, 16};
        BinaryTreeNode head = bn.createTree(data);
        //Node head = bn.createTreeIterator(data, 0);
        System.out.print("树的层序序列：");
        levelPrintTree(head);
        BinaryTreeNode node = bn.toTwoWayLinkedList(head);
        bn.printTwoLinkedList(node);
    }

    /*
     * 思路：中序遍历二叉树，将上次访问的节点记为previous，当前访问的节点记为current；
     * 对于遍历过程中的每个当前节点，让该节点的左指针指向previous(current->left = previous)，让previous的右指针
     * 指向当前节点(previous->right = current)，然后将previous更新为current。
     * 当中序遍历结束时，二叉搜索树也被转化为双链表了。
     *
     * 具体思路可参见：http://hi.baidu.com/gropefor/blog/item/d2144f8ce0325105b31bba11.html
     *
     * 问题：这个previous只能作为类成员才能得到正确的结果，作为局部变量的话，我得不到正解。 我尝试过这样写：
     * toTwoWayLinkedList(Node node,Node previous),在main函数里面调用时候，
     * 用toTwoWayLinkedList(head,null)，得不到正确答案
     */
    private BinaryTreeNode previous;

    public BinaryTreeNode toTwoWayLinkedList(BinaryTreeNode head) {
        convert(head);
        // after converting to List,head=a[0]=10,but the head is not the
        // actually head of list.
        // the true head is 4.
        while (head.getLeft() != null) {
            // find the true Head.
            head = head.getLeft();
        }
        return head;
    }

    public void convert(BinaryTreeNode head) {
        if (head != null) {
            convert(head.getLeft());
            if (previous != null) {
                previous.setRight(head);
                head.setLeft(previous);
            }
            previous = head;
            convert(head.getRight());
        }
    }

    public void printTwoLinkedList(BinaryTreeNode node) {
        if (node != null) {
            System.out.println(node.val);
            while (node != null) {
                System.out.print(node.val + " ");
                node = node.getRight();
            }
        }
    }

    public BinaryTreeNode createTree(int[] data) {

        List<BinaryTreeNode> nodeList = new ArrayList();
        for (int each : data) {
            BinaryTreeNode node = new BinaryTreeNode(each);
            nodeList.add(node);
        }
        int lastRootIndex = data.length / 2 - 1;
        for (int i = lastRootIndex; i >= 0; i--) {
            int leftIndex = i * 2 + 1;
            BinaryTreeNode root = nodeList.get(i);
            BinaryTreeNode left = nodeList.get(leftIndex);
            root.setLeft(left);
            if (leftIndex + 1 < data.length) {
                BinaryTreeNode right = nodeList.get(leftIndex + 1);
                root.setRight(right);
            }
        }
        BinaryTreeNode head = nodeList.get(0);
        return head;
    }

    public BinaryTreeNode createTreeIterator(int[] data, int i) {
        if (null == data || i < 0 || i >= data.length) {
            return null;
        } else {
            BinaryTreeNode root = new BinaryTreeNode(data[i]);
            root.setLeft(createTreeIterator(data, (i << 1) + 1));
            root.setRight(createTreeIterator(data, (i << 1) + 2));
            return root;
        }
    }

    private static void levelPrintTree(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Queue<BinaryTreeNode> queue = new LinkedList();
        // 把根节点入队
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();
            System.out.print(node.val + " ");

            // 把树的所有直接子节点入队,如果是棵任意树，需要遍历所有直接子节点
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        System.out.println();
    }
}
