import java.util.Scanner;
import java.util.Comparator;



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
class sortByCategory implements Comparator<Student> {
	public int compare(Student s1, Student s2) {
		return s1.category.compareTo(s2.category);
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
		String[] students = new String[qualifiedStudents];
		Student[] object = new Student[qualifiedStudents];
		for (int i = 0; i < qualifiedStudents; i++){
			 students[i] = sc.next();
			String[] tokens = students[i].split(",");
			object[i] = new Student(tokens[0], tokens[1], Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4]), Integer.parseInt(tokens[5]), tokens[6]);
			// System.out.println(object[i].show());
		}
		// System.out.println(student);
		Allotment a = new Allotment(object);
		a.sortByMarks(new sortByMarks());
		a.showStudents();
		System.out.println();
		a.sortByCategory(new sortByCategory());
		a.showStudents();
	}
}