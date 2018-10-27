import java.util.Scanner;
import java.util.ArrayList;
/**
 * Class for linear probing hash st.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class LinearProbingHashST<Key, Value> {
    /**
     * Capacity value.
     */
    private static final int INIT_CAPACITY = 4;
    /**
     * number of key-value pairs in the symbol table.
     */
    private int n;
    /**
     * size of linear probing table.
     */
    private int m;
    /**
     * the keys.
     */
    private Key[] keys;
    /**
     * the values.
     */
    private Value[] vals;


    /**
     * Initializes an empty symbol table.
     */
    LinearProbingHashST() {
        this(INIT_CAPACITY);
    }

    /**
     * Initializes an empty symbol table with the specified initial capacity.
     *
     * @param capacity the initial capacity
     */
    LinearProbingHashST(final int capacity) {
        m = capacity;
        n = 0;
        keys = (Key[])   new Object[m];
        vals = (Value[]) new Object[m];
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     *
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return n;
    }

    /**
     * Returns true if this symbol table is empty.
     * Complexity is 1.
     *
     * @return {@code true} if this symbol table is empty;
     *         {@code false} otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns true if this symbol table.
     * contains the specified key.
     * Complexity is N.
     *
     * @param  key the key
     * @return {@code true} if this symbol
     * table contains {@code key};
     *         {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public boolean contains(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException(
                "argument to contains() is null");
        }
        return get(key) != null;
    }

    /**
     * hash function for keys - returns value between 0 and M-1.
     * Complexity is 1.
     *
     * @param      key   The key
     *
     * @return     { hash value }
     */
    private int hash(final Key key) {
        final int eleven = 11;
        return (eleven * key.hashCode()) % m;
    }


    /**
     * resizes the hash table to the given.
     * capacity by re-hashing all of the keys.
     * Complexity is N.
     *
     *
     * @param      capacity  The capacity
     */
    private void resize(final int capacity) {
        LinearProbingHashST<Key, Value> temp
        = new LinearProbingHashST<Key, Value>(capacity);
        for (int i = 0; i < m; i++) {
            if (keys[i] != null) {
                temp.put(keys[i], vals[i]);
            }
        }
        keys = temp.keys;
        vals = temp.vals;
        m    = temp.m;
    }

    /**
     * Inserts the specified key-value pair into
     * the symbol table, overwriting the old
     * value with the new value if the symbol
     * table already contains the specified key.
     * Deletes the specified key (and its
     * associated value) from this symbol table
     * if the specified value is {@code null}.
     * Complexity is N.
     *
     * @param  key the key
     * @param  val the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void put(final Key key, final Value val) {
        if (key == null) {
            throw new IllegalArgumentException(
                "first argument to put() is null");
        }

        if (val == null) {
            delete(key);
            return;
        }

        // double table size if 50% full
        if (n >= m / 2) {
            resize(2 * m);
        }

        int i;
        for (i = hash(key); keys[i] != null;
            i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        n++;
    }

    /**
     * Returns the value associated with the specified key.
     * Complexity is N.
     * @param key the key
     * @return the value associated with {@code key};
     *         {@code null} if no such value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Value get(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException(
                "argument to get() is null");
        }
        for (int i = hash(key); keys[i] != null;
            i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                return vals[i];
            }
        }
        return null;
    }

    /**
     * Removes the specified key and its associated
     * value from this symbol table
     * (if the key is in this symbol table).
     * Complexity is N.
     *
     * @param  key the key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void delete(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException(
                "argument to delete() is null");
        }
        if (!contains(key)) {
            return;
        }

        // find position i of key
        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % m;
        }

        // delete key and associated value
        keys[i] = null;
        vals[i] = null;

        // rehash all keys in same cluster
        i = (i + 1) % m;
        while (keys[i] != null) {
            // delete keys[i] an vals[i] and reinsert
            Key keyToRehash = keys[i];
            Value valToRehash = vals[i];
            keys[i] = null;
            vals[i] = null;
            n--;
            put(keyToRehash, valToRehash);
            i = (i + 1) % m;
        }
        n--;
        // halves size of array if it's 12.5% full or less
        final int eight = 8;
        if (n > 0 && n <= m / eight) {
            resize(m / 2);
        }
        assert check();
    }

    /**
     * Returns all keys in this symbol
     * table as an {@code Iterable}.
     * To iterate over all of the keys
     * in the symbol table named {@code st},
     * use the foreach notation: {@code for
     * (Key key : st.keys())}.
     *
     * @return all keys in this symbol table
     */
    public ArrayList<Key> keys() {
        ArrayList<Key> keyslist = new ArrayList<Key>();
        for (int i = 0; i < m; i++) {
            if (keys[i] != null) {
                keyslist.add(keys[i]);
            }
        }
        return keyslist;
    }

    // integrity check - don't check after each put() because
    // integrity not maintained during a delete()


    /**
     * Checks if the key is resent or not.
     *
     * @return     { description_of_the_return_value }
     */
    private boolean check() {

        // check that hash table is at most 50% full
        if (m < 2 * n) {
            return false;
        }

        // check that each key in table can be found by get()
        for (int i = 0; i < m; i++) {
            if (keys[i] == null) {
                
                continue;
            } else if (get(keys[i]) != vals[i]) {
                return false;
            }
        }
        return true;
    }
    /**
     * Checks if the given element is present or not.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public boolean check(final Key key) {
        if (key == null) {
            return false;
        }

        for (int i = 0; i < m; i++) {
            if (keys[i] != null) {
                if (key.equals(keys[i])) {
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * Display the values in a String.
     *
     * @return     { String of all values.}
     */
    public String display() {
        if (size() == 0) {
            return "{}";
        }
        String str = "{";
        for (int i = 0; i < m; i++) {
            if (keys[i] != null) {
                str = str + keys[i] + ":"
                + get(keys[i]) + ", ";
            }
        }
        return str.substring(0, str.length() - 2) + "}";
    }
}

