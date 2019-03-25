package com.buildhappy.leedcode.medium;

import com.buildhappy.leedcode.Task;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/subarray-sum-equals-k/submissions/
 * Given an array of integers and an integer k,
 * you need to find the total number of continuous subarrays whose sum equals to k.
 * eg.
 * in:1 1 1 k=2
 * out:2
 */
public class _561_ContinuousSubarraySumEqualsK extends Task {

    @Override
    public void run() {
        int[] data = {5, 4, 4, 5};
        int k = 9;
        println(subArraySum(data, k));
        println(subArraySum2(data, k));
    }

    /**
     * We know the key to solve this problem is SUM[i, j].
     * So if we know SUM[0, i - 1] and SUM[0, j], then we can easily get SUM[i, j].
     * To achieve this, we just need to go through the array,
     * calculate the current sum and save number of all seen PreSum to a HashMap.
     * Time complexity O(n), Space complexity O(n).
     */
    public int subArraySum(int[] nums, int k) {
        if (nums == null) {
            throw new IllegalArgumentException("");
        }
        int rest = 0, sum = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        for (int num : nums) {
            sum += num;
            rest += preSum.getOrDefault(sum - k, 0);
            // 最后+1目的是防止出现0的情况，出现0 sum不变
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return rest;
    }

    /**
     * 暴力搜索
     **/
    public int subArraySum2(int[] nums, int k) {
        int rest = 0;
        for (int i = 0; i < nums.length; ++i) {
            int sum = 0;
            for (int j = i; j < nums.length; ++j) {
                sum += nums[j];
                if (sum == k) {
                    rest++;
                }
            }
        }
        return rest;
    }

}







