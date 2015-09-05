package com.buildhappy.swordOffer._011_CalcExponent;

/**
 * 面试题11：数值的整数次方
 * 实现函数double power(double base, int exponent)，求base的exponent次方。
 * 不得使用库函数，同时不需要考虑大数问题。
 * 思路：
    可以考虑对指数折半，这样只需要计算一半的值，若指数是奇数，则-1再折半，否则直接折半。
 * @author dell
 * 
 */
public class Item11 {
	public static void main(String args[]) {
		int base = 2;
		int exponent_1 = 9;
		int exponent_2 = 10;
		System.out.println("当exponent为奇数：" + power(base, exponent_1));
		System.out.println("当exponent为偶数：" + power(base, exponent_2));
	}

	/**
	 * 整数次方
	 * @param base底
	 * @param exponent指数
	 * @return
	 */
	public static double power(double base, int exponent) {
		if (exponent == 0) {
			return 1;
		}

		if (exponent == 1) {
			return base;
		}
		//底数为0，且指数小于0
		if(Math.abs(base - 0.0) < 0.00001 && exponent < 0){
			return 0;
		}
		if (exponent >> 1 == 0) {// 偶数
			int exponent_1 = exponent >> 1;
			double tmp = power(base, exponent_1);
			return tmp * tmp;
		} else {// 非偶数
			int exponent_2 = exponent - 1;// -1后就是偶数
			double tmp = power(base, exponent_2);
			return tmp * base;// 最后还有先开始减掉的一个base
		}
	}
}
