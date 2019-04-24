package com.buildhappy.leetcode.medium;

import com.buildhappy.leetcode.Task;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * TODO 未完成
 */
public class _033_TODOSearchInRotatedSortedArray extends Task {

    @Override
    public void run() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        search(nums, target);
    }

    public int search(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }

        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) >> 1;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[low] > nums[mid]) {
                if (nums[mid] > target) {
//                    mid =
                }
            } else {

            }

        }
        return -1;
    }
}
