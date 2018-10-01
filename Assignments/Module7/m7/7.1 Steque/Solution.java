import java.util.Scanner;
class Node {
	int data;
	Node next;
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
		head = head.next;
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

	boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}
	void print() {
		if (isEmpty()) {
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
	public static void main(String[] args) {
		Steque s = new Steque();
		Scanner sc = new Scanner(System.in);
		int numberOfCases = Integer.parseInt(sc.nextLine());
		while (sc.hasNext()) {
			String line = sc.nextLine();
			if (line.equals("") || line.equals(null)) {
				System.out.println("");
				break;
			} else {
				s = new Steque();
				String[] tokens = line.split(" ");
				switch (tokens[0]) {
					case "push":
						s.push(Integer.parseInt(tokens[1]));
						s.print();
						break;
					case "pop":
					    if (!s.isEmpty()) {
					        s.pop();
					        if (!s.isEmpty()) {
					        s.print();   		
					        } else {
					        	System.out.println("Steque is empty.");
					        }	
					    } else {
					    	System.out.println("Steque is empty.");
					    }
						break;
					case "enqueue":
						s.enqueue(Integer.parseInt(tokens[1]));
						s.print();
						break;
					default:
						
				}
			}
			
			//numberOfCases--;
		}

	}
}