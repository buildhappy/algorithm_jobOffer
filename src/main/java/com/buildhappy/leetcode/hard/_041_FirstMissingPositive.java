package com.buildhappy.leetcode.hard;

import com.buildhappy.leetcode.Task;

/**
 * https://leetcode.com/problems/first-missing-positive/
 * Given an unsorted integer array, find the smallest missing positive integer.
 */
public class _041_FirstMissingPositive extends Task {
    @Override
    public void run() {
        int[] nums = {2, 2};
        println(firstMissingPositive(nums));
    }

    public int firstMissingPositive(int[] data) {
        int n = data.length;
        int i = 0;
        while (i < n) {
            //合法
            if (data[i] == i + 1) {
                i++;
            } else if (data[i] > n || data[i] <= i || data[data[i] - 1] == data[i]) {
                data[i] = data[--n];
            } else {
                //合法，但不在合适位置
                swap(data, i, data[i] - 1);
            }
        }
        return i + 1;
    }

    public void swap(int[] data, int a, int b) {
        int x = data[a];
        data[a] = data[b];
        data[b] = x;
    }
}
