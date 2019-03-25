package com.buildhappy.swordoffer.useless._004_StringReplaceBlank;

/**
 * 面试题4：替换空格
 * 思路：
    在Java和C中，对字符串的处理略有不同，在C中字符串是以字符数组的形式存储的，
    并且在字符串或者字符数组中都有一个结束符"\0"；
    而在Java中，却没有这样的结束符，所以本题在Java下的处理与C中也不一样。

    在C中，思路为：先遍历一遍，找到空格的个数，这样便可以计算新的字符串的长度=旧的字符串的长度+空格数*2，
    然后从尾部向前遍历，遇到非空格，则复制到新的位置，否则直接添加新字符。

    在Java中，字符替换主要有两种：replace(char oldChar, char newChar)和
    replaceAll(String regex, String replacement)。
 * @author dell
 * 
 */
public class Item04 {
	public static void main(String args[]) {
		String s = "We are happy.";
		char c_old[] = s.toCharArray();
		// 为简单起见，我们假设给它一个新的空间，空间的大小组以存下替换后的字符
		char c_new[] = new char[100];
		for (int i = 0; i < c_old.length; i++) {
			c_new[i] = c_old[i];
		}

		// 输出新的数组
		System.out.println(replaceBlank(c_new, c_old.length));
	}
	
	/**
	 * 计算新的字符串
	 * @param c 带空格的字符数组
	 * @param length 是指第一个字符到最后一个字符的长度，不是字符数组的长度
	 * @return
	 */
	public static String replaceBlank(char c[], int length) {
		// 查找空格的数目
		int blank = 0;
		for (int i = 0; i < length; i++) {
			if (c[i] == ' ') {
				blank++;
			}
		}

		// 重新计算新的数组的大小
		int length_new = length + blank * 2;

		// 从尾到头查找
		int j = length - 1;
		int k = length_new - 1;
		while (j >= 0 && k >= 0) {
			if (c[j] != ' ') {
				c[k--] = c[j];
			} else {
				c[k--] = '0';
				c[k--] = '2';
				c[k--] = '%';
			}
			j--;
		}
		return new String(c);
	}
}
