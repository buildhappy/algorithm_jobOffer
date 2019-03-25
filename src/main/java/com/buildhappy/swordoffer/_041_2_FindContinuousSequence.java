package com.buildhappy.swordoffer;

import java.util.LinkedList;
import java.util.List;

/**
 * 题目二：和为s的连续序列
 * P216
 * 输入一个正数s，打印出所有和为s的<连续>正数序列(至少含有两个不同的数字)
 * 思路：
 * s至少要为3，这样才能满足至少含有两个数，若s>3，这时可以查找low和high之间的和，
 * 若=s，则输出；若<s，则增加high，若>s，则增加low，这样就减少了他们之间的数，
 * 直到low<(1+s)/2；即小于中间值，因为两个中间值的和可能为s。
 */
public class _041_2_FindContinuousSequence {
    public static void main(String args[]) {
        System.out.println("打印序列：");
        System.out.println(findSequenceWithSum(19));
    }

    /**
     * 查找序列
     */
    public static List<List<Integer>> findSequenceWithSum(int s) {
        if (s < 3) {
            return null;
        }

        List<List<Integer>> result = new LinkedList<>();
        // 至少有两个，那么最小也得为3
        int high = 2;
        int low = 1;
        // 记录当前的和
        int currentSum = low + high;

        int end = (s + 1) >> 1;
        while (low < end) {
            if (currentSum == s) {
                saveSequence(result, low, high);
            }
            // 大于，要减小
            while (currentSum > s && low < end) {
                currentSum -= low;
                low++;
                if (currentSum == s) {
                    saveSequence(result, low, high);
                }
            }
            high++;
            currentSum += high;
        }
        return result;
    }

    public static void saveSequence(List<List<Integer>> result, int low, int high) {
        // 只有一个数或者high<low
        if (high - low <= 0) {
            System.out.println("不存在");
            return;
        }
        List<Integer> current = new LinkedList<>();
        for (int i = low; i <= high; i++) {
            current.add(i);
        }
        result.add(current);
    }
}
