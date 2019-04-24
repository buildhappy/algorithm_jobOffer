package com.buildhappy.leetcode.medium;

import com.buildhappy.bean.ListNode;
import com.buildhappy.leetcode.Task;
import com.buildhappy.util.ListUtil;

/**
 * https://leetcode.com/problems/add-two-numbers/
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class _002_AddTwoNumbers extends Task {
    @Override
    public void run() {
        super.run();
        ListNode head1 = new ListNode(2);
        ListNode node1_2 = new ListNode(4);
        ListNode node1_3 = new ListNode(3);
        head1.setNext(node1_2);
        node1_2.setNext(node1_3);
        node1_3.setNext(null);

        ListNode head2 = new ListNode(5);
        ListNode node2_2 = new ListNode(6);
        ListNode node2_3 = new ListNode(4);
        head2.setNext(node2_2);
        node2_2.setNext(node2_3);
        node2_3.setNext(null);

        ListUtil.printList(addTwoNumbers(head1, head2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p1 = l1, p2 = l2, cur = dummyHead;
        int carry = 0;
        while (p1 != null || p2 != null) {
            int x = (p1 != null) ? p1.val : 0;
            int y = (p2 != null) ? p2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            if (p1 != null) {
                p1 = p1.next;
            }
            if (p2 != null) {
                p2 = p2.next;
            }
            cur = cur.next;
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        // 去掉无用的head
        return dummyHead.next;
    }
}
