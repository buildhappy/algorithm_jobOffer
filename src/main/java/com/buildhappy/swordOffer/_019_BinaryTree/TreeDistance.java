package com.buildhappy.swordOffer._019_BinaryTree;

import java.util.Stack;

/**
 * 求二叉树的距离 计算一个二叉树的最大距离有两个情况: 情况A: 路径经过左子树的最深节点，通过根节点，再到右子树的最深节点。 情况B:
 * 路径不穿过根节点，而是左子树或右子树的最大距离路径，取其大者。
 * 
 * @author buildhappy
 *
 */
public class TreeDistance {
	public static int maxDistance = 0;

	/**
	 * 递归的方式实现（深度优先遍历） 注意与39题的广度优先遍历的比较
	 * 
	 * @param root
	 */
	public static void maxDistance_iterator(TreeNode root) {
		if (root == null)
			return;
		if (root.left != null) {
			maxDistance_iterator(root.left);
			root.maxLeft = Math.max(root.left.maxLeft, root.left.maxRight) + 1;
		}
		if (root.right != null) {
			maxDistance_iterator(root.right);
			root.maxRight = Math.max(root.right.maxLeft, root.right.maxRight) + 1;
		}
		if ((root.maxLeft + root.maxRight) > maxDistance) {
			maxDistance = root.maxLeft + root.maxRight;
		}
	}

	
	static Stack<TreeNode> stack = new Stack<TreeNode>();
	/**
	 * 非递归的方式实现（深度优先遍历）
	 * 注意与39题的广度优先遍历的比较
	 * @param root
	 */
	public static int maxDistance(TreeNode root) {
		if (root == null) {
			return 0;
		}
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode cur = stack.peek();
			//将左子树所有结点入栈
			if (cur.left != null) {
				if (cur.left.visited) {
					// 左子树计算完了
					cur.maxLeft = Math.max(cur.left.maxLeft , cur.left.maxRight) + 1;
				} else {
					stack.push(cur.left);
					continue;
				}
			}
			//将右子树所有结点入栈
			if (cur.right != null) {
				if (cur.right.visited) {
					cur.maxRight = Math.max(cur.right.maxLeft , cur.right.maxRight) + 1;
				} else {
					stack.push(cur.right);
					continue;
				}
			}
			maxDistance = Math.max(maxDistance , cur.maxLeft + cur.maxRight);
			cur.visited = true;
			stack.pop();
			//continue;
		}
		return maxDistance;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode("a");
		TreeNode root1 = new TreeNode("b");
		TreeNode root2 = new TreeNode("c");
		TreeNode root3 = new TreeNode("d");
		TreeNode root4 = new TreeNode("e");
		root.left = root1;
		root.right = root2;
		root1.left = root3;
		root2.right = root4;
		
		maxDistance_iterator(root);
		System.out.println("递归实现的结果：" + maxDistance);
		maxDistance = 0;
		maxDistance(root);
		System.out.println("递归实现的结果：" + maxDistance);
	}

}


class TreeNode {
	String data;

	public TreeNode(String data) {
		this.data = data;
	}

	int maxLeft = 0;
	int maxRight = 0;
	TreeNode left = null;
	TreeNode right = null;
	boolean visited = false;
}