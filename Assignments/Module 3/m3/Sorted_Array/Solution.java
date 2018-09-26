import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for solution.
 */
class Solution {
    /**
     * constructor for solution class.
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
        while (sc.hasNext()) {
            int size1 = sc.nextInt();
            int size2 = sc.nextInt();
            sc.nextLine();
            String[] firstArray = sc.nextLine().split(",");
            String[] secondArray = sc.nextLine().split(",");
            // System.out.println(Arrays.toString(firstArray));
            // System.out.println(Arrays.toString(secondArray));
            int[] outputArray = new int[size1 + size2];
            for (int i = 0; i < size1; i++) {
                outputArray[i] = Integer.parseInt(
                    firstArray[i]);
            }
            // int outputArraysize  = firstArray.length - 1;
            int temp = size1;
            for (int j = 0; j < size2; j++) {
                outputArray[temp++] = Integer.parseInt(
                    secondArray[j]);

            }
            Arrays.sort(outputArray);
            for (int i = 0; i < outputArray.length - 1; i++) {
                System.out.print(outputArray[i] + ",");
            }
            System.out.print(outputArray[outputArray.length - 1]);
        }
    }
}