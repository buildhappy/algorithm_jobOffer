package com.buildhappy.swordOffer._005_PrintListReversingly;

import java.util.Stack;

/**
 * 方法一：递归：采用递归调用的方式依次打印下一个。
 * 伪代码： 笔记
 * @author Administrator
 *
 */
public class PrintListReversingly {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		n1.setNext(n2);
		n2.setNext(n3);		
		n3.setNext(null);
		
		ListNode head = n1;
		printListRecursively(head);
		printListIteratively(head);
	}
	/**
	 * 递归的方式
	 * @param n
	 */
	public static void printListRecursively(ListNode n){
		if(null != n){
			printListRecursively(n.getNext());
			System.out.println(n.getValue());
		}
	}
	
	/**
	 * 入栈、弹栈的方式
	 * @param n
	 */
	public static void printListIteratively(ListNode n){
		Stack<ListNode> s_node = new Stack<ListNode>();
		//入栈
		while (n != null) {
			s_node.push(n);
			n = n.getNext();
		}
		//弹栈、打印
		while (!s_node.empty()) {
			System.out.println(s_node.pop().getValue());
		}
	}
}
