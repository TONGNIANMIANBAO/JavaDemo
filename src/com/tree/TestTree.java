package com.tree;

import java.util.ArrayList;
import java.util.List;

public class TestTree {

	private Node root;
	private List<Node> nodes = new ArrayList<>();

	private class Node {
		private String data;
		private Node lChild;
		private Node rChild;

		public Node(String data, Node lChild, Node rChild) {
			this.data = data;
			this.lChild = lChild;
			this.rChild = rChild;
		}
	}

	public TestTree() {
		Node z = new Node("z", null, null);
		Node x = new Node("x", null, null);
		Node y = new Node("y", null, null);
		Node g = new Node("g", null, z);
		Node f = new Node("f", null, null);
		Node e = new Node("e", g, null);
		Node d = new Node("d", x, y);
		Node c = new Node("c", e, f);
		Node b = new Node("b", d, null);
		Node a = new Node("a", b, c);
		this.root = a;
	}

	/**
	 * 前序遍历，先遍历根节点后左右子树 序指的是根节点顺序
	 * 
	 * @param node
	 */
	public void preOrder(Node node) {
		nodes.add(node);
		if (node.lChild != null) {
			preOrder(node.lChild);
		}
		if (node.rChild != null) {
			preOrder(node.rChild);
		}
	}

	public void inOrder(Node node) {
		if (node.lChild != null) {
			inOrder(node.lChild);
		}
		nodes.add(node);
		if (node.rChild != null) {
			inOrder(node.rChild);
		}
	}

	public void postOrder(Node node) {
		if (node.lChild != null) {
			postOrder(node.lChild);
		}
		if (node.rChild != null) {
			postOrder(node.rChild);
		}
		nodes.add(node);
	}

	public int getTreeDepth(Node node) {
		int left = 0;
		int right = 0;
		if (node.lChild == null && node.rChild == null) {
			return 1;
		}
		if (node.lChild != null) {
			left = getTreeDepth(node.lChild);
		}
		if (node.rChild != null) {
			right = getTreeDepth(node.rChild);
		}
		return left > right ? left + 1 : right + 1;

	}

	public static void main(String[] args) {
		TestTree tree = new TestTree();
		tree.postOrder(tree.root);
		for (Node node : tree.nodes) {
			System.out.println(node.data);
		}

		int depth = tree.getTreeDepth(tree.root);
		System.out.println(depth);
	}
}
