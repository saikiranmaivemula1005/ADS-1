class Node {
	int data;
	Node next;
}
public class Problemll {
	public static void main(String[] args) {
	Linkedlist list = new Linkedlist();		
	list.insert(5);
	list.insert(50);
	list.insert(10);
	list.insertAtStart(25);
	list.insertAt(2, 55);
	list.deleteAt(1);
	list.show();

	}
}

class Linkedlist {
	Node head;
	void insert(int data) {
		Node node = new Node();
		node.data = data;
		node.next = null;
		if (head == null) {
			head = node;
		} else {
			Node n = head;
			while (n.next != null) {
				n = n.next;
			}
			n.next = node;
		}

	}
	void insertAtStart(int data) {
		Node node = new Node();
		node.data = data;
		node.next = null;
		node.next = head;
		head = node;
	}
	void insertAt(int index, int data) {
		Node node = new Node();
		node.data = data;
		node.next = null;
		if (index == 0) {
			insertAtStart(data);
		}
		else {
			Node n = head;
			for (int i = 0; i < index - 1; i++) {
				n = n.next;
			}
		node.next = n.next;
		n.next = node; 
		}
	}
	void deleteAt(int index) {
		if (index == 0) {
			head = head.next;
		}
		else {
			Node n = head;
			Node n1 = null;
			for (int i = 0; i < index - 1; i++) {
				n = n.next;
			}
			n1 = n.next;
			n.next = n1.next;
			System.out.println("n1" + n1.data);
		}
	}
	void show() {
		Node node = head;
		while (node.next != null) {
			System.out.println(node.data);
			node = node.next;
		}
		System.out.println(node.data);
	}
}