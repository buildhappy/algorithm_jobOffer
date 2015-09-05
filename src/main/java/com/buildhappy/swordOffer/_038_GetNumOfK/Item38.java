package com.buildhappy.swordOffer._038_GetNumOfK;

/**
 * 面试题38：数字在排序数组中出现的次数
 * 题目大致为：
 *  统计一个数字在排序数组中出现的次数。
 * 思路：
 *  由于是排序数组，要查找其中的一个数字，最简便的方法便是折半查找，
 *  这样我们可以先查找最先出现的位置和最后出现的位置，数出中间的个数便为总共的出现次数。
 * @author dell
 * 
 */
public class Item38 {
	public static void main(String args[]) {
		// 测试
		int array[] = { 1, 2, 3, 3, 3, 3, 4, 5 };
		int k = 3;// 待查找的数
		System.out.println(k + "的个数为：" + getNumOfK(array, k));
	}

	/**
	 * 通过计算初始位置和结束位置，计算出所有的个数
	 * 
	 * @param array
	 * @param k
	 * @return
	 */
	public static int getNumOfK(int array[], int k) {
		int num = 0;
		if (array != null) {
			int index_start = getFirstK(array, k, 0, array.length - 1);// 初始位置
			int index_end = getLastK(array, k, 0, array.length - 1);// 结束位置

			if (index_start > -1 && index_end > -1) {
				num = index_end - index_start + 1;
			}
		}
		return num;
	}

	/**
	 * 查找k在数组中的最先出现的位置
	 * 
	 * @param array初始数组
	 * @param k待查找的值
	 * @return
	 */
	public static int getFirstK(int array[], int k, int low, int high) {
		//判断low和high
		if (low > high) {
			return -1;
		}
		//折半查找的思想，找中间位置
		int middle = (low + high) / 2;

		//查找是否为k
		if (array[middle] == k) {//查找的值是为k，剩下的是判断是否是第一个k
			// 是第一个
			if ((middle > 0 && array[middle - 1] != k) || middle == 0) {
				return middle;
			}
			//不是第一个
			else {
				high = middle - 1;
			}
		} else if (array[middle] > k) {//在左侧
			high = middle - 1;
		} else {//在右侧
			low = middle + 1;
		}

		return getFirstK(array, k, low, high);
	}

	/**
	 * 类似getFirstK，查找最后一个为K
	 * 
	 * @param array
	 * @param k
	 * @return
	 */
	public static int getLastK(int array[], int k, int low, int high) {
		//判断low和high
		if (low > high) {
			return -1;
		}
		int middle = (low + high) / 2;

		//查找是否为k
		if (array[middle] == k) {// 查找的值是为k，剩下的是判断是否是最后一个k
			//是最后一个
			if ((middle > 0 && array[middle + 1] != k)
					|| middle == array.length - 1) {
				return middle;
			}
			//不是最后一个
			else {
				low = middle + 1;
			}
		} else if (array[middle] > k) {// 在左侧
			high = middle - 1;
		} else {//在右侧
			low = middle + 1;
		}

		return getLastK(array, k, low, high);
	}

}
