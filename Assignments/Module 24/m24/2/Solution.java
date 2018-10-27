import java.util.Scanner;
class Student {
	String name;
	double marks;
	Student() {

	}
	Student(String n, double m) {
		this.name = n;
		this.marks = m;
	}
	public String getname() {
		return this.name;
	}
	public double getmarks() {
		return this.marks;
	}
}


class Solution {
	Solution() {
	}
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int numberOfStudents = sc.nextInt();
			BinarySearchST<Integer, Student> bst = new BinarySearchST<Integer, Student>();
			for (int i = 0; i < numberOfStudents; i++) {
				String[] data = sc.next().split(",");
				// System.out.println(data[1]);
				sc.nextLine();
				// sc.nextLine();
				Student student = new Student();
				student = new Student(data[1], Double.parseDouble(data[2]));
				bst.put(Integer.parseInt(data[0]), student);
			}
			String queries = sc.next();
			for (int i = 0; i < Integer.parseInt(queries); i++) {
				sc.next();
				String[] data = sc.nextLine().split(" ");
				// System.out.println(data[0]);
				// System.out.println(data[2]);
				if (data[0].equals("BE")) {
					System.out.println(bst.keys(Integer.parseInt(data[1]), Integer.parseInt(data[2])));
				}
				if (data[0].equals("GE")) {
					System.out.println(bst.keys(Integer.parseInt(data[1]), bst.max()));
				}
				if (data[0].equals("LE")) {
					System.out.println(bst.keys(Integer.parseInt(data[1]),bst. min()));
				}
				
			}
		}
	}
