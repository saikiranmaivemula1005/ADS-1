 class Queue {
	int[] queue = new int[10];
	int size;
	int front;
	int rear;
	public  void enQueue(int data) {
		if (! isFull()) {
		queue[rear++] = data;
		size++;	
	} else {
		System.out.println("queue is full");
	}
		
	}
	public  void show() {
		System.out.print("elements: ");
		for (int i = 0; i < size; i++) {
			System.out.print(queue[front + i] + " ");
		}
		for (int n : queue) {
			System.out.println(n + " ");
		}
	}
	public int deQueue() {
		 int data = queue[front];
		 if (!isEmpty()) {
			 front++;
		 	size--; 	
		 } else {
		 	System.out.println("queue is empty");
		 }
		
		 return data;
	}
	public int size() {
		return size;
	}
	boolean isEmpty() {
		return (size() == 0);
	}
	boolean isFull() {
		return size() == 10;
	}
}
