/**
 * Class for balanced paranthesis.
 */
public class balancedParanthesis {
	/**
	 * constructor for the class.
	 */
	protected balancedParanthesis() {

	}
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