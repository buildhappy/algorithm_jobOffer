package com.buildhappy.swordOffer._021_StackWithMin;

import java.util.Stack;

/**
 * 面试题21：包含min函数的栈
 * 题目大致为：
    定义栈的数据结构，在给类型中实现一个能够得到栈的最小元素的min函数。
    在该栈中，调用min、push及pop的时间复杂度都是O(1)。
思路：
    可以建一个辅助的栈，在插入的过程中，插入栈1，同时在插入辅助栈的过程中要求与栈中的元素比较，
    若小于栈顶元素，则插入该元素，若大于栈顶元素，则继续插入栈顶元素。
 * @author dell
 * 
 */
class StackWithMin {
	private Stack<Integer> stack;
	private Stack<Integer> stackHelp;// 一个辅助的栈

	public StackWithMin() {
		stack = new Stack<Integer>();
		stackHelp = new Stack<Integer>();
	}

	/**
	 * 直接插入stack中，在插入stackHelp时，如果为空则直接插入，或者要判断与顶部元素的大小，
	 * 若小于则插入，若大于则继续插入顶部元素
	 * 
	 * @param t 待插入元素
	 */
	public void push(int t) {
		stack.push(t);
		// 插入辅助的栈
		if (stackHelp.size() == 0 || t < stackHelp.peek()) {
			stackHelp.push(t);
		} else {
			stackHelp.push(stackHelp.peek());//stackHelp元素个数与stack相同
		}
	}

	/**
	 * 出栈，要求stack和stackHelp均不为空
	 * 
	 * @return
	 */
	public int pop() {
		assert (stack.size() > 0 && stackHelp.size() > 0);

		stackHelp.pop();
		return stack.pop();
	}

	/**
	 * 取得最小值，最小值一定是stackHelp的栈顶元素
	 * 
	 * @return
	 */
	public int min() {
		assert (stack.size() > 0 && stackHelp.size() > 0);

		return stackHelp.peek();//只取不删除
	}
}

public class Item21 {
	public static void main(String args[]) {
		StackWithMin s = new StackWithMin();
		s.push(3);
		s.push(4);
		s.push(2);
		System.out.println(s.min());
		s.push(1);
		System.out.println(s.min());
	}

}
