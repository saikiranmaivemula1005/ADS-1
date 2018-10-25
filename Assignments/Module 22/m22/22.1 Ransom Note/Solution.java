import java.util.Scanner;
import java.util.LinkedList;
 class SeparateChainingHashST {
 	private int n, m;
 	private SequentialSearchST<String, Integer>[] st;
 	public SeparateChainingHashST() {
 		st = (SequentialSearchST<String, Integer>[]) new SequentialSearchST[m];
 		m = 1;
 		n = 1;
    } 
	 private int hash(String key) {
        return (key.hashCode() & 0x7fffffff) % m;
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
		String lineOne = sc.next();
		String[] mag = lineOne.split(" ");
		String lineTwo = sc.next();
		String[] ran = lineTwo.split(" ");
		for (int i = 0; i < mag.length; i++) {
			magazine.put(mag[i], i);
		}
		for (int i = 0; i < ran.length; i++) {
			ransom.put(ran[i], i);
		}
		System.out.println(magazine);
		System.out.println(ransom);
	}
}