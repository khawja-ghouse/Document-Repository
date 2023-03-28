package com.skg.binarytree;

public class BinaryTreeTesting {

	public static void main(String[] args) {

		BinaryTree binaryTree = new BinaryTree();

		binaryTree.addNewNode(10);
		binaryTree.addNewNode(9);
		binaryTree.addNewNode(12);
		binaryTree.addNewNode(6);
		binaryTree.addNewNode(5);
		binaryTree.addNewNode(6);
		binaryTree.addNewNode(11);

		binaryTree.preOrderTraversal(binaryTree.root);

		// System.out.println(binaryTree.root);
	}
}

// Binary tree can have 

// In Binary search trees, the order of nodes are as: leftnode < parentnode < rightnode
//. So, your code will always run into error if both left and right of a parent node is same.
