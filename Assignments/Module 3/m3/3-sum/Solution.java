import java.util.Scanner;
import java.util.Arrays;
class Solution {
	public static void main(String[] args) {
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
		for (int i = 0; i < length; i++) {
			for (int j = i + 1; j  < length && array[i] + array[j] == 0; j++) {
				int k = Arrays.binarySearch(array, j + 1, length, -array[i] - array[j]);
				if (k > j) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
}