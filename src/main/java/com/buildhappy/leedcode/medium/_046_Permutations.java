package com.buildhappy.leedcode.medium;

import com.buildhappy.leedcode.Task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/permutations/
 * <p>
 * Given a collection of distinct integers, return all possible permutations.
 * Input: [1,2,3]
 * Output:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class _046_Permutations extends Task {
    @Override
    public void run() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> rest = permute(nums);
        println(rest);
    }

    /**
     * 方法一: 回溯方法的实现
     **/
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> rest = new ArrayList<>();
        List<Integer> curRest = new ArrayList<>();
        backtracking(rest, curRest, nums);
        return rest;
    }

    private void backtracking(List<List<Integer>> rest, List<Integer> curRest, int[] nums) {
        if (curRest.size() == nums.length) {
            rest.add(new ArrayList<>(curRest));
            return;
        }
        for (int num : nums) {
            // 已经选过的数不再选
            if (curRest.contains(num)) {
                continue;
            }
            // 选择当前节点
            curRest.add(num);
            backtracking(rest, curRest, nums);
            // 回溯到上一步,去掉当前节点(最终目的是为了清空curRest,因为满足条件的curRest已经放到rest中被记录下来)
            // 可以理解为逐层出栈删除对应的节点
            curRest.remove(curRest.size() - 1);
        }
    }

    /**
     * 方法二:思路跟剑指offer的28题一样，性能差
     **/
    public List<List<Integer>> permute_2(int[] nums) {
        List<List<Integer>> rest = new ArrayList<>();
        permute(rest, nums, 0);
        return rest;
    }

    private void permute(List<List<Integer>> rest, int[] nums, int index) {
        if (index == nums.length - 1) {
            List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
            rest.add(list);
        } else {
            for (int i = index; i < nums.length; ++i) {
                swap(nums, i, index);
                permute(rest, nums, index + 1);
                swap(nums, index, i);
            }
        }
    }

    private void swap(int[] nums, int from, int to) {
        int tmp = nums[from];
        nums[from] = nums[to];
        nums[to] = tmp;
    }
}
