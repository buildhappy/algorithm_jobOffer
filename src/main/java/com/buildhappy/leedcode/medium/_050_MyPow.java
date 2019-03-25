package com.buildhappy.leedcode.medium;

import com.buildhappy.leedcode.Task;

/**
 * Implement pow(x, n), which calculates x raised to the power n (x^n).
 */
public class _050_MyPow extends Task {
    @Override
    public void run() {
        double x = 2.00000;
        int n = 10;
        println(myPow(x, n));
    }

    public double myPow(double x, int n) {
        if(n == 1) {
            return x;
        }
        if(n == -1) {
            return 1 / x;
        }
        if(n == 0) {
            return 1.0;
        }
        double half = myPow(x, n / 2);
        return half * half * myPow(x, n % 2);
    }
}
