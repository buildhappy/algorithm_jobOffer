package com.buildhappy.swordoffer;

import com.buildhappy.bean.ListNode;

/**
 * 面试题56：链表中环的入口结点
 * 题目大致为：
    一个链表中包含环，如何找出环的入口结点？
 * 对于上图中的链表，首先得判断是否有环存在，在环存在的情况下求出环中结点的个数，
 * 最后类似求链表的倒数第K个结点求出入口结点。这样的过程可以使用快慢指针的方式求解。
 * @author dell
 * 
 */
public class _056_RingEntry {
	public static void main(String args[]) {
		// 生成链表
		ListNode head = new ListNode(1);
		ListNode node_2 = new ListNode(2);
		ListNode node_3 = new ListNode(3);
		ListNode node_4 = new ListNode(4);
		ListNode node_5 = new ListNode(5);
		ListNode node_6 = new ListNode(6);
		head.setNext(node_2);
		node_2.setNext(node_3);
		node_3.setNext(node_4);
		node_4.setNext(node_5);
		node_5.setNext(node_6);
		node_6.setNext(node_3);

		// 找到环的入口结点
		System.out.println("环的入口结点为：" + getEntry(head).getVal());
	}
	
	/**
	 * 求出环内结点的个数
	 * @param head
	 * @return
	 */
	private static int numOfCycle(ListNode head) {
		if (head == null) {
			return -1;
		}

		// 建立快慢指针
		ListNode fastNode = head;
		ListNode slowNode = head;

        // 环中结点的个数
		int num = 0;

		while (fastNode != null && slowNode != null) {
			if (fastNode.getNext() != null && fastNode.getNext().getNext() != null) {
				fastNode = fastNode.getNext().getNext();
			} else {
				return -1;
			}
			slowNode = slowNode.getNext();
			// 相遇表示存在环
			if (fastNode == slowNode) {
				break;
			}
		}

		// 计算环中结点的个数
		num++;
		slowNode = slowNode.getNext();
		while (slowNode != fastNode) {
			slowNode = slowNode.getNext();
			num++;
		}
		return num;
	}
	
	/**
	 * 得到入口结点
	 * @param head
	 * @return
	 */
	public static ListNode getEntry(ListNode head) {
		if (head == null) {
			return null;
		}

		ListNode fastNode = head;
		ListNode slowNode = head;
		int k = numOfCycle(head);
		// 无环
		if (k == -1) {
			return null;
		}

		// 快指针先走k步，这边是关键
		for (int i = 0; i < k; i++) {
			fastNode = fastNode.getNext();
		}

		// 同时走
		while (fastNode != slowNode) {
			fastNode = fastNode.getNext();
			slowNode = slowNode.getNext();
		}

		return fastNode;
	}
}
