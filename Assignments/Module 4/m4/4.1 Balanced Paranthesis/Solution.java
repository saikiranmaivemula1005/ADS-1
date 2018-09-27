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
 * Class for balanced paranthesis.
 */
class balancedParanthesis {
    /**
     * Checks if matching pair exist or not.
     * @param      inputOne  first string
     * @param      inputTwo  second string
     * @return     True if matching pair exist.
     */
    boolean isMatching(final String inputOne, final String inputTwo) {
        if (inputOne.equals("(") && inputTwo.equals(")")) {
            return true;
        }
        if (inputOne.equals("{") && inputTwo.equals("}")) {
            return true;
        }
        if (inputOne.equals("[") && inputTwo.equals("]")) {
            return true;
        }
        return false;
    }
    /**
     * checkBalanced method.
     * @param      array   The array
     * @return     True if balanced, False otherwise.
     */
    boolean checkBalanced(final String[] array) {
        Stack stack = new Stack(array.length);
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals("{")
                || array[i].equals("(") || array[i].equals("[")) {
                stack.push(array[i]);
            }
            if (array[i].equals("}")
                || array[i].equals(")") || array[i].equals("]")) {
                if (stack.isStackEmpty()) {
                    return false;
                }
                if (!isMatching(stack.pop(), array[i])) {
                    return false;
                }
            }
        }
        return stack.isStackEmpty();
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