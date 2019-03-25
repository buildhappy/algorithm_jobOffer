package com.buildhappy.swordoffer;

import com.buildhappy.bean.ListNode;
import com.buildhappy.factory.ListFactory;

/**
 * 面试题16：反转链表
 * 题目大致为：
 * 对于一个链表，反转该链表并返回头结点。
 * 思路：
 * 主要是指针的操作，但是要注意不能断链。这里可以使用非递归的方式求解。
 *
 * @author dell
 */
public class _016_ReverseList {
    /**
     * 测试函数
     */
    public static void main(String args[]) {
        ListNode head = ListFactory.getList();
        printList(head);
        //反转测试
        ListNode reservedHead = reverseList(head);
        printList(reservedHead);

        head = ListFactory.getList();
        ListNode reservedHead2 = reverseListRecursive(head);
        printList(reservedHead2);
    }

    /**
     * 非递归实现
     *
     * @param head 头指针
     */
    public static ListNode reverseList(ListNode head) {
        if (null == head || null == head.getNext()) {
            return head;
        }
        //需要三个指针:指向当前遍历到的节点、它的前一个节点和后一个节点
        ListNode preNode = head;
        ListNode curNode = head.getNext();
        while (curNode != null) {
            ListNode nextNode = curNode.getNext();
            curNode.setNext(preNode);
            preNode = curNode;
            curNode = nextNode;
        }
        head.setNext(null);
        return preNode;
    }

    /**
     * 递归实现
     * @param head
     * @return
     */
    public static ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        ListNode reverseHead = reverseListRecursive(head.getNext());
        // 设置当前节点后面的节点,指向该节点
        head.getNext().setNext(head);
        head.setNext(null);
        return reverseHead;
    }

    /**
     * 链表的打印
     *
     * @param head
     */
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.getVal() + ",");
            head = head.getNext();
        }
        System.out.println();
    }
}
