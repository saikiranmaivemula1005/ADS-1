import java.util.Scanner;
import java.util.Arrays;
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sizeOfArray = sc.nextInt();
		int[] array = new int[sizeOfArray];
		int count = 0;
		for (int i = 0; i < sizeOfArray; i++) {
			array[i] = sc.nextInt();
		}
		Binarysearch b = new Binarysearch();
		Arrays.sort(array);
		for (int i = 0; i < sizeOfArray; i++) {
			for (int j = i + 1; j  < sizeOfArray && array[i] + array[j] < 0; j++) {
				int k = b.binarySearch(array, j + 1, sizeOfArray, -array[i] - array[j]);
				if (k  > j) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
}