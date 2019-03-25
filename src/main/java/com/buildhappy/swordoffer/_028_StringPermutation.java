package com.buildhappy.swordoffer;

import java.util.HashSet;
import java.util.Set;

/**
 * 字符串的全排列(P155)
 *
 * @author buildhappy
 */
public class _028_StringPermutation {
    private static Set<String> results = new HashSet<String>();

    public static void permutation(String s) {
        if (null == s) {
            return;
        }
        permutation(s.toCharArray(), 0);
        System.out.println(Integer.parseInt("123"));
    }

    private static void permutation(char[] chars, int index) {
        if (index == chars.length - 1) {
            //去掉重复的排列
            results.add(new String(chars));
        } else {
            for (int i = index; i < chars.length; i++) {
                //将第i位与后一位进行交换
                swap(chars, index, i);
                permutation(chars, index + 1);
                //将第i位的元素进行复原
                swap(chars, index, i);
            }
        }
    }

    private static void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    public static void main(String[] args) {
        permutation("aabcd");
        for (String s : results) {
            System.out.println(s);
        }
    }

}
