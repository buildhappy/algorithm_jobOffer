package com.buildhappy.swordoffer;

/**
 * 题目: 一个整数数组里除了两个数字以外，其他数组都出现两次。
 * 要求时间复杂度O(n), 空间O(1)
 * 需要注意的地方:
 * 在一个数组中除两个数字只出现1次外，其它数字都出现了2次， 要求尽快找出这两个数字
 *
 */

public class _040_FindNumAppearOnce {

    public void process(int[] data) {
        //1.异或整个数组，
        int xor = populateXORValue(data);
        System.out.println(xor);
        //2.根据整个数组异或得到的值，判断哪一位(低位到高位,0开始计算)要进行区别 0 或者1
        int position = populatePosition(xor);
        System.out.println("position:" + position);
        //3.根据不同位置上的值是0还是1区别不同的数组
        int[] numbers = populateNoRepeatNumnbers(data, position);
        //4.打印出只出现一次的两个数字
        printTwoNumbers(numbers);
    }

    /**
     * 异或整个数组,返回的值是整个数组中非重复出现的两个数字的异或值
     */
    private int populateXORValue(int[] data) {
        int xor = 0;
        for (int element : data) {
            xor ^= element;
        }
        return xor;
    }

    private int populatePosition(int xorValue) {
        int position = 0;
        while ((xorValue & 1) == 0) {
            xorValue >>= 1;
            position++;
        }
        return position;
    }

    private int[] populateNoRepeatNumnbers(int[] data, int position) {
        int num1 = 0, num2 = 0;
        for (int i = 0; i < data.length; ++i) {
            //将原数组分成两组
            if (((data[i] >> position) & 1) == 1) {
                num1 ^= data[i];
            } else {
                num2 ^= data[i];
            }
        }
        return new int[]{num1, num2};
    }

    private void printTwoNumbers(int[] numbers) {
        System.out.println(String.format("数组中只出现一次的两个数字是: %d, %d", numbers[0],
                numbers[1]));
    }

    public static void main(String[] args) {
        _040_FindNumAppearOnce util = new _040_FindNumAppearOnce();
        util.process(new int[]{1, 3, 3, 1, 5, 8});
        util.process(new int[]{1, 3, 6, 3});
    }
}