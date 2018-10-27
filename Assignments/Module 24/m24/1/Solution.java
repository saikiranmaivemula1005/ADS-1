
import java.util.Scanner;
 /**
 * Class for student.
 */
class Student {
     /**
     * roll number of student.
     */
    private int rollnumber;
     /**
     * name of student.
     */
    private String name;
     /**
     * percentage of the student.
     */
    private double percentage;
     /**
     * Gets the name of the student.
     *
     * @return     The name.
     *
     */
    String getName() {
        return this.name;
    }
     /**
     * Gets the percentage of the student.
     *
     * @return     The percentage.
     */
    double getpercentage() {
        return this.percentage;
    }

     /**
     * Constructs the object.
     *
     * @param      r   rollnumber of  student
     * @param      n      name of  student
     * @param      p       percentage of  student
     */
    Student(final int r, final String n, final double p) {
        this.rollnumber = r;
        this.name = n;
        this.percentage = p;
    }
 }


/**
 * Solution class.
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
        Scanner scan = new Scanner(System.in);
        LinearProbingHashST<Integer, Student> lphst =
            new LinearProbingHashST();
        int numberOfStudents = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < numberOfStudents; i++) {
            String[] tokens = scan.nextLine().split(",");
            Integer rollnumber = Integer.parseInt(tokens[0]);
            lphst.put(rollnumber,
            new Student(rollnumber, tokens[1], Double.parseDouble(tokens[2])));
        }
        int queries = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < queries; i++) {
            String[] tokens = scan.nextLine().split(" ");
             switch (tokens[2]) {
            case "1":
                Student student = lphst.get(Integer.parseInt(tokens[1]));
                if (student != null) {
                    System.out.println(student.getName());
                } else {
                    System.out.println("Student doesn't exists...");
                }
                break;
            case "2":
                 student = lphst.get(Integer.parseInt(tokens[1]));
                if (student != null) {
                    System.out.println(student.getpercentage());
                } else {
                    System.out.println("Student doesn't exists...");
                }
                break;
            default:
            }
        }
     }
}
