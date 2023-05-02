package com.skg.queue;

public class LinkedListQueue {

	ListNode front, rare;
	int length;

	public LinkedListQueue() {
		length = 0;
		front = rare = null;
	}

	public void enqueue(int data) {

	}

	public boolean isEmpty() {
		return length == 0;
	}

	public int size() {
		return length;
	}
}
