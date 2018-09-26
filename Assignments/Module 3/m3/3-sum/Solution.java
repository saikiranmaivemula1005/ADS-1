import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for solution.
 */
class Solution {
	/**
	 * constructor for solution class.
	 */
	protected Solution() {

	}
	/**
	 * main method.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		int sizeOfArray = sc.nextInt();
		int[] array = new int[sizeOfArray];
		int length = array.length;
		int count = 0;
		for (int i = 0; i < sizeOfArray; i++) {
			array[i] = sc.nextInt();
		}
		Binarysearch b = new Binarysearch();
		Arrays.sort(array);
		for (int i = 0; i < length && array[i] < 0; i++) {
			for (int j = i + 1;
			 j  < length && array[i] + array[j] < 0; j++) {
				int k = b.binarySearch(
					array, j + 1, length - 1,
					 -array[i] - array[j]);
				if (k != -1) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
