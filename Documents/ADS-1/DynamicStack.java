class DynamicStack {
	public static void main(String[] args) {
		Stack nums = new Stack();
		System.out.println(nums.isEmpty());
		nums.push(15);
		nums.push(8);
		nums.push(10);
		nums.push(6);
		nums.push(70);
		nums.push(89);
		nums.show();
		nums.pop();
		nums.show();
		nums.pop();
		nums.show();
		nums.pop();
		nums.show();
	}
}
class Stack {
	int capacity = 2;
	int[] stack = new int[capacity];
	int top = 0;
	void push(int data) {
		if (size() == capacity) {
			expand();			
		}
		stack[top++] = data;
	}
	void expand() {
		int length = size();
		int[] newStack = new int[2 * capacity];
		System.arraycopy(stack,0,newStack,0,length);
		stack = newStack;
		capacity *= 2;
	}
	int pop() {
		int data = 0;
		if (isEmpty()) {
			System.out.println("stack is empty");
		} else{
		top--;
		data = stack[top];
		stack[top] = 0;
		shrink(); 
		}
		return data;
	}
	void shrink(){
		int length = size();
		if (length <= (capacity / 2) / 2){
			capacity /= 2;
			int[] newStack = new int[capacity];
			System.arraycopy(stack,0, newStack, 0, length);
			stack = newStack;
		}
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
		System.out.println();
	}
}