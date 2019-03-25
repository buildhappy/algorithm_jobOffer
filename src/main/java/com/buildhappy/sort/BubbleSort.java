package com.buildhappy.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = {3,5,2,1,4};
//        int[] nums = {1, 2, 3, 4, 5};
        int[] rest = sort(nums);
        System.out.print(Arrays.toString(nums));
    }

    public static int[] sort(int[] datas) {
        if (datas == null) {
            return datas;
        }
        boolean canStop = false;
        for (int i = 0; i < datas.length - 1 && !canStop; ++i) {
            for (int j = datas.length - 1; j > i; --j) {
                canStop = true;
                if (datas[j - 1] > datas[j]) {
                    int tmp = datas[j - 1];
                    datas[j - 1] = datas[j];
                    datas[j] = tmp;
                    canStop = false;
                }
            }
        }
        return datas;
    }
}
