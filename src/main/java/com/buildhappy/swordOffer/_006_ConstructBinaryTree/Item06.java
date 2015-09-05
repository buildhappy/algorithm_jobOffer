package com.buildhappy.swordOffer._006_ConstructBinaryTree;

import java.util.Arrays;

/**
 * 面试题6：重建二叉树
 * 在前序遍历的序列中第一个就是树的根结点，此时再在中序遍历的序列里查找这个根结点，
 * 则中序遍历的序列里根结点左侧的就是左子树，右侧的就是右子树，再对左右子树进行同样的操作，
 * 此时可以使用递归实现，这样便能构造出这个二叉树。
 * 
 * 测试用例：
 *     普通二叉树：完全二叉树，不完全二叉树
 *     特殊二叉树：所有的节点都没有左节点或右节点，只有一个节点的二叉树
 *     特殊输入
 * @author dell
 * 
 */
public class Item06 {
	public static void main(String args[]) {
		// 二叉树的前序遍历
		//int[] preOrder = { 1, 2, 4, 7, 3, 5, 6, 8 };
		int[] preOrder = {5,4,3,2,6,7};
		// 二叉树的中序遍历
		//int inOrder[] = { 4, 7, 2, 1, 5, 3, 8, 6 };
		int inOrder[] = {3,4,2,5,7,6};
		
		BinaryTreeNode root = constructTree(preOrder, inOrder);
		printPostOrder(root);
		System.out.println();
		
		
		System.out.println("************* test **************");
		int inOrder2[] = {3,4,2,5,7,6};
		int inOrder3[] = Arrays.copyOfRange(inOrder2, 4, inOrder2.length);
		for(int i : inOrder3){
			System.out.print(i + ",");
		}
	}

	public static BinaryTreeNode constructTree(int preOrder[], int inOrder[]) {
		if(preOrder.length <= 0 || inOrder.length <= 0 || inOrder.length != preOrder.length){
			return null;
		}
		// 根据前序遍历创建根结点
		BinaryTreeNode root = new BinaryTreeNode(preOrder[0]);
		root.setLeft(null);
		root.setRight(null);

		int leftNum = 0;//左子树的结点个数

		// 在中序中找到根节点
		for (int i = 0; i < inOrder.length; i++) {
			if (inOrder[i] == root.getValue()) {
				break;
			} else {
				leftNum++;
			}
		}
		int rightNum = preOrder.length - 1 - leftNum;
		
		// 左子树不为空
		if (leftNum > 0) {
			//构造左子树的前序和中序遍历序列
			int leftPreOrder[] = new int[leftNum];
			int leftInOrder[] = new int[leftNum];
			
			/*
			for (int i = 0; i < leftNum; i++) {
				leftPreOrder[i] = preOrder[i + 1];
				leftInOrder[i] = inOrder[i];
			}
			*/
			
			leftPreOrder = Arrays.copyOfRange(preOrder , 1 , leftNum + 1);
			leftInOrder = Arrays.copyOfRange(inOrder, 0, leftNum);
			
			/*
			不能用System.arraycopy代替，因为该函数复制数组时不保持顺序性
			System.arraycopy(preOrder , 1 ,leftPreOrder , 0 , leftNum);
			System.arraycopy(inOrder , 0 , leftInOrder , 0 , leftNum);
			*/
			
			//递归构造左子树
			BinaryTreeNode leftRoot = constructTree(leftPreOrder, leftInOrder);
			root.setLeft(leftRoot);
		}
		
		//右子树不为空
		if (rightNum > 0) {
			//构造右子树的前序和中序遍历序列
			int rightPreOrder[] = new int[rightNum];
			int rightInOrder[] = new int[rightNum];
			/*
			for (int i = 0; i < rightNum; i++) {
				rightPreOrder[i] = preOrder[leftNum + i + 1];
				rightInOrder[i] = inOrder[leftNum + i + 1];
			}
			*/
			rightPreOrder = Arrays.copyOfRange(preOrder, leftNum + 1 , preOrder.length);
			rightInOrder = Arrays.copyOfRange(inOrder, leftNum + 1 , preOrder.length);
			//递归构造右子树
			BinaryTreeNode rightRoot = constructTree(rightPreOrder,
					rightInOrder);	
			root.setRight(rightRoot);
		}
		return root;
	}
	
	/**
	 * 后序遍历打印二叉树(递归实现)
	 * @param root 树的根结点
	 */
	public static void printPostOrder(BinaryTreeNode root) {
		if (root != null) {
			printPostOrder(root.getLeft());
			printPostOrder(root.getRight());
			System.out.print(root.getValue() + "、");
		}
	}
}
