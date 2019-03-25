package com.buildhappy.interviewcollection;

import java.util.Arrays;

/**
 * 求出数组中未出现的最小正整数
 * LeetCode：https://leetcode.com/problems/first-missing-positive/submissions/
 * Created by caijianfu on 15/9/19.
 */
public class Leshi_FindMissMinNum {
    public static void main(String[] args) {
        int[] data = {-1, 60, 30, 50, 10};
        //int[] data = {1,2,3,4,5};
        //getMinMissNum(data);
        System.out.println(firstMissingPositive(data));
    }

    public static int firstMissingPositive(int[] data) {
        int n = data.length;
        int i = 0;
        while (i < n) {
            //合法
            if (data[i] == i + 1) {
                i++;
            } else if (data[i] > n || data[i] <= i || data[data[i] - 1] == data[i]) {
                data[i] = data[--n];
            } else {
                //合法，但不在合适位置
                swap(data, i, data[i] - 1);
            }
        }
        return i + 1;
    }

    public static void swap(int[] data, int a, int b) {
        int x = data[a];
        data[a] = data[b];
        data[b] = x;
    }
}
