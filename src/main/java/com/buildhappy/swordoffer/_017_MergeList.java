package com.buildhappy.swordoffer;

import com.buildhappy.bean.ListNode;

/**
 * 面试题17：合并两个排序的链表
 * 题目大致为：
 * 输入两个递增排序的链表，合并这两个链表并使得新链表中的结点仍然按照递增排序的。
 * 思路：
 * 主要是链表中值的比较，取较小的结点插入到新的链表中。
 *
 * @author dell
 */
public class _017_MergeList {
    public static void main(String args[]) {
        // 构建链表1
        ListNode head1 = new ListNode(1);
        ListNode node1_2 = new ListNode(3);
        ListNode node1_3 = new ListNode(5);
        ListNode node1_4 = new ListNode(7);
        head1.setNext(node1_2);
        node1_2.setNext(node1_3);
        node1_3.setNext(node1_4);
        node1_4.setNext(null);
        // 构建链表2
        ListNode head2 = new ListNode(20);
        ListNode node2_2 = new ListNode(40);
        ListNode node2_3 = new ListNode(60);
        ListNode node2_4 = new ListNode(80);
        head2.setNext(node2_2);
        node2_2.setNext(node2_3);
        node2_3.setNext(node2_4);
        node2_4.setNext(null);

        System.out.println("链表1：");
        printList(head1);
        System.out.println("-------------");

        System.out.println("链表2：");
        printList(head2);
        System.out.println("-------------");

        System.out.println("合并后的链表：");
//        ListNode head = mergeListRecursive(head1, head2);
        ListNode head = mergeList(head1, head2);
        printList(head);
        System.out.println("-------------");


    }

    /**
     * 合并两个链表
     *
     * @param head1 链表1
     * @param head2 链表2
     * @return
     */
    public static ListNode mergeListRecursive(ListNode head1, ListNode head2) {
        //合并后的头指针
        ListNode head = null;

        // 如果有一个为空，则为另一个链表
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        // 两个都不为空
        // node_1和node_2是用于遍历
        ListNode node_1 = head1;
        ListNode node_2 = head2;
        if (node_1.getVal() < node_2.getVal()) {
            head = node_1;
            head.setNext(mergeListRecursive(node_1.getNext(), node_2));
        } else {
            head = node_2;
            head.setNext(mergeListRecursive(node_1, node_2.getNext()));
        }
        return head;
    }

    public static ListNode mergeList(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        ListNode p = head1, q = head2, result;
        if (p.val < q.val) {
            result = head1;
            p = p.next;
        } else {
            result = head2;
            q = q.next;
        }

        ListNode last = result;
        while (p != null && q != null) {
            if (p.val < q.val) {
                last.next = p;
                p = p.next;
            } else {
                last.next = q;
                q = q.next;
            }
            // 一定不能丢
            last = last.next;
        }

        if (p != null) {
            last.next = p;
        }
        if (q != null) {
            last.next = q;
        }
        return result;
    }

    /**
     * 打印链表
     *
     * @param head 头指针
     */
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.getVal() + "、");
            current = current.getNext();
        }
        System.out.println();
    }

}
