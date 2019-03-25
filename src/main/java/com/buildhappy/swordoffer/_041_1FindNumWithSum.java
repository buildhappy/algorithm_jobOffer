package com.buildhappy.swordoffer;

/**
 * 面试题41：和为s的两个数字VS和为s的连续正数序列
 * 题目一大致为：
 *  输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得他们的和正好是s。
 * 思路：
 *  对于有序数组，用两个指针分别指向头和尾部，然后将他们的和与s比较，
 *  若等于s，退出；若<s，则头指针向后移；若>s，则尾指针向前移；直到两个指针相遇。
 *
 */
public class _041_1FindNumWithSum {
	public static void main(String args[]) {
		int array[] = { 1, 2, 4, 7, 11, 15 };
		int s = 15;
        //存储两个解
		int[] result = new int[2];
		boolean flag = findNumWithSum(array, result, s);

        // 存在这样的解，输出
		if (flag == true) {
			System.out.println("一组解为：" + result[0] + "、" + result[1]);
		} else {
			System.out.println("不存在");
		}

	}

	/**
	 * 和为s的两个数组
	 * @param array 原始数组
	 * @param result 结果数组
	 * @param s 和
	 * @return
	 */
	public static boolean findNumWithSum(int array[], int result[], int s) {
		int length = array.length;
		boolean flag = false;
		//条件检查，要保证能存储两个数
		if (length <= 0 || result.length != 2) {
			return flag;
		}

		// 两个指针
		int low = 0;
		int high = length - 1;

		while (low < high) {
			// 如果相等
			if (array[low] + array[high] == s) {
				// 记录下
				result[0] = array[low];
				result[1] = array[high];
                // 表示找到了
				flag = true;
				break;
			}
			// 如果>
			else if (array[low] + array[high] > s) {
				high--;// 减小
			}
			// 如果小于
			else {
				low++;// 增加
			}
		}
		return flag;
	}
}
