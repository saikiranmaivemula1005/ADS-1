import java.util.Scanner;
 class Percolation {
	int[][] grid;
	int openSites;
	WeightedQuickUnion wqu;
	int size;
    Percolation(int size)  {
   	grid = new int[size][size];
   	openSites = 0;
   	wqu = new WeightedQuickUnion((size * size) + 2);
   	size = size;
   }              // create n-by-n grid, with all sites blocked
    void open(int row, int col) {
   		row = row - 1;
   		col = col - 1;
   		grid[row][col] = 1;
   		openSites++;
   		if (row == 1) {
   			wqu.Union(0, component(row, col));
   		}
   		if (row == size) {
   			wqu.Union((size * size) + 1, component(row, col));
   		}
   		if (row < size) {
   			if (grid[row + 1][col] == 1) {
   				wqu.Union(component(row, col), component((row + 1), col));
   			}
   		}
   		if (row >1) {
   			if (grid[row - 1][col] == 1) {
   				wqu.Union(component(row, col), component((row - 1), col));
   			}
   		}
   		if (col <= size) {
   			if (grid[row][col + 1] == 1) {
   				wqu.Union(component(row, col), component(row, (col + 1)));
   			}
   		}
   		if (col > 1) {
   			if (grid[row][col - 1] == 1) {
   				wqu.Union(component(row, col), component(row, (col - 1)));
   			}
   		}
   }
   int component(int i, int j) {
   		return ((i * size) + j) + 1;
   }
    boolean isOpen(int row, int col) {
   		return grid[row - 1][col - 1] == 1;
   }
    boolean isFull(int row, int col) {
   	return grid[row - 1][col - 1] == 0;
   }
    int numberOfOpenSites() {
   		return openSites;
   }
    boolean percolates() {
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
