import java.io.*;
import java.util.*;
/**
 * Class for solution.
 */
class Solution {
	/**
	 * Constructor for solution class.
	 */
	Solution() {

	}
	/**
	 * main method.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		int numberOfLines = sc.nextInt();
		// System.out.println(numberOfLines);
		while (sc.hasNext()) {
			String line = sc.next();
			Node n = new Node(line);
			if (n.checkbalanced(line)) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
	}
}
class Node {
	String item;
	Node next;
	Node(String value) {
		item = value;
		next = null;
	}
	public boolean checkbalanced(String input) {
		return (next == null);
	}

}