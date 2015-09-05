package com.buildhappy.swordOffer._041;

/**
 * 题目二：和为s的连续序列
 * 输入一个正数s，打印出所有和为s的连续正数序列(至少含有两个数)。
思路：
   s至少要为3，这样才能满足至少含有两个数，若s>3，这时可以查找low和high之间的和，
   若=s，则输出；若<s，则增加high，若>s，则增加low，这样就减少了他们之间的数，
   直到low<(1+s)/2；即小于中间值，因为两个中间值的和可能为s。
 * @author dell
 * 
 */
public class Item41_2 {
	public static void main(String args[]) {
		System.out.println("打印序列：");
		findSquenceWithSum(15);
	}

	/**
	 * 查找序列
	 * 
	 * @param s和
	 */
	public static void findSquenceWithSum(int s) {
		if (s < 3) {
			System.out.println("不存在");
			return;
		}
		int high = 2;// 至少有两个，那么最小也得为3
		int low = 1;
		int currentSum = low + high;// 记录当前的和

		int end = (1 + s) >> 1;
		while(low < end) {
			// 若==s，则返回
			if (currentSum == s)
				printSquence(low, high);
			// 大于，要减小
			while (currentSum > s && low < end) {
				currentSum -= low;
				low++;
				if (currentSum == s)
					printSquence(low, high);
			}
			high++;
			currentSum += high;
		}
	}

	/**
	 * 打印函数
	 * 
	 * @param low下界
	 * @param high上界
	 */
	public static void printSquence(int low, int high) {
		// 判断是否符合要求
		if (high - low <= 0) {// 只有一个数或者high<low
			System.out.println("不存在");
			return;
		}
		for (int i = low; i <= high; i++) {
			System.out.print(i + "、");
		}
		System.out.println();// 换行
	}
}
