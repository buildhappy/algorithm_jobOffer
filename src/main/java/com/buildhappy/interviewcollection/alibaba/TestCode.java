package com.buildhappy.interviewcollection.alibaba;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 实现两个线程，使之交替打印1-100
 * 如：两个线程分别为：Printer1和Printer2,
 * 最后输出结果为： Printer1 — 1 Printer2 一 2 Printer1 一 3 Printer2 一 4
 */
public class TestCode {
    private static int totalNum = 100;
    private static Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger counter = new AtomicInteger(1);
        Thread t1 = new Thread(new PrintTask("Printer1", counter));
        Thread t2 = new Thread(new PrintTask("Printer2", counter));
        t1.start();
        Thread.sleep(10);
        t2.start();
    }

    private static class PrintTask implements Runnable {
        private String name;
        private AtomicInteger counter;

        public PrintTask(String name, AtomicInteger counter) {
            this.name = name;
            this.counter = counter;
        }

        @Override
        public void run() {
            while (counter.get() <= totalNum) {
                synchronized (object) {
                    object.notify();
                    try {
                        System.out.println(name + " - " + counter.getAndIncrement());
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    object.notify();
                }
            }
        }

    }
}
