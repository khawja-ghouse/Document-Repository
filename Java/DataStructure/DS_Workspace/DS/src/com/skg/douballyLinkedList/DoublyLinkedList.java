package com.skg.douballyLinkedList;

public class DoublyLinkedList {

	private DListNode head;

	private int length;

	public DoublyLinkedList() {
		length = 0;
	}

	public synchronized DListNode getHead() {
		return head;
	}

	@Override
	public String toString() {
		String result = "[";
		if (head == null) {
			return result + "]";
		}
		result = result + head.getData();
		DListNode temp = head.getNext();
		while (temp != null) {
			result = result + "," + temp.getData();
			temp = temp.getNext();
		}
		return result + "]";
	}

	public synchronized void insertAtBeginning(int data) {

		// 1. allocate data
		// 2. put in the data

		DListNode newNode = new DListNode(data);
		/*
		 * 3. Make next of new node as head and previous as NULL
		 */
		newNode.next = head;
		newNode.prev = null;

		/* 4. change prev of head node to new node */
		if (head != null)
			head.prev = newNode;

		/* 5. move the head to point to the new node */
		head = newNode;

		length++;
	}

	public synchronized void insertAtLast(int data) {

		DListNode newNode = new DListNode(data);

		DListNode temp = null, last = null;
		temp = head;

		if (head.getNext() == null) {
			head.next = newNode;
			newNode.prev = head;
			newNode.next = null;
		} else {
			while ((last = temp.getNext()) != null) {
				temp = last;
			}
			last = temp;
			last.next = newNode;
			newNode.prev = last;

			newNode.next = null;
		}

		length++;

	}

	public synchronized String traverseInReverseOrder() {
		String result = "[";
		if (head == null) {
			return result + "]";
		}
		// result = result + head.getData();
		DListNode temp = head.getNext();
		DListNode last;

		while ((last = temp.getNext()) != null) {
			temp = last;
		}
		last = temp;

		while (last != null) {
			result = result + last.getData() + ",";
			last = last.getPrevious();
		}
		return result + "]";
	}

}
