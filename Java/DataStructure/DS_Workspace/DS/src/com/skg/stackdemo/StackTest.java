package com.skg.stackdemo;

public class StackTest {

	public static void main(String[] args) {

		Stack stack = new Stack(5);

		stack.push(21);
		stack.push(22);
		stack.push(23);
		stack.push(24);
		stack.push(25);
		System.out.println("Stack ::");
		
		stack.printStack();
		System.out.println("Remove item from stack ::" + stack.pop());
		stack.push(26);
		stack.printStack();

	}
}
