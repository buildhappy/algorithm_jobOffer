package com.buildhappy.swordoffer;

/**
 * 面试题8：旋转数组的最小数字
 * 其实就是找数组里的最小元素
 * 一个递增排序的数组的一个旋转(把一个数组最开始的若干元素搬到数组的末尾,称之为数组的旋转)
 * 输入一个递增数组的一个旋转，输出旋转数组的最小元素
 * 思路：
 *  旋转过后的数组是部分有序的，这样的数组依然可以使用折半查找的思路求解
 * 测试：
 * 功能测试，输入正常的数组查看结果；
 * 边界测试，输入只有一个元素的数组；
 * 特殊输入，数组为null
 */
public class _008_MinNumberInRotatedArray {

    public static void main(String args[]) {
        // 数组A是数组{1,2,3,4,5}的旋转数组
        int[] A = {6, 1, 2, 3, 4, 5};//{3, 4, 5, 5, 5, 1, 2};

        System.out.println(findMin(A));
    }

    public static int findMin(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Data is null");
        }
        if (array.length == 1) {
            return array[0];
        }
        int low = 0;
        int high = array.length - 1;
        int middle = low;

        while (array[low] >= array[high]) {
            // 数组中就只有两个数,最小的为后者,终止条件
            if (high - low == 1) {
                middle = high;
                break;
            }
            //查找中间位置
            middle = (high + low) >> 1;
            if (array[middle] >= array[low]) {
                low = middle;
            } else if (array[middle] <= array[high]) {
                high = middle;
            }
        }
        return array[middle];
    }
}
