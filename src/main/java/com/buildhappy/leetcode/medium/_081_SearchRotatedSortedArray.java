package com.buildhappy.leetcode.medium;

import com.buildhappy.leetcode.Task;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 * 使用二分查找，判断旋转数组中是否包某个数字
 * <p/>
 * 思路:
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/discuss/177150/Search-in-Rotated-Sorted-Array-I-python-code
 */
public class _081_SearchRotatedSortedArray extends Task {
    @Override
    public void run() {
        int[] data = {2, 5, 6, 0, 0, 1, 2};
        int target = 0;

        data = new int[]{2,5,6,0,0,1,2};
        target = 3;

        println(search(data, target));
    }

    public boolean search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            while (low < high && nums[low] == nums[high]) {
                low++;
            }
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return true;
            }
            // 落在高区
            if (nums[mid] >= nums[low]) {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid] <= nums[high]) {
                // 低区
                if (target >= nums[mid] && target < nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }

}
