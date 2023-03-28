package com.skg.queue.dqueue;

public class DqueueTesting {

	public static void main(String[] args) {
		Dqueue dqueue = new Dqueue(5);

		dqueue.insertFront(10);
		dqueue.insertFront(9);
		dqueue.insertFront(8);
		dqueue.insertFront(7);

		dqueue.printDqueue(); // 10(rear) 0 9(front) 8 7
		dqueue.deleteFront(); // delete front
		dqueue.printDqueue(); // 10(rear) 0 0 8(front) 7
		dqueue.deleteRear();  // delete from rear
		dqueue.printDqueue(); // 0 0 0 8 7
		
		dqueue.insertRare(10); // insert rear
		dqueue.printDqueue();  // 10(rear) 0 0 8(front) 7

	}
}
