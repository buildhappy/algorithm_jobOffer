package com.buildhappy.swordoffer;

import com.buildhappy.bean.ListNode;

/**
 * 思路：
 *  将重复节点全部删除，一个不留，这就是本题的难点所在，
 *  我们必须保存当前节点的前一个节点，因为我们不知道当前节点是否是重复节点。
 *  还有一个难点，当开头就是重复元素时，我们需要调整head，这时候需要一些判断条件。
 */
public class _013_DeleteListDuplicateNode {
    public static void main(String args[]) {
        // 构建链表
        ListNode head = new ListNode(2);
        ListNode node_2 = new ListNode(2);
        ListNode node_3 = new ListNode(3);
        ListNode node_4 = new ListNode(4);
        ListNode node_5 = new ListNode(5);
        ListNode node_5_5 = new ListNode(5);
        ListNode node_6 = new ListNode(6);
        ListNode node_7 = new ListNode(7);
        head.setNext(node_2);
        node_2.setNext(node_3);
        node_3.setNext(node_4);
        node_4.setNext(node_5);
        node_5.setNext(node_5_5);
        node_5_5.setNext(node_6);
        node_6.setNext(node_7);
        node_7.setNext(null);
        _013_DeleteListNode.printList(removeDuplicate(head));
    }
    public static ListNode removeDuplicate(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head, pre = null;
        while (cur != null) {
            // 发现重复元素
            if (cur.next != null && cur.val == cur.next.val) {
                int curValue = cur.val;
                // 跳过重复元素
                while (cur.next != null && cur.next.val == curValue) {
                    cur = cur.next;
                }
                // 开头元素就有重复
                if (pre == null) {
                    head = cur.next;
                } else {
                    pre.next = cur.next;
                }
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}
