import java.util.Scanner;
import java.util.Stack;
class Node {
	int data;
	Node next;
	Node() {
		data = 0;
		next = new Node();
	}
}
class Steque {
	Node head;
	int size = 0;
	void push(int element) {
		Node node = new Node();
		size++;
		if (head == null) {
			node.data = element;
			node.next = null;
			head = node;
		} else {
			node.data = element;
			node.next = head;
			head = node;
		}
	}
	void pop() {
		if (size == 0) {
			System.out.println("Steque is empty.");
		}
		Node node = new Node();
		Node temp = head;
		temp = temp.next;
		head.next = null;
		head = temp;
		size--;
	}
	void enqueue(int element) {
		Node node = new Node();
		size++;
		if (head == null) {
			node.data = element;
			node.next = null;
			head = node;
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			node.data = element;
			temp.next = node;
			node.next = null;
		}
	}
	void print() {
		if (size <= 0) {
			System.out.println("Steque is empty.");
			return;
		}
		if (head.next == null) {
			System.out.println(head.data);
			return;
		}
		Node temp = head;
		while (temp.next != null) {
			System.out.print(temp.data + ", ");
			temp = temp.next;
		}
		System.out.println(temp.data);
	}
}
class Solution {
	protected Solution() {

	}
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		int numberOfCases = sc.nextInt();
			Steque s = new Steque();
			while (sc.hasNext()) {
				String line = sc.next();
				if (line.equals("")) {
					break;
				}
					String[] tokens = line.split(" ");
					switch (tokens[0]) {
						case "push":
							s.push(Integer.parseInt(tokens[1]));
							s.print();
							break;
						case "pop":
							s.pop();
							s.print();
							break;
						case "enqueue":
							s.enqueue(Integer.parseInt(tokens[1]));
							s.print();
							break;
						default:				
					}
			}
		}

	}
