package com.buildhappy.swordoffer;

/**
 * 面试题29：数组中出现次数超过一半的数字P163
 * 题目大致为：
 * 数组中有一个数字出现的次数超过数组长度的一般，找出这个数字。
 * 思路：
 * 在遍历数组的过程中纪录两个量，一个是数组中的数字，一个是次数，当下一个数字和我们保存的一致时则次数加1，
 * 当不一致时次数减1，当次数为0时，重置两个量。数组中的数字为当前访问的值，次数为1。
 * 这里主要是利用了出现的次数超过了一半，其实就是超过一半数出现的次数减去其他的数出现的次数始终是大于0的。
 *
 * @author dell
 */
public class _029_FindMoreThanHalf {
    public static void main(String args[]) {
        int nums[] = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        //System.out.println("超过一半的数字为：" + moreThanHalfNum(nums));
        //int[] nums = {5,4,1,3,8,9};
        System.out.println(partition(nums));
    }

    /** 法一：巧妙的解法(思路如上) **/
    public static int moreThanHalfNum(int array[]) {
        int length = array.length;//数组的长度
        int result = array[0];
        int times = 0;
        for (int i = 1; i < length; i++) {
            if (times == 0) {
                result = array[i];
                times = 1;
            } else if (array[i] == result) {
                times++;
            } else {
                times--;
            }
        }
        if (checkMoreThanHalf(array, result)) {
            return result;
        }
        return -1;
    }

    //法二：利用快排的partition函数
    public static int partition(int[] nums) {
        if (null == nums || nums.length == 0) {
            return -1;
        }
        int mark = nums[0], low = 0, high = nums.length - 1;
        while (low < high) {
            //寻找右边比mark小的数字
            while (low < high && nums[high] > mark) {
                high--;
            }
            nums[low] = nums[high];
            while (low < high && nums[low] < mark) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = mark;
        int result = nums[nums.length >> 1];

        if (checkMoreThanHalf(nums, result)) {
            return result;
        }
        return -1;
    }

    //判断该数字出现的次数是否超过数组长度的一半
    public static boolean checkMoreThanHalf(int[] nums, int number) {
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == number) {
                counter++;
            }
        }
        System.out.println(number + "出现次数:" + counter);
        return counter >= (nums.length >> 1);
    }
}
