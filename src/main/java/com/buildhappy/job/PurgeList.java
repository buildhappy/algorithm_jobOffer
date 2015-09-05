package com.buildhappy.job;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * 去除链表中所有重复的元素，并且保证顺序不变
 * 要求只遍历一遍链表，不能另建新表
 * 比如，输入：1,5,3,9,5；输出：1,3,9
 * 百度技术架构部
 * @author buildhappy
 *
 */
public class PurgeList {
	public static void purge(ListNode head){
		if(head == null) return;
		List<Integer> toDeleteValue = new ArrayList<Integer>();
		HashMap<Integer , ListNode> nodes = new HashMap<Integer , ListNode>();
		ListNode p = head , q = head;
		while(p != null){
			//Set<Integer> values = nodes.keySet();
			int value = p.value;
			if(nodes.containsKey(value)){
				if(p.next == null){
					q.next = null;
					q = p;
					p = null;
				}else{
					q = p;
					p.value = p.next.value;
					p.next = p.next.next;
					//p = p.next;
				}

				if(!toDeleteValue.contains(value)){
					toDeleteValue.add(value);
				}
				
			}else{
				nodes.put(p.value, p);
				q = p;
				p = p.next;
			}
		}
		System.out.print("toDeleteValue中的值为：");
		for(int value : toDeleteValue){
			System.out.print(value + " ");
		}
		System.out.println();
		while(!toDeleteValue.isEmpty()){
			int value = toDeleteValue.get(0);
			toDeleteValue.remove(0);
			if(nodes.containsKey(value)){
				ListNode cur = nodes.get(value);
				if(cur.next != null){
					cur.value = cur.next.value;
					cur.next = cur.next.next;
				}
			}
		}
	}
	public static void main(String[] args) {
		ListNode head = new ListNode();
		head.value = 1;
		ListNode node1 = new ListNode();
		node1.value = 3;
		ListNode node2 = new ListNode();
		node2.value = 4;
		ListNode node3 = new ListNode();
		node3.value = 3;
		ListNode node4 = new ListNode();
		node4.value = 4;
		
		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = null;
		ListNode p = head;
		
		System.out.print("\n原链表：");
		while(p != null){
			System.out.print(p.value + " ");
			p = p.next;
		}
		System.out.println();
		
		purge(head);
		
		System.out.println();
		System.out.print("去重后链表：");
		while(head != null){
			System.out.print(head.value + " ");
			head = head.next;
		}
	}

}
