package com.buildhappy.swordOffer._015_findKThToTail;

/**
 * 面试题15：链表中倒数第k个结点
 * 题目大致为：
    在一个链表中，查找倒数的第k个数。
 * 思路：
    使用双指针的方式，前一个指针先走k步(中间隔k-1个结点)，后一个指针才开始走，直到第一个指针走到尾，
    后一个指针指向的就是要找的倒数第k个数。
    值得注意的是：1、k是否超过链表长度且k必须为正整数；2、链表是否为空。
 * @author dell
 * 
 */
public class Item15 {

	public static void main(String args[]) {
		// 构建链表
		ListNode head = new ListNode(1);
		ListNode h1 = new ListNode(2);
		ListNode h2 = new ListNode(3);
		ListNode h3 = new ListNode(4);
		ListNode h4 = new ListNode(5);
		ListNode h5 = new ListNode(6);
		head.setNext(h1);
		h1.setNext(h2);
		h2.setNext(h3);
		h3.setNext(h4);
		h4.setNext(h5);
		h5.setNext(null);
		// 查找倒数第k个
		ListNode p = findKthToTail(head, 6);
		System.out.println(p.getValue());

	}

	public static ListNode findKthToTail(ListNode head, int k) {
		// 首先判断链表是否存在，k是否大于0
		if (head == null || k <= 0) {
			return null;
		}

		ListNode prePoint = head;// 第一个指针
		ListNode postPoint = head;// 第二个指针
		/*
		for (int i = 0; i < k - 1; i++) {
			if (prePoint.getNext() != null) {
				prePoint = prePoint.getNext();
			} else {
				return null;
			}
		}

		while (prePoint.getNext() != null) {
			prePoint = prePoint.getNext();
			postPoint = postPoint.getNext();
		}
		*/
		int counter = 1;
		while(prePoint.getNext() != null){
			prePoint = prePoint.getNext();
			counter++;
			if(counter > k - 1){
				postPoint = postPoint.getNext();
			}
		}
		if(counter < k){
			return null;
		}
		return postPoint;

	}

}
