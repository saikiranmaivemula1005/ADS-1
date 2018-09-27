import java.util.Scanner;
/**
 * Stack class to store the elements.
 */
class Stack {
    /**
     * top variable.
     */
    private int top;
    /**
     * array of type String array to store the elements.
     */
    private String[] array;
    /**
     * n to store the size.
     */
    private int n;
    /**
     * Constructor for stack class.
     * @param      size  The size
     */
    Stack(final int size) {
        n = size;
        top = -1;
        array = new String[n];
    }
    /**
     * push method which pushes the element into stack.
     * @param      x     element to be pushed.
     */
    void push(final String x) {
        array[++top] = x;
    }
    /**
     * pop method which pops the element from stack.
     * @return     element which is popped.
     */
    String pop() {
        String ele = array[top];
        top--;
        return ele;
    }
    /**
     * Determines if empty.
     * @return     True if empty, False otherwise.
     */
    boolean isEmpty() {
        if (top == -1) {
            return true;
        }
        return false;
    }
}
/**
 * Class for is balanced.
 */
class IsBalanced {
    /**
     * Determines if matching pair.
     * @param      str1  The string 1
     * @param      str2  The string 2
     * @return     True if matching pair, False otherwise.
     */
    boolean isMatchingPair(final String str1, final String str2) {
        if (str1.equals("(") && str2.equals(")")) {
            return true;
        }
        if (str1.equals("{") && str2.equals("}")) {
            return true;
        }
        if (str1.equals("[") && str2.equals("]")) {
            return true;
        }
        return false;
    }
    /**
     * areBalanced method to check
       whether the parenthesis are balanced or not.
     * @param      array   The array
     * @return     True if balanced, False otherwise.
     */
    boolean areBalanced(final String[] array) {
        Stack st = new Stack(array.length);
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals("{")
                || array[i].equals("(") || array[i].equals("[")) {
                st.push(array[i]);
            }
            if (array[i].equals("}")
                || array[i].equals(")") || array[i].equals("]")) {
                if (st.isEmpty()) {
                    return false;
                }
                if (!isMatchingPair(st.pop(), array[i])) {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * main method to drive the function.
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int noofinputs = Integer.parseInt(sc.nextLine());
        while (noofinputs != 0) {
            String line = sc.nextLine();
            String[] array = line.split("");
            IsBalanced b = new IsBalanced();
            if (b.areBalanced(array)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            noofinputs--;
        }
    }
}