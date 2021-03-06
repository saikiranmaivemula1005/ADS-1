class Stackarray {
	public static void main(String[] args) {
		Stack nums = new Stack();
		System.out.println(nums.isEmpty());
		nums.push(15);
		nums.push(8);
		nums.push(10);
		nums.push(6);
		nums.push(70);
		nums.push(89);
		System.out.println(nums.pop());
		System.out.println(nums.peek());
		System.out.println(nums.size());
		System.out.println(nums.isEmpty());
		nums.show();
	}
}
class Stack {
	int[] stack = new int[5];
	int top = 0;
	void push(int data) {
		if (top == 5 ) {
			System.out.println("stack is full ");
		} else {
		stack[top++] = data;
		}
	}
	int pop() {
		int data = 0;
		if (isEmpty()) {
			System.out.println("stack is empty");
		} else{
		top--;
		data = stack[top];
		stack[top] = 0; 
		}
		return data;
	}
	int peek() {
		int data;
		data = stack[top - 1];
		return data;
	}
	int size() {
		return top;
	}
	boolean isEmpty() {
		return top <= 0;
	}
	void show() {
		for (int i : stack) {
			System.out.print (i + " ");
		}
	}
}