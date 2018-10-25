import java.util.Scanner;
import java.util.LinkedList;
 class SeparateChainingHashST<Key, Value> {
 	private int n, m;
 	private SequentialSearchST<Key, Value>[] st;
 	public SeparateChainingHashST() {

    } 
	 private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }
     public void put(Key key, Value val) {
        if (val == null) {
            delete(key);
            return;
        }
        int i = hash(key);
        if (!st[i].contains(key)) n++;
        st[i].put(key, val);
    }
    public void delete(Key key) {
        int i = hash(key);
        if (st[i].contains(key)) n--;
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
		for (int i = 1; i <= lineOne.length()- 1; i++) {
			magazine.put(mag[i], i);
		}
		for (int i = 1; i <= lineTwo.length()- 1; i++) {
			ransom.put(ran[i], i);
		}
		System.out.println(magazine);
		System.out.println(ransom);
	}
}