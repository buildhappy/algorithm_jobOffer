package com.buildhappy.interviewcollection;

/**
 * 求出数组中未出现的最小正整数
 * Created by caijianfu on 15/9/19.
 */
public class Leshi_FindMissMinNum {
    public static void main(String[] args){
        int[] data = {-1 , 2, 3, 4};
        //int[] data = {1,2,3,4,5};
        getMinMissNum(data);
        System.out.println();
    }
    public static int getMinMissNum(int[] data){
        int n = data.length;
        int i = 0;
        while(i < n){
            if(data[i] == i + 1){//合法
                i++;
            }else if(data[i] > n || data[i] <= i || data[data[i] - 1] == data[i]){//不合法
                data[i] = data[--n];
            }else{//合法，但不在合适位置
                swap(data , i , data[i] - 1);
            }
        }
        return i + 1;
    }

    public static void swap(int[] data , int a , int b){
        int x = data[a];
        data[a] = data[b];
        data[b] = x;
    }
}
