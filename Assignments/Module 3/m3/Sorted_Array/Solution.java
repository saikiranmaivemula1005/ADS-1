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
			int[] outputArray = new int[size1 + size2];
			for (int i = 0; i < size1; i++) {
				outputArray[i] = Integer.parseInt(firstArray[i]);
			}
			// int outputArraysize  = firstArray.length - 1;
			int t = size1;
			for (int j = 0; j < size2; j++) {
				outputArray[t++] = Integer.parseInt(secondArray[j]);

			}
			Arrays.sort(outputArray);
			// 
			for(int i : outputArray) {
				System.out.print(i + " ");
			}
		}
	}
}