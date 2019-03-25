package com.buildhappy.swordoffer;

import java.util.Arrays;

/**
 * 面试题14：调整数组顺序使奇数位于偶数前面
 * 题目大致为：
 * 对于一个数组，实现一个函数使得所有奇数位于数组的前半部分，偶数位于数组的后半部分。
 * 思路：
 * 可以使用双指针的方式，一个指针指向数组的开始，一个指针指向数组的尾部，
 * 如果头部的数为偶数且尾部的数是奇数则交换，否则头部指针向后移动，尾部指针向前移动，直到两个指针相遇
 *
 * @author dell
 */
public class _014_ReorderOddEven {
    public static void main(String args[]) {
        int[] A = {1, 2, 3, 4, 5, 8, 42, 7};
        reorderOddEven(A);
        System.out.println(Arrays.toString(A));
    }

    /**
     * 调整数组的顺序
     *
     * @param array 数组
     */
    public static void reorderOddEven(int[] array) {
        // 两个位置，头和尾
        int low = 0;
        int high = array.length - 1;

        // 两个位置直到相遇
        while (low < high) {
            // 如果low位置上的为偶数，high位置上的为奇数，交换
            if ((array[low] & 0X1) == 0 && (array[high] & 0X1) == 1) {
                int tmp = array[low];
                array[low] = array[high];
                array[high] = tmp;
                low++;
                high--;
            } else if ((array[low] & 0X1) == 1) {
                // 如果low位置上的为奇数，low后移
                low++;
            } else {
                // high位置上的值为偶数，high前移
                high--;
            }
        }
    }
}
