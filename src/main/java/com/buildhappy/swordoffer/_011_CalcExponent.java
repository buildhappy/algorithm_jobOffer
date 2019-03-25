package com.buildhappy.swordoffer;


import static com.buildhappy.util.LogUtils.*;

/**
 * 计算base的exp次方
 *
 * @author Administrator
 */
public class _011_CalcExponent {
    private static byte one = 0X1;
    public static void main(String[] args) {
        //方法一：效率较低 ，但是考虑了base, exp特殊输入情况。
        println(calcExp(1.2, 2000));
        println((4 & one) == 1);
        println((3 & one) == 1);
    }


    private static double calcExp(double base, int exp) {
        if (base == 0) {
            return 1;
        }
        if (exp == 0) {
            return 1;
        } else if (exp > 0) {
            return calcExpPositive(base, exp);
//			return calcExpPositiveRecursion(base, exp);
        } else {
            exp = Math.abs(exp);
            return 1.0 / calcExpPositive(base, exp);
//			return 1.0/calcExpPositiveRecursion(base, exp);
        }
    }

    /**
     * 依次相乘
     *
     * @param base
     * @param exp
     * @return
     */
    private static double calcExpPositive(double base, int exp) {
        double result = 1.0;
        for (int i = 1; i <= exp; i++) {
            result *= base;
        }
        return result;
    }

    /**
     * 递归 求解，减少计算次数。
     *
     * @param base
     * @param exp
     * @return
     */
    private static double calcExpPositiveRecursion(double base, int exp) {
        if (exp == 0) {
            return 1;
        }

        if (exp == 1) {
            return base;
        }

        double result = calcExpPositiveRecursion(base, exp >> 1);
        result *= result;
        //基数
        if ((exp & one) == 1) {
            result = result * base;
        }
        return result;
    }
}
