package com.buildhappy.leedcode.medium;

import com.buildhappy.leedcode.Task;

import java.util.*;

/**
 * https://leetcode.com/problems/merge-intervals/submissions/
 * 区间合并
 */
public class _056_MergeIntervals extends Task {
    @Override
    public void run() {
        List<Interval> intervals = new LinkedList<>();
        intervals.add(new Interval(2,3));
        intervals.add(new Interval(1,4));
        //[1,3],[2,6],[8,10],[15,18]
//        intervals.add(new Interval(1,3));
//        intervals.add(new Interval(2,6));
//        intervals.add(new Interval(8,10));
//        intervals.add(new Interval(15,18));
        println(merge(intervals));
    }


    public List<Interval> merge(List<Interval> intervals) {
        Comparator<Interval> comparator = (Interval o1, Interval o2) -> {
            return o1.start > o2.start? 1: o1.start == o2.start ? 0 : -1;
        };

        Collections.sort(intervals, comparator);
        println(intervals);
        LinkedList<Interval> rest = new LinkedList<>();
        for (Interval interval: intervals) {
            if (rest.isEmpty() || rest.getLast().end < interval.start) {
                rest.add(interval);
            } else {
                rest.getLast().end = Math.max(rest.getLast().end, interval.end);
            }
        }
        return rest;
    }

    private class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
