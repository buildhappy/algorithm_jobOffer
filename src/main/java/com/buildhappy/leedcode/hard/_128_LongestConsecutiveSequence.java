package com.buildhappy.leedcode.hard;

import com.buildhappy.leedcode.Task;

import java.util.Arrays;

/**
 * 最长连续序列
 * https://leetcode.com/problems/longest-consecutive-sequence/
 * 给定一个未排序的整数数组，找出最长连续序列的长度
 *
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4
 */
public class _128_LongestConsecutiveSequence extends Task {
    @Override
    public void run() {
        int[] datas = {100, 4, 200, 1, 3, 2, 5};
        println(longestConsecutive(datas));
    }

    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int curLength = 0, maxLength = 0;
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] == nums[i + 1] - 1) {
                curLength++;
            } else {
                if (curLength > maxLength) {
                    maxLength = curLength;
                }
                curLength = 1;
            }
        }
        return maxLength;
    }
}
