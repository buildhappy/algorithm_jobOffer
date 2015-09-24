package com.buildhappy.swordOffer._008_MinNumberInRotatedArray;

/**
 * 找出数组中没有出现的最小的正整数，要求数组基本有序
 */
public class MinNumber {

	public static void main(String[] args) {
		int[] numArr = {3,4,5,6,7,9,23,54,1,2};
//		int[] numArr = {1,1,0,1,1,1,1};
//		int[] numArr = {1};
//		int[] numArr = {};

		int minIndex = selectMin(numArr);
		
		System.out.println(minIndex);

//		printNum(numArr);
	}

	private static void printNum(int[] numArr) {
		for (int i : numArr) {
			System.out.println(i);
		}
	}

	/**
	 * 思路：两个指针向中间靠近，相邻时结束。
	 * @param numArr
	 * @return
	 */
	private static int selectMin(int[] numArr) {
		int low = 0, high = numArr.length-1;
		//三种情况：
		if(numArr.length > 1){
			while (low != high-1) {  //终止条件：两个索引(指针)相邻
				int midIndex = (low+high)/2;
				//****特殊情况：三个索引指向的数字相同:遍历所有数字****
				if(numArr[midIndex] == numArr[low] && numArr[midIndex] == numArr[high]){
					System.out.println("mid");
					return selectInOrder(numArr);
				}
				//移动两个指针
				if(numArr[midIndex] >= numArr[low]){
					low = midIndex;
				}else if(numArr[midIndex] <= numArr[high]){
					high = midIndex;
				}
			}
		}
		else if(numArr.length == 0){  // 无数据返回-1
			high = -1;
		}

		return high;
	}

	/**
	 * 特殊情况： numArr = {1,1,1,0,1,1,1,1}
	 * @param numArr
	 * @return
	 */
	private static int selectInOrder(int[] numArr) {
		int minIndex = numArr[0];

		for (int i = 0; i < numArr.length; i++) {
			if (numArr[i] < numArr[minIndex]) {
				minIndex = i;
			}		
		}
		return minIndex;
	}
	
}
