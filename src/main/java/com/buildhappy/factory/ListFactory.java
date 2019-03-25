package com.buildhappy.factory;

import com.buildhappy.bean.ListNode;

public class ListFactory {

    /**
     * 返回有环的链表
     * @return
     */
    public static ListNode getCycleList() {
        // 4->3->2->1->4
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node2.next = node1;
        ListNode node3 = new ListNode(3);
        node3.next = node2;
        ListNode node4 = new ListNode(4);
        node4.next = node3;
        // 环
        node1.next = node4;

        return node4;
    }

    /**
     * 获取普通链表
     * @return
     */
    public static ListNode getList() {
        // 构建链表 0->1->2->3->4
        ListNode head = new ListNode(0);
        ListNode node_one = new ListNode(1);
        ListNode node_two = new ListNode(2);
        ListNode node_three = new ListNode(3);
        ListNode node_four = new ListNode(4);
        head.setNext(node_one);
        node_one.setNext(node_two);
        node_two.setNext(node_three);
        node_three.setNext(node_four);
        node_four.setNext(null);
        return head;
    }
}
