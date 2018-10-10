import java.util.Scanner;
import java.util.ArrayList;
/**
 * Class for binarysearch st.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class BinarysearchST<Key extends Comparable<Key>, Value> {
    /**
     * keys array.
     */
    private Key[] keys;
    /**
     * values array.
     */
    private Value[] vals;
    /**
     * size variable.
     */
    private int size;
    /**
     * empty constructor.
     */
    BinarysearchST() {

    }
    /**
     * overloaded constructor.
     *
     * @param      capacity  The capacity
     */
    BinarysearchST(final int capacity) {
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }
    /**
     * resize method.
     *
     * @param      capacity  The capacity
     */
    public void resize(final int capacity) {
        Key[] tempkey = (Key[]) new Comparable[capacity];
        Value[] tempval = (Value[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            tempkey[i] = keys[i];
            tempval[i] = vals[i];
        }
        vals = tempval;
        keys = tempkey;
    }
    /**
     * size method.
     *
     * @return     {returns size.}
     */
    public int size() {
        return size;
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return size() == 0;
    }
    /**
     * contains method.
     *
     * @param      key   The key
     *
     * @return     { returns true if key is in array. }
     */
    public boolean contains(final Key key) {
        return get(key) != null;
    }
    /**
     * gets the value of key.
     *
     * @param      key   The key
     *
     * @return     {returns the value of given key}
     */
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
    /**
     * rank method.
     *
     * @param      key   The key
     *
     * @return     { returns rank. }
     */
    public int rank(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to rank() is null");
        }
        int low = 0; int high = size - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comp = key.compareTo(keys[mid]);
            if (comp < 0) {
                high = mid - 1;
            } else if (comp > 0) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return low;
    }
    /**
     * adds value and key into list.
     *
     * @param      key   The key
     * @param      val   The value
     */
    public void put(final Key key, final Value val) {
        if (key == null) {
            throw new IllegalArgumentException("Null key");
        }
        if (val == null) {
            delete(key);
            return;
        }
        int i = rank(key);
        if (i < size && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }
        if (size == keys.length) {
            resize(2 * keys.length);
        }
        for (int j = size; j > i; j--) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }
        keys[i] = key;
        vals[i] = val;
        size++;
    }
    /**
     * deletes the key and value.
     *
     * @param      key   The key
     */
    public void delete(final Key key) {
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
        for (int j = i; j < size - 1; j++) {
            keys[j] = keys[j + 1];
            vals[j] = vals[j + 1];
        }
        size--;
        keys[size] = null;
        vals[size] = null;
        final int four = 4;
        if (size > 0 && size == keys.length / four) {
            resize(keys.length / 2);
        }
    }
    /**
     * select method.
     *
     * @param      k     { integer variable. }
     *
     * @return     { returns the key }
     */
    public Key select(final int k) {
        if (k < 0 || k >= size()) {
            throw new IllegalArgumentException("Invalid argument");
        }

        return keys[k];
    }
    /**
     * floor method.
     *
     * @param      key   The key
     *
     * @return     { returns floor value }
     */
    public Key floor(final Key key) {
        if (key == null) {
            throw new
            IllegalArgumentException("argument to floor() is null");
        }
        int i = rank(key);
        if (i < size && keys[i].compareTo(key) == 0) {
            return keys[i];
        }
        if (i == 0) {
            return null;
        } else {
            return keys[i - 1];
        }
    }
    /**
     * ceiling method.
     *
     * @param      key   The key
     *
     * @return     { returns ceiling value }
     */
    public Key ceiling(final Key key) {
        if (key == null) {
            throw new
             IllegalArgumentException("argument to ceiling() is null");
        }
        int i = rank(key);
        if (i == size) {
            return null;
        } else {
            return keys[i];
        }
    }
    /**
     * keys method.
     *
     * @return     { returns keys in the list. }
     */
    public ArrayList<String> keys() {
        return keys(min(), max());
    }
    /**
     * min method.
     *
     * @return     { returns minimum key }
     */
    public Key min() {
        return keys[0];
    }
    /**
     * max method.
     *
     * @return     { returns maximum key }
     */
    public Key max() {
        return keys[size - 1];
    }
    /**
     * delete minimum method.
     */
    public void deleteMin() {
        delete(min());
    }
    /**
     * keys method.
     *
     * @param      low   The low
     * @param      high  The high
     *
     * @return     { returns keys and values list }
     */
    public ArrayList<String> keys(
        final Key low, final Key high) {
        ArrayList<String> limit = new ArrayList<>();
        if (low.compareTo(high) > 0) {
            return limit;
        }

        for (int i = rank(low); i < rank(high); i++) {
            limit.add((String) keys[i]);
        }

        if (contains(high)) {
            limit.add((String) keys[rank(high)]);
        }

        return limit;
    }
}
/**
 * Class for solution.
 */
class Solution {
    /**
     * Constructs the object.
     */
    protected Solution() {

    }
    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        BinarysearchST<String, Integer> bst
         = new BinarysearchST<String, Integer>();
        String[] input = sc.nextLine().split(" ");
        bst = new BinarysearchST<String, Integer>(input.length);
        for (int i = 0; i < input.length; i++) {
            bst.put(input[i], i);
        }
        while (sc.hasNextLine()) {
            String[] tokens = sc.nextLine().split(" ");
            switch (tokens[0]) {
                case "contains":
                System.out.println(bst.contains(tokens[1]));
                break;
                case "get":
                System.out.println(bst.get(tokens[1]));
                break;
                case "max":
                System.out.println(bst.max());
                break;
                case "min":
                System.out.println(bst.min());
                break;
                case "floor":
                System.out.println(bst.floor(tokens[1]));
                break;
                case "rank":
                System.out.println(bst.rank(tokens[1]));
                break;
                case "deleteMin":
                bst.deleteMin();
                break;
                case "keys":
                ArrayList<String> limit = bst.keys();
                for (int i = 0; i < limit.size(); i++) {
                    System.out.println(
                        limit.get(i) + " "
                         + bst.get(limit.get(i)));
                }
                break;
                default:
                break;
            }
        }
    }
}