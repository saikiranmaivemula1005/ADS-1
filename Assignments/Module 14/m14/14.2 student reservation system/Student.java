/**
 * Class for student.
 */
class Student implements Comparable<Student> {
	/**
	 * name.
	 */
	private String name;
	/**
	 * dob.
	 */
	private String dob;
	/**
	 * s1.
	 */
	private int s1;
	/**
	 * s2.
	 */
	private int s2;
	/**
	 * s3.
	 */
	private int s3;
	/**
	 * total.
	 */
	private int total;
	/**
	 * category.
	 */
	private String category;
	/**
	 * Constructs the object.
	 *
	 * @param      name      The name
	 * @param      dob       The dob
	 * @param      s1        The s 1
	 * @param      s2        The s 2
	 * @param      s3        The s 3
	 * @param      total     The total
	 * @param      category  The category
	 */
	Student(final String name,
	final  String dob, final String s1,
	 final String s2, final String s3,
	 final  String total, final String category) {
		this.name = name;
		this.dob = dob;
		String[] date = dob.split("-");
		int year = Integer.parseInt(date[2]);
		int month = Integer.parseInt(date[1]);
		int day = Integer.parseInt(date[0]);
		this.s1 = Integer.parseInt(s1);
		this.s2 = Integer.parseInt(s2);
		this.s3 = Integer.parseInt(s3);
		this.total = Integer.parseInt(total);
		this.category = category;
	}
	/**
	 * Gets the name.
	 *
	 * @return     The name.
	 */
	public String getName() {
        return name;
	}
	/**
	 * Gets the total.
	 *
	 * @return     The total.
	 */
	public int getTotal() {
		return total;
	}
	/**
	 * Gets the category.
	 *
	 * @return     The category.
	 */
	public String getCategory() {
        return category;
	}
	/**
	 * Gets the year.
	 *
	 * @return     The year.
	 */
	public int getYear() {
		String[] date = dob.split("-");
		int year = Integer.parseInt(date[2]);
		return year;
	}
	/**
	 * Gets the month.
	 *
	 * @return     The month.
	 */
	public int getMonth() {
		String[] date = dob.split("-");
		int month = Integer.parseInt(date[1]);
		return month;
	}
	/**
	 * Gets the day.
	 *
	 * @return     The day.
	 */
	public int getDay() {
		String[] date = dob.split("-");
		int day = Integer.parseInt(date[0]);
		return day;
	}
	/**
	 * compare to method.
	 *
	 * @param      s     { parameter_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	public int compareTo(Student s) {
		if (this.total > s.total) {
			return 1;
		}
		if (this.total < s.total) {
			return -1;
		}
		if (this.s3 > s.s3) {
			return 1;
		}
		if (this.s3 < s.s3) {
			return -1;
		}
		if (this.s2 > s.s2) {
			return 1;
		}
		if (this.s2 < s.s2) {
			return -1;
		}
		if (this.getYear() > s.getYear()) {
			return 1;
		}
		if (this.getYear() < s.getYear()) {
			return -1;
		}
		if (this.getMonth() > s.getMonth()) {
            return 1;
		}
		if (this.getMonth() < s.getMonth()) {
            return -1;
		}
		if (this.getDay() > s.getDay()) {
			return 1;
		}
		if (this.getDay() < s.getDay()) {
			return -1;
		}
		return 0;
	}
	/**
	 * Returns a string representation of the object.
	 *
	 * @return     String representation of the object.
	 */
	public String toString() {
		return this.name + "," + this.total + "," + this.category;
	}
}
