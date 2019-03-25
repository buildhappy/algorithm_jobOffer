package com.buildhappy.swordoffer;

/**
 * 大数相加
 *
 * @author buildhappy
 */

public class _012_PrintNum {
    public static void main(String[] args) {
        int[] result = bigNumSum("999999999999999", "99999999999999999");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
        }
    }

    public static int[] bigNumSum(String num1, String num2) {
        String number1 = num1;
        String number2 = num2;
        char[] ch1 = number1.toCharArray();
        char[] ch2 = number2.toCharArray();
        int[] sum;
        int len = Math.abs(ch1.length - ch2.length);
        //为true时表示两数相加>=10
        int takeOver = 0;

        //如果两个数的长度相等
        if (ch1.length == ch2.length) {
            //相加结果的长度为任一长度+1，因为最高位相加可能>10
            sum = new int[ch1.length + 1];
            //从个位开始相加
            for (int i = ch1.length - 1; i >= 0; i--) {
                sum[i + 1] = (int) (ch1[i] - '0') + (int) (ch2[i] - '0') + takeOver;
                //处理两数相加是否>10
                takeOver = handleSumOverTen(sum, i, len);
            }
            //处理最高位
            handleTopDigit(takeOver, sum);
            return sum;
        } else if (ch1.length > ch2.length) {

            //结果的最大长度为数1的长度+1
            sum = new int[ch1.length + 1];

            for (int i = ch2.length - 1; i >= 0; i--) {
                sum[i + len + 1] = (int) (ch1[i + len] - '0') + (int) (ch2[i] - '0') + takeOver;
                takeOver = handleSumOverTen(sum, i, len);
            }
            //处理数1多出来的位数
            for (int i = ch1.length - ch2.length - 1; i >= 0; i--) {
                sum[i + 1] = (int) (ch1[i] - '0') + takeOver;
                takeOver = handleSumOverTen(sum, i, 0);
            }

            handleTopDigit(takeOver, sum);
            return sum;
        } else {
            sum = new int[ch2.length + 1];

            for (int i = ch1.length - 1; i >= 0; i--) {
                sum[i + len + 1] = (int) (ch1[i] - '0') + (int) (ch2[i + len] - '0') + takeOver;
                takeOver = handleSumOverTen(sum, i, len);
            }

            for (int i = ch2.length - ch1.length - 1; i >= 0; i--) {
                sum[i + 1] = (int) (ch2[i] - '0') + takeOver;
                takeOver = handleSumOverTen(sum, i, 0);
            }

            handleTopDigit(takeOver, sum);
            return sum;
        }
    }

    /**
     * 处理两数相加是否>10
     */
    public static int handleSumOverTen(int[] sum, int i, int len) {
        if (sum[i + len + 1] >= 10) {
            sum[i + len + 1] = sum[i + len + 1] - 10;
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * 处理最高位
     */
    public static void handleTopDigit(int takover, int[] sum) {
        if (takover == 1) {
            sum[0] = 1;
        } else {
            sum[0] = 0;
        }
    }

}
