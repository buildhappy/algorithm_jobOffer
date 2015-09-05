package com.buildhappy.swordOffer._037_CommanNode;

import com.buildhappy.swordOffer._017_MergeList.ListNode;

/**
 * 面试题37：两个链表的第一个公共结点
 * 思路：
 *  第一个公共结点开始往后都是公共结点，所以在末尾向前遍历，就可以找到第一个公共结点。
 *  利用上面的思想，可以先计算两个链表的长度，计算两个链表的长度差，然后先遍历较长的链表，
 *  等到剩余长度相等时开始同时遍历，这样就能较快地找到相同的结点，时间复杂度为O(m+n)，
 *  其中m，n分别为两个链表的长度。
 * @author dell
 * 
 */
public class Item37 {
	public static void main(String args[]) {
		// 构建链表
		ListNode head1 = new ListNode(1);
		ListNode node_2 = new ListNode(2);
		ListNode node_3 = new ListNode(3);
		ListNode head2 = new ListNode(4);
		ListNode node_5 = new ListNode(5);
		ListNode node_6 = new ListNode(6);
		ListNode node_7 = new ListNode(7);
		head1.setNext(node_2);
		node_2.setNext(node_3);
		node_3.setNext(node_6);
		node_6.setNext(node_7);
		node_7.setNext(null);
		head2.setNext(node_5);
		node_5.setNext(node_6);

		ListNode result = findFirst(head1, head2);
		System.out.println("第一个公共结点：" + result.getValue());
	}
	
	/**
	 * 查找第一个公共结点
	 * @param head1链表1的头指针
	 * @param head2链表2的头指针
	 * @return
	 */
	public static ListNode findFirst(ListNode head1, ListNode head2) {
		ListNode p1 = head1;
		ListNode p2 = head2;
		int list_1_len = 0;
		int list_2_len = 0;
		// 分别计算两个链表的长度
		while (p1 != null) {
			list_1_len++;
			p1 = p1.getNext();
		}

		while (p2 != null) {
			list_2_len++;
			p2 = p2.getNext();
		}

		// 长度差
		int nLength = list_1_len - list_2_len;

		ListNode pLong = head1;
		ListNode pShort = head2;
		if (list_1_len < list_2_len) {
			pLong = head2;
			pShort = head1;
			nLength = list_2_len - list_1_len;
		}

		// 长的先走nLength步
		for (int i = 0; i < nLength; i++) {
			pLong = pLong.getNext();
		}

		// 此时长度相等，一起向前走，并判断他们的值是否相等
		while (pLong != null && pShort != null && pLong != pShort) {
			pLong = pLong.getNext();
			pShort = pShort.getNext();
		}

		return pLong;

	}

}
