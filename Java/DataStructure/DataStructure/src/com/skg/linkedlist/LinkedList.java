package com.skg.linkedlist;

public class LinkedList {

	/** This is the only field of the class. It holds the head of the list */
	ListNode head;

	/** Length of the linked list. */
	private int length;

	/** This class has a default constructor: */
	public LinkedList() {
		length = 0;
	}

	/** Return the first node in the list. */
	public synchronized ListNode getHead() {
		return head;
	}

	// Make the node as head node.
	public synchronized void insertAtBeginning(ListNode listNode) {
		// This should be always the first step
		listNode.setNext(head);
		head = listNode;
		length++;
	}

	/** Insert a node at the end of the list. */
	public synchronized void insertAtEnd(ListNode node) {
		if (head == null) {
			head = node;
		} else {
			ListNode p, q;
			for (p = head; (q = p.getNext()) != null; p = q) {
			}
			p.setNext(node);
		}
		length++;
	}

	/**
	 * Return a string representation of this collection, in the form
	 * ["str1","str2",...].
	 */
	@Override
	public String toString() {
		String result = "[";
		if (head == null) {
			return result + "]";
		}
		result = result + head.getData();
		ListNode temp = head.getNext();
		while (temp != null) {
			result = result + "," + temp.getData();
			temp = temp.getNext();
		}
		return result + "]";
	}

	public synchronized void insertAtPosition(int data, int position) {
		if (position < 0) {
			position = 0;
		}
		if (position > length) {
			position = length;
		}

		// if the list is empty, make it to be the only element
		if (head == null) {
			head = new ListNode(data);
		} else if (position == 0) {
			ListNode temp = new ListNode(data);
			temp.next = head;
			head = temp;
		} else {
			ListNode temp = head;

			for (int i = 1; i < position; i++) {
				temp = temp.getNext();
			}
			ListNode newListNode = new ListNode(data);
			newListNode.next = temp.next;
			temp.setNext(newListNode);
		}
		length++;
	}

	public int getPosition(int data) {
		// go looking for the data
		ListNode temp = head;
		int pos = 0;
		while (temp != null) {
			if (temp.getData() == data) {
				// return the position if found
				return pos;
			}
			pos += 1;
			temp = temp.getNext();
		}
		// else return -1
		return Integer.MIN_VALUE;
	}

	// TODO
	// 1. Remove from start
	// 2. Remove from end
	// 3. Remove from given position
	// 4. Get Last
	// 5. public synchronized void removeMatched(ListNode node)

	public ListNode removeFromStart() {
		// 1. remove the head and update the head
		ListNode p, q;
		p = head;
		head = null;
		head = p.getNext();

		return p;
	}

	public ListNode removeFromEnd() {
		// traverse till the end and remove the end and make the lastButOne as end;
		ListNode p, q = null, lastButOne = null, last = null;
		if (head == null) {
			return null;
		}
		if (length == 1) {
			p = head;
			head = null;
			length -= 1;
			return p.getNext();
		}
		for (p = head; (q = p.getNext()) != null; p = q) {
			lastButOne = p;
			last = p.getNext();
		}
		lastButOne.setNext(null);
		length -= 1;

		return last;
	}

	public ListNode removeNodeFromPosition(int position) {
		if (position < 0) {
			position = 0;
		}

		if (position > length) {
			position = length;
		}

		if (head == null) {
			return null;
		} else if (position == 0) {
			return removeFromStart();
		} else {
			ListNode temp = head, removedNode = null;

			for (int i = 1; i < position; i++) {
				temp = temp.getNext();
			}
			removedNode = temp.getNext();
			ListNode newListNode = removedNode;
			temp.next = removedNode.getNext();
			removedNode = null;
			length--;
			return newListNode;

		}

	}

	/** Return the current length of the list. */
	public int length() {
		return length;
	}

	/** Get the node of the given position */
	public synchronized ListNode getNodeAtPosition(int position) {
		if (position < 0) {
			position = 0;
			return head;
		}
		if (position > length) {
			position = length;
		}

		ListNode temp = head;

		for (int i = 1; i < position; i++) {
			temp = temp.getNext();
		}

		return temp.getNext();
	}

	/** Size of the list. */
	public boolean isEmpty() {
		return length == 0;
	}

	/** Remove everything from the list. */
	public void clearList() {
		head = null;
		length = 0;
	}

}
