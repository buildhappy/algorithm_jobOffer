package com.buildhappy.kmp;

import java.util.Arrays;

/**
 * Java实现KMP算法
 * 字符串查找问题,给定文本串text和模式串pattern，从文本串text中找出模式串pattern第一次出现的位置。
 * 
 * 思想：每当一趟匹配过程中出现字符比较不等，不需要回溯i指针， 
 * 而是利用已经得到的“部分匹配”的结果将模式向右“滑动”尽可能远 
 * 的一段距离后，继续进行比较。
 * 
 * 时间复杂度O(n+m)
 * 
 * @author xqh
 * 
 */
public class KMPTest {
	public static void main(String[] args) {
		String s = "abbabbbbcab"; //主串
		String t = "bbcab"; //模式串
		char[] ss = s.toCharArray();
		char[] tt = t.toCharArray();
		System.out.println(kmpIndex(ss, tt)); //KMP匹配字符串
	}

	/**
	 * 获得字符串的next函数值
	 * next数组中存放的是对应元素以前的序列，指引着下一步应该走到哪里
	 * next数组：首位元素填-1（只是约定，可以填0），第二号元素如果前面没有匹配的话填-1，否则值加1
	 * 从第三号元素开始
	 * @param t 字符串
	 * @return next函数值
	 */
	public static int[] next(char[] t){
		int[] next = new int[t.length];
		next[0] = -1;
		int i = 0;//后缀
		int j = -1;//前缀
		while (i < t.length - 1){
			if (j == -1 || t[i] == t[j]){
				i++;
				j++;
				if (t[i] != t[j]){
					next[i] = j;
				} else {
					next[i] = next[j];
				}
			} else{
				j = next[j];
			}
		}
		return next;
	}

	/**
	 * KMP匹配字符串
	 * 
	 * @param s 主串
	 * @param t 模式串
	 * @return 若匹配成功，返回下标，否则返回-1
	 */
	public static int kmpIndex(char[] s, char[] t) {
		System.out.println(Arrays.toString(t));
		int[] next = next(t);
		System.out.println(Arrays.toString(next));
		int i = 0;
		int j = 0;
		while (i <= s.length - 1 && j <= t.length - 1) {
			if (j == -1 || s[i] == t[j]) {
				i++;
				j++;
			} else {
				j = next[j];
			}
			System.out.println(Arrays.toString(next));
		}
		if (j < t.length) {
			return -1;
		} else
			return i - t.length; // 返回模式串在主串中的头下标
	}
}

