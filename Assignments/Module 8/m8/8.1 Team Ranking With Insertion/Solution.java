import java.util.Scanner;
import java.util.Arrays;
class InsertionSort {
	void sort(String[] elements) {

	}
}
class Solution {
	public static void main(String[] args) {
		InsertionSort isort = new InsertionSort();
		Scanner sc = new Scanner(System.in);
		String[] elements = new String[10];
		for (int i = 0; i < 10; i++) {
		while (sc.hasNext()) {
			String line = sc.next();
			String[] tokens = line.split(",");
				elements[i] = (tokens[0]);
		}
	}
		System.out.println(Arrays.toString(elements));
		isort.sort(elements);
	}
}