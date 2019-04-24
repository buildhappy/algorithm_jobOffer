package com.buildhappy.leetcode.medium;

import com.buildhappy.leetcode.Task;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/group-anagrams/solution/
 * Given an array of strings, group anagrams(字谜) together.
 * eg:
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 */
public class _049_GroupPermutation extends Task {
    @Override
    public void run() {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        println(groupAnagrams(strs));
    }

    /**
     * 该思路跟567题的思路很像
     * 使用一个计数器来统计每个字母的出现的次数,如果两个字符串属于相同的排列组合那么他们的计数器应该是一样的
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] count = new int[26];
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            Arrays.fill(count, 0);
            char[] chs = str.toCharArray();
            for (char c : chs) {
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            List<String> tmp = map.getOrDefault(key, new LinkedList<>());
            tmp.add(str);
            map.put(key, tmp);
        }
        return new LinkedList<>(map.values());
    }
}
