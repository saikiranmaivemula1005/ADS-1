import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

class Merit {
    Student[] students;
    Student[] students1;

    int size;
    Merit() {
        students = new Student[50];
        students1 = new Student[50];

        size = 0;
    }
    
    public void addStudent(Student st) {
        students[size++] = st;
    }
    
    public int getSize() {
        return size;
    }
    
    public String toString() {
        String str = "";
        for (int i = 0; i < size; i++) {
            str += students[i].name+","+students[i].total+","+students[i].category+"\n";
        }
        return str;
    }
    
    public String toString1() {
        String str = "";
        for (int i = 0; i < size; i++) {
            str += students[i].name+","+students[i].total+","+students[i].category+"\n";
        }
        return str;
    }
    public void exch(Student[] students, int i, int j) {
        Student stu = students[j];
        students[j] = students[i];
        students[i] = stu;
    }

    boolean contains(Student obj) {
        for (Student stu : students1) {
            try {
                if(stu.equals(obj)) {
                    return true;
                }   
            } catch (Exception e) {

            }
            
        }
        return false;
    }



    public void sort(int noOfvacancies,int noOfunres,int noOfBC,int noOfSC,int noOfST) {
        int z = 0;
        for(int i = 0; i<noOfunres; i++){
            students1[z++] = students[i];
            // System.out.println(students1[i]);
        }

        int bc = 0;
        if(noOfBC != 0) {
            for (int i = noOfunres; i<students.length; i++ ) {
                try {
                    if (students[i].category.equals("BC")) {
                        students1[z++] = students[i];
                        bc++;
                    if(bc == noOfBC){
                        break;
                    }
            // System.out.println(students1[i]);

                }   
            } catch(Exception e) {

            }

                

            }
        }

        int sc = 0;
        if (noOfSC != 0) {
            for (int i = noOfunres ; i<size; i++ ) {
                if (students[i].category.equals("SC")) {
                    students1[z++] = students[i];
                    sc++;
                    if(sc == noOfSC) {
                        break;
                    }
                }
            }
        }

        int st = 0;
        if (noOfST != 0) {
            for (int i = noOfunres ; i<size; i++ ) {
                if (students[i].category.equals("ST")) {
                        students1[z++] = students[i];
                        st++;
                        if(st == noOfST) {
                            break;
                        }
                }
            }
        }

        
        

        
        
        
        if(bc != noOfBC) {
            for (int i = noOfunres; i<students.length; i++ ) {
                if (!contains(students[i])){
                        students1[z++] = students[i];
                        bc++;
                    if(bc == noOfBC){
                        break;
                    }
            // System.out.println(students1[i]);
                }
            }
        }

        if(sc != noOfSC) {
            for (int i = noOfunres; i<students.length; i++ ) {
                if (!contains(students[i])){
                        students1[z++] = students[i];
                        sc++;
                    if(sc == noOfSC){
                        break;
                    }
            // System.out.println(students1[i]);
            }
        }
    
        }

        if(st != noOfST) {
            for (int i = noOfunres; i<students.length; i++ ) {
                if (!contains(students[i])){
                        students1[z++] = students[i];
                        st++;
                        if(st == noOfST){
                            break;
                        }
            // System.out.println(students1[i]);
                }
            }
    
        }

        students1 = Arrays.copyOf(students1, z);
        Arrays.sort(students1, Collections.reverseOrder());

    }
        
    public void InsertionSort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (!less(students, j - 1, j)) {
                    break;
                } else {
                    exch(students, j - 1, j);
                }
                } 
            }
        }

    public boolean less(Student[] arr, int i, int j) {
        return  arr[i].compareTo(arr[j]) < 0;
    }
}
class Solution {
    Solution() {
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Merit m = new Merit();
            int noOfapplied = Integer.parseInt(sc.nextLine());
            int noOfvacancies = Integer.parseInt(sc.nextLine());
            int noOfunres = Integer.parseInt(sc.nextLine());
            int noOfBC = Integer.parseInt(sc.nextLine());
            int noOfSC = Integer.parseInt(sc.nextLine());
            int noOfST = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < noOfapplied; i++) {
                String data = sc.nextLine();
                String[] tokens = data.split(",");
                m.addStudent(new Student(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4], tokens[5], tokens[6]));
            }
        m.InsertionSort();
        System.out.println(m);
        m.sort(noOfvacancies,noOfunres,noOfBC,noOfSC,noOfST);
        // System.out.println(m);
        for (int i = 0;i<noOfvacancies ;i++ ) {
            System.out.println(m.students1[i]);
            
        }
    }
    
}