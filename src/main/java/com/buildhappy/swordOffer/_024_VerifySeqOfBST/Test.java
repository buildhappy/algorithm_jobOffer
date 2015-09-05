package com.buildhappy.swordOffer._024_VerifySeqOfBST;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		int[] array = {1,2,5,8};
		int[] b = Arrays.copyOfRange(array, 3, 4);
		for(int i : b){
			System.out.print(i + " ");
		}
	}

}
