import java.util.Scanner;
/**
 * Class for steque that implements the methods
 * push,pop,enqueue,isEmpty and print the stack methods.
 */
class Steque {
    /**
     * head of node type used to store the first element in the linked list.
     */
    private Node head;
    /**
     * size of integer type used to store the size of stack.
     */
    private int size = 0;
    /**
     * This method is used to add the given elements at the head
     * of the linked list.
     *All operations in this method take constant time.
     *So, time complexity is O(1).
     * @param      element  The element
     */
    void push(final int element) {
        Node node = new Node();
        size++;
        if (head == null) {
            node.data = element;
            node.next = null;
            head = node;
        } else {
            node.data = element;
            node.next = head;
            head = node;
        }
    }
    /**
     * This method is used to pop or remove the elements from head
     * in the linked list.
     *All operations in this method take constant time.
     *So, time complexity is O(1).
     */
    void pop() {
        head = head.next;
        size--;
    }
    /**
     * This method is used to add the elements at the end of the
     * stack.
     *All operations in this method take constant time.
     *So, time complexity is O(1).
     * @param      element  The element
     */
    void enqueue(final int element) {
        Node node = new Node();
        size++;
        if (head == null) {
            node.data = element;
            node.next = null;
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            node.data = element;
            temp.next = node;
            node.next = null;
        }
    }
    /**
     * This method is used to check whether the stack is empty or not.
     *All operations in this method take constant time.
     *So, time complexity is O(1).
     * @return returns true if stack is empty, false otherwise.
     */
    boolean isEmpty() {
        return (size == 0);
    }
    /**
     *This method is used to display the stack elements.
     *All operations in this method take constant time.
     *So, time complexity is O(1).
     * @throws     Exception throws exception if stack is empty.
     */
    void print() throws Exception {
        if (isEmpty()) {
            throw new Exception("Steque is empty.");
        }
        if (head.next == null) {
            System.out.println(head.data);
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            System.out.print(temp.data + ", ");
            temp = temp.next;
        }
        System.out.println(temp.data);
    }
}
/**
 * Class for solution.
 */
class Solution {
    /**
     * Constructor for solution class.
     */
    protected Solution() {

    }
    /**
     * main method for solution class.
     *Here, while loop runs for the given "N" number
     *of tasks. So, the time complexity = O(N).
     * @param      args       The arguments
     *
     * @throws     Exception  exception if stack is empty.
     */
    public static void main(final String[] args) throws Exception {
        Steque s = new Steque();
        Scanner sc = new Scanner(System.in);
        int numberOfCases = Integer.parseInt(sc.nextLine());
        while (sc.hasNext()) {
            String line = sc.nextLine();
            if (line.equals("")) {
                s = new Steque();
                System.out.println("");
            } else {
                String[] tokens = line.split(" ");
                switch (tokens[0]) {
                    case "push":
                        s.push(Integer.parseInt(tokens[1]));
                        s.print();
                        break;
                    case "pop":
                        if (!s.isEmpty()) {
                            s.pop();
                            if (!s.isEmpty()) {
                                s.print();
                                } else {
                                    System.out.println("Steque is empty.");
                            }
                        } else {
                            System.out.println("Steque is empty.");
                        }
                        break;
                    case "enqueue":
                        s.enqueue(Integer.parseInt(tokens[1]));
                        s.print();
                        break;
                    default:
                }
            }
        }

    }
}
