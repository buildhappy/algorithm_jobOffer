package com.buildhappy.leedcode.medium;

import com.buildhappy.leedcode.Task;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximal-square/
 * 最大的正方形
 */
public class _221_MaximalSquare extends Task {
    @Override
    public void run() {
        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}};
        println(maximalSquare(matrix));
    }

    /**
     * dp[i][j]代表以i,j为右下角的最大的正方形
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[][] dp = new int[rows + 1][cols + 1];
        int max = 0;
        for (int i = 1; i <= rows; ++i) {
            for (int j = 1; j <= cols; ++j) {
                if (matrix[i-1][j-1] == '1') {
                    dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max * max;
    }

    private int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}
