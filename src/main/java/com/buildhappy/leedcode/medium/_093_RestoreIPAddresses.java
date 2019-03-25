package com.buildhappy.leedcode.medium;

import com.buildhappy.leedcode.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/restore-ip-addresses/
 * 参考:https://www.cnblogs.com/grandyang/p/4305572.html
 */
public class _093_RestoreIPAddresses extends Task {
    @Override
    public void run() {
        println(restoreIpAddresses("25525511135"));
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> rest = new ArrayList<>();
        generateIp(s, 4, "", rest);
        return rest;
    }


    private void generateIp(String s, int k, String out, List<String> rest) {
        if (k == 0) {
            if (s.isEmpty()) {
                rest.add(out);
            }
            return;
        }
        for (int i = 1; i <= 3; ++i) {
            if (s.length() < i) {
                continue;
            }
            String t = s.substring(0, i);
            if (!valide(t)) {
                continue;
            }
            String sub = s.substring(i);
            if (k == 1) {
                generateIp(sub, k - 1, out + t, rest);
            } else {
                generateIp(sub, k - 1, out + t + ".", rest);
            }
        }
    }

    private boolean valide(String s) {
        if (s.isEmpty() || (s.length() > 1 && s.charAt(0) == '0')) {
            return false;
        }
        int i = Integer.parseInt(s);
        return i >= 0 && i <= 255;
    }
}
