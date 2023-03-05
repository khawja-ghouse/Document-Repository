package com.skg.queue.normalqueue;

public class QueueTest {

	public static void main(String[] args) {
		CircularQueue queue = new CircularQueue(5);

		queue.enqueue(10);
		queue.enqueue(9);
		queue.enqueue(8);
		queue.enqueue(7);
		queue.enqueue(6);
		queue.printStack();
		System.out.println("Get the top element ::" + queue.deQueue());
		queue.printStack();
		System.out.println("Get the top element ::" + queue.deQueue());
		queue.printStack();
		System.out.println("Get the top element ::" + queue.deQueue());
		queue.printStack();
		queue.enqueue(8);
		queue.enqueue(9);
		queue.enqueue(10);
		queue.printStack();
	}
}
