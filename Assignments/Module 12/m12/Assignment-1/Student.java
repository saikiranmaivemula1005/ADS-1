/**
 * Class for student.
 */
class Student {
	 String name;
	 String dob;
	 int marks1;
	 int marks2;
	 int marks3;
	 int total;
	 String category;
	Student() {

	}
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