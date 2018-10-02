import java.util.Scanner;


class Solution {
	// InsertionSort i = new InsertionSort();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String line = sc.next();
			String[] tokens = line.split(",");
			System.out.println(tokens[0]);
			System.out.println(tokens[1]);
			System.out.println(tokens[2]);
			System.out.println(tokens[3]);
		}
	}
}