import java.util.Scanner;
import java.util.Arrays;
class Binarysearch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sizeOfArray = sc.nextInt();
		int[] array = new int[sizeOfArray];
		for (int i = 0; i < sizeOfArray; i++) {
			array[i] = sc.nextInt();
		}
		Arrays.sort(array);
		System.out.println(Arrays.toString(array));
		int search = sc.nextInt();
		System.out.println(binarySearch(array, 0, array.length - 1, search));
	}
	 static int binarySearch(int[] array, int start, int end, int search) { 
        if (end >= start) 
        { 
            int middleValue = start + (end - start) / 2;
            if (array[middleValue] == search) 
               return array[middleValue]; 
            if (array[middleValue] > search) 
               return binarySearch(array, start, middleValue-1, search); 
            return binarySearch(array, middleValue + 1, end, search); 
        } 
        return -1; 
    } 
  
}
