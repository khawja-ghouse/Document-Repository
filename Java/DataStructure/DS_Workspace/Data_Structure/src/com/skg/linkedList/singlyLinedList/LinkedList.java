package com.skg.linkedList.singlyLinedList;

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
		System.out.println("inside printLinkedList");
		if (head != null) {
			ListNode temp = head;
			while (temp.getNext() != null) {
				System.out.println(temp.getData());
				temp = temp.getNext();
			}
			System.out.println(temp.getData());
		}
	}

}
