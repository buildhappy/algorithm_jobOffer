package com.buildhappy.swordOffer._017_MergeList;

/**
 * 面试题17：合并两个排序的链表
 * 题目大致为：
	输入两个递增排序的链表，合并这两个链表并使得新链表中的结点仍然按照递增排序的。
 * 思路：
	主要是链表中值的比较，取较小的结点插入到新的链表中。
 * @author dell
 * 
 */
public class Item17 {
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
		ListNode head2 = new ListNode(2);
		ListNode node2_2 = new ListNode(4);
		ListNode node2_3 = new ListNode(6);
		ListNode node2_4 = new ListNode(8);
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
		ListNode head = mergeList(head1, head2);
		printList(head);
		System.out.println("-------------");
	}
	
	/**
	 * 合并两个链表
	 * @param head1 链表1
	 * @param head2 链表2
	 * @return
	 */
	public static ListNode mergeList(ListNode head1, ListNode head2) {
		ListNode head = null;//合并后的头指针

		// 如果有一个为空，则为另一个链表
		if (head1 == null)
			head = head2;
		if (head2 == null)
			head = head1;

		// 两个都不为空
		if (head1 != null && head2 != null) {
			// node_1和node_2是用于遍历
			ListNode node_1 = head1;
			ListNode node_2 = head2;
			if (node_1.getValue() < node_2.getValue()) {
				head = node_1;
				head.setNext(mergeList(node_1.getNext(), node_2));
			} else {
				head = node_2;
				head.setNext(mergeList(node_1, node_2.getNext()));
			}
		}
		return head;
	}

	/**
	 * 打印链表
	 * 
	 * @param head 头指针
	 */
	public static void printList(ListNode head) {
		ListNode current = head;
		while (current != null) {
			System.out.print(current.getValue() + "、");
			current = current.getNext();
		}
		System.out.println();
	}

}
