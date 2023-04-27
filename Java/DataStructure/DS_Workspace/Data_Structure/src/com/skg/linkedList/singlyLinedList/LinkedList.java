package com.skg.linkedList.singlyLinedList;

import java.util.List;

public class LinkedList {

	ListNode head;
	int length = 0;

	public void insertAtStart(int data) {
		ListNode listNode = new ListNode(data);
		// Check if head is empty, if empty
		if (head == null) {
			head = listNode;
			head.setNext(null);
		} else {
			ListNode temp = head;
			head = listNode;
			head.setNext(temp);
		}
		length++;
	}

	public void insertAtEnd(int data) {
		ListNode listNode = new ListNode(data);
		// Check if head is empty, if empty
		if (head == null) {
			head = listNode;
			head.setNext(null);
		} else {
			ListNode temp = head;
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}

			temp.setNext(listNode);
		}
		length++;
	}

	public void insertAtPosition(int position, int data) {
		ListNode listNode = new ListNode(data);
		if (position == 1) {
			insertAtStart(position);
		} else {
			ListNode positionNode = head, tempNode = head.getNext();
			for (int i = 1; i != position - 1; positionNode = positionNode.getNext(), i++) {
				System.out.println(positionNode.getData());
				tempNode = positionNode.getNext();
			}
			tempNode = tempNode.getNext();
			positionNode.setNext(listNode);
			listNode.setNext(tempNode);
		}
	}

	public void printLinkedList() {

		ListNode currentNode = head;

		while (currentNode != null) {
			System.out.print(currentNode+ ",");
			currentNode = currentNode.getNext();
		}
		System.out.println();
	}

	public ListNode deleteNodeAtBegining() {
		ListNode node = head;

		if (node != null) {
			head = node.getNext();
			node.setNext(null);
		}
		// System.out.println(node);
		return node;
	}

	public ListNode deleteNodeAtEnd() {

		if (head == null)
			return null;

		ListNode p = head, next = head.getNext(), q = null;
		if (head.getNext() == null) {
			head = null;
			return p;
		}

		while ((next = p.getNext()) != null) {
			q = p;
			p = next;
		} // next = 1, q = 2, p = 3
		q.setNext(null);

		return p;
	}

}
