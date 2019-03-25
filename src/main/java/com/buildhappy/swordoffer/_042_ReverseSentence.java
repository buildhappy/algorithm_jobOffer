package com.buildhappy.swordoffer;

/**
 * 面试题42：翻转单词顺序VS左旋转字符串
 * 题目一大致为：
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。
 * 思路：
 * 两次翻转，对于字符串"I am a student."，首先进行第一次翻转，
 * 即翻转完为：".tneduts a ma I"，然后再对每个单词翻转，最终为："student. a am I"。
 *
 * @author dell
 */
public class _042_ReverseSentence {
    public static void main(String args[]) {
        String s = "I am a student.";

        System.out.println(reverseSentence(s));
    }

    /**
     * 翻转整个字符串
     *
     * @param s
     * @return
     */
    public static String reverseSentence(String s) {
        //将字符串转换成字符数组
        char c[] = s.toCharArray();
        //先将整个字符数组翻转
        reverse(c, 0, c.length - 1);

        //再翻转每一个单词
        int lengthOfTerm = 0;//单词的长度
        for (int i = 0; i < c.length; i++) {
            if (c[i] == ' ') {
                int end = i - 1;//末尾的位置
                int start = end - lengthOfTerm + 1;
                reverse(c, start, end);//翻转单词
                lengthOfTerm = 0;
            } else {
                lengthOfTerm++;//增加单词的字符数
            }
        }

        return new String(c);
    }

    /**
     * 通用的对每个字符数组翻转
     *
     * @param c
     * @param start 字符数组的开始
     * @param end   字符数组的结束
     */
    public static void reverse(char c[], int start, int end) {
        //不满足要求的输入
        if (c == null || start > end) {
            return;
        }
        //只有一个字符
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
