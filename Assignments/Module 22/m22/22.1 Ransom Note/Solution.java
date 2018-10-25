import java.util.Scanner;
class Solution {
	Solution() {

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		String lineOne = sc.next();
		String lineTwo = sc.next();
		if (lineOne.equals(lineTwo)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}