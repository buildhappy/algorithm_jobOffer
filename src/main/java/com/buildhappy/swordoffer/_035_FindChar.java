package com.buildhappy.swordoffer;

import java.util.HashMap;

/**
 * 面试题35：第一个只出现一次的字符
 * 题目大致为：
 * 在字符串中找出第一个只出现一次的字符。
 * 思路：
 * 在Java中可以把字符串转换成字符数组处理，可以使用HashMap的数据结构存储，其中key为字符，
 * value为对应出现的次数，这样通过两次遍历字符数组就可以找出，
 * 其中，第一次是构建HashMap，第二次是对每个字符判断其HashMap中对应的value的值是否为1。
 */
public class _035_FindChar {
    public static void main(String args[]) {
        // 测试
        String s = "xmabaccdeff";
        char c[] = s.toCharArray();
        System.out.println("第一个只出现一次的字符为：" + first(c));

        System.out.println(findFireAppearChar(s));
    }

    //法一：使用HashMap存放结果
    public static char first(char c[]) {
        char tmp = 0;
        // 可以使用Hash表，key存储的是字符，value存储的是出现的次数
        HashMap<Character, Integer> map = new HashMap();
        for (int i = 0; i < c.length; i++) {
            // hash表中已经存在key
            if (map.containsKey(c[i])) {
                // 修改其value
                int value = map.get(c[i]);// 根据key得到value
                map.remove(c[i]);
                map.put(c[i], value + 1);
            } else {
                map.put(c[i], 1);
            }
        }
        //插入完毕后依次搜索
        for (int i = 0; i < c.length; i++) {
            if (map.get(c[i]) == 1) {
                tmp = c[i];
                break;// 退出循环
            }
        }
        return tmp;
    }

    //法二：使用一个数组来缓存字符出现的次数
    public static char findFireAppearChar(String s) {
        if (null == s || s.length() <= 0) {
            return 0;
        }
        char temp = 0;
        //注意假设此处的s只包含英文字符，java的char占两个字节(c占一个)
        int[] counter = new int[255];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'A']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (counter[s.charAt(i) - 'A'] == 1) {
                temp = s.charAt(i);
                break;
            }
        }
        return temp;
    }
}
