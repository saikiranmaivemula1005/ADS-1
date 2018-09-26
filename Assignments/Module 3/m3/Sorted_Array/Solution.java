import java.util.*;
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()){
			int size1 = sc.nextInt();
			int size2 = sc.nextInt();
			String[] firstArray = sc.nextLine().split(",");
			String[] secondArray = sc.nextLine().split(",");
			System.out.println(Arrays.toString(firstArray));
			System.out.println(Arrays.toString(secondArray));
		}

	}
}