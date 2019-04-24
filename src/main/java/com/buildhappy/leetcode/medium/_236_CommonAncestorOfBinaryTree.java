package com.buildhappy.leetcode.medium;

import com.buildhappy.bean.BinaryTreeNode;
import com.buildhappy.leetcode.Task;

/**
 * 两个节点的最低公共父节点
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 */
public class _236_CommonAncestorOfBinaryTree extends Task {

    @Override
    public void run() {
        super.run();
    }

    public BinaryTreeNode lowestCommonAncestor(BinaryTreeNode root,
                                               BinaryTreeNode p, BinaryTreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        BinaryTreeNode left = lowestCommonAncestor(root.left, p, q);
        BinaryTreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        } else {
            return left != null ? left : right;
        }
    }
}
