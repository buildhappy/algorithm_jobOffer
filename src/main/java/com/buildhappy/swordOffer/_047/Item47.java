package com.buildhappy.swordOffer._047;

/**
 * 面试题47：不用加减乘除做加法
 * 题目大致为：
写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
思路：
使用位运算。分三步：第一、不考虑进位，用异或模拟加法；第二、用与运算并左移一位模拟进位；第三、重复前面两步。
 * @author dell
 * 
 */
public class Item47 {

	public static void main(String args[]) {
		int a = 1;
		int b = 2;
		System.out.println(add(a, b));
	}

	public static int add(int num1, int num2) {
		int sum = 0;
		int carry = 0;
		do {
			sum = num1 ^ num2;// 第一步，异或
			carry = (num1 & num2) << 1;// 第二步，进位
			// 第三步，相加
			num1 = sum;
			num2 = carry;
		} while (num2 != 0);

		return num1;
	}
}
