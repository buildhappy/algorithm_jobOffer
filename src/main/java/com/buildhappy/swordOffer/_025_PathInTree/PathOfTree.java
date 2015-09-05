package com.buildhappy.swordOffer._025_PathInTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
/**
 * 查找树中，路径和为某个值得所有路径
 * @author buildhappy
 *
 */
public class PathOfTree {
	public static class Tree {
		int v;
		Tree left;
		Tree right;
	}

	/**
	 * 从数组中递归创建树
	 * 
	 * @param data
	 * @param i 数组中第i个元素
	 * @return 树的根节点
	 */
	private static Tree create(int[] data, int i) {
		if (data == null || i < 0 || i >= data.length) {
			return null;
		} else {
			Tree root = new Tree();
			root.v = data[i];
			// root 对应数组下标为0
			root.left = create(data, (i << 1) + 1);
			root.right = create(data, (i << 1) + 2);
			return root;
		}
	}

	/**
	 * 按层次遍历树
	 */
	private static void levelPrintTree(Tree root) {
		if (root == null) {
			return;
		}
		Queue<Tree> queue = new LinkedList<Tree>();
		// 把根节点入队
		queue.add(root);
		while (!queue.isEmpty()) {
			Tree node = queue.poll();
			System.out.print(node.v + "\t");

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

	/**
	 * 查找二叉树中和为某一值的路径
	 */
	public static void findPath(Tree root, int expectSum, Stack<Integer> stack,
			int currentSum) {
		if (root == null) {
			return;
		}
		//把当前结点进栈
		stack.push(root.v);
		currentSum += root.v;
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

	public static void main(String[] args) {
		int[] data = {10, 5, 12, 4, 7};//层序序列
		Tree root = create(data, 0);
		levelPrintTree(root);
		Stack<Integer> stack = new Stack<Integer>();
		findPath(root, 22, stack, 0);
	}
}
