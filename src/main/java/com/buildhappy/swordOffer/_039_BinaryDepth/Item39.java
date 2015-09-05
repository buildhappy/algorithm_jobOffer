package com.buildhappy.swordOffer._039_BinaryDepth;

import java.util.AbstractSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 面试题39：二叉树的深度
 * 题目大致为：
    输入一棵二叉树的根结点，求该树的深度。
    其中，从根结点到叶结点一次经过的结点形成树的一条路径，最长路径的长度为树的深度。
 * 思路：
 *  树的遍历可以利用递归实现，查找深度其实也是遍历的一种，分别遍历左右子树，找到左右子树中结点的个数。
 * @author dell
 * 
 */
public class Item39 {

	public static void main(String args[]) {
		BinaryTreeNode root = new BinaryTreeNode(1);
		BinaryTreeNode node_2 = new BinaryTreeNode(2);
		BinaryTreeNode node_3 = new BinaryTreeNode(3);
		BinaryTreeNode node_4 = new BinaryTreeNode(4);
		BinaryTreeNode node_5 = new BinaryTreeNode(5);
		BinaryTreeNode node_6 = new BinaryTreeNode(6);
		BinaryTreeNode node_7 = new BinaryTreeNode(7);
		root.setLeft(node_2);
		root.setRight(node_3);
		node_2.setLeft(node_4);
		node_2.setRight(node_5);
		node_3.setLeft(null);
		node_3.setRight(node_6);
		node_4.setLeft(null);
		node_4.setRight(null);
		node_5.setLeft(node_7);
		node_5.setRight(null);
		node_6.setLeft(null);
		node_6.setRight(null);
		node_7.setLeft(null);
		node_7.setRight(null);

		// 计算深度
		System.out.println("二叉树的深度为(递归)：" + treeDepth_iterator(root));
		// 计算深度
		System.out.println("二叉树的深度为(非递归)：" + treeDepth(root));
		inOrder(root);
	}

	/**
	 * 计算二叉树的深度（递归实现），广度优先遍历
	 * 注意与19题的深度优先遍历的比较
	 * @param root根结点
	 * @return深度
	 */
	public static int treeDepth_iterator(BinaryTreeNode root) {
		//先判断树是否存在
		if (root == null)
			return 0;

		//递归实现左右子树的深度
		int leftDepth = treeDepth_iterator(root.getLeft());
		int rightDepth = treeDepth_iterator(root.getRight());

		//找到最大值
		return (leftDepth > rightDepth ? (leftDepth + 1) : (rightDepth + 1));
	}
	/**
	 * 计算二叉树的深度（非递归），广度优先遍历
	 * 注意与19题的深度优先遍历的比较
	 * @param tree
	 */
	public static int treeDepth(BinaryTreeNode root){
		if(root == null) return 0;
		int depth = 0;
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()){
			BinaryTreeNode node = queue.poll();
			int leftDepth = depth;
			int rightDepth = depth;
			//rightDepth = depth;
			if(node.getLeft() != null){
				queue.offer(node.getLeft());
				leftDepth++;
			}
			if(node.getRight() != null){
				queue.offer(node.getRight());
				rightDepth++;
			}
			depth = (rightDepth > leftDepth) ? rightDepth : leftDepth;
		}
		return depth;
	}
	//非递归实现前序遍历
	public static void inOrder(BinaryTreeNode tree){
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		BinaryTreeNode p = tree;
		while(p != null || !stack.isEmpty()){
			if(p != null){
				stack.push(p);
				System.out.print(p.getValue() + " ");//前序遍历
				p = p.getLeft();
			}else{
				BinaryTreeNode q = stack.pop();
				//System.out.print(q.getValue() + " ");中序遍历
				p = q.getRight();
			}
		}
	}
	
	/**
	 * 层次遍历（广度优先）
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
