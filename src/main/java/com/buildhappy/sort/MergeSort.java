package com.buildhappy.sort;

import java.util.Arrays;

/**
 * 归并排序
 * @author buildhappy
 *
 */
public class MergeSort {
	
	public static void main(String[] args) {
		int[] a = {2,4,3,7,8,1};
		int[] c = mergeSort(a);
		
		for(int i : c){
			System.out.print(i + ",");
		}
	}
	
	public static int[] mergeSort(int[] nums){
		if(null == nums)
			return null;
		
		if(nums.length < 2)
			return nums;
		
		int middle = nums.length >> 1;
		int[] left = Arrays.copyOfRange(nums , 0 , middle);
		int[] right = Arrays.copyOfRange(nums, middle, nums.length);
		int[] sortedLeft = mergeSort(left);
		int[] sortedRight = mergeSort(right);
		return merge(sortedLeft , sortedRight);
	}
	//将两个有序数组合并
	public static int[] merge(int[] a , int[] b){
		if(null == a || null == b){
			try {
				throw new Exception("array is null");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		int aLength = a.length , bLength = b.length;
		int[] c = new int[aLength + bLength];
		int aP = 0, bP = 0 , cP = 0;
		while(aP < aLength && bP < bLength){
			if(a[aP] > b[bP])
				c[cP++] = b[bP++];
			else
				c[cP++] = a[aP++];
		}
		while(aP < aLength){
			c[cP++] = a[aP++];
		}
		while(bP < bLength){
			c[cP++] = b[bP++];
		}
		return c;
	}

}
