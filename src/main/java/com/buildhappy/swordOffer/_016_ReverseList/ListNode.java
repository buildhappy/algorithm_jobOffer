package com.buildhappy.swordOffer._016_ReverseList;

/**
 * 链表的节点
 * 
 * @author dell
 * 
 */
public class ListNode {
	private int value;
	private ListNode next;

	public ListNode(int value) {
		this.value = value;
	}

	public ListNode(int value, ListNode next) {
		this.value = value;
		this.next = next;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}

	public int getValue() {
		return this.value;
	}

	public ListNode getNext() {
		return this.next;
	}

}
