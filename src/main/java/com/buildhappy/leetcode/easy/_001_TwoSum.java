package com.buildhappy.leetcode.easy;

import com.buildhappy.leetcode.Task;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 */
public class _001_TwoSum extends Task {
    @Override
    public void run() {
        int[] datas = {2, 7, 11, 15};
        int k = 9;
        println(Arrays.toString(twoSum(datas, k)));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int index = 0; index < nums.length; ++index) {
            Integer e = map.get(nums[index]);
            if (e != null) {
                return new int[]{e, index};
            }
            map.put(target - nums[index], index);
        }
        return null;
    }
}
