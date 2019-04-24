package com.buildhappy.leetcode.medium;

import com.buildhappy.leetcode.Task;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/triangle/
 * 三角形的最短路径
 */
public class _120_TrianglePath extends Task {
    @Override
    public void run() {
        List<List<Integer>> triangle = new LinkedList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        println(minimumTotal(triangle));
    }

    /**
     * p[i][j] = p[i][j] + min(p[i - 1][j], p[i - 1][j - 1])
     **/
    public int minimumTotal(List<List<Integer>> triangle) {

        for (int i = 1; i < triangle.size(); ++i) {

            List<Integer> preLevel = triangle.get(i - 1);
            List<Integer> curLevel = triangle.get(i);
            for (int j = 0; j < curLevel.size(); ++j) {
                int preMinValue = Integer.MAX_VALUE;
                if (j >= 0 && j < preLevel.size()) {
                    preMinValue = preLevel.get(j);
                }
                if (j - 1 >= 0 && j - 1 < preLevel.size()) {
                    preMinValue = Math.min(preMinValue, preLevel.get(j - 1));
                }
                curLevel.set(j, preMinValue + curLevel.get(j));
            }
        }
//        for (List<Integer> level : triangle) {
//            println(level);
//        }
        return triangle.get(triangle.size() - 1).stream().min(Integer::compareTo).get();
    }
}
