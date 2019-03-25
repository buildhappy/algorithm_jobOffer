package com.buildhappy.util;

import com.buildhappy.bean.ListNode;

public class ListUtil {
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.getVal() + "、");
            current = current.getNext();
        }
        System.out.println();
    }
}
