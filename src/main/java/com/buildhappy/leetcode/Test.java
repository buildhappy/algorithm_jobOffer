package com.buildhappy.leetcode;

import java.util.concurrent.ConcurrentSkipListMap;

public class Test extends Task {
    @Override
    public void run() {
        ConcurrentSkipListMap<String, String> map = new ConcurrentSkipListMap<>();
        map.put("a", "2");
        map.put("b", "1");
        println(map.firstKey());
        println(map.ceilingKey("ab"));
    }
}
