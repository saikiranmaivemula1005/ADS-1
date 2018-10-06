import java.util.Comparator;
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

}