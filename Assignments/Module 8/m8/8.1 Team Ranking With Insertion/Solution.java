import java.util.Scanner;
import java.util.Arrays;
class InsertionSort {
	void sort(int[] elements) {

	}
}
class Solution {
	public static void main(String[] args) {
		InsertionSort isort = new InsertionSort();
		Scanner sc = new Scanner(System.in);
		int[] elements = new int[10];
		while (sc.hasNext()) {
			String line = sc.next();
			String[] tokens = line.split(",");
			for (int i = 0; i < tokens.length; i++) {
				elements[i] = Integer.parseInt(tokens[1]);
			}
		}
		System.out.println(Arrays.toString(elements));
		isort.sort(elements);
	}
}