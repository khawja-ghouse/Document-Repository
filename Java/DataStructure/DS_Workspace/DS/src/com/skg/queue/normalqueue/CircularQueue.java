package com.skg.queue.normalqueue;

public class CircularQueue {

	int[] queueArray = null;
	int front = 0;
	int rear = 0;
	int capacity = 0;

	public CircularQueue(int capacity) {
		this.capacity = capacity;
		front = 0;
		rear = capacity - 1;
		queueArray = new int[capacity];
	}

	public void enqueue(int item) {
		if (isFull()) {
			System.out.println("QUEUE FULL");
			System.exit(1);
		} else {
			if (front == -1)
				front = 0;
			this.rear = (this.rear + 1) % this.capacity;
			this.queueArray[this.rear] = item;
		}
	}

	public int deQueue() {
		int temp = 0;
		if (isEmpty()) {
			System.out.println("QUEUE EMPTY");
			System.exit(1);
		} else {
			temp = queueArray[front];
			this.front = (this.front + 1) % capacity;
			System.out.println("front value :" + this.front);
			return temp;
		}
		return temp;
	}

	public int front() {
		if (isEmpty())
			return Integer.MIN_VALUE;
		else
			return queueArray[this.front];
	}

	public int rear() {
		if (isEmpty())
			return Integer.MIN_VALUE;
		else
			return queueArray[this.rear];
	}

	// Check if the queue is full
	private boolean isFull() {
		if (front == 0 && rear == capacity - 1) {
			return true;
		}
		if (front == rear + 1) {
			return true;
		}
		return false;
	}

	// Check if the queue is empty
	boolean isEmpty() {
		if (front == -1)
			return true;
		else
			return false;
	}

	// display elements of stack
	public void printStack() {
		System.out.println("Queue Data ::");
		// Print the data from front to rear
		int temp = front;
		while (temp != rear) {
			System.out.print(this.queueArray[temp] + ",");
			temp = (temp + 1) % capacity;
		}
		System.out.print(this.queueArray[temp]);
		System.out.println();
	}

}
