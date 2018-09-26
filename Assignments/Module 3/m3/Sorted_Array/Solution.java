import java.util.*;
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] firstArray = new int[size];
		int[] secondArray = new int[size];
		for (int i = 0; i < firstArray.length; i++) {
			firstArray[i] = sc.nextInt();
		}
		for (int i = 0; i < secondArray.length; i++) {
			secondArray[i] = sc.nextInt();
		}
		System.out.println(Arrays.toString(firstArray));
		System.out.println(Arrays.toString(secondArray));
	}
}