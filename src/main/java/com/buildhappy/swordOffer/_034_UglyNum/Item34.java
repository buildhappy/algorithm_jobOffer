package com.buildhappy.swordOffer._034_UglyNum;

/**
 * 面试题34：丑数
 * 题目大致为：
    丑数的定义为：只包含因子2,3和5的数。求按从小到大的顺序的第1500个丑数。约定：1当做第一个丑数。
 * 思路：
 *  设置三个指针分别代表该位置*2，*3和*5，并将这三个数中的最小值插入数组中，若当前位置的值*对应的因子<=刚插入的值，
 *  便将该指针后移，直到新的位置上的值*对应的因子>刚插入的值。
 * @author dell
 * 
 */
public class Item34 {
	public static void main(String args[]) {
		int index = 15;
		System.out.println("第" + index + "个丑数为：" + getUglyNum(index));
	}

	/**
	 * 根据index计算丑数
	 * 
	 * @param index丑数的下标
	 * @return丑数
	 */
	public static int getUglyNum(int index) {
		// 检查index
		if (index <= 0) {
			return 0;
		}
		// 为了便于存储，可以建立数组保存中间结果
		int tmp[] = new int[index];
		// 保存第一个
		tmp[0] = 1;
		// 记录三组数的位置
		int multi2 = 0;
		int multi3 = 0;
		int multi5 = 0;

		int nextUglyNum = 1;
		while (nextUglyNum < index) {
			int min = findMin(tmp[multi2] * 2, tmp[multi3] * 3, tmp[multi5] * 5);
			tmp[nextUglyNum] = min;

			// 重新计算multi2,multi3,multi5
			while (tmp[multi2] * 2 <= min) {
				multi2++;
			}
			while (tmp[multi3] * 3 <= min) {
				multi3++;
			}
			while (tmp[multi5] * 5 <= min) {
				multi5++;
			}
			nextUglyNum++;
			System.out.println(min);
		}
		return tmp[index - 1];
	}

	/**
	 * 计算三个数的最小值
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public static int findMin(int a, int b, int c) {
		int minTmp = (a < b ? a : b);
		return (minTmp < c ? minTmp : c);
	}
}
