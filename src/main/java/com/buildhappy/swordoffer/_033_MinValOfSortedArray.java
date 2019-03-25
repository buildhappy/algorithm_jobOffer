package com.buildhappy.swordoffer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 输入一个正整数数组，将它们连接起来排成一个数，输出能排出的所有数字中最小的一个。
 * 例如输入数组{32, 321}，则输出这两个能排成的最小数字32132。请给出解决问题的算法，并证明该算法
 *
 * 参考：com.buildhappy.leedcode.medium._179_MaxNum
 */
public class _033_MinValOfSortedArray {

    public static void main(String[] args) {
        System.out.println("************ test Arrays.sort() **************");
        int[] test = {5, 263, 82, 0, 8};
        Arrays.sort(test);
        for (int i : test) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("************ 算法测试 **************");
        int[][] val = {
                {32, 321},//32132
                {532, 45, 78},//4553278
                {2, 23, 231},//223123
                {2, 3, 1},//123
        };

        for (int[] x : val) {
            System.out.printf("输入的数组：");
            for (int i : x) {
                System.out.print(i + " ");
            }
            System.out.println();
            //solution 1
            String result = minNumFromIntArray(x);
            System.out.println("法一结果：" + result);
            //solution 2
            AuxClass minStr = new AuxClass();
            minNumFromIntArray2(x, 0, minStr);
            System.out.println("法二结果：" + minStr.str);
            System.out.println();
        }
        //System.out.println("32".compareTo("321"));//<0
    }

    /**
     * solution 1:
     * if ab > ba,then a > b
     * 1.sort the integer array. the comparator is "if ab<ba,then a<b"
     * 2.append each integer in the array to create a string and that's the result.
     */
    public static String minNumFromIntArray(int[] x) {
        String[] strs = stringsOf(x);
        //数组按指定规则升序排列
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String each : strs) {
            sb.append(each);
        }
        return sb.toString();
    }

    //convert int[] to String[].For comparing.
    public static String[] stringsOf(int[] x) {
        int len = x.length;
        String[] strs = new String[len];
        for (int i = 0; i < len; i++) {
            strs[i] = "" + x[i];
        }
        return strs;
    }

    /**
     * solution 2
     * get all the permutations.
     * find the min.
     * Of course we use String instead of Big Integer.
     */
    public static void minNumFromIntArray2(int[] x, int index, AuxClass minStr) {
        //此时获取一个排序结果
        if (index == x.length - 1) {
            StringBuilder sb = new StringBuilder();
            for (int each : x) {
                sb.append(each);
            }
            if (minStr.str == null) {
                minStr.str = sb.toString();
            } else {
                if (minStr.str.compareTo(sb.toString()) > 0) {
                    minStr.str = sb.toString();//保存每次全排列较小的值
                }
            }
            return;
        }
        //全排列
        for (int i = index; i <= x.length - 1; i++) {
            swap(x, index, i);
            minNumFromIntArray2(x, index + 1, minStr);
            swap(x, index, i);
        }
    }

    public static void swap(int[] x, int i, int j) {
        int temp = x[i];
        x[i] = x[j];
        x[j] = temp;
    }

    /*
     * 保存
     * when you use 'String' instead of inner class,you get 'null' all the time
     */
    static class AuxClass {
        String str;
    }
}

