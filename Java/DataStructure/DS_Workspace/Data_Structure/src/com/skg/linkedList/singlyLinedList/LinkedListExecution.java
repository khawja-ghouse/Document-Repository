package com.skg.linkedList.singlyLinedList;

public class LinkedListExecution {

	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();

		linkedList.insertAtStart(5);
		linkedList.insertAtStart(10);
		linkedList.insertAtStart(15);
		linkedList.insertAtStart(20);
		linkedList.printLinkedList();
		linkedList.insertAtEnd(25);
		linkedList.printLinkedList();
		linkedList.insertAtStart(1200);
		linkedList.printLinkedList();
		linkedList.insertAtPosition(3, 21);
		linkedList.printLinkedList();
		linkedList.insertAtPosition(2, 81);
		linkedList.printLinkedList();
		System.out.println(linkedList.deleteNodeAtBegining());
		linkedList.printLinkedList();
		System.out.println(linkedList.deleteNodeAtEnd());
		linkedList.printLinkedList();
	}

}
