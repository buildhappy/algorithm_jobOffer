package com.buildhappy.interviewcollection;

import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        String line = cin.nextLine();
        String[] ss = line.split(" ");
        int[] data = new int[ss.length];
        for(int i = 0; i < ss.length; i++){
            data[i] = Integer.parseInt(ss[i]);
        }
        System.out.println(data[0]);
    }
}
