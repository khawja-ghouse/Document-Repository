package com.skg.stackdemo;

public class Stack {

	int[] array = null;
	int top = -1;
	int capacity = 0;

	public Stack(int size) {
		array = new int[size];
		capacity = size;
	}

	public synchronized void push(int element) {
		if (isFull()) {
			System.out.println("STACK FULL");
			// terminates the program
			System.exit(1);
		} else {
			top++;
			array[top] = element;
		}

	}

	public synchronized int pop() {
		int temp = 0;
		if (isEmpty()) {
			System.out.println("STACK EMPTY");
			// terminates the program
			System.exit(1);
		} else {
			temp = array[top];
			array[top] = 0;
			top--;
			return temp;
		}
		return temp;

	}

	private boolean isFull() {
		return top == capacity - 1;
	}

	private boolean isEmpty() {
		return top == -1;
	}

	// display elements of stack
	public void printStack() {
		for (int i = 0; i <= top; i++) {
			System.out.println(array[i] + ", ");
		}
	}

	// return size of the stack
	public int getSize() {
		return top + 1;
	}
}
