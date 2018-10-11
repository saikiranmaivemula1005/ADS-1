import java.util.Scanner;
class Book {
	String name;
	String author;
	float price;
	Book(String n, String a, float p) {
		this.name = n;
		this.author = a;
		this.price = p;
	}
	public String getName() {
		return this.name;
	}
	public String getAuthor() {
		return this.author;
	}
	public float getprice() {
		return this.price;
	}
}


class BinarySearchTree<Key extends Comparable<Key>, Value> {
	BinarySearchTree() {

	}
	private Node root;
	private class Node {
		private Book key;
		private String value;
		private Node left, right;
		Node(Book k, String v) {
			this.key = k;
			this.value = v;
		}
	}
	public void put(Book key, String value) {
		 root = put(root, key, value);
	}
	private Node put(Node x, Book key, String value) {
		if (x == null) {
			return new Node(key, value);
		}
		int cmp = key.getName().compareTo(x.key.getName());
		if (cmp < 0) {
			x.left = put(x.left, key, value);
		}
		if (cmp > 0) {
			x.right = put(x.right, key, value);
		} else {
			x.value = value;
		}
		return x;
	}
	public String get(Book key) {
		Node x = root;
		if (x == null) {
			System.out.println("null");
		}
		while (x != null) {
			int cmp = key.getName().compareTo(x.key.getName());
				if (cmp < 0) {
					x = x.left;
				}
				if (cmp > 0) {
					x = x.right;
				} else {
					return x.value;
				}
			}
			return null;
		}
	}

class Solution {
	protected Solution() {

	}
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		Scanner sc = new Scanner(System.in);	
		while (sc.hasNext()) {
			String[] tokens = sc.next().split(",");
			switch (tokens[0]) {
				case "put":
					Book key = new Book(tokens[1], tokens[2], Float.parseFloat(tokens[3]));
					String value = tokens[4];
					bst.put(key, value);
					break;
				case "get":
				    key = new Book(tokens[1], tokens[2], Float.parseFloat(tokens[3]));
					System.out.println(bst.get(key));
					break;
				default:
			}
		}
	}
}