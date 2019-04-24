package com.buildhappy.leetcode.medium;

import com.buildhappy.bean.ListNode;
import com.buildhappy.factory.ListFactory;
import com.buildhappy.leetcode.Task;
import com.buildhappy.util.ListUtil;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/submissions/
 * 删除链表的倒数第n个节点
 */
public class _019_RemoveNthFromEnd extends Task {
    @Override
    public void run() {
        ListNode head = ListFactory.getList();
        println("Org list nodes: ");
        ListUtil.printList(head);
        int n = 1;
        ListUtil.printList(removeNthFromEnd(head, n));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        // 又是dummy节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int c = 0;
        while (p != null) {
            p = p.next;
            c++;
        }
        int step = c - n;
        p = dummy;
        while (step > 0) {
            step--;
            p = p.next;
        }

        p.next = p.next.next;
        return dummy.next;
    }
}
