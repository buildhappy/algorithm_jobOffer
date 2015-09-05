package com.buildhappy.swordOffer._031_MaxSum;

/**
 * 面试题31：连续字数组的最大和
 * 题目大致为：
 *  输入一个整型数组，数组里有正数也有负数。数组中一个或者连续的多个整数组成一个子数组。
 *  求所有字数组的和的最大值。要求时间复杂度为O(n)。
 * 思路：
 *  因为时间复杂度为O(n)，则只能遍历一次数组，这里同时使用两个变量currentSum和finalGreatSum，
 *  其中currentSum保存的是当前的和，若currentSum<0，则从下一个位置从新记录，
 *  finalGreatSum记录的是历史的最小值，只有当currentSum>finalGreatSum时用currentSum替换finalGreatSum。
 * @author dell
 * 
 */
public class Item31 {
	public static void main(String args[]) {
		//测试
		int array[] = { 1, -2, 3, 10, -4, 7, 2, -5 };
		int result = findGreatSumOfSubArray(array);
		System.out.println("子数组的最大和为：" + result);
	}

	public static int findGreatSumOfSubArray(int array[]) {
		//用currentSum记录当前的和
		int currentSum = 0;
		//用finalGreatSum记录历史最佳
		int finalGreatSum = 0;

		for (int i = 0; i < array.length; i++) {
			currentSum += array[i];
			//如果currentSum>0则记录
			if (currentSum > 0) {
				//如果currentSum>finalGreatSum则替换finalGreatSum
				if (currentSum > finalGreatSum) {
					finalGreatSum = currentSum;
				}
			} else {
				currentSum = 0;
			}
		}
		return finalGreatSum;
	}

}
