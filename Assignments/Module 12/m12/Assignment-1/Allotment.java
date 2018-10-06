import java.util.Comparator;

class Allotment {
	Student[] students;
	// Student s = new Student();
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
		for (int i = students.length - 1; i >= 0; i--) {
			System.out.println(students[i].show());
		}
	}
	void sortByCategory(Comparator<Student> c) {
		ms.sort(students, c);
	}

}