package com.skg.queue;

public class LinkedListQueue {

	ListNode front, rare;
	int length;

	public LinkedListQueue() {
		length = 0;
		front = rare = null;
	}

	public void enqueue(int data) {
		ListNode listNode = new ListNode(data);
		if (isEmpty())
			front = listNode;
		else
			rare.setNext(listNode);
		rare = listNode;
		length++;
	}

	public int deQueue() throws Exception {
		if (isEmpty())
			throw new Exception();
		int result = front.getData();
		front = front.getNext();
		length--;
		if (isEmpty())
			rare = null;

		return result;
	}

	public int first() throws Exception {
		if (isEmpty())
			throw new Exception();
		return front.getData();
	}

	public boolean isEmpty() {
		return length == 0;
	}

	public int size() {
		return length;
	}

	public String toString() {
		String result = "";
		ListNode currentNode = front;

		while (currentNode != null) {
			result = result + currentNode.getNext();
		}
		return result;
	}
}
