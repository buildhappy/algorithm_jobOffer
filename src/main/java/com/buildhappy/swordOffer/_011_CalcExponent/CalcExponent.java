package com.buildhappy.swordOffer._011_CalcExponent;

import java.util.Date;

import javax.xml.crypto.Data;

/**
 * 计算base的exp次方
 * @author Administrator
 *
 */
public class CalcExponent {

	public static void main(String[] args) {
		//方法一：效率较低 ，但是考虑了base, exp特殊输入情况。
		//System.out.println(calcExp(1.2, 2000));
		System.out.println((4 & 0X1) == 1);
		//方法二：利用递归
	}

	
	private static double calcExp(double base, int exp) {
		if(base == 0){
			return 1;
		}
		if(exp == 0){
			return 1;
		}else if (exp > 0){
			return calcExpPositive(base, exp);
//			return calcExpPositiveRecursion(base, exp);
		}else {
			exp = Math.abs(exp);
			return 1.0/calcExpPositive(base, exp);
//			return 1.0/calcExpPositiveRecursion(base, exp);
		}
	}
 
	/**
	 * 依次相乘
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
	 * @param base
	 * @param exp
	 * @return
	 */
	private static double calcExpPositiveRecursion(double base, int exp) {
		if(exp == 0){
			return 1;
		}else if (exp == 1) {
			return base;
		}
		double result = calcExpPositiveRecursion(base, exp >> 1);
		result *= result;
		if((exp & 0X1) == 1){  //基数
			result = result * base;
		}
		return result;
	}
}
