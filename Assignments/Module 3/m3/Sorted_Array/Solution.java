import java.util.*;
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()){
			int size1 = sc.nextInt();
			int size2 = sc.nextInt();
			sc.nextLine();
			String[] firstArray = sc.nextLine().split(",");
			String[] secondArray = sc.nextLine().split(",");
			// System.out.println(Arrays.toString(firstArray));
			// System.out.println(Arrays.toString(secondArray));
			int variable = 0;
			String[] outputArray = new String[size1 + size2];
			for (int i = 0; i < size1; i++) {
				outputArray[i] = firstArray[i];
				variable = i;
			}
			for (int j = 0; j < size2; j++) {
				outputArray[variable + 1 ] = secondArray[j];
			}
			System.out.println(Arrays.toString(outputArray));
		}
	}
}