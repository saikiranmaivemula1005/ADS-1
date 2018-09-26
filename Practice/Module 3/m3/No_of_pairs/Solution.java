import java.util.Scanner;
import java.util.Arrays;
import java.util.*;
class Solution {
	int[] arr;
	int n;
	Solution() {
		arr = new int[n];
	}
	/**
	 * count pairs method.
	 *
	 * @param      array  The array
	 */
	public static void countPairs(int[] array) {
		int c = 1;
		int sumOfNumbers = 0;
		Arrays.sort(array);
		for(int i = 0 ; i< array.length-1; i++){
			if(i == array.length - 2 &&  array[i] == array[i + 1]){
				c++;
				sumOfNumbers += c * (c - 1) / 2;
				break;
			}
			if(array[i] == array[ i + 1]){
				c++;
				continue;
			}
			if(c>1 && array[i] != array[i+1]){
				sumOfNumbers += c*(c-1)/2;
				c=1;
			}
		}
		System.out.println("number of pairs: " + sumOfNumbers);
		
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = sc.nextInt();
		}
		countPairs(array);
	}
}