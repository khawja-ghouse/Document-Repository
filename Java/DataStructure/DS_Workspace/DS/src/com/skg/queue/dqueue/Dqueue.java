package com.skg.queue.dqueue;

public class Dqueue {

	private int front;
	private int rear;
	private int size;
	private int array[];

	public Dqueue(int size) {
		array = new int[size];
		front = -1;
		rear = 0;
		this.size = size;
	}

	// Checks whether Deque is full or not.
	boolean isFull() {
		return ((front == 0 && rear == size - 1) || front == rear + 1);
	}

	// Checks whether Deque is empty or not.
	boolean isEmpty() {
		return (front == -1);
	}

	public void insertFront(int data) {
		// check whether Dequeue if full or not
		if (isFull()) {
			System.out.println("Overflow");
			return;
		}
		// If queue is initially empty
		if (front == -1) {
			front = 0;
			rear = 0;
		} else if (front == 0)
			front = size - 1;
		else
			front = front - 1;
		array[front] = data;
	}

	public void insertRare(int data) {
		// check whether Dequeue if full or not
		if (isFull()) {
			System.out.println(" Overflow ");
			return;
		}
		// If queue is initially empty
		if (front == -1) {
			front = 0;
			rear = 0;
		} else if (rear == size - 1) {
			rear = 0;
		} else
			rear = rear + 1;

		array[rear] = data;

	}

	public void deleteFront() {
		if (isEmpty()) {
			System.out.println(" Empty ");
			return;
		}
		// If queue is initially empty
		if (front == rear) {
			front = -1;
			rear = -1;
		} else if (front == size - 1) {
			front = 0;
		} else
			front = front + 1;
	}

	public void deleteRear() {
		if (isEmpty()) {
			System.out.println(" Empty ");
			return;
		}
		// If queue is initially empty
		if (rear == front) {
			front = -1;
			rear = -1;
		} else if (rear == 0) {
			rear = size - 1;
		} else
			rear = rear - 1;
	}

	// Returns front element of Deque
	int getFront() {
		// check whether Deque is empty or not
		if (isEmpty()) {
			System.out.println(" Underflow");
			return -1;
		}
		return array[front];
	}

	// function return rear element of Deque
	int getRear() {
		// check whether Deque is empty or not
		if (isEmpty() || rear < 0) {
			System.out.println(" Underflow\n");
			return -1;
		}
		return array[rear];
	}
}
