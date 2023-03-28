package com.skg.binarytree;

public class BinaryTree {

	Node root;

	public void addNewNode(int data) {
		Node newNode = new Node(data);

		if (root == null) {
			root = newNode;
		} else {
			Node focusNode = root;
			Node parent = null;

			while (true) {
				parent = focusNode;
				if (data < focusNode.data) {
					focusNode = focusNode.left;

					if (focusNode == null) {
						parent.left = newNode;
						return;
					}
				} else {
					focusNode = focusNode.right;
					if (focusNode == null) {
						parent.right = newNode;
						return;
					}
				}
			}
		}
	}

	public void preOrderTraversal(Node focusNode) {
		if (focusNode != null) {
			System.out.print(focusNode.data + " ");
			preOrderTraversal(focusNode.left);
			System.out.println();
			preOrderTraversal(focusNode.right);
		}
		//System.out.println();
	}
}
