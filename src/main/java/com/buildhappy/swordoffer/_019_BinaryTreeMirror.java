package com.buildhappy.swordoffer;

import com.buildhappy.bean.BinaryTreeNode;
import com.buildhappy.factory.BinaryTreeFactory;

/**
 * 面试题19：二叉树的镜像
 * 题目大致为：
    给定一棵二叉树，将其每一个结点的左右子树交换，这就叫做镜像。
 * 思路：
    先对其根节点的左右子树处理，交换左右子树，此时再递归处理左右子树。
    这里要注意分为三种情况：1、树为空；2、只有根结点；3、左右子树至少有一个不为空。
 * @author dell
 * 
 */
public class _019_BinaryTreeMirror {
	public static void main(String args[]) {
		// 构建二叉树
		BinaryTreeNode root = BinaryTreeFactory.getBinaryTree();

		// 求镜像
		mirrorRecursively(root);

		// 前序遍历输出
		printPreOrder(root);
	}

	/**
	 * 分三种情况：1、树为空；2、只有根结点；3、左右子树至少有一个不为空 
	 * 对根结点的左右子树的处理方法与根结点的处理一致，可以采用递归的方式求解
	 * @param root
	 */
	public static void mirrorRecursively(BinaryTreeNode root) {
		// 树为空
		if (root == null) {
			return;
		}
		// 只有一个根结点
		if (root.getLeft() == null && root.getRight() == null) {
			return;
		}

		// 左右子树至少有一个不为空
		BinaryTreeNode treeTmp = root.getLeft();
		root.setLeft(root.getRight());
		root.setRight(treeTmp);

		// 递归求解左右子树
		if (root.getLeft() != null) {
			mirrorRecursively(root.getLeft());
		}

		if (root.getRight() != null) {
			mirrorRecursively(root.getRight());
		}
	}
	
	/**
	 * 递归方式实现前序遍历输出
	 * @param root
	 */
	public static void printPreOrder(BinaryTreeNode root) {
		if (root != null) {
			System.out.print(root.getVal() + "、");
			printPreOrder(root.getLeft());
			printPreOrder(root.getRight());
		}
	}
}
