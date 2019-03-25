package com.buildhappy.leedcode.medium;

import com.buildhappy.leedcode.Task;

import java.util.*;

/**
 * https://leetcode.com/problems/simplify-path/
 * 简化Linux的路径
 */
public class _071_SimplifyPath extends Task {
    @Override
    public void run() {
        println(simplifyPath("/home//foo/"));
    }

    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..",".",""));
        for (String dir: path.split("/")) {
            if (dir.equals("..") && !stack.isEmpty()) {
                stack.pop();
            } else if (!skip.contains(dir)) {
                stack.push(dir);
            }
        }
        String rest = "";
        for (String dir: stack) {
            rest = "/" + dir + rest;
        }
        return stack.isEmpty() ? "/" : rest;
    }
}
