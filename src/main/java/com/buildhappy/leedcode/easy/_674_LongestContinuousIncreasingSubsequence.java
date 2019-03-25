package com.buildhappy.leedcode.easy;

import com.buildhappy.leedcode.Task;

/**
 * 最长的<连续>递增子序列,比较第300题
 * https://leetcode.com/problems/longest-continuous-increasing-subsequence/solution/
 */
public class _674_LongestContinuousIncreasingSubsequence extends Task {

    @Override
    public void run() {
        int[] nums = {7, 8, 9, 1, 2, 3};
        println(findLengthOfLCIS(nums));
    }

    public int findLengthOfLCIS(int[] nums) {
        int result = 0, tmpIndex = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i - 1] >= nums[i]) {
                tmpIndex = i;
            }
            result = Math.max(result, i - tmpIndex + 1);
        }
        return result;
    }
}
