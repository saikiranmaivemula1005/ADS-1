import java.util.Scanner;
/**
 * Class for taxicab.
 */
class Taxicab implements Comparable<Taxicab> {
    /**
     * integer variables.
     */
    private int i, j;
    /**
     * sum variable.
     */
    private long sum;
    /**
     * Constructs the object.
     *
     * @param      i1    I 1
     * @param      j1    The j 1
     */
    Taxicab(final int i1, final int j1) {
        this.sum = (long) i1 * i1 * i1 + (long) j1 * j1 * j1;
        this.i = i1;
        this.j = j1;
    }
    /**
     * Gets i.
     *
     * @return     I.
     */
    public int getI() {
        return i;
    }
    /**
     * Gets the j.
     *
     * @return     The j.
     */
    public int getJ() {
        return j;
    }
    /**
     * Getting sum.
     *
     * @return     { sum. }
     */
    public long getsum() {
        return sum;
    }
    /**
     * compare to method.
     * Time complexity : O(1).
     * @param      that  The that
     *
     * @return     { returns 1, 0, -1 based on inputs }
     */
    public int compareTo(final Taxicab that) {
        if (this.sum < that.sum) {
            return -1;
        } else if (this.sum > that.sum) {
            return +1;
        } else {
            return  0;
        }
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return i + "^3 + " + j + "^3";
    }
}
/**
 * Class for solution.
 */
class Solution {
    /**
     * Constructs the object.
     */
    protected Solution() {

    }
    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[] input = sc.nextLine().split(" ");
            int num = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            final int n = 1000;
            MinPQ<Taxicab> pq = new MinPQ<Taxicab>();
            for (int i = 1; i <= n; i++) {
                pq.insert(new Taxicab(i, i));
            }
            int pair = 1;
            Taxicab prev = new Taxicab(0, 0);
            int pairCount = 0;
            while (!pq.isEmpty()) {
                Taxicab curr = pq.delMin();
                if (prev.getsum() == curr.getsum()) {
                    pair++;
                    if (pair == m) {
                        pairCount = pairCount + 1;
                    }
                    if (pairCount == num) {
                        System.out.println(prev.getsum());
                        break;
                    }
                } else {
                    pair = 1;
                }
                prev = curr;
                if (curr.getJ() < n) {
                    pq.insert(new
                        Taxicab(curr.getI(), curr.getJ() + 1));
                }
            }
    }
    }
    }

    