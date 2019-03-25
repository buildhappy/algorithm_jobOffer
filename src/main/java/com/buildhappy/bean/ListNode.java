package com.buildhappy.bean;

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(Integer val) {
	    this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        Integer nextValue = null;
        if (next != null) {
            nextValue = next.val;
        }
        return "ListNode{" +
                "val=" + val +
                ", next=" + nextValue +
                '}';
    }
}
