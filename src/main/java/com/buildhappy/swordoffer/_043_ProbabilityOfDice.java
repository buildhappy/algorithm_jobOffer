package com.buildhappy.swordoffer;

/**
 * n个骰子的点数 
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为S。输入n，打印出S的所有可能的值出现的概率。
 * 在以下求解过程中，我们把骰子看作是有序的。
 * 例如当n=2时，我们认为(1,2)和(2,1)是两种不同的情况
 */
public class _043_ProbabilityOfDice {
	private static int MAX = 6;

	public static void main(String[] args) {
		// n是骰子的个数
		int n = 2;
        // solution 1,use recursion
		printProbabilityOfDice_1(n);
		System.out.println("============");
        // solution 2,use DP
		printProbabilityOfDice_2(n);
	}
	//法一：利用递归
	public static void printProbabilityOfDice_1(int n) {
		if (n < 1) {
			return;
		}
		double total = Math.pow(MAX, n);
        // the sum of n dices is from n*1 to n*MAX
		int len = n * MAX - n * 1 + 1;
		int[] times = new int[len];
        // initial the first dice.
		for (int i = 1; i <= MAX; i++) {
            // count the times of each possible sum
			probabilityOfDice(n, i, n, 0, times);
		}
		for (int i = 0; i < len; i++) {
			System.out.println((i + n) + "," + times[i] + "/" + total);
		}

	}

	private static void probabilityOfDice(int n, int curDiceValue,
			int numOfDices, int curSum, int[] times) {
		if (numOfDices == 1) {
			int sum = curSum + curDiceValue;
            // n*1 to n*MAX <---> 0 to len
			times[sum - n]++;
		} else {
			int sum = curSum + curDiceValue;
			for (int i = 1; i <= MAX; i++) {
				probabilityOfDice(n, i, numOfDices - 1, sum, times);
			}
		}
	}

	/**
	 * 法二：
	 * 有k-1个骰子时，再增加一个骰子，这个骰子的点数只可能为1、2、3、4、5或6。那k个骰子得到点数和为n的情况有：
	 * (k-1,n-1)：第k个骰子投了点数1 (k-1,n-2)：第k个骰子投了点数2 (k-1,n-3)：第k个骰子投了点数3 ....
	 * (k-1,n-6)：第k个骰子投了点数6 在k-1个骰子的基础上，再增加一个骰子出现点数和为n的结果只有这6种情况！
	 * 所以：f(k,n)=f(k-1
	 * ,n-1)+f(k-1,n-2)+f(k-1,n-3)+f(k-1,n-4)+f(k-1,n-5)+f(k-1,n-6)
	 * 初始化：有1个骰子，f(1,1)=f(1,2)=f(1,3)=f(1,4)=f(1,5)=f(1,6)=1。
	 */
	public static void printProbabilityOfDice_2(int n) {
		if (n < 1) {
			return;
		}
		double total = Math.pow(MAX, n);
		int maxSum = n * MAX;
		double[][] f = new double[n + 1][n * MAX + 1];
		for (int i = 1; i <= MAX; i++) {
			f[1][i] = 1;
		}
		for (int k = 2; k <= n; k++) {
			for (int sum = n; sum <= maxSum; sum++) {
				for (int i = 1; sum - i >= 1 && i <= MAX; i++) {
					f[k][sum] += f[k - 1][sum - i];
				}
			}
		}

		for (int sum = n; sum <= maxSum; sum++) {
			System.out.println(sum + "," + f[n][sum] + "/" + total);
		}
	}
}
