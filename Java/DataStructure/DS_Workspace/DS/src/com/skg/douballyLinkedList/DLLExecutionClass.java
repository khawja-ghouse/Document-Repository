package com.skg.douballyLinkedList;

public class DLLExecutionClass {

	public static void main(String[] args) {

		DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

		doublyLinkedList.insertAtBeginning(21);

		System.out.println(doublyLinkedList);

		doublyLinkedList.insertAtLast(22);
		doublyLinkedList.insertAtLast(23);
		doublyLinkedList.insertAtLast(24);

		System.out.println(doublyLinkedList);

		doublyLinkedList.insertAtBeginning(25);

		System.out.println(doublyLinkedList);

		System.out.println("PrintList in reverse order ::" + doublyLinkedList.traverseInReverseOrder());

		System.out.println(doublyLinkedList.getHead());
		
		doublyLinkedList.insertAtBeginning(98);
		
		System.out.println(doublyLinkedList.getHead());
	}
}
