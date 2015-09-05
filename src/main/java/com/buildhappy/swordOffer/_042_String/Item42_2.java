package com.buildhappy.swordOffer._042_String;

/**
 * 题目二：左旋转字符串
 * 题目二大致为：
    字符串的左旋转操作时把字符串前面的若干个字符转移到字符串的尾部。
    如输入字符串为"abcdefg"和数字2，则返回"cdefgab"。
思路：
    类似上面的两次翻转。
 * @author dell
 * 
 */
public class Item42_2 {
	public static void main(String args[]) {
		String s = "abcdefg";
		int k = 2;
		System.out.println(leftRotateString(s, k));
	}

	/**
	 * 左旋转
	 * @param s原始字符串
	 * @param k旋转的个数
	 * @return
	 */
	public static String leftRotateString(String s, int k) {
		// 先检查s和k的合法性
		if (s == null || k <= 0)
			return s;

		// 将字符串转换成字符数组
		char c[] = s.toCharArray();
		// 翻转整个字符串
		reverse(c, 0, c.length - 1);

		// 找到k的位置
		reverse(c, 0, c.length - 1 - k);
		reverse(c, c.length - k, c.length - 1);
		return new String(c);
	}

	/**
	 * 通用的对每个字符数组翻转
	 * 
	 * @param c
	 * @param start字符数组的开始
	 * @param end字符数组的结束
	 */
	public static void reverse(char c[], int start, int end) {
		// 不满足要求的输入
		if (c == null || start > end) {
			return;
		}
		// 只有一个字符
		if (start == end) {
			return;
		}

		while (start < end) {
			char tmp = c[start];
			c[start] = c[end];
			c[end] = tmp;
			start++;
			end--;
		}
	}

}
