import java.util.Scanner;
/**
 * Solution class.
 */
final class Solution {
    /**
     *an empty constructor.
     */
    private Solution() {
    }
    /**
     *the main method is to.
     *take the tokens[1 from user.
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        DynamicMedian obj = new DynamicMedian();
        int inputs = scan.nextInt();
        // double element = scan.nextDouble();
        // obj.insertAtMin(element);
        // double median = element;
        // System.out.println(median);
        float median = 0;
        for (long i = 1; i < inputs; i++) {
        	String[] tokens = scan.nextLine().split(",");
            // double tokens[1 = scan.nextDouble();
            if (Float.parseFloat(tokens[1]) > median) {
                obj.insertAtMin(Float.parseFloat(tokens[1]));
            } else if (Float.parseFloat(tokens[1]) < median) {
                obj.insertAtMax(Float.parseFloat(tokens[1]));
            } else {
                obj.insertAtMin(Float.parseFloat(tokens[1]));
            }
            if (obj.getMinSize() - obj.getMaxSize() > 1) {
                obj.insertAtMax(obj.delMin());
            }
            if (obj.getMaxSize() - obj.getMinSize()  > 1) {
                obj.insertAtMin(obj.delMax());
            }
            if (Math.abs(
                        obj.getMinSize() - obj.getMaxSize()) == 1) {
                if (obj.getMinSize() > obj.getMaxSize()) {
                    median = obj.getMin();
                    // System.out.println(median);
                } else {
                    median = obj.getMax();
                    // System.out.println(median);
                }
            }
            if (obj.getMinSize()  == obj.getMaxSize()) {
                float min = obj.getMin();
                float max = obj.getMax();
                median = (min + max) / 2;
                // System.out.println(median);
            }
        }
        obj.printmax();
        obj.printmin();
    }
}