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
			BinarySearchST<Integer, Student> bst = new BinarySearchST<Integer, Student>();
			while(sc.hasNext()) {
				String data = sc.nextLine();
				String[] tokens = data.split(",");
				// System.out.println(data[1]);
				// sc.nextLine();
				// Student student = new Student();
				System.out.println(tokens[1]);
				System.out.println(tokens[2]);
				Student student = new Student(tokens[1], Double.parseDouble(tokens[2]));
				bst.put(Integer.parseInt(tokens[0]), student);
			}
			String queries = sc.next();
			for (int i = 0; i < Integer.parseInt(queries); i++) {
				sc.next();
				String data = sc.nextLine();
				String[] tokens = data.split(" ");
				// System.out.println(data[0]);
				// System.out.println(data[2]);
				if (tokens[1].equals(null)) {
					System.out.println("Student doesn't exists...");
				}
				if (tokens[2].equals(1)) {
					System.out.println(bst.get(i).getname());
				}
				if (tokens[2].equals(2)) {
					System.out.println(bst.get(i).getpercentage());
				}
				
			}
		}
	}
