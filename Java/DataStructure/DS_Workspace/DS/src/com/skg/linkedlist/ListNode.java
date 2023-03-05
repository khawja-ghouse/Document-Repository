package com.skg.linkedlist;

public class ListNode {

	public int data;
	public ListNode next;

	// create an empty node
	public ListNode() {
		this.next = null;
		this.data = Integer.MIN_VALUE;
	}

	public ListNode(int data) {
		this.data = data;
		this.next = null;
	}

	// Set next
	public void setNext(ListNode node) {
		this.next = node;
	}

	// Returns the node that follows this one.
	public ListNode getNext() {
		return next;
	}

	// Returns the data stored in this node.
	public int getData() {
		return data;
	}

	// Sets the data stored in this node.
	public void setdata(int elem) {
		data = elem;
	}

	// Sets the data stored in this node.
	public String toString() {
		return Integer.toString(data);
	}

}
