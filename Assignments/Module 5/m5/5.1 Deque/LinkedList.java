class LinkedList<E> {
	class Node {
		private E data;
		private Node next;
		Node(final E d, final Node n) {
			data = d;
			next = n;
		}
		E getdata() {
			return data;
		}
		void setdata(final E d) {
			data = d;
		}
		Node getnext() {
			return next;
		}
		void setnext(final Node n) {
			next = n;
		}
	}
	private Node head;
	private Node tail;
	private int size;
	LinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	boolean isEmpty() {
		return head == null;
	}
	int getsize() {
		return size;
	}
	void insertAtStart(E data) {
		Node first = new Node(data, null);
		size++;
		if (head == null) {
			head = first;
			tail = head;
		} else {
			first.setnext(head);
			head = first;
		}
	}
	void insertAtEnd(E data) {
		Node first = new Node(data, null);
		size++;
		if (head == null) {
			head = first;
			tail = head;
		} else {
			tail.setnext(first);
			tail = first;
		}
	}
	void insertAtPos(E data, int pos) {
		Node first = new Node(data, null);
		Node second = head;
		pos--;
		for (int i = 1; i < size; i++) {
			if (i == pos) {
				Node temp = second.getnext();
				second.setnext(first);
				first.setnext(temp);
				break;
			}
			second = second.getnext();
		}
		size++;
	}
	void deleteAtPos(int pos) {
		if (pos == 1) {
			head = head.getnext();
			size--;
			return;
		}
		if (pos == size) {
			Node s = head;
			Node t = head;
			while (s != tail) {
				t = s;
				s = s.getnext();
			}
			tail = t;
			tail.setnext(null);
			size --;
			return;
		}
		Node first = head;
		pos--;
		for (int i = 1; i < size - 1; i++) {
			if (i == pos) {
				Node tmp = first.getnext();
				tmp = tmp.getnext();
				first.setnext(tmp);
				break;
			}
			first = first.getnext();
		}
		size-- ;
	}
	void display() {
		if (size == 0) {
			System.out.println("[]");
			return;
		}
		if (head.getnext() == null) {
			System.out.println("[" + head.getdata() + "]");
			return;
		}
		Node first = head;
		System.out.print("[" + head.getdata());
		first = head.getnext();
		while (first.getnext() != null) {
			System.out.print(", " + first.getdata());
			first = first.getnext();
		}
		System.out.print(", " + first.getdata() + "]" + "\n");
	}
}
