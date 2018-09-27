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
			checkbalanced(line);
		}
	}
	public static String checkbalanced(String input) {
		return input;
	}
}