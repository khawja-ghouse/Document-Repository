package com.skg.douballyLinkedList;

import com.skg.linkedlist.ListNode;

public class DListNode {

	int data;
	DListNode prev;
	DListNode next;

	// create an empty node
	public DListNode() {
		this.next = null;
		this.prev = null;
		this.data = Integer.MIN_VALUE;
	}

	public DListNode(int data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}

	public int getData() {
		return data;
	}

	// Sets the data stored in this node.
	public String toString() {
		return Integer.toString(data);
	}

	public DListNode getNext() {
		// TODO Auto-generated method stub
		return next;
	}

	public DListNode getPrevious() {
		// TODO Auto-generated method stub
		return prev;
	}

}
