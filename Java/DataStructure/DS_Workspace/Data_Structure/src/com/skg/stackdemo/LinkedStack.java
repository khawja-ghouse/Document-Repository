package com.skg.stackdemo;

import java.util.EmptyStackException;

public class LinkedStack {
	private int lenght; // indicates the size of the linked list

	private ListNode top;
	
	// Constructor: Creates an empty stack.
	public LinkedStack() {
		lenght = 0;
		top = null;
	}

	// Adds the specified data at the top of this stack.
	public void push(int data) {
		ListNode listNode = new ListNode(data);
		listNode.setNext(top);
		top = listNode;
		lenght++;
	}

	// Removes the data at the top of this stack and returns a reference to it.
	// Throws an EmptyStackException if the stack is empty.
	public int pop() throws EmptyStackException {
		if (isEmpty())
			throw new EmptyStackException();
		int result = top.getData();
		top = top.getNext();
		lenght--;
		return result;
	}

	// Returns a reference to the data at the top of the stack
	// The data is not removed form the stack. Throws an EmptyStackException if the
	// stack is empty.
	public int peek() throws EmptyStackException {
		if (isEmpty())
			throw new EmptyStackException();
		return top.getData();
	}

	// Returns true if this stack is empty and false otherwise
	public boolean isEmpty() {
		return (lenght == 0);
	}

	// Returns the number of elements in the stack
	public int size() {
		return lenght;
	}

}
