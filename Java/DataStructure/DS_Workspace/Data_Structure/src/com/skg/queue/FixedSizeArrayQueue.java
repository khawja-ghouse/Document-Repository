package com.skg.queue;

public class FixedSizeArrayQueue {

	private int[] queueRep;

	private int size, front, rear;

	private static final int CAPACITY = 10;

	// Initialize the queue to use array of the default length
	public FixedSizeArrayQueue() {
		queueRep = new int[CAPACITY];
		size = front = rear = 0;
	}

	// Initialize the queue to use array of the given length
	public FixedSizeArrayQueue(int cap) {
		queueRep = new int[cap];
		size = front = rear = 0;
	}

	public void enQueue(int data) {
		if (size == CAPACITY)
			throw new IllegalStateException("Queue is full: Overflow");
		else {
			size++;
			queueRep[rear] = data;
			rear = (rear + 1) % CAPACITY;
		}
	}

	public int deQueue() {
		if (size == 0)
			throw new IllegalStateException("Queue is Empty: Underflow");
		else {
			size--;
			int data = queueRep[front % CAPACITY];
			queueRep[front] = Integer.MIN_VALUE;
			front = (front + 1) % CAPACITY;
			return data;
		}
	}

	public boolean isFull() {
		return size == CAPACITY;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public String toString() {
		String result = "[";

		for (int i = 0; i < size; i++) {
			result += Integer.toString(queueRep[(front + 1) % CAPACITY]);

			if (i < size - 1) {
				result += ",";
			}
		}

		result += "]";
		return result;
	}

}
