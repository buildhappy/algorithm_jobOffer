package com.buildhappy.swordOffer._060.printBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

import com.buildhappy.swordOffer._039_BinaryDepth.BinaryTreeNode;

/**
 * 面试题60：把二叉树打印成多行
 * 题目大致为：
从上往下按层打印二叉树，同一层的结点按从左到右的顺序打印，每一层打印到一行。
思路：
实际上就是二叉树的层次遍历问题，可以使用队列存储。
 * @author dell
 * 
 */
public class Item60 {
	public static void main(String args[]) {
		// 构建二叉树
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
		// 逐层打印
		printMulti(root);
	}
	
	/**
	 * 逐层打印
	 * @param root根结点
	 */
	public static void printMulti(BinaryTreeNode root) {
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.add(root);
		int num = 1;// 表示当前lever层上的结点个数
		while (!queue.isEmpty()) {// 队列非空
			int nextNum = 0;// 临时变量，用来记录下一层的结点个数
			// 取出当前层并打印，随后加入下一层的结点
			for (int i = 0; i < num; i++) {
				BinaryTreeNode tmp = queue.poll();// 取出队列头

				// 左孩子不为空
				if (tmp.getLeft() != null) {
					queue.add(tmp.getLeft());
					nextNum++;
				}

				// 右孩子不为空
				if (tmp.getRight() != null) {
					queue.add(tmp.getRight());
					nextNum++;
				}
				System.out.print(tmp.getValue() + "\t");

			}
			System.out.println();
			num = nextNum;
		}
	}

}
