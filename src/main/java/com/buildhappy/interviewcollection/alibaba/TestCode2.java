package com.buildhappy.interviewcollection.alibaba;

import java.util.Arrays;

/**
 * 实现函数,给定一个字符串数组,求该数组的连续非空子集，分別打印出来各子集 ，举例数组为[abc]，输出[a],[b],[c],[ab],[bc],[abc]
 */
public class TestCode2 {
    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'c'};
        solution(chars);
    }


    public static void solution(char[] chars) {
        if (chars == null) {
            return;
        }
        for (int i = 0; i < chars.length; ++i) {
            for (int j = i; j < chars.length; ++j) {
                System.out.println(Arrays.copyOfRange(chars, i, j + 1));
            }
        }

    }
}
