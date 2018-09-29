import java.util.Scanner;
import java.util.LinkedList;
import java.util.Stack;
/**
 * Class for add large numbers.
 */
class AddLargeNumbers {
    /**
     * Constructs the object.
     */
    protected AddLargeNumbers() {

    }
    /**
     * convert number to digits.
     *
     * @param      number  The number
     *
     * @return   returns the linked list.
     */
   public static LinkedList numberToDigits(final String number) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        char[] charA = number.toCharArray();
        for (Character i : charA) {
            list.add(Character.getNumericValue(i));
        }
        return list;

    }
    /**
     * convert digits to numbers.
     *
     * @param      list  The list
     *
     * @return  returns the string
     */
    public static String digitsToNumber(final LinkedList list) {
        return list.toString().replaceAll("\\[", "").
        replaceAll("]", "").replaceAll(", ", "");
    }
    /**
     * Adds large numbers.
     *
     * @param      list1  The list 1
     * @param      list2  The list 2
     *
     * @return    returns the addition of two numbers.
     */
    public static LinkedList addLargeNumbers(final
     LinkedList list1, final LinkedList list2) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        Stack<Integer> stk1 = new Stack<Integer>();
        Stack<Integer> stk2 = new Stack<Integer>();
        Stack<Integer> stk3 = new Stack<Integer>();

        for (int i = 0; i < list1.size(); i++) {
            int a = (Integer) (list1.get(i));
            stk1.push(a);
        }
        for (int i = 0; i < list2.size(); i++) {
            int a = (Integer) (list2.get(i));
            stk2.push(a);
        }
        int carry = 0;
        final int ten = 10;
        while (!stk1.isEmpty() && !stk2.isEmpty()) {
            int a = stk1.pop() + stk2.pop() + carry;
            stk3.push(a % ten);
            carry = a / ten;

        }
        int l1 = list1.size();
        int l2 = list2.size();
        if (l2 < l1) {
            int t = l1;
            l1 = l2;
            l2 = l1;
            Stack<Integer> tstk = stk1;
            stk2 = stk1;
            stk1 = tstk;
        }
        if (l1 < l2) {
            for (int i = l1; i < l2; i++) {
                int a = stk2.pop() + carry;
                stk3.push(a % ten);
                carry = a / ten;
            }
        }
        if (carry > 0) {
            stk3.push(carry);
        }
        while (!stk3.isEmpty()) {
            list.add(stk3.pop());
        }
        return list;
    }
}
/**
 * Class for solution.
 */
public class Solution {
    /**
     * constructor for solution class.
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
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch (input) {
            case "numberToDigits":
                LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
                LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
                System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
                System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
                break;

            case "addLargeNumbers":
                 pDigits = AddLargeNumbers.numberToDigits(p);
                 qDigits = AddLargeNumbers.numberToDigits(q);
                LinkedList result =
                AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
                System.out.println(AddLargeNumbers.digitsToNumber(result));
                break;
                default:
        }
    }
}


