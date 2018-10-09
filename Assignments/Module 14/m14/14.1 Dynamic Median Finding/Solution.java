import java.util.Scanner;
/**
 * Class for solution.
 */
public class Solution {
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
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int[] minHeap = new int[n];
        int[] maxHeap = new int[n];
        int minHeapSize = 0;
        int maxHeapSize = 0;
        float currentMedian = 0;
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            if (a[i] < currentMedian) {
                maxHeap[maxHeapSize++] = a[i];
                if (maxHeap[maxHeapSize - 1] > maxHeap[0]) {
                    swap(maxHeap, maxHeapSize - 1, 0);
                }
            } else {
                minHeap[minHeapSize++] = a[i];
                if (minHeap[minHeapSize - 1] < minHeap[0]) {
                    swap(minHeap, minHeapSize - 1, 0);
                }
            }
            if (Math.abs(maxHeapSize - minHeapSize) > 1) {
                if (maxHeapSize > minHeapSize) {
                    swap(maxHeap, maxHeapSize - 1, 0);
                    minHeap[minHeapSize++] = maxHeap[--maxHeapSize];
                    swap(minHeap, 0, minHeapSize - 1);
                    buildMaxHeap(maxHeap, maxHeapSize);
                } else {
                    swap(minHeap, minHeapSize - 1, 0);
                    maxHeap[maxHeapSize++] = minHeap[--minHeapSize];
                    swap(maxHeap, 0, maxHeapSize - 1);
                    buildMinHeap(minHeap, minHeapSize);
                }
            }
            if (maxHeapSize == minHeapSize) {
                currentMedian = (minHeap[0] + maxHeap[0]);
                currentMedian = currentMedian / 2;
            } else if (maxHeapSize > minHeapSize) {
                currentMedian = maxHeap[0];
            } else {
                currentMedian = minHeap[0];
            }

            System.out.println(currentMedian);

        }

    }
    /**
     * Builds a maximum heap.
     *
     * @param      input     The input
     * @param      heapSize  The heap size
     */
    static void buildMaxHeap(final int[] input, final int heapSize) {
        int depth = (heapSize - 1) / 2;
        for (int i = depth; i >= 0; i--) {
            maxHeapify(input, i, heapSize);
        }
    }
    /**
     * max heap method.
     *
     * @param      input     The input
     * @param      i         { integer variable }
     * @param      heapSize  The heap size
     */
    static void maxHeapify(final int[] input, final int i, final int heapSize) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if (left < heapSize && input[left] > input[largest]) {
            largest = left;
        }
        if (right < heapSize && input[right] > input[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(input, i, largest);
            maxHeapify(input, largest, heapSize);
        }
    }
    /**
     * Builds a minimum heap.
     *
     * @param      input     The input
     * @param      heapSize  The heap size
     */
    static void buildMinHeap(final int[] input, final int heapSize) {
        int depth = (heapSize - 1) / 2;
        for (int i = depth; i >= 0; i--) {
            minHeapify(input, i, heapSize);
        }
    }
    /**
     * min heap method.
     *
     * @param      input     The input
     * @param      i         { integer variable }
     * @param      heapSize  The heap size
     */
    static void minHeapify(final int[] input, final int i, final int heapSize) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int smallest = i;
        if (left < heapSize && input[left] < input[smallest]) {
            smallest = left;
        }
        if (right < heapSize && input[right] < input[smallest]) {
            smallest = right;
        }
        if (smallest != i) {
            swap(input, i, smallest);
            minHeapify(input, smallest, heapSize);
        }
    }
    /**
     * swap method.
     *
     * @param      input  The input
     * @param      i      { integer variable }
     * @param      j      { integer variable }
     */
    static void swap(final int[] input, final int i, final int j) {
        if (i == j) {
            return;
        }
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
