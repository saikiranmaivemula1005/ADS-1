class Node {
	int data;
	Node next;
}
public class LinkedListImp {
	public static void main(String[] args) {
	Linkedlist list = new Linkedlist();		
	list.insert(5);

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
	void show() {
		Node node = head;
		while (node.next != null) {
			System.out.println(node.data);
			node = node.next;
		}
	}
}