import java.util.Scanner;
import java.util.LinkedList;
 class SeparateChainingHashST {
 	private int n, m;
 	private SequentialSearchST<String, Integer>[] st;
 	public SeparateChainingHashST() {
 		st = (SequentialSearchST<String, Integer>[]) new SequentialSearchST[m];
    } 
	 private int hash(String key) {
        return (key.hashCode()) % m;
    }
     public void put(String key, Integer val) {
        if (val == null) {
            delete(key);
            return;
        }
        int i = hash(key);
        if (!st[i].contains(key))  {
        	n++;
        }
        st[i].put(key, val);
    }
    public void delete(String key) {
        int i = hash(key);
        if (st[i].contains(key)) {
        	n--;
        }
        st[i].delete(key);
    }
     public Integer get(String key) {
        int i = hash(key);
        return st[i].get(key);
    } 
     public boolean contains(String key) {
        return get(key) != null;
    }
    
}
class Solution {
	Solution() {

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SeparateChainingHashST magazine = new SeparateChainingHashST();
		SeparateChainingHashST ransom = new SeparateChainingHashST();
		int m = sc.nextInt();
		int n = sc.nextInt();
		sc.nextLine();
		String lineOne = sc.nextLine();
		String[] mag = lineOne.split(" ");
		// for (int  i = 0; i < mag.length; i++) {
		// 	System.out.println(mag[i]);
		// }
		String lineTwo = sc.nextLine();
		String[] ran = lineTwo.split(" ");
		// for (int  i = 0; i < ran.length; i++) {
		// 	System.out.println(ran[i]);
		// }
		for (int i = 0; i < mag.length; i++) {
			System.out.println(mag[i]);
			magazine.put(mag[i], i);
		}
		for (int i = 0; i < ran.length; i++) {
			System.out.println(ran[i]);
			ransom.put(ran[i], i);
		}
		// System.out.println(magazine);
		// System.out.println(ransom);
	}
}