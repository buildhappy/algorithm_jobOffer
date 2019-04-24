package com.buildhappy.leetcode.medium;

import com.buildhappy.leetcode.Task;

/**
 * https://leetcode.com/problems/multiply-strings/
 * 字符串相乘
 * Note: The numbers can be arbitrarily large and are non-negative.
 * 参考思路: http://www.cnblogs.com/grandyang/p/4395356.html
 */
public class _043_MultiplyStrings extends Task {
    @Override
    public void run() {
        String num1 = "0", num2 = "0";
        println(multiply(num1, num2));
    }

    /**
     * 整个计算过程几个核心点
     * 1. 声明一个新的数组保存两个数组对应位相乘的结果，不考虑进位
     * 2. 注意原始字符串的最高位在index=0的位置，bitSum保存的结果最高位n1 + n2 - 2的位置
     * 3. 第一个数组第i为和第二个数组的第j位相乘,结果保存在新数组的位置为(n1 + n2 - 2 - i - j)
     * 4. 最后打印数组时要把最高位的0去掉
     */
    public String multiply(String num1, String num2) {
        int n1 = num1.length(), n2 = num2.length();
        // 最高位
        int place = n1 + n2 - 2;
        // 每一位相乘的临时结果,长度必须是n1+n2(n1+n2-1位数不够,因为进位时会溢出)
        int[] bitSum = new int[n1 + n2];
        for (int i = 0; i < n1; ++i) {
            for (int j = 0; j < n2; ++j) {
                // 第i位和第j位相乘的结果，应该保存在新数组的位置为：place-i-j
                // 这个映射关系记住吧，没搞清楚怎么回事
                bitSum[place - i - j] += ((num1.charAt(i) - '0') * (num2.charAt(j) - '0'));
            }
        }

        int carry = 0;
        for (int i = 0; i < n1 + n2; ++i) {
            bitSum[i] += carry;
            carry = bitSum[i] / 10;
            bitSum[i] %= 10;
        }

        // 最高位的index
        int i = n1 + n2 - 1;
        while (i >= 0 && bitSum[i] == 0) {
            i--;
        }
        if (i < 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (i >= 0) {
            sb.append(bitSum[i--]);
        }
        return sb.toString();
    }
}
