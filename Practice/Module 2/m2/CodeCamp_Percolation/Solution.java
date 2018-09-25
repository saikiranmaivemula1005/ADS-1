import java.util.Scanner;
 class Percolation {

    private boolean[][] opened;
    private int top = 0;
    private int bottom;
    private int size;
    private WeightedQuickUnion qf;

    /**
     * Creates N-by-N grid, with all sites blocked.
     */
    public Percolation(int N) {
        size = N;
        bottom = size * size + 1;
        qf = new WeightedQuickUnion(size * size + 2);
        opened = new boolean[size][size];
    }

    /**
     * Opens site (row i, column j) if it is not already.
     */
    public void open(int i, int j) {
        opened[i - 1][j - 1] = true;
        if (i == 1) {
            qf.Union(getQFIndex(i, j), top);
        }
        if (i == size) {
            qf.Union(getQFIndex(i, j), bottom);
        }

        if (j > 1 && isOpen(i, j - 1)) {
            qf.Union(getQFIndex(i, j), getQFIndex(i, j - 1));
        }
        if (j < size && isOpen(i, j + 1)) {
            qf.Union(getQFIndex(i, j), getQFIndex(i, j + 1));
        }
        if (i > 1 && isOpen(i - 1, j)) {
            qf.Union(getQFIndex(i, j), getQFIndex(i - 1, j));
        }
        if (i < size && isOpen(i + 1, j)) {
            qf.Union(getQFIndex(i, j), getQFIndex(i + 1, j));
        }
    }

    /**
     * Is site (row i, column j) open?
     */
    public boolean isOpen(int i, int j) {
        return opened[i - 1][j - 1];
    }

    /**
     * Is site (row i, column j) full?
     */
    public boolean isFull(int i, int j) {
        if (0 < i && i <= size && 0 < j && j <= size) {
            return qf.connected(top, getQFIndex(i , j));
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Does the system percolate?
     */
    public boolean percolates() {
        return qf.connected(top, bottom);
    }

    private int getQFIndex(int i, int j) {
        return size * (i - 1) + j;
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
