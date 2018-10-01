import java.util.Scanner;
import java.util.Stack;
class Steque {
	Steque () {

	}
	int size = 0;
	int front = 0;
	int[] stack = new int[10];
	void push(int element) {
		for (int i = size; i >= 0; i--) {
			stack[i + 1] = stack[i];
		}
		stack[0] = element;
		size++;
	}
	void pop() {
		if (size() == 0) {
			System.out.println("Steque is empty.");
		}
		for (int i = 1; i < size - 1; i++) {
			System.out.print(stack[i] + ", ");
		}
		System.out.print(stack[size - 1]);
		System.out.println();
		size--;
	}
	int size() {
		return size;
	}
	void enqueue(int element) {
		stack[size++] = element;
	}
	void print() {
		if (size() == 0) {
			System.out.println("Steque is empty.");
		} else {
		for (int i = 0; i < size - 1; i++) {
			System.out.print(stack[i] + ", ");
		}
		System.out.print(stack[size - 1]);
		System.out.println();
		}
	}
}






class Solution {
	protected Solution() {

	}
	public static void main(String[] args) {
		Steque s = new Steque();
		Scanner sc = new Scanner(System.in);
		int numberOfCases = sc.nextInt();
		while (sc.hasNext()) {
			String line = sc.nextLine();
			String[] tokens = line.split(" ");
			switch (tokens[0]) {
				case "push":
					s.push(Integer.parseInt(tokens[1]));
					s.print();
					break;
				case "pop":
					s.pop();
					break;
				case "enqueue":
					s.enqueue(Integer.parseInt(tokens[1]));
					s.print();
					break;
				default:
					
			}
			numberOfCases--;
		}

	}
}