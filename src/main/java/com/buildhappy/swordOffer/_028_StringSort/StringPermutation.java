package com.buildhappy.swordOffer._028_StringSort;

import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

/**
 * 字符串的全排列(P155)
 * @author buildhappy
 *
 */
public class StringPermutation {
	private static Set<String> results = new HashSet<String>();
	static void permutaion(String s){
		if(null == s) return;
		permutation(s.toCharArray() , 0);
	}
	
	static void permutation(char[] s , int index){
		if(index == s.length - 1){
			//System.out.println(s);
			results.add(new String(s));//去掉重复的排列
		}else{
			for(int i = index; i < s.length; i++){
				//将第i位与后一位进行交换
				swap(s , index , i);
				permutation(s , index + 1);
				//将第i位的元素进行复原
				swap(s , index , i);
			}
		}
	}
	public static void swap(char[] s,int i,int j){
		char temp = s[i];
		s[i] = s[j];
		s[j] = temp;
	}
	public static void main(String[] args) {
		permutaion("aabcd");
		for(String s : results){
			System.out.println(s);
		}
	}

}
