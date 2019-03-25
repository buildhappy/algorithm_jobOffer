package com.buildhappy.leedcode.medium;

import com.buildhappy.leedcode.Task;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/permutation-in-string/
 * 判断s1是不是s2的一个子组合
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1.
 * In other words, one of the first string's permutations is the substring of the second string.
 */
public class _567_PermutationInString extends Task {

    @Override
    public void run() {
        String s1 = "abc", s2 = "eidbacooo";
        int[] window = new int[26];
        println(Arrays.toString(window));
        println(checkInclusion(s1, s2));
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] window = new int[26];
        int windowSize = s1.length();
        for (int i = 0; i < s1.length(); ++i) {
            window[s1.charAt(i) - 'a']++;
            window[s2.charAt(i) - 'a']--;
        }
        if (allZero(window)) {
            return true;
        }

        // 这一段逻辑如果忘记举个例子模拟走一下
        for (int i = s1.length(); i < s2.length(); ++i) {
            window[s2.charAt(i) - 'a']--;
            // 把之前窗口外的数据复原
            window[s2.charAt(i - windowSize) - 'a']++;
            if (allZero(window)) {
               return true;
            }
        }
        return false;
    }

    private boolean allZero(int[] window) {
        for (int i: window) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
