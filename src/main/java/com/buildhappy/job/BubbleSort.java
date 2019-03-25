package com.buildhappy.job;

public class BubbleSort {
    public static void main(String[] args) {
        int score[] = {1, 98, 33, 2, 70, 309, 11, 45};
        //System.out.print("最终排序结果：");
        bubbleSort(score);
        for (int a = 0; a < score.length; a++) {
            System.out.print(score[a] + "\t");
        }
    }

    public static void bubbleSort(int[] score) {
        for (int i = 0; i < score.length - 1; i++) {
            for (int j = 0; j < score.length - i - 1; j++) {
                if (score[j] > score[j + 1]) {
                    int temp = score[j];
                    score[j] = score[j + 1];
                    score[j + 1] = temp;
                }
            }
        }
    }

}