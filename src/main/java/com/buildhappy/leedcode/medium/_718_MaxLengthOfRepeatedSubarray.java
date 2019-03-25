package com.buildhappy.leedcode.medium;

import com.buildhappy.leedcode.Task;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-length-of-repeated-subarray/submissions/
 * 最长公共子序列
 * Given two integer arrays A and B, return the maximum length of a subarray that appears in both arrays.
 * Input: A: [1,2,3,2,1], B: [3,2,1,4,7]
 * Output: 3
 * Explanation: The repeated subarray with maximum length is [3, 2, 1].
 * 参考思路：
 * https://blog.csdn.net/someone_and_anyone/article/details/81044153
 */
public class _718_MaxLengthOfRepeatedSubarray extends Task {
    @Override
    public void run() {
        int[] A = {1, 2, 3, 2, 1, 7};
        int[] B = {3, 2, 1, 4, 7};
        println(findLength2(A, B));
    }


    public int findLength2(int[] A, int[] B) {
        int max = 0;
        int[][] dp = new int[A.length + 1][B.length + 1];
        int start1 = 0, start2 = 0;

        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                        start1 = i;
                        start2 = j;
                    }
//                    max = Math.max(dp[i][j], max);
                }
            }
        }
        println("start1: " + Arrays.toString(Arrays.copyOfRange(A, start1 - max, start1)));
        println("start2: " + Arrays.toString(Arrays.copyOfRange(B, start2 - max, start2)));
        return max;
    }
}
