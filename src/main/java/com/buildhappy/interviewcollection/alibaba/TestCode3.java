package com.buildhappy.interviewcollection.alibaba;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * 文件系统中按逗号分割保存了1亿个正整数(一行10个数，1000万行)，找出其中最大的100个数
 */
public class TestCode3 {
    public static void main(String[] args) {
        try {
            solution();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void solution() throws IOException {
        String path = "/Users/caijianfu02/Desktop/test_data";
        Stream<String> lines = Files.lines(Paths.get(path));
        PriorityQueue<Integer> result = new PriorityQueue<>();
        AtomicInteger count = new AtomicInteger(0);
        lines.forEach(line -> {
            String[] datas = line.split(",");
            for (String data: datas) {
                int dataInt = Integer.parseInt(data);
                if (count.getAndIncrement() < 10) {
                    result.add(dataInt);
                } else {
                    if (result.peek() < dataInt) {
                        result.poll();
                        result.add(dataInt);
                    }
                }
            }
        });
        System.out.println(result);
        System.out.println(result.size());
    }
}
