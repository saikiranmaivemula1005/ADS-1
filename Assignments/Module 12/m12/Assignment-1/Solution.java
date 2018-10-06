import java.util.Scanner;
import java.util.Comparator;
import java.util.Arrays;
class Student {
	String name;
	String dob;
	int marks1;
	int marks2;
	int marks3;
	int total;
	String category;
	Student(String name, String dob, int marks1, int marks2, int marks3, int total, String category) {
		this.name = name;
		this.dob = dob;
		this.marks1 = marks1;
		this.marks2 = marks2;
		this.marks3 = marks3;
		this.total = total;
		this.category = category;
	}
	String getName() {
		return name;
	}
	String getdob() {
		return dob;
	}
	int getMarks() {
		return total;
	}
	String getCategory() {
		return category;
	}
	String show() {
		return name + "," + getMarks() + "," + getCategory();
	}

}

class Allotment {
	Student[] students;
	MergeSort<Student> ms = new MergeSort<Student>();
	Allotment(Student[] students) {
		this.students = students;
	}
	void sortByMarks(Comparator<Student> c) {
		ms.sort(students, c);
	}
	void sortByAge(Comparator<Student> c) {
		ms.sort(students, c);
	}
	void showStudents() {
		System.out.println(Arrays.toString(students));
	}

}
class sortByMarks implements Comparator<Student> {
	public int compare(Student s1, Student s2) {
		return s1.total - s2.total;
	}
}
class sortByAge implements Comparator<Student> {
	public int compare(Student s1, Student s2) {
		return s1.dob.compareTo(s2.dob);
	}
}

class MergeSort<T> {
    private  T[] aux;
    public  void sort(T[] a, Comparator<T> cp) {
        aux = (T[]) new Object[a.length];
        sort(a, 0, a.length - 1, cp);
    }
    private void merge(T[] a, int lo, int mid, int hi, Comparator<T> cp) {
        int i = lo, j = mid + 1;
        
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];

        for (int k = lo; k <= hi; k++)
            if      (i > mid)              a[k] = aux[j++];
            else if (j > hi )              a[k] = aux[i++];
            else if (less(aux[j], aux[i], cp)) a[k] = aux[j++];
            else                           a[k] = aux[i++];
    }
    private boolean less(T a, T b, Comparator<T> cp) {
        return cp.compare(a,b) < 0;
    }
    private void sort(T[] a, int lo, int hi, Comparator<T> cp) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid, cp);
        sort(a, mid + 1, hi, cp);
        merge(a, lo, mid, hi, cp);
    }
}
class Solution {
	Solution() {

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int qualifiedStudents = sc.nextInt();
		int vacancies = sc.nextInt();
		int openSeats = sc.nextInt();
		int bcSeats = sc.nextInt();
		int scSeats = sc.nextInt();
		int stseats = sc.nextInt();
		String[] students = new String[100];
		Student[] object = new Student[100];
		for (int i = 0; i < qualifiedStudents; i++){
			 students[i] = sc.next();
			String[] tokens = students[i].split(",");
			object[i] = new Student(tokens[0], tokens[1], Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4]), Integer.parseInt(tokens[5]), tokens[6]);
		}
		// System.out.println(student);
		Allotment a = new Allotment(object);
		a.showStudents();

	}
}