package com.skg.binarytree;

public class Node {
	int data;
	Node left, right;

	public Node(int data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return ""+data;
	}
}
