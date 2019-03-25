package com.buildhappy.leedcode.medium;

import com.buildhappy.leedcode.Task;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/3sum-closest/
 * 给定一个包括n个整数的数组nums和一个目标值target.找出nums中的三个整,使得它们的和与target最接近
 * 返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 参考:https://blog.csdn.net/u013360073/article/details/81482002
 */
public class _016_3SumClosest extends Task {

    @Override
    public void run() {
        int[][] numsList = {{-1, 2, 1, -4}, {0, 0, 0, 1}};
        for (int[] nums : numsList) {
            int rest = threeSumClosest(nums, 1);
            println(Arrays.toString(nums) + " rest: \n" + rest);
            println();
        }
    }

    public int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        int closedSum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ++i) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int temSum = nums[i] + nums[j] + nums[k];
                int absDiff = Math.abs(temSum - target);
                if (absDiff < diff) {
                    diff = absDiff;
                    closedSum = temSum;
                }
                if (temSum < target) {
                    j++;
                } else if (temSum > target) {
                    k--;
                } else {
                    return closedSum;
                }
            }
        }
        return closedSum;
    }
}
