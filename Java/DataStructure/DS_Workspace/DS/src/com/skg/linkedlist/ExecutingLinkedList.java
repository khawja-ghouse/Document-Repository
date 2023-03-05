package com.skg.linkedlist;

public class ExecutingLinkedList {

	public static void main(String[] args) {

		LinkedList linkedList = new LinkedList();

		linkedList.insertAtPosition(20, 0);// This becomes head
		linkedList.insertAtPosition(21, 1);// 1
		linkedList.insertAtPosition(22, 2);// 2
		linkedList.insertAtPosition(23, 3);// 3

		System.out.println("Get Head of the List :" + linkedList.getHead());
		System.out.println("Get Node at position 3 :" + linkedList.getNodeAtPosition(3));
		System.out.println("Get Node at position 1 :" + linkedList.getNodeAtPosition(1));

		System.out.println("Complete Linked List :" + linkedList);

		linkedList.removeFromStart();

		System.out.println("Get Head of the List :" + linkedList.getHead());

		System.out.println("Complete Linked List :" + linkedList);

		System.out.println(linkedList.removeFromEnd());

		System.out.println("After Remove from the end :" + linkedList);

		System.out.println("Get position of 22 :" + linkedList.getPosition(22));

		linkedList.insertAtPosition(24, 2);// 2

		linkedList.insertAtPosition(25, 3);// 3

		System.out.println("Complete List ::" + linkedList);

		linkedList.removeNodeFromPosition(2);

		System.out.println("After Removing Node at position 2 :" + linkedList);

		System.out.println("Complete List ::" + linkedList);
	}
}
