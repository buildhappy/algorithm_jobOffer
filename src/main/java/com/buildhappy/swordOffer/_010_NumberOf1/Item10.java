package com.buildhappy.swordOffer._010_NumberOf1;

/**
 * 面试题10：实现一个函数，输入一个整数，输出该数二进制表示中1的个数。
 * 思路：
    把一个整数减去1，再和原整数做与运算，会把最右边一个1变成0，
    那么一个整数的二进制表示中有多少个1，就可以进行多少次这样的操作。
 * @author dell
 * 
 */
public class Item10 {
	public static void main(String args[]) {
		int n = -121;
		String byts = Integer.toBinaryString(n);
		System.out.println(byts);
		System.out.println(n + "的二进制表示中1的个数为：" + numberOf1(n));
		System.out.println("右移的统计结果：" + numberOf1MoveRight(n));
		System.out.println("左移的统计结果：" + numberOf1MoveLeft(n));
	}
	/**
	 * 利用了与的操作(高效的算法)
	 * 每次经过 n=n&(n-1) ，1的个数少一个；最后为0
	 * 注意：对于负数，包含了负号1 的个数
	 * @param n
	 * @return
	 */
	public static int numberOf1(int n) {
		int count = 0;
		while(n != 0) {
			//if((n & 0X1) == 1) count++;
			count++;
			n = (n - 1) & n;
			//System.out.println(Integer.toBinaryString(n));
		}
		return count;
	}
	

	/**
	 * 方法二：左移标志数字flag
	 * 用于负数和正数
	 * @param testNum
	 * @return
	 */
	private static int numberOf1MoveLeft(int testNum) {
		//System.out.println("测试数据二进制：" + Integer.toBinaryString(testNum));
		int cnt = 0, flag = 1;
		while (flag >= 0) {//32位的整数要循环32次
			if ((testNum & flag) > 0) {
				cnt++;
			}
			flag = flag << 1;
		}
		if(testNum < 0) cnt++;
		return cnt;
	}
	
	/**
	 * 方法一：右移testNum
	 * 仅适用于正数
	 * @param testNum
	 * @return
	 */
	private static int numberOf1MoveRight(int testNum) {
		int cnt=0;
		while (testNum>0) {
			if ((testNum&1) == 1) {
				cnt++;
			}
			testNum = testNum >> 1;
		}
		return cnt;
	}

}
