import java.util.Scanner;
/**
 * Class for MergeSort.
 */
class MergeSort {
    /**
     * cutoff to insertion sort.
     */
    private final int x = 7;
    /**
     * Constructor for MergeSort class.
     * Time complexity of this method is O(1).
     */
    MergeSort() {

    }
    /**
     * Method to merge two arrays.
     * Time complexity of this method is O(N).
     * @param      array  The array
     * @param      auxiliaryArray    The auxiliary
     * @param      low     The lower value
     * @param      mid    The middle value
     * @param      high     The higher value
     */
    public void merge(final Comparable[] array,
     final Comparable[] auxiliaryArray,
        final int low, final int mid, final int high) {
        assert isSorted(array, low, mid);
        assert isSorted(array, mid + 1, high);
        int i = low;
        int j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                auxiliaryArray[k] = array[j++];
            } else if (j > high) {
                auxiliaryArray[k] = array[i++];
            } else if (lessthan(array[j], array[i])) {
                auxiliaryArray[k] = array[j++];
            } else {
                auxiliaryArray[k] = array[i++];
            }
        }
        assert isSorted(auxiliaryArray, low, high);
    }
    /**
     * Method for sorting.
     * Time complexity of sorting is O(log(N)).
     * @param      array  The array
     * @param      auxiliaryArray    The auxiliary array
     * @param      low     The lower value
     * @param      high     The higher value
     */
    public void sort(final Comparable[] array,
     final Comparable[] auxiliaryArray,
        final int low, final int high) {
        if (high <= low + x) {
            insertionSort(auxiliaryArray, low, high);
            System.out.println("Insertion sort method invoked...");
            return;
        }
        int mid = low + (high - low) / 2;
        sort(auxiliaryArray, array, low, mid);
        sort(auxiliaryArray, array, mid + 1, high);
        if (!lessthan(array[mid + 1], array[mid])) {
            for (int i = low; i <= high; i++) {
                auxiliaryArray[i] = array[i];
            }
            System.out.println(
                "Array is already sorted. So, skipped the call to merge...");
            return;
        }
        merge(array, auxiliaryArray, low, mid, high);
    }
    /**
     * Rearranges the array in ascending order, using the natural order.
     * Time complexity of this method is O(N).
     * @param      array     Comparable array.
     */
    public void sort(final Comparable[] array) {
        Comparable[] auxiliaryArray = array.clone();
        sort(auxiliaryArray, array, 0, array.length - 1);
        assert isSorted(array);
    }
    /**
     * Method for insertion sort.
     * sort from a[low] to a[high].
     * Time complexity of insertion sort is O(N^2/2).
     * @param      array    Comparable array.
     * @param      low    The lower value
     * @param      high    The higher value
     */
    public void insertionSort(final Comparable[] array,
        final int low, final int high) {
        for (int i = low; i <= high; i++) {
            for (int j = i; j > low && lessthan(array[j], array[j - 1]); j--) {
                exchange(array, j, j - 1);
            }
        }
    }
    /**
     * Method to exchange two elements in the array.
     * Time complexity of this method is O(N).
     * @param      array     Array of object
     * @param      i     Integer variable i
     * @param      j     Integer variable j
     */
    public void exchange(final Comparable[] array,
        final int i, final int j) {
        Comparable temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    /**
     * Method to check the smaller of the two.
     * Time complextiy of this method is O(1).
     * @param      a     Comparable variable.
     * @param      b     Comparable variable.
     *
     * @return    True if less, False otherwise.
     */
    public boolean lessthan(final Comparable a, final Comparable b) {
        return a.compareTo(b) < 0;
    }
    /**
     * Method which determines whether the array is sorted (or) not.
     * Time complexity of this method is O(1).
     * @param      array     Comparable array
     *
     * @return     True if sorted, False otherwise.
     */
    public boolean isSorted(final Comparable[] array) {
        return isSorted(array, 0, array.length - 1);
    }
    /**
     * Method which determines whether the array is sorted (or) not.
     * Time complexity of this method is O(N).
     * @param      array     Comparable array
     * @param      low    The lower value
     * @param      high    The higher value
     *
     * @return     True if sorted, False otherwise.
     */
    public boolean isSorted(final Comparable[] array,
        final int low, final int high) {
        for (int i = low + 1; i <= high; i++) {
            if (lessthan(array[i], array[i - 1])) {
                return false;
            }
        }
        return true;
    }
    /**
     * {Method to print the values of the Comparable array}.
     * Time complexity of this method is O(N).
     * @param      array    array
     *
     * @return    returns the String
     */
    public String show(final Comparable[] array) {
        String result = "[";
        int i;
        for (i = 0; i < array.length - 1; i++) {
            result += array[i] + ", ";
        }
        result += array[i] + "]";
        return result;
    }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructor for solution class.
     * Time complexity of this method is O(1).
     */
    private Solution() {

    }
    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        MergeSort m = new MergeSort();
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(",");
            m.sort(tokens);
            System.out.println(m.show(tokens));
            System.out.println();
        }
    }
}