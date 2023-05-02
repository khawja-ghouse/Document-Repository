package com.skg.queue;

public class ListNode {

	private int data;
	private ListNode next;

	public ListNode(int data) {
		this.data = data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public int getData() {
		return this.data;
	}

	public void setNext(ListNode listNode) {
		this.next = listNode;
	}

	public ListNode getNext() {
		return this.next;
	}

	@Override
	public String toString() {
		return data + "";
	}

}
