package com.buildhappy.leedcode.easy;

import com.buildhappy.leedcode.Task;
import com.buildhappy.util.LogUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/k-diff-pairs-in-an-array/
 *
 * Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array.
 * Here a k-diff pair is defined as an integer pair (i, j),
 * where i and j are both numbers in the array and their absolute difference is k.
 * <p>
 * eg:
 * in:  3,1,4,1,5 k=2
 * out: 2
 * pair: (3,1),(3,5)
 */
public class _532_KDiffPairsInArray extends Task {
    public static void main(String[] args) {
        new _532_KDiffPairsInArray().run();
    }

    @Override
    public void run() {
        int[] data = {3, 1, 4, 1, 5};
        int k = 2;
        println(findPairs(data, k));
        println(findPairs2(data, k));

    }

    public static int findPairs(int[] data, int k) {
        Arrays.sort(data);
        int rest = 0;
        for (int i = 0, j = 0; i < data.length; ++i) {
            // 找到第一个与i差值大于k的j
            for (j = Math.max(j, i + 1); j < data.length && (data[j] - data[i]) < k; j++){}
            if (j < data.length && (data[j] - data[i]) == k) {
                rest++;
            }
            // 跳过重复数据
            while ((i + 1) < data.length && data[i + 1] == data[i]){
                i++;
            }
        }
        return rest;
    }

    /**
     * 借助辅助容器
     * @param data
     * @param k
     * @return
     */
    public static int findPairs2(int[] data, int k) {
        HashMap<Integer, Integer> counter = new HashMap<>(data.length);
        int rest = 0;
        for (int num : data) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry: counter.entrySet()) {
            if (k == 0 && entry.getValue() >= 2) {
                rest++;
            } else {
                if (counter.containsKey(entry.getKey() + k)) {
                    rest++;
                }
            }
        }
        return rest;
    }

}
