/**
 * Class for student.
 */
class Student {
	/**
	 * name variable.
	 */
	 String name;
	 /**
	  * age.
	  */
	 String dob;
	 /**
	  * marks variable.
	  */
	 int marks1;
	 /**
	  *  marks variable.
	  */
	 int marks2;
	 /**
	  *  marks variable.
	  */
	 int marks3;
	 /**
	  * total marks.
	  */
	 int total;
	 /**
	  * category.
	  */
	 String category;
	 /**
	  * Constructs the object.
	  */
	Student() {

	}
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
	Student(String name, String dob, int marks1, int marks2, int marks3, int total, String category) {
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