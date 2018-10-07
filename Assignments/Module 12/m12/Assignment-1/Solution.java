import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
/**
 * Class for solution.
 */   
class Solution {
    /**
     * Constructs the object.
     */
    Solution() {
    }
    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Merit m = new Merit();
            int noOfapplied = Integer.parseInt(sc.nextLine());
            int noOfvacancies = Integer.parseInt(sc.nextLine());
            int noOfunres = Integer.parseInt(sc.nextLine());
            int noOfBC = Integer.parseInt(sc.nextLine());
            int noOfSC = Integer.parseInt(sc.nextLine());
            int noOfST = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < noOfapplied; i++) {
                String data = sc.nextLine();
                String[] tokens = data.split(",");
                m.addStudent(new Student(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4], tokens[5], tokens[6]));
            }
        m.InsertionSort();
        System.out.println(m);
        m.sort(noOfvacancies,noOfunres,noOfBC,noOfSC,noOfST);
        // System.out.println(m);
        for (int i = 0; i < noOfvacancies; i++) {
            System.out.println(m.students1[i]);       
        }
    }   
}