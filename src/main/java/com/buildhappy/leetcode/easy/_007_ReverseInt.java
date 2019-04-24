package com.buildhappy.leetcode.easy;

import com.buildhappy.leetcode.Task;

/**
 * https://leetcode.com/problems/reverse-integer/submissions/
 * 整数反转
 * 关键是要处理好溢出的情况
 */
public class _007_ReverseInt extends Task {
    @Override
    public void run() {
        println(reverse(120));
        println(reverse(123));
        println(reverse(-123));
        println(reverse(-1563847412));
//        println(Integer.MAX_VALUE);
//        println(1534236469 * 2);
//        println(964632430 * 10);
    }

    public int reverse(int x) {
        int rest = 0;
        while (x != 0) {
            int mod = x % 10;
            int promote = rest * 10;
            if (rest > Integer.MAX_VALUE / 10 || (rest == Integer.MAX_VALUE / 10 && mod > 7)) {
                return 0;
            }
            if (rest < Integer.MIN_VALUE / 10 || (rest == Integer.MIN_VALUE / 10 && -mod < -8)) {
                return 0;
            }
            rest = promote + mod;
            x /= 10;
        }
        return rest;
    }
}
