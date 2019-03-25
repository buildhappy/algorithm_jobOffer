package com.buildhappy.swordoffer;

/**
 * 统计从1到n出现的1的次数，比如n=12,从1到12出现1的数字包括1,10,11,12，共3个
 *
 * @author buildhappy
 */
public class _032_NumberOf1Between1AndN {
    //法一：效率较低
    public static int numberOf1Between1AndN(int n) {
        int counter = 0;
        for (int i = 1; i <= n; i++) {
            counter += numberOf1(i);
        }
        return counter;
    }

    //统计数字n中包括的1的个数
    private static int numberOf1(int n) {
        int counter = 0;
        while (n > 0) {
            if ((n % 10) == 1) {
                counter++;
            }
            n /= 10;
        }
        return counter;
    }

    //法二：分析数字规律
    public static int numberOf1Between1AndN_2(int n) {
        String num = n + "";
        return numberOf1_2(num);
    }

    private static int numberOf1_2(String num) {
        if (num == null || num.length() == 0) {
            return 0;
        }

        //获取首位数字
        int firstNum = Integer.parseInt(num.substring(0, 1));

        if (num.length() == 1 && firstNum == 0) {
            return 0;
        }
        if (num.length() == 1 && firstNum > 0) {
            return 1;
        }

        //假设数字是213456
        //numFirstDigit为10000-19999中1的个数
        int numFirstDigit;
        if (firstNum == 1) {
            numFirstDigit = Integer.parseInt(num.substring(1)) + 1;
        } else {
            numFirstDigit = (int) Math.pow(10, num.length() - 1);
        }
        //numOtherDigit是除了第一位以外的位数中的1的数目(1345-21345)
        int numOtherDigit = firstNum * (num.length() - 1) * (int) Math.pow(10, num.length() - 2);//不太懂?????
        //numRecursive是递归后的数字统计(1-1345)
        int numRecursive = numberOf1_2(num.substring(1));
        return numFirstDigit + numOtherDigit + numRecursive;
    }

    public static void main(String[] args) {
        int n = 13;
        System.out.println("Method1:");
        System.out.println(numberOf1Between1AndN_2(n));
        System.out.println("Method2:");
        System.out.println(numberOf1Between1AndN(n));
    }

}
