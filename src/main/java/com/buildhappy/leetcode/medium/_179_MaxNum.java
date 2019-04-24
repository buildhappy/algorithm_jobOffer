package com.buildhappy.leetcode.medium;

import com.buildhappy.leetcode.Task;

import java.util.Arrays;

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class _179_MaxNum extends Task {
    @Override
    public void run() {
        int[] num = {3, 30, 34, 5, 9};
        println(largestSum(num));
    }

    public String largestSum(int[] num) {
        if (num == null) {
            return null;
        }
        String[] str = Arrays.stream(num).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(str, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        return Arrays.stream(str).reduce((s1, s2) -> s1.equals("0") ? s2 : s1 + s2).get();
    }
}
