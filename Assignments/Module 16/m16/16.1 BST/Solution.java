import java.util.Scanner;
/**
 * Class for book.
 */
class Book {
	/**
	 * name of the book.
	 */
	String name;
	/**
	 * name of the author.
	 */
	String author;
	/**
	 * price of the book.
	 */
	float price;
	/**
	 * constructor 
	 *
	 * @param      n     { name }
	 * @param      a     { author }
	 * @param      p     { price }
	 */
	Book(String n, String a, float p) {
		this.name = n;
		this.author = a;
		this.price = p;
	}
	public String getName() {
		return this.name;
	}
}
/**
 * Class for binary search tree.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class BinarySearchTree<Key extends Comparable<Key>, Value> {
	BinarySearchTree() {

	}
	private Node root;
	private class Node {
		private Book key;
		private int value;
		private Node left, right;
		/**
		 * Constructs the object.
		 *
		 * @param      k     { book }
		 * @param      v     { value }
		 */
		Node(Book k, int v) {
			this.key = k;
			this.value = v;
		}
	}
	/**
	 * put method
	 *
	 * @param      key    The key
	 * @param      value  The value
	 */
	public void put(Book key, int value) {
		 root = put(root, key, value);
	}
	/**
	 * put overloaded method
	 *
	 * @param      x      { Node }
	 * @param      key    The key
	 * @param      value  The value
	 *
	 * @return     { returns the node }
	 */
	private Node put(Node x, Book key, int value) {
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
	/**
	 * get method.
	 *
	 * @param      key   The key
	 *
	 * @return     { returns integer value }
	 */
	public Integer get(Book key) {
		Node x = root;
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
/**
 * Class for solution.
 */
class Solution {
	/**
	 * Constructs the object.
	 */
	protected Solution() {

	}
	/**
	 * main method.
	 *
	 * @param      args  The arguments
	 */
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		Scanner sc = new Scanner(System.in);	
		while (sc.hasNext()) {
			String[] tokens = sc.next().split(",");
			switch (tokens[0]) {
				case "put":
					Book key = new Book(tokens[1], tokens[2], Float.parseFloat(tokens[3]));
					int value = Integer.parseInt(tokens[4]);
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