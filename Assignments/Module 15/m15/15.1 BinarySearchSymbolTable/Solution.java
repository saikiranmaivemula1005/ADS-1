import java.util.Scanner;
import java.util.NoSuchElementException;
/**
 * Class for binary search st.
 */
class BinarySearchST<Key extends Comparable<Key>, Value>{
    private Key[] keys;
    private Value[] vals;
    private int size = 0;
    /**
     * constructor for the class.
     */
    BinarySearchST() {
    }
    BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }
    public int size() {
        return size;
    }
    public Key max() {
        if (isEmpty()) {
            throw new NoSuchElementException(("called max() with empty symbol table"));
        }
        return keys[size - 1];
    }
    public Key floor(final Key key) {
         if (key == null) {
            throw new IllegalArgumentException("argument to flowor() is null");
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
        int low = 0, high = size - 1; 
        while (low <= high) { 
            int mid = low + (high - low) / 2; 
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
                high = mid - 1;
            } 
            else if (cmp > 0) {
                low = mid + 1;
            } else {
                return mid;
            } 
        } 
        return low;
    }
    public void deleteMin(){
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
         if (size > 0 && size == keys.length / 4) {
            resize(keys.length / 2);
        }
    }
     public void resize(int capacity) {
        Key[] temporaykey = (Key[]) new Comparable[capacity];
        Value[] temporarval = (Value[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            temporaykey[i] = keys[i];
            temporarval[i] = vals[i];
        }

        vals = temporarval;
        keys = temporaykey;
    }
    public Key min() {
        return keys[0]; 
    }
    public void put(Key key, Value value) {
        if (key == null) {
            throw new IllegalArgumentException("Null key");
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
        if (size == keys.length) {
            resize(2 * keys.length);
        }
        for (int j = size; j > i; j--)  {
            keys[j] = keys[j-1];
            vals[j] = vals[j-1];
        }
        keys[i] = key;
        vals[i] = value;
        size++;
    }
    public boolean contains(final Key key) {
        return get(key) != null;
    }
    public List<String> keys() {
        return keys(min(), max());
    }
    public List<String> keys(Key loww, Key highgh) {
        if (loww == null) {
            throw new IllegalArgumentException("first argument to keys() is null"); 
        }

        if (highgh == null) {
            throw new IllegalArgumentException("last argument to keys() is null"); 
        }

        List<String> list = new List<>();
        if (loww.compareTo(highgh) > 0) {
            return list;
        }

        for (int i = rank(loww); i < rank(highgh); i++) {
            list.add((String)keys[i]);
        }

        if (contains(highgh)) {
            list.add((String)keys[rank(highgh)]);
        }

        return list;
    }
    public Value get(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Key is null");
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
            String inputWord = sc.next();
            String[] tokens = inputWord.split(" ");
            bst = new BinarySearchST<String, Integer>(tokens.length);
            for (int i = 0; i < tokens.length; i++) {
                System.out.println(tokens[i]);
                bst.put(tokens[i], i);
            }
        while (sc.hasNext()) {
            String line = sc.next();
            String[] cases = line.split(" ");
            switch (cases[0]) {
                case "max":
                    System.out.println(bst.max());
                    break;
                case "floor":
                    System.out.println(bst.floor(cases[1]));
                    break;
                case "rank":
                    System.out.println(bst.rank(cases[1]));
                    break;
                case "deleteMin":
                    bst.deleteMin();
                    break;
                case "contains":
                    System.out.println(bst.contains(cases[1]));
                    break;
                case "keys":
                    List<String> list = bst.keys();
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println(list.get(i) + " " + bst.get(list.get(i)));
                    }
                    break;
                case "get":
                    System.out.println(bst.get(cases[1]));
                    break;
            }
        }
    }
}