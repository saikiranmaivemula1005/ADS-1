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
     * push method to push the element into stack.
     * @param      input     variable of string type.
     */
    void push(final String input) {
        array[++top] = input;
    }
    /**
     * pop method to pop the element from stack.
     * @return     returns the element that is popped.
     */
    String pop() {
        String element = array[top];
        top--;
        return element;
    }
    /**
     * checks if stack is  empty.
     * @return     True if empty, False otherwise.
     */
    boolean isStackEmpty() {
        return (top == -1);
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
        int numberOfLines = Integer.parseInt(sc.nextLine());
        while (numberOfLines != 0) {
            String line = sc.nextLine();
            String[] array = line.split("");
            balancedParanthesis b = new balancedParanthesis();
            if (b.checkBalanced(array)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            numberOfLines--;
        }
    }
}
