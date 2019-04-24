package com.buildhappy.leetcode.medium;

import com.buildhappy.leetcode.Task;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class _003_LongestSubstrWithNoRepeateChar extends Task {
    @Override
    public void run() {
        String s = "pwwkew";
        println(lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int rest = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))){
                // 扩大窗口[i, j]，将j右移
                set.add(s.charAt(j++));
                rest = Math.max(rest, j - i);
            } else {
                // 发现重复元素,缩小窗口[i, j]，将i右移
                set.remove(s.charAt(i++));
            }
        }
        return rest;
    }
}
