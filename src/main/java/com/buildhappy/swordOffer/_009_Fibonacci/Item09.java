package com.buildhappy.swordOffer._009_Fibonacci;

/**
 * 面试题9：斐波那契数列
 * 思路：
 *   用递归实现的过程中会出现重复计算的情况，
 *   此时，可以利用动态规划的思想，保存中间结果，这样可以避免不必要的计算。
 * 题目扩展：
 *   青蛙跳台阶(P76)；小矩形覆盖大矩形
 *   
 * @author dell
 * 
 */
public class Item09 {
	public static void main(String args[]) {
		int n = 30;
		System.out.println(fibonacci(n));
	}
	//非递归，保存中间结果，效率高
	public static int fibonacci(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			//由zero和one保存中间结果
			int fN_2 = 0;//fN_1
			int fN_1 = 1;
			int fN = 0;
			for (int i = 2; i <= n; i++) {
				fN = fN_1 + fN_2;
				fN_2 = fN_1;
				fN_1 = fN;
			}
			return fN;
		}
	}
	
	/**
	 * 递归的方式，时间复杂度超级大。
	 * @param n
	 * @return
	 */
	private static int fiboRecursion(int n) {
		if(0 == n){
			return 0;
		}
		else if(1 == n) {
			return 1;
		}else {
			return fiboRecursion(n-1)+fiboRecursion(n-2);
		}
	}
	
	/**
	 * 将中间结果存储。O(n)
	 * @param n
	 * @return
	 */
	private static int fiboTimeN(int n) {
		int[] fibArr = new int[n+1];
		fibArr[0]=0;
		fibArr[1]=1;
		for (int i = 2; i <= n; i++) {
			fibArr[i] = fibArr[i-1] + fibArr[i-2];
		}
		return fibArr[n];
	}
}
