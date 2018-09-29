import java.util.*;
class Implementation {
	boolean percolation(int a, int b) {
		return isPercolates();
	}
	boolean isPercolates() {
		//true if percolates, else no!!!
		return true;
	}
}
class WeightedQuickUnion {
	private int[] id;
	private int[] size;
	private int count;
	WeightedQuickUnion(int n) {
		count = n;
		id = new int[n];
		for (int i = 0; i < n; i++) {
			id[i] = i;
		}
		for (int i = 0; i < n; i++) {
			size[i] = 1;
		}
	}
	public int count() {
		return count;
	}
	public boolean connected(int a, int b) {
		return find(a) == find(b);
	}
	public int find(int a) {
		while (a != id[a]) {
			a = id[a];
			return a;
		}
		return 0;
	}
	public void Union(int a, int b) {
		if (find(a) == find(b)) {
			return;
		}
		if (size[find(a)] < size[find(b)]) {
			id[find(a)] = find(b);;
			size[find(b)] += size[find(a)];
		} else {
			id[find(b)] = find(a);;
			size[find(a)] += size[find(b)];
		}
		count--;
	}
}








class Percolation {
	public static void main(String[] args) {
		Implementation i = new Implementation();
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int[][] grid = new int[input][input];
		while (sc.hasNext()) {
			String x = sc.nextLine();
			String[] tokens = x.split(" ");
			System.out.println(tokens[0]);
			System.out.println(tokens[1]);
			i.percolation(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
		}
	}
}