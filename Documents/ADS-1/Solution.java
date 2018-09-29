import java.util.*;
class Solution {
	public static void main(String[] args) {
		Queue q = new Queue();
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int[] queue = new int[input];
		for (int i = 0; i < input; i++) {
			queue[i] = sc.nextInt();
		}
		for (int i = 0; i < input; i++) {
			q.enQueue(queue[i]);
		}
		q.deQueue();
		q.show();
	}
}