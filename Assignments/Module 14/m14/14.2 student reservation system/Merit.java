import java.util.Arrays;
import java.util.Collections;
/**
 * Class for merit.
 */
public class Merit {
    /**
     * student array.
     */
    private Student[] students;
    /**
     * new array.
     */
    private Student[] newstudents;
    /**
     * size variable.
     */
    private int size;
    /**
     * Constructs the object.
     */
    Merit() {
        students = new Student[50];
        newstudents = new Student[50];

        size = 0;
    }
    /**
     * Adds a student.
     *
     * @param      st    { student }
     */
    public void addStudent(final Student st) {
        students[size++] = st;
    }
    public Student getnewStudents(final int i) {
        return newstudents[i];
    }
    /**
     * Gets the size.
     *
     * @return     The size.
     */
    public int getSize() {
        return size;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String str = "";
        for (int i = 0; i < size; i++) {
            str += students[i].getName() + ","
             + students[i].getTotal() + "," +
              students[i].getCategory() + "\n";
        }
        return str;
    }
    /**
     * string representation
     *
     * @return     { String representation }
     */
    public String toString1() {
        String str = "";
        for (int i = 0; i < size; i++) {
            str += students[i].getName() 
            + "," + students[i].getTotal() + 
            "," + students[i].getCategory() + "\n";
        }
        return str;
    }
    /**
     * exchange method
     *
     * @param      students  The students
     * @param      i         { parameter_description }
     * @param      j         { parameter_description }
     */
    public void exch(final Student[] students,
    final int i, final int j) {
        Student stu = students[j];
        students[j] = students[i];
        students[i] = stu;
    }
    /**
     * contains method.
     *
     * @param      obj   The object
     *
     * @return     { returns true if the object is in array }
     */
    boolean contains(final Student obj) {
        for (Student stu : newstudents) {
            try {
                if(stu.equals(obj)) {
                    return true;
                }   
            } catch (Exception e) {

            }
            
        }
        return false;
    }
    /**
     * sort method
     *
     * @param      noOfvacancies  No ofvacancies
     * @param      noOfunres      No ofunres
     * @param      noOfBC         No of bc
     * @param      noOfSC         No of sc
     * @param      noOfST         No of st
     */
public void sort(final int noOfvacancies,
    final int noOfunres, final int noOfBC,
     final int noOfSC, final int noOfST) {
        int z = 0;
        for(int i = 0; i < noOfunres; i++){
            newstudents[z++] = students[i];
        }
        int bc = 0;
        if(noOfBC != 0) {
            for (int i = noOfunres; i < students.length; i++) {
                try {
                    if (students[i].getCategory().equals("BC")) {
                        newstudents[z++] = students[i];
                        bc++;
                    if(bc == noOfBC){
                        break;
                    }
                }   
            } catch(Exception e) {
            }
            }
        }
        int sc = 0;
        if (noOfSC != 0) {
            for (int i = noOfunres ; i<size; i++ ) {
                if (students[i].getCategory().equals("SC")) {
                    newstudents[z++] = students[i];
                    sc++;
                    if(sc == noOfSC) {
                        break;
                    }
                }
            }
        }
        int st = 0;
        if (noOfST != 0) {
            for (int i = noOfunres ; i<size; i++ ) {
                if (students[i].getCategory().equals("ST")) {
                        newstudents[z++] = students[i];
                        st++;
                        if(st == noOfST) {
                            break;
                        }
                }
            }
        }
        if(bc != noOfBC) {
            for (int i = noOfunres; i<students.length; i++ ) {
                if (!contains(students[i])) {
                        newstudents[z++] = students[i];
                        bc++;
                    if(bc == noOfBC) {
                        break;
                    }
                }
            }
        }
        if(sc != noOfSC) {
            for (int i = noOfunres; i<students.length; i++ ) {
                if (!contains(students[i])){
                        newstudents[z++] = students[i];
                        sc++;
                    if(sc == noOfSC) {
                        break;
                    }
            }
        }
        }
        if(st != noOfST) {
            for (int i = noOfunres; i<students.length; i++ ) {
                if (!contains(students[i])){
                        newstudents[z++] = students[i];
                        st++;
                        if(st == noOfST){
                            break;
                        }
                }
            }
        }
        newstudents = Arrays.copyOf(newstudents, z);
        Arrays.sort(newstudents, Collections.reverseOrder());
    }
    /**
     * insertion sort.
     */
    public void InsertionSort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (!less(students, j - 1, j)) {
                    break;
                } else {
                    exch(students, j - 1, j);
                }
                } 
            }
        }
        /**
         * less method.
         *
         * @param      arr   The arr
         * @param      i     { integer variable }
         * @param      j     { integer variable }
         *
         * @return     { returns the result of less method. }
         */
    public boolean less(final Student[] arr, final int i, final int j) {
        return  arr[i].compareTo(arr[j]) < 0;
    }
}