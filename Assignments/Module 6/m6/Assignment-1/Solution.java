import java.util.Scanner;
/**
 * class for linkedist.
 */
class LinkedList {
    /**
     * head of node type.
     */
    private Node head;
    /**
     * count of integer type.
     */
    private int count = 0;
    /**
     * method to insert data.
     *
     * @param      data  The data
     */
    void insert(final String data) {
        Node node = new Node();
        node.data = data;
        node.next = null;
        if (head == null) {
            head = node;
        } else {
            Node n = head;
            while (n.next != null) {
                n = n.next;
                count++;
            }
            n.next = node;
        }
    }
    /**
     * method to display elements.
     */
    void show() {
        Node node = head;
        while (node.next != null) {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.print(node.data);
    }
    /**
     * method to return size.
     *
     * @return returns size of linked list.
     */
    int size() {
        return count;
    }
    /**
     * method to get the element at that index.
     *
     * @param      index integer parameter
     *
     * @return returns the value at that node.
     */
    String get(final int index) {
        Node x = head;
       if (index < size() && index > 0) {
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        }
        return x.data;
    }
}
/**
 * class for stack.
 */
class Stack {
    /**
     * array of string type.
     */
    private String[] array;
    /**
     * integer variable.
     */
    private int n;
    /**
     * Constructor for stack class.
     */
    Stack() {
        final int variable = 100000000;
        array = new String[variable];
        n = 0;
    }
    /**
     * method to push elements into stack.
     *
     * @param      item  string item.
     */
    void push(final String item) {
        array[n++] = item;
    }
    /**
     * method to remove elements from stack.
     *
     * @return returns the removed element.
     */
    String pop() {
        if (isEmpty()) {
            return null;
        }
        String s = array[--n];
        return s;
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    boolean isEmpty() {
        return (n == 0);
    }
    /**
     * returns size of stack.
     *
     * @return returns size of stack.
     */
    int size() {
        return n;
    }
    /**
     * returns element at the given index.
     *
     * @param      i  integer parameter.
     *
     * @return returns element at the given index
     */
    String get(final int i) {
        return array[i];
    }
}
/**
 * Class for add large numbers.
 */
class AddLargeNumbers {
    /**
     * constructor for the class.
     */
    protected AddLargeNumbers() {

    }
    /**
     * convert number to digits.
     *
     * @param      number  string variable
     *
     * @return  returns the list of digits.
     */
    public static LinkedList numberToDigits(final String number) {
        Node node = new Node();
        LinkedList list = new LinkedList();
        String[] tokens = number.split("");
        for (int i = 0; i < number.length(); i++) {
            list.insert(tokens[i]);
        }
        return list;
    }
    /**
     * convert the digits to number.
     *
     * @param      list  linked list type list.
     *
     * @return  returns the linked list.
     */

    public static String digitsToNumber(final LinkedList list) {
        String s = "";
        Node n = new Node();
        list.show();
        while (n.next != null) {
            s += n.data;
        }

        return s;
    }
    /**
     * method to Add large numbers.
     *
     * @param      list1  The list 1
     * @param      list2  The list 2
     *
     * @return returns the addition of given numbers.
     */
    public static LinkedList addLargeNumbers(final LinkedList
     list1, final LinkedList list2) {
        LinkedList outputList = new LinkedList();
        final int ten = 10;
        String[] x = new String[ten];
        int outputListsize = 0;
        Stack s1 = new Stack();
        Stack s2 = new Stack();
        Stack s3 = new Stack();
        int j = 0;
        for (int i = 0; i < list1.size(); i++) {
            s1.push(list1.get(i));
            // System.out.print(list1.get(i) + " ");
            j++;
        }
        System.out.println();
        for (int i = 0; i < list2.size(); i++) {
            s2.push(list2.get(i));
            // System.out.print(list2.get(i) + " ");
            j++;
        }
        for (int i = 0; i < s1.size() + s2.size(); i++) {
           System.out.println(s1.pop());
            System.out.println(s2.pop());
        }
        // for (int i = 0; ) {
        //     s3.push(s1.pop() + s2.pop());
        //     x[i] = s3.get(i);
        // }
        // for (int i = 0; i < s1.size() + s2.size(); i++) {
        //     outputList.insert(x[i]);
        //     System.out.print(x[i] + " ");
        // }
        return outputList;
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

