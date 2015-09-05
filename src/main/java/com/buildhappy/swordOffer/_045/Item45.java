package com.buildhappy.swordOffer._045;

/**
 * 面试题45：圆圈中最后剩下的数字
 * 题目大致为：
    0，1，...，n-1这n个数字排成一个圆圈，从数字0开始每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
思路：
    第一种办法就是通过环形链表模拟这样的删除过程；但是作者推导出了这样的关系式，具体关系式可以见书P231。
 * @author dell
 * 
 */
public class Item45 {
	public static void main(String args[]) {
		System.out.println(lastRemaining(5, 3));
	}

	/**
	 * 比较巧妙的办法是推导出一个推导公式
	 * 
	 * @param n：n个数字
	 * @param m：删除第m个数字
	 * @return
	 */
	public static int lastRemaining(int n, int m) {
		if (n < 1 || m < 1) {
			return -1;
		}

		int last = 0;
		for (int i = 2; i <= n; i++) {
			last = (last + m) % i;
		}
		return last;
	}

}
