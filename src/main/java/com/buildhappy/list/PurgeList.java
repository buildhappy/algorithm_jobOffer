package com.buildhappy.list;

import com.buildhappy.bean.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 去除链表中所有重复的元素，并且保证顺序不变
 * 要求只遍历一遍链表，不能另建新表
 * 比如，输入：1,5,3,9,5；输出：1,3,9
 * 百度技术架构部
 *
 * @author buildhappy
 */
public class PurgeList {
    // TODO 未做完
    public static void purge_new(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode curNode = head;
        ListNode workNode = head.next;

    }

    public static void purge(ListNode head) {
        if (head == null) {
            return;
        }
        List<Integer> toDeleteValue = new ArrayList<Integer>();
        HashMap<Integer, ListNode> nodes = new HashMap<Integer, ListNode>();
        ListNode p = head, q = head;
        while (p != null) {
            //Set<Integer> values = nodes.keySet();
            int value = p.val;
            if (nodes.containsKey(value)) {
                if (p.next == null) {
                    q.next = null;
                    q = p;
                    p = null;
                } else {
                    q = p;
                    p.val = p.next.val;
                    p.next = p.next.next;
                    //p = p.next;
                }

                if (!toDeleteValue.contains(value)) {
                    toDeleteValue.add(value);
                }

            } else {
                nodes.put(p.val, p);
                q = p;
                p = p.next;
            }
        }
        System.out.print("toDeleteValue中的值为：");
        for (int value : toDeleteValue) {
            System.out.print(value + " ");
        }
        System.out.println();
        while (!toDeleteValue.isEmpty()) {
            int value = toDeleteValue.get(0);
            toDeleteValue.remove(0);
            if (nodes.containsKey(value)) {
                ListNode cur = nodes.get(value);
                if (cur.next != null) {
                    cur.val = cur.next.val;
                    cur.next = cur.next.next;
                }
            }
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
        ListNode p = head;

        System.out.print("\n原链表：");
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();

        purge(head);

        System.out.println();
        System.out.print("去重后链表：");
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

}
