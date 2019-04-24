package com.buildhappy.leetcode.medium;

import com.buildhappy.leetcode.Task;

import java.util.Arrays;

/**
 * 最长递增子序列(Longest Increasing Subsequence,LIS)
 * 注意与674题,最长的<连续>递增子序列的比较
 * https://leetcode.com/problems/longest-increasing-subsequence/
 * <p>
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * <p>
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 */
public class _300_LongestIncreaseSubsequence extends Task {

    @Override
    public void run() {
        int[] nums = {9, 10, 2, 5, 6, 3, 4};
        println(lengthOfLIS(nums));
//        println(binarySearch(new int[]{4, 5, 6}, 3, 3));
//        println(binarySearch(new int[]{2, 5}, 3, 2));
    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }

        int[] tmp = new int[nums.length];
        int result = 1;
        tmp[0] = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            // 跟tmp的最后一个元素比较,如果超过的话说明是在原来基础上加的
            if (nums[i] <= tmp[result - 1]) {
                int index = binarySearch(tmp, nums[i], result);
                if (index >= 0) {
                    tmp[index] = nums[i];
                } else {
                    tmp[-(index + 1)] = nums[i];
                }
            } else {
                tmp[result++] = nums[i];
            }
        }
        println(Arrays.toString(tmp));
        return result;
    }


    /**
     * 等价于：Arrays.binarySearch(a, 0, size, key);
     */
    private int binarySearch(int[] a, int key, int size) {
        int low = 0;
        int high = size - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];

            if (midVal == key) {
                return mid;
            }
            // 三个判断很重要
            if (midVal < key) {
                low = mid + 1;
            } else if (midVal > key) {
                high = mid - 1;
            }
        }
        // key not found.
        return -(low + 1);
    }

}
