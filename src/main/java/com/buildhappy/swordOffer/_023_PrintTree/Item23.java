package com.buildhappy.swordOffer._023_PrintTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 面试题23：从上往下打印二叉树
 * 题目大致为：
    层次遍历打印二叉树。
 * 思路：
    可以使用队列的方式存储，先将根结点入队，若队列不为空，则取出队列的头，
    若这个结点有左孩子，则左孩子入队，若有右孩子，则右孩子入队。
 * 扩展：P140 
 * @author dell
 * 
 */
public class Item23 {
	public static void main(String args[]) {
		//构建二叉树
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
		t3.setLeft(null);
		t3.setRight(null);
		t4.setLeft(null);
		t4.setRight(null);
		t5.setLeft(null);
		t5.setRight(null);
		t6.setLeft(null);
		t6.setRight(null);

		//层次遍历
		System.out.println("层次遍历序列：");
		printFromTopToBottom(root);

	}

	/**
	 * 层次遍历
	 * 
	 * @param root根结点
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
			System.out.print(treeNode.getValue() + "、");

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
