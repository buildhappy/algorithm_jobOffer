package com.buildhappy.swordOffer._044;

import java.util.Arrays;

/**
 * 面试题44：扑克牌的顺序
 * 题目大致为：
    从扑克牌中随机抽出5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2~10为数字本身，A为1，J为11，Q为12，K为13，而大、小王可以看成是任意数字。
思路：
    实则本题是判断一个数组是否是连续的，将大、小王看成是0，0可以充当任何的数。
    这样我的思路是：先对数组排序，排序后统计出0的个数，在计算非0数之间的缺少的数字个数的总和，
    若是在这个过程中发现前后两个的差为0则为相同的元素，则不符合题意；
    在满足题意的情况下，若是0的个数大于等于缺少的数字个数的总和，那么满足条件，否则不满足条件。
 * @author dell
 * 
 */
public class Item44 {
	public static void main(String args[]) {
		// 模拟随机抽牌，大小王为0，A为1，J为11，Q为12，K为13，其实就是个数组，判断数组是否是顺序的

		// 测试1：正好填补
		int array_1[] = { 0, 0, 1, 4, 5 };
		System.out.println(isContinuous(array_1));
		// 测试2：不能填补
		int array_2[] = { 0, 1, 4, 5, 6 };
		System.out.println(isContinuous(array_2));
		// 测试3：有相同元素
		int array_3[] = { 0, 1, 3, 3, 4, };
		System.out.println(isContinuous(array_3));
	}

	public static boolean isContinuous(int array[]) {
		// 由于数组的规模很小，则可以直接使用库函数完成
		// 作者有句话很重要：通常我们认为不同级别的时间复杂度只有当n足够大的时候才有意义
		Arrays.sort(array);

		int numOfZero = 0;// 统计0的个数
		int sumOfError = 0;
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] == 0) {
				numOfZero++;
			} else {// 非零的情况
					// 若有相同的元素
				if (array[i + 1] - array[i] == 0) {
					return false;
				} else {
					sumOfError += (array[i + 1] - array[i] - 1);
				}
			}
		}
		if (numOfZero >= sumOfError) {// 0能填补空缺
			return true;
		} else {
			return false;
		}
	}

}
