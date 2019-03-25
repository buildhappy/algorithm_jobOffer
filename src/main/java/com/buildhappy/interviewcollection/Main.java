package com.buildhappy.interviewcollection;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by buildhappy on 15/10/14.
 */
public class Main {
    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int k = n;
        LinkedList[] talks = new LinkedList[n];
        while(n-- != 0){
            while (cin.hasNext()){
                talks[n].add(cin.nextInt());
            }
        }
        while(n-- != 0){
            int length = talks[n].size();
            int i = 0;
            while(i < length - 1){
                System.out.print(talks[n].get(i) + " ");
            }
            System.out.println();
        }
    }
    public void work(){

    }
}
