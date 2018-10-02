import java.util.Scanner;
import java.util.Arrays;
class Team {
	String nameOfTeam;
	int wins;
	int losses;
	int draws;
	Team(String nameOfTeam, int wins, int losses, int draws) {
		this.nameOfTeam = nameOfTeam;
		this.wins = wins;
		this.losses = losses;
		this.draws = draws;
	}

}
class InsertionSort {
	void sort(int[] elementsArray) {
		for (int i = 1; i < elementsArray.length; i++) {
			int key = elementsArray[i];
			int j = i - 1;
			while (j > 0 && elementsArray[j] < key) {
				elementsArray[j + 1] = elementsArray[j];
				j = j - 1;
			}
		}
		System.out.println(Arrays.toString(elementsArray));
	}
}

class Solution {
	// InsertionSort i = new InsertionSort();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		while (sc.hasNext()) {
			String line = sc.next(); 
			String[] tokens = line.split(",");
			Team t = new Team(tokens[0], Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]));
			// System.out.println(tokens[0]);
			// System.out.println(tokens[1]);
			// System.out.println(tokens[2]);
			// System.out.println(tokens[3]);
			// System.out.println("finish");
			count++;

		}
		System.out.println(count);
	}
}