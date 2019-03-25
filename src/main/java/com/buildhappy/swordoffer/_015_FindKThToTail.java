package com.buildhappy.swordoffer;

import com.buildhappy.bean.ListNode;
import com.buildhappy.factory.ListFactory;

/**
 * 面试题15：链表中倒数第k个结点
 * 题目大致为：
 * 在一个链表中，查找倒数的第k个数。
 * 思路：
 * 使用双指针的方式，前一个指针先走k步(中间隔k-1个结点)，后一个指针才开始走，直到第一个指针走到尾，
 * 后一个指针指向的就是要找的倒数第k个数。
 * 值得注意的是：1、k是否超过链表长度且k必须为正整数；2、链表是否为空。
 */
public class _015_FindKThToTail {

    public static void main(String[] args) {
        // 构建链表 0->1->2->3->4
        ListNode head = ListFactory.getList();
        // 查找倒数第k个
        ListNode p = findKthToTail(head, 4);
        System.out.println(p.getVal());

        ListNode q = find(head, 4);
        System.out.println(q.getVal());

    }

    public static ListNode findKthToTail(ListNode head, int k) {
        // 首先判断链表是否存在，k是否大于0
        if (head == null || k <= 0) {
            return null;
        }
        // 第一个指针
        ListNode prePoint = head;
        // 第二个指针
        ListNode postPoint = head;
        int counter = 0;
        while (prePoint.getNext() != null) {
            prePoint = prePoint.getNext();
            counter++;
            if (counter > k - 1) {
                postPoint = postPoint.getNext();
            }
        }
        if (counter < k) {
            return null;
        }
        return postPoint;

    }

    public static ListNode find(ListNode head, int k) {
        if (head == null || k < 0) {
            return null;
        }

        ListNode p = head, q = head;
        int count = 0;
        while (q.next != null) {
            if (count < k) {
                count++;
                q = q.next;
            }
            if (k - 1 == count) {
                p = p.next;
                q = q.next;
            }
        }
        return p;
    }

}
