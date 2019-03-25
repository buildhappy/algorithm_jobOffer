package com.buildhappy.job;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by buildhappy on 15/10/17.
 */
public class Main {
    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int m = cin.nextInt();
        //System.out.println(n + "  " + m);

        int[][] map = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++)
               map[i][j] = cin.nextInt();
        }
//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < m; j++)
//                System.out.print(map[i][j] + " ");
//            System.out.println();
//        }

        //int[][] map = {{5,1,8,5,2},{1 ,3 ,10, 3 ,3},{7 ,8 ,5 ,5 ,16}};
        //int n = 3; int m = 5;

        System.out.println(work(map , n , m));
    }
    public static long work(int[][] map , int n ,int m){
        long lmap[] = new long[n];
        long hmap[] = new long[m];
        for(int i = 0; i < n; i++){
            lmap[i] = 1;
            for(int j = 0; j < m; j++){
                lmap[i] *= map[i][j];
            }
        }
        for(int i = 0; i < m; i++){
            hmap[i] = 1;
            for(int j = 0; j < n; j++){
                hmap[j] *= map[j][i];
            }
        }
        long max = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] != 0){
                    long t = lmap[i] / map[i][j] * hmap[j]/map[i][j];
                    if(t > max) max = t;
                }
            }
        }
        return max;
    }
}
