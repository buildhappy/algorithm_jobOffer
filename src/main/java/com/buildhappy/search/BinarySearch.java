package com.buildhappy.search;
/**
 * 二分法查找
 * @author buildhappy
 *
 */
public class BinarySearch {
	public static int binarySearch(int[] num , int k){
		if(null == num || num.length == 0)
			return -1;
		int low = 0 , high = num.length - 1;
		while(low <= high){
			int middle = (low + high) >> 1;
			if(num[middle] == k){
				return middle;
			}else if(num[middle] > k){
				high = middle - 1;
			}else{
				low = middle + 1;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] num = {1,2,3,4,5,6};
		System.out.println(binarySearch(num , 1));
	}

}
