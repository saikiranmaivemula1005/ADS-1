import java.util.Scanner;
class Student {
	String name;
	double percentage;
	Student() {

	}
	Student(String n, double p) {
		this.name = n;
		this.percentage = p;
	}
	public String getname() {
		return this.name;
	}
	public double getpercentage() {
		return this.percentage;
	}
}


class Solution {
	Solution() {
	}
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int numberOfStudents = sc.nextInt();
			sc.nextLine();
			Student[] students = new Student[numberOfStudents];
			BinarySearchST<Integer, Student> bst = new BinarySearchST<Integer, Student>();
			for (int i = 0; i < numberOfStudents; i++) {
				String[] data = sc.next().split(",");
				// System.out.println(data[1]);
				// sc.nextLine();
				System.out.println(data[2]);
				students[i] = new Student(data[1], Double.parseDouble(data[2]));
				System.out.println(students[i]);
				bst.put(Integer.parseInt(data[0]), students[i]);
			}
			String queries = sc.next();
			for (int i = 0; i < Integer.parseInt(queries); i++) {
				sc.next();
				String[] data = sc.nextLine().split(" ");
				// System.out.println(data[0]);
				// System.out.println(data[2]);
				if (data[1].equals(null)) {
					System.out.println("Student doesn't exists...");
				}
				if (data[2].equals(1)) {
					System.out.println("kk");
					System.out.println(bst.get(i).getname());
				}
				if (data[2].equals(2)) {
					System.out.println(bst.get(i).getpercentage());
				}
				
			}
		}
	}
