import java.util.Scanner;
 class Percolation {
	int[][] grid;
	int openSites;
	WeightedQuickUnion wqu;
	int size;
   public Percolation(int size)  {
   	grid = new int[size][size];
   	openSites = 0;
   	wqu = new WeightedQuickUnion((size * size) + 2);
   	size = size;
   }              // create n-by-n grid, with all sites blocked
   public void open(int row, int col) {
   		row = row - 1;
   		col = col - 1;
   		grid[row][col] = 1;
   		openSites++;
   		if (row == 0) {
   			wqu.Union(0, component(row, col));
   		}
   		if (row == size - 1) {
   			wqu.Union((size * size) + 1, component(row, col));
   		}
   		if (row > 0) {
   			if (grid[row + 1][col] == 1) {
   				wqu.Union(component(row, col), component((row + 1), col));
   			}
   		}
   		if (row <= size - 1) {
   			if (grid[row - 1][col] == 1) {
   				wqu.Union(component(row, col), component((row - 1), col));
   			}
   		}
   		if (col > 0) {
   			if (grid[row][col + 1] == 1) {
   				wqu.Union(component(row, col), component(row, (col + 1)));
   			}
   		}
   		if (col < size - 1) {
   			if (grid[row][col - 1] == 1) {
   				wqu.Union(component(row, col), component(row, (col - 1)));
   			}
   		}
   }
   int component(int i, int j) {
   		return ((i * size) + j) + 1;
   }
   public boolean isOpen(int row, int col) {
   		return grid[row - 1][col - 1] == 1;
   }
   public boolean isFull(int row, int col) {
   	return grid[row - 1][col - 1] == 0;
   }
   public int numberOfOpenSites() {
   		return openSites;
   }
   public boolean percolates() {
   	return wqu.connected(0, (size * size)  +1);
   }
}
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		Percolation p = new Percolation(size);
		while (sc.hasNext()) {
			p.open(sc.nextInt(), sc.nextInt());
		}
		System.out.println(p.percolates());
	}
}
