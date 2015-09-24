package com.buildhappy.swordOffer._016_ReverseList;

/**
 * 面试题16：反转链表
 * 题目大致为：
    对于一个链表，反转该链表并返回头结点。
 * 思路：
    主要是指针的操作，但是要注意不能断链。这里可以使用非递归的方式求解。
 * @author dell
 * 
 */
public class Item16 {
	/**
	 * 测试函数
	 */
	public static void main(String args[]) {
		// 构建链表
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
		printList(head);
		//反转测试
		ListNode reservedHead = reverseList(head);
		printList(reservedHead);
	}

	/**
	 * 非递归实现
	 * @param head 头指针
	 */
	public static ListNode reverseList(ListNode head) {
		/*
		ListNode reservedHead = null;
		//需要三个指针:指向当前遍历到的节点、它的前一个节点和后一个节点
		ListNode pNode = head;
		ListNode pPrev = null;
		while (pNode != null) {
			ListNode pNext = pNode.getNext();
			//最后一个元素
			if (pNext == null)
				reservedHead = pNode;
			
			pNode.setNext(pPrev);
			pPrev = pNode;
			pNode = pNext;
		}
		return reservedHead;
		*/
		
		if(null == head || null == head.getNext()) 
			return head;
		//需要三个指针:指向当前遍历到的节点、它的前一个节点和后一个节点
		ListNode curNode = head.getNext();
		ListNode preNode = head;
		while(curNode != null){
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
	public static ListNode reverseList_Iterator(ListNode head){
		if(null == head || null == head.getNext())
			return head;
		ListNode reverseHead = reverseList_Iterator(head.getNext());
		head.getNext().setNext(head);//设置当前节点后面的节点，指向该节点
		head.setNext(null);
		return reverseHead;
	}
	/**
	 * 链表的打印
	 * @param head
	 */
	public static void printList(ListNode head){
		while(head != null){
			System.out.print(head.getValue() + ",");
			head = head.getNext();
		}
		System.out.println();
	}
}
