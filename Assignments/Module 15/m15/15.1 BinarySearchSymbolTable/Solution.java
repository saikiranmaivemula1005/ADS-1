import java.util.Scanner;
import java.util.NoSuchElementException;
/**
 * Class for binary search st.
 */
class BinarySearchST<Key extends Comparable<Key>, Value>{
	private Key[] keys;
    private Value[] vals;
    private int size = 1;
	/**
	 * constructor for the class.
	 */
	BinarySearchST() {
		keys = (Key[]) new Comparable[10];
		vals = (Value[]) new Object[10];
	}
	public int size() {
		return size;
	}
	public Key max() {
		if (isEmpty()) {
			System.out.println(("called max() with empty symbol table"));
		}
        return keys[size-1];
	}
	public Key floor(final Key key) {
		 if (key == null) {
		 	throw new IllegalArgumentException("argument to floor() is null");
		 }
        int i = rank(key);
        if (i < size && key.compareTo(keys[i]) == 0) {
        	return keys[i];
        }
        if (i == 0) {
        	return null;
        } else {
        	return keys[i-1];
        }
	}
	public boolean isEmpty() {
        return size() == 0;
    }
	public int rank(final Key key) {
		if (key == null) {
			throw new IllegalArgumentException("argument to rank() is null");
		}
        int lo = 0, hi = size-1; 
        while (lo <= hi) { 
            int mid = lo + (hi - lo) / 2; 
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
            	hi = mid - 1;
            } 
            else if (cmp > 0) {
            	lo = mid + 1;
            } else {
            	return mid;
            } 
        } 
        return lo;
	}
	public void deleteMin(){
		if (isEmpty()) {
			throw new NoSuchElementException("Symbol table underflow error");
		}
        delete(min());
	}
	public void delete(Key key) {
        if (key == null) {
        	throw new IllegalArgumentException("argument to delete() is null");
        } 
        if (isEmpty()) {
        	return;
        }
        int i = rank(key);
        if (i == size || keys[i].compareTo(key) != 0) {
            return;
        }
        for (int j = i; j < size-1; j++) {
            keys[j] = keys[j+1];
            vals[j] = vals[j+1];
        }
        size--;
        keys[size] = null;
        vals[size] = null;
    }
    public Key min() {
        if (isEmpty()) {
        	throw new NoSuchElementException("called min() with empty symbol table");
        }
        return keys[0]; 
    }
	public void put(Key key, Value value) {
		if (key == null) {
			throw new IllegalArgumentException("first argument to put() is null");
		}
        if (value == null) {
            delete(key);
            return;
        }
        int i = rank(key);
        if (i < size && keys[i].compareTo(key) == 0) {
            vals[i] = value;
            return;
        }
	}
	public boolean contains(final Key key) {
		if (key == null) {
			throw new IllegalArgumentException("argument to contains() is null");
		}
        return get(key) != null;
	}
	public void keys() {
		for (int i = 0; i < keys.length; i++) {
			System.out.println(keys[i] + " " + vals[i]);
		}
	}
	public Value get(final Key key) {
		if (key == null) {
			throw new IllegalArgumentException("argument to get() is null");
		} 
        if (isEmpty()) {
        	return null;
        }
        int i = rank(key); 
        if (i < size && keys[i].compareTo(key) == 0) {
        	return vals[i];
        }
        return null;
	}
}

class Solution {
	protected Solution() {

	}
	public static void main(final String[] args) {
		BinarySearchST<String, Integer> bst = new BinarySearchST<String, Integer>();
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String inputWord = sc.next();
			String[] tokens = inputWord.split(" ");
			String line = sc.next();
			String[] cases = line.split(" ");
			switch (cases[0]) {
				case "max":
					bst.max();
					break;
				case "floor":
					bst.floor(cases[1]);
					break;
				case "rank":
					bst.rank(cases[1]);
					break;
				case "deleteMin":
					bst.deleteMin();
					break;
				case "contains":
					bst.contains(cases[1]);
					break;
				case "keys":
					bst.keys();
					break;
				case "get":
					bst.get(cases[1]);
					break;
			}
		}
	}
}