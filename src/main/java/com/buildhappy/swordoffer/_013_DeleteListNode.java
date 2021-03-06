package com.buildhappy.swordoffer;

import com.buildhappy.bean.ListNode;

import static com.buildhappy.util.LogUtils.println;

/**
 * 面试题13：在O(1)时间删除链表的节点
 * 题目大致为：
 * 给定单向链表的头指针和一个结点指针，定义一个函数在O(1)时间删除该结点。
 * 思路：
 * 想要在O(1)时间内删除链表的指定结点，要遍历的话得O(n)，则肯定不能遍历。
 * 若是要删除的结点不是尾结点，那么可以将后面的那个值复制到该指针处，并将后面指针所指空间删除，
 * 用复制+删除后面的实现删除，时间复杂度为O(1)。对于尾结点，需要遍历，那么时间复杂度是O(n)，
 * 但是总的时间复杂度为[(n-1)*O(1)+O(n)]/n，结果是O(1)。
 *
 */
public class _013_DeleteListNode {
    public static void main(String args[]) {
        // 构建链表
        ListNode head = new ListNode(1);
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

        //输出原始链表
        System.out.println("原始链表：");
        printList(head);
        System.out.println("----------------");

//        //删除结点head
//        deleteNode(head, head);
//        System.out.println("删除head后链表：");
//        printList(head);
//        System.out.println("----------------");
//
//        //删除结点node_3
//        deleteNode(head, node_3);
//        System.out.println("删除node_3后链表：");
//        printList(head);
//        System.out.println("----------------");
//
//        //删除结点head
//        deleteNode(head, node_7);
//        System.out.println("删除最后一个节点：");
//        printList(head);
//        System.out.println("----------------");

        println("给定值删除对应的节点：");
        printList(deleteNodeMode2(head, 1));
//        printList(removeElements(head, 5));
    }

    /**
     * 快慢指针删除给定的元素,可能会有重复的value
     *
     * @param head
     * @param value
     * @return
     */
    public static ListNode deleteNodeMode2(ListNode head, int value) {

        if (head == null) {
            return null;
        }
        if (head.next == null && head.val == value) {
            return null;
        }
        if (head.next == null && head.val != value) {
            return head;
        }
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == value) {
                if (cur.next != null) {
                    cur.val = cur.next.val;
                    cur.next = cur.next.next;
                } else {
                    ListNode tmp = head;
                    // 防止只有一个元素的情况
                    if (tmp == cur) {
                        return null;
                    }
                    while (tmp.next != cur) {
                        tmp = tmp.next;
                    }
                    tmp.next = null;
                    return head;
                }
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    /**
     * 狸猫换太子删除结点
     *
     * @param head        头指针
     * @param toBeDeleted 要删除的指针
     */
    public static void deleteNode(ListNode head, ListNode toBeDeleted) {
        if (head == null || toBeDeleted == null) {
            return;
        }
        //如果链表只有一个节点，删除头节点(也是尾节点)
        if (head == toBeDeleted) {
            head = null;
            return;
        }

        //找到要删除的节点的下一个节点
        if (toBeDeleted.getNext() != null) {
            //p为toBeDeleted的下一个节点
            ListNode p = toBeDeleted.getNext();
            toBeDeleted.setVal(p.getVal());
            // 删除p节点
            toBeDeleted.setNext(p.getNext());
            return;
        }
        // 删除尾节点,要顺序遍历得到该节点的前序节点
        ListNode currentNode = head;
        while (currentNode.getNext() != toBeDeleted) {
            currentNode = currentNode.getNext();
        }
        currentNode.setNext(null);
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
