import java.util.Scanner;
import java.util.Comparator;
/**
 * Class for student.
 */
class Student {
    /**
     * name variable.
     */
     public String name;
     /**
      * age.
      */
     public String dob;
     /**
      * marks variable.
      */
     public int marks1;
     /**
      *  marks variable.
      */
     public int marks2;
     /**
      *  marks variable.
      */
     public int marks3;
     /**
      * total marks.
      */
     public int total;
     /**
      * category.
      */
     public String category;
     /**
      * Constructs the object.
      */
    /**
     * Constructs the object.
     *
     * @param      name      The name
     * @param      dob       The dob
     * @param      marks1    The marks 1
     * @param      marks2    The marks 2
     * @param      marks3    The marks 3
     * @param      total     The total
     * @param      category  The category
     */
    Student(final String name, 
        final String dob, final int marks1,
        final int marks2, final int marks3,
        final  int total, final String category) {
        this.name = name;
        this.dob = dob;
        this.marks1 = marks1;
        this.marks2 = marks2;
        this.marks3 = marks3;
        this.total = total;
        this.category = category;
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    String getName() {
        return name;
    }
    /**
     * gets age.
     *
     * @return     { description_of_the_return_value }
     */
    String getdob() {
        return dob;
    }
    /**
     * Gets the marks.
     *
     * @return     The marks.
     */
    int getMarks() {
        return total;
    }
    /**
     * Gets the category.
     *
     * @return     The category.
     */
    String getCategory() {
        return category;
    }
    /**
     * prints the data.
     *
     * @return     { description_of_the_return_value }
     */
    String show() {
        return name + "," + getMarks() + "," + getCategory();
    }
}
/**
 * Class for merge sort.
 *
 * @param      <T>   { parameter_description }
 */
class MergeSort<T> {
    /**
     * auxiliary array.
     */
    private  T[] aux;
    /**
     * sort method.
     *
     * @param      a     { array }
     * @param      cp    { comparator variable }
     */
    public  void sort(final T[] a, final Comparator<T> cp) {
        aux = (T[]) new Object[a.length];
        sort(a, 0, a.length - 1, cp);
    }
    /**
     * merge method.
     *
     * @param      a     { array }
     * @param      lo    The lower
     * @param      mid   The middle
     * @param      hi    The higher
     * @param      cp    { comparator variable }
     */
    public void merge(final T[] a,
     final int lo, final int mid,
      final int hi, final Comparator<T> cp) {
        int i = lo, j = mid + 1;
        
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              a[k] = aux[j++];
            else if (j > hi )              a[k] = aux[i++];
            else if (less(aux[j], aux[i], cp)) a[k] = aux[j++];
            else                           a[k] = aux[i++];
        }
    }
    /**
     * less method.
     *
     * @param      a     { variable}
     * @param      b     { variable }
     * @param      cp    {comparator variable }
     *
     * @return     { description_of_the_return_value }
     */
    public boolean less(T a, T b, Comparator<T> cp) {
        return cp.compare(a,b) < 0;
    }
    /**
     * sort method.
     *
     * @param      a     { array }
     * @param      lo    The lower
     * @param      hi    The higher
     * @param      cp    { comparator variable}
     */
    public void sort(T[] a, int lo, int hi, Comparator<T> cp) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid, cp);
        sort(a, mid + 1, hi, cp);
        merge(a, lo, mid, hi, cp);
    }
}

/**
 * Class for allotment.
 */
class Allotment {
    /**
     * students array.
     */
    Student[] students;
    // Student s = new Student();
    MergeSort<Student> ms = new MergeSort<Student>();
    /**
     * Constructs the object.
     *
     * @param      students  The students
     */
    Allotment(Student[] students) {
        this.students = students;
    }
    void sortByMarks(final Comparator<Student> c) {
        ms.sort(students, c);
    }
    void sortByAge(final Comparator<Student> c) {
        ms.sort(students, c);
    }
    void showStudents() {
        for (int i = students.length - 1; i >= 0; i--) {
            System.out.println(students[i].show());
        }
    }
    void sortByCategory(final Comparator<Student> c) {
        ms.sort(students, c);
    }
    //  void removeElement(Object[] arr, int removedIdx) {
    //     System.arraycopy(arr, removedIdx + 1
    //     , arr, removedIdx, arr.length - 1 - removedIdx);
    // }

}
/**
 * Class for sort by marks.
 */
 class sortByMarks implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        return s1.total - s2.total;
    }
}
/**
 * Class for sort by age.
 */
class sortByAge implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        return s1.dob.compareTo(s2.dob);
    }
}
/**
 * Class for sort by category.
 */
class sortByCategory implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        return s1.category.compareTo(s2.category);
    }
}
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
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int qualifiedStudents = sc.nextInt();
        int vacancies = sc.nextInt();
        int openSeats = sc.nextInt();
        int bcSeats = sc.nextInt();
        int scSeats = sc.nextInt();
        int stseats = sc.nextInt();
        String[] students = new String[qualifiedStudents];
        Student[] object = new Student[qualifiedStudents];
        for (int i = 0; i < qualifiedStudents; i++){
             students[i] = sc.next();
            String[] tokens = students[i].split(",");
            object[i] = new Student(tokens[0], tokens[1],
             Integer.parseInt(tokens[2]),
              Integer.parseInt(tokens[3]),
               Integer.parseInt(tokens[4]),
                Integer.parseInt(tokens[5]), tokens[6]);
            // System.out.println(object[i].show());
        }
        // System.out.println(student);
        Allotment a = new Allotment(object);
        a.sortByMarks(new sortByMarks());
        a.showStudents();
        System.out.println();
        for (int j = object.length - 1; j >= object.length - openSeats; j--) {
            System.out.println(object[j].show());
            // a.removeElement(object, j);
        }
        for (int i = object.length - openSeats; i > 0; i--) {

            for (int j = 0; j < stseats; j++) {
                if (object[i].getCategory().equals("BC")) {
                    System.out.println(object[i].show());
                }
            }
            }
        for (int i = object.length - openSeats - bcSeats; i > 0; i--) {

            for (int j = 0; j < stseats; j++) {
                if (object[i].getCategory().equals("ST")) {
                    System.out.println(object[i].show());
                }
            }
            }
        for (int i = object.length - openSeats - stseats - bcSeats; i > 0; i--) {
            for (int k = 0; k < scSeats; k++) {
                if (object[i].getCategory().equals("SC")) {
                    System.out.println(object[i].show());
                    return;
                }
            }
            }
        
        
    }
}