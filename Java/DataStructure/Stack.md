## What is stack?
A stack is a simple data structure used for storing data (similar to Linked Lists). In a stack, the order in which the data arrives is important. A pile of plates in a cafeteria is a good example of a stack. The plates are added to the stack as they are cleaned and they are placed on the top. When a plate, is required it is taken from the top of the stack. The first plate placed on the stack is the last one to be used.

## Defination: 
A stack is an ordered list in which insertion and deletion are done at one end, called top. The last element inserted is the first one to be deleted. Hence, it is called the Last in First out (LIFO) or First in Last out (FILO) list.
Special names are given to the two changes that can be made to a stack. When an element is inserted in a stack, the concept is called push, and when an element is removed from the stack, the concept is called pop. Trying to pop out an empty stack is called underflow and trying to push an element in a full stack is called overflow. Generally, we treat them as exceptions. As an example, consider the snapshots of the stack.

![[Pasted image 20230425110548.png]]

## Stack ADT
The following operations make a stack an ADT. For simplicity, assume the data is an integer type.

**Main stack operations**
 - **void push(int data):** insert data onto stack.
 - **int pop():** Removes and returns the last inserted elements from the stack.

**Auxiliary stack operations**
-  **int Top():** Returns the last inserted element without removing it.
-  **int Size():** Returns the number of elements stored in the stack. 
-  **int IsEmptyStack():** Indicates whether any elements are stored in the stack or not. 
-  **int IsFullStack():** Indicates whether the stack is full or not.

### Applications
- Balancing of symbols
- Infix-to-postfix conversion 
- Evaluation of postfix expression 
- mplementing function calls (including recursion) 
- Page-visited history in a Web browser [Back Buttons] 
- Undo sequence in a text editor 
- Matching Tags in HTMLand XML

### Implementation 
There are many ways of implementing stack ADT; below are the commonly used methods.
- Simple array based implementation.
- Dynamic array based implementation.
- Linked lists implementation.

### Linked list implementation

ListNode.java
```JAVA
package com.skg.stackdemo;

public class ListNode {
	private int data;
	private ListNode next;
	public ListNode(int data) {
	this.data = data;
}

public void setData(int data) {
	this.data = data;
}

public int getData() {
	return this.data;
}

public void setNext(ListNode listNode) {
	this.next = listNode;
}

public ListNode getNext() {
	return this.next;
}

@Override
public String toString() {
	return data + "";
}

}
```

LinkedStack.java
```JAVA
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

// Returns a reference to the data at the top of the stackn The data is not removed form the stack. Throws an EmptyStackException if the stack is empty.

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

public String toString(){
	String result = "";
	ListNode current = top;
	while(current != null){
		result = result + current.toString() + "\n";
		current = current.getNext();
	}
	return result;
}

}
```

### Performance

Let n be the number of elements in the stack. The complexities for operations with this representation can be given as:

![[Pasted image 20230425111225.png]]

### Stacks: Problem & Solutions
Problem-1 Discuss how stacks can be used for checkking balancing of sysmbols.

> **Algorithm**
> 	1. Create a stack.
> 	2. while (end of input is not reached)
> 		1. If the character read is not a symbol to be balanced, ignore it.
> 		2. If the character is an opening symbol like (, {, push it onto the stack
> 		3. If it is a closing symbol like ),],}, then if the stack is empty report an error. Otherwise pop the stack.
> 		4. If the symbol popped is not the corresponding opening symbol, report an error.
> 	3. At end of input, if the stack is not empty report an error.



ValidSymbolPattern.java

```JAVA
public static boolean isValidSymbolPattern(String s) {
	Stack<Character> stack = new Stack<>();
	if (s == null || s.length() == 0)
		return true;
	for (int i = 0; i < s.length(); i++) {
		if (s.charAt(i) == ')') {
			if (!stack.isEmpty() && stack.peek() == '(')
				stack.pop();
			else
				return false;
		} else if (s.charAt(i) == ']') {
			if (!stack.isEmpty() && stack.peek() == '[')
				stack.pop();
			else
				return false;
		} else if (s.charAt(i) == '}') {
			if (!stack.isEmpty() && stack.peek() == '{')
				stack.pop();
			else
				return false;
		} else {
			stack.push(s.charAt(i));
		}
	}
	if (stack.isEmpty())
		return true;
	else
		return false;
}
```

