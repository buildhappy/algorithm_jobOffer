package com.buildhappy.leedcode.medium;

import com.buildhappy.leedcode.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/
 * 给一个数n,求出所有的括号组合
 * For example, given n = 3, a solution set is:
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class _022_GenerateParentheses extends Task {

    @Override
    public void run() {
        int n = 3;
        println("Num: " + n + "s all possible result: \n" + generateParenthesis(n));
    }

    public List<String> generateParenthesis(int n) {
        List<String> rest = new ArrayList<>();
        track(rest, "", 0, 0, n);
        return rest;
    }

    private void track(List<String> rest, String cur, int left, int right, int max) {
        if (cur.length() == 2 * max) {
            rest.add(cur);
            return;
        }

        if (left < max) {
            track(rest, cur + "(", left + 1, right, max);
        }
        // 注意right < left
        if (right < left) {
            track(rest, cur + ")", left, right + 1, max);
        }
    }
}
