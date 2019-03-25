package com.buildhappy.bean;

public class BinaryTreeNode {
	public int val;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

	public BinaryTreeNode(){}

	public BinaryTreeNode(int val) {
		this.val = val;
	}

	public BinaryTreeNode(int val, BinaryTreeNode left, BinaryTreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public BinaryTreeNode getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode left) {
		this.left = left;
	}

	public BinaryTreeNode getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode right) {
		this.right = right;
	}

}
