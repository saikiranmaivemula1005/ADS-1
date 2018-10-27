
import java.util.Scanner;
 /**
 * Class for student.
 */
class Student {
     /**
     * roll number of student.
     */
    private Double rollnumber;
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
    Student(final Double r, final String n, final double p) {
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
        LinearProbingHashST<Double, Student> lphst =
            new LinearProbingHashST();
        Double numberOfStudents = Double.parseDouble(scan.nextLine());
        for (int i = 0; i < numberOfStudents; i++) {
            String[] tokens = scan.nextLine().split(",");
            Double rollnumber = Double.parseDouble(tokens[0]);
            lphst.put(rollnumber,
            new Student(rollnumber, tokens[1], Double.parseDouble(tokens[2])));
        }
        Double queries = Double.parseDouble(scan.nextLine());
        for (int i = 0; i < queries; i++) {
            String[] tokens = scan.nextLine().split(" ");
             switch (tokens[0]) {
            case "GE":
                Student student = lphst.get(Double.parseDouble(tokens[1]));
                break;
            case "BE":
                Student student1 = lphst.get(Double.parseDouble(tokens[1]));
                Student student2 = lphst.get(Double.parseDouble(tokens[2]));
                for (double j = student1.getpercentage(); j < student2.getpercentage(); j++) {
                	System.out.println(student1.getName());
                }
                break;
            case "LE":
                  student = lphst.get(Double.parseDouble(tokens[1]));
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
