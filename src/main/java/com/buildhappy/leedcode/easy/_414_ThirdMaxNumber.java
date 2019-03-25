package com.buildhappy.leedcode.easy;

import com.buildhappy.leedcode.Task;

/**
 * https://leetcode.com/problems/third-maximum-number/
 * Given a non-empty array of integers, return the third maximum number in this array.
 * If it does not exist, return the maximum number. The time complexity must be in O(n).
 */
public class _414_ThirdMaxNumber extends Task {
    @Override
    public void run() {
        super.run();
        int[] nums = {2,2,3,1};
        println(thirdMax(nums));
    }

    public int thirdMax(int[] nums) {
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE, third = Integer.MIN_VALUE;

        for (int num : nums) {
            // 先跟最大的比
            if (num < third) {
                continue;
            }
            if (num >= second) {
                if (num > first) {
                    third = second;
                    second = first;
                    first = num;
                } else {
                    third = second;
                    second = num;
                }
            } else {
                third = num;
            }
            println(first + "," + second + "," + third);
        }
        if (nums.length < 3) {
            return first;
        }
        return third;
    }
}
