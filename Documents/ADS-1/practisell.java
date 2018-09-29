import java.util.*;
class practisell{
	String[] array;
	int n;
	practisell() {
		array = new String[10];
		n = 0;
	}
	void push(String item) {
		array[n++] = item;
	}
	String pop() {
		if (isEmpty()) {
			return null;
		}
		String s = array[--n];
		return s;
	}
	boolean isEmpty() {
		return (n==0);
	}
	int size() {
		return n;
	}
}
class Node{
	String data;
	Node next;
	Node() {

	}
	Node(String value) {
		data = value;
		next = null;
	}
}
class LinkedList {
	Node start;
	int n;
	LinkedList() {
		n = 0;
	}
	void insert(String value) {
		Node obj = new Node(value);
		if (n == 0) {
			start = obj;
		}
		Node temp = start;
		while(temp.next != null) {
			temp = temp.next;
		}
		temp.next = obj;
	}
	Node delete(String value) {
		temp = start;
		while (temp.next != null) {
			if (temp == value) {
				previous.next = temp.next;
				start = start.next;
			}
			previous = temp;
			temp = temp.next;
		}
	}
	
}