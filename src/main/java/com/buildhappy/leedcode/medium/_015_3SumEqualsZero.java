package com.buildhappy.leedcode.medium;

import com.buildhappy.leedcode.Task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/3sum/
 * 给定一个包含n个整数的数组nums，判断nums中是否存在三个元素a,b,c, 使得 a+b+c=0,找出所有不重复的三元组
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]
 * 结果: [[-1, 0, 1], [-1, -1, 2]]
 *
 * 思路:先进行排序，第一次循环遍历所有负数和零，第二层遍历找使用双指针找到两数之和等于第一个数的绝对值
 *     注意返回数组不能重复，所以遇到相同的数跳过
 * 参考:https://www.jianshu.com/p/69b0a1170f96
 */
public class _015_3SumEqualsZero extends Task {
    @Override
    public void run() {
        int[][] numsList = {{-1, 0, 1, 2, -1, -4}, {0, 0, 0}};
        for (int[] nums : numsList) {
            List<List<Integer>> rest = threeSum(nums);
            println(Arrays.toString(nums) + " rest: \n" + rest);
            println();
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rest = new ArrayList<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length && nums[i] <= 0; ++i) {
            // 防止第一个数字出现重复
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            int sum = -nums[i];
            while (j < k) {
                int tmpSum = nums[j] + nums[k];
                if (tmpSum == sum) {
                    List<Integer> cur = new ArrayList<>();
                    cur.add(nums[i]);
                    cur.add(nums[j]);
                    cur.add(nums[k]);
                    rest.add(cur);
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    j++;
                    k--;
                } else if (tmpSum > sum) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return rest;
    }
}
