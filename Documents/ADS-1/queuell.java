class queuell {
	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		String[] s = "Playing Cricket - is - a hobby - - of - - mentor - deepak".split(" ");
		for (String sub : s) {
			if (sub.equals("-")) {
				System.out.println(l.deQueue());
			} else {
				l.enQueue(sub);
				}
		}
		System.out.println("remaining elements: ");
		while (!l.isEmpty()) {
			System.out.println(l.deQueue());
		}
		l.display();
	}
}

class Node {
	String data;
	Node next;
	Node() {

	}
	Node(String data) {
		this.data = data;
	}
}
class LinkedList {
	Node first;
	Node last;
	int size;
	LinkedList() {
		first = new Node();
		last = new Node();
		size = 0;
	}
	void enQueue(String item) {
		Node obj = new Node(item);
		if (size == 0) {
			first = obj;
			last = obj;
			size++;
			return;
		}
		last.next = obj;
		last = obj;
		size++;
	}
	String deQueue() {
		String data = first.data;
		first = first.next;
		size--;
		return data;
	}
	boolean isEmpty() {
		return (size == 0);
	}
	 String display() {
		if (size == 1) {
			return first.data;
		}
		String res = "";
		Node temp = first;
		while (temp != null) {
			res += temp.data;
			temp = temp.next;
		}
		return res;
		///////////
		// for (Node x = first; x != null; x = x.next) {
		// 	res += x.data;
		// }
	}
}
