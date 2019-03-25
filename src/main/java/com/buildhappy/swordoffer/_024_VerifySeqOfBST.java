package com.buildhappy.swordoffer;

import java.util.Arrays;

/**
 * 面试题24：二叉搜索树的后序遍历序列
 * 题目大致为：
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true，否则返回false。
 * 假设输入的数组的任意两个数字都互不相同。
 * 思路：
 * 主要考察的是二叉搜索树和后序遍历的性质，其中后序遍历的最后一个数是根结点，在二叉搜索树中，
 * 左子树的值都小于根结点，右子树的值都大于根结点，这样便能构造左右子树的序列，
 * 用同样的方法分别处理左右子树序列，这便是一个递归的问题。
 *
 * @author dell
 */
public class _024_VerifySeqOfBST {
    public static void main(String args[]) {
        int array[] = {5, 7, 6, 9, 11, 10, 8};
        System.out.println(verifySquenceOfBST(array));
        int array2[] = {7, 4, 6, 5};
        System.out.println(verifySquenceOfBST(array2));
    }

    public static boolean verifySquenceOfBST(int[] sequence) {
        //判断序列是否满足要求
        int length = sequence.length;
        if (sequence == null || length <= 0) {
            return false;
        }
        //序列的最后一个数是二查搜索树的根结点
        int root = sequence[length - 1];
        int leftNum;
        for (leftNum = 0; leftNum < length; leftNum++) {
            //当只有根结点的时候要用等于去判断
            if (sequence[leftNum] >= root) {
                break;
            }
        }

        //判断右子树是否满足要求
        for (int j = leftNum; j < length - 1; j++) {
            if (sequence[j] < root) {
                return false;
            }
        }
        // 构造左子树的序列
        int[] left = Arrays.copyOfRange(sequence, 0, leftNum);
        // 构造右子树的序列
        int[] right = Arrays.copyOfRange(sequence, leftNum, length - 1);
        boolean leftBool = true;
        boolean rightBool = true;
        // 当左子树的序列存在时
        if (left.length > 0) {//要有判断，否则会返回错误结果
            leftBool = verifySquenceOfBST(left);
        }
        // 当右子树的序列存在时
        if (right.length > 0) {
            rightBool = verifySquenceOfBST(right);
        }
        return (leftBool && rightBool);
    }
}
