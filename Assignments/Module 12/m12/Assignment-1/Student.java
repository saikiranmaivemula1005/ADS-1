class Student implements Comparable<Student> {
	String name;
	String dob;
	int s1;
	int s2;
	int s3;
	int total;
	String category;
	Student(String name, String dob, String s1, String s2, String s3, String total, String category) {
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
	public String getName() {
        return name;
	}
	public int getTotal() {
		return total;
	}
	public String getCategory() {
        return category;
	}
	public int getYear() {
		String[] date = dob.split("-");
		int year = Integer.parseInt(date[2]);
		return year;
	}
	public int getMonth() {
		String[] date = dob.split("-");
		int month = Integer.parseInt(date[1]);
		return month;
	}
	public int getDay() {
		String[] date = dob.split("-");
		int day = Integer.parseInt(date[0]);
		return day;
	}
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
	public String toString() {
		return this.name+","+this.total+","+this.category;
	}
}
