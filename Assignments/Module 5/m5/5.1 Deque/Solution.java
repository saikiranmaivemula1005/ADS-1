import java.util.Scanner;
/**
 * Class for dequeue.
 * @param      <E>   E of type generic.
 */
class Dequeue<E> {
    /**
     * LinkedList class.
     */
    private LinkedList<E> linkedlist;
    /**
     * Constructs the object.
     */
    Dequeue() {
        linkedlist = new LinkedList<E>();
    }
    /**
     * Determines if empty.
     * @return     True if empty, False otherwise.
     */
    boolean isEmpty() {
        return linkedlist.isEmpty();
    }
    /**
     * returns the size.
     * @return     size.
     */
    int size() {
        return linkedlist.getsize();
    }
    /**
     * Pushes at left.
     * @param      data  The data
     */
    void pushLeft(final E data) {
        linkedlist.insertAtStart(data);
    }
    /**
     * Pushes at right.
     * @param      data  The data
     */
    void pushRight(final E data) {
        linkedlist.insertAtEnd(data);
    }
    /**
     * pops the element to the left.
     */
    void popLeft() {
        linkedlist.deleteAtPos(1);
    }
    /**
     * pops the element to the right.
     */
    void popRight() {
        linkedlist.deleteAtPos(linkedlist.getsize());
    }
    /**
     * displays the queue.
     */
    void display() {
        linkedlist.display();
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
     * main method which drives the program.
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        Dequeue<Integer> dequeue = new Dequeue<Integer>();
        int numberOfLines = Integer.parseInt(sc.nextLine());
        while (numberOfLines != 0) {
            String line = sc.nextLine();
            String[] tokens = line.split(" ");
            switch (tokens[0]) {
            case "isEmpty":
                System.out.println(dequeue.isEmpty());
                break;
            case "size":
                System.out.println(dequeue.size());
                break;
            case "pushLeft":
                dequeue.pushLeft(Integer.parseInt(tokens[1]));
                dequeue.display();
                break;
            case "pushRight":
                dequeue.pushRight(Integer.parseInt(tokens[1]));
                dequeue.display();
                break;
            case "popLeft":
                if (dequeue.size() == 0) {
                    System.out.println("Deck is empty");
                } else {
                    dequeue.popLeft();
                    dequeue.display();
                }
                break;
            case "popRight":
                if (dequeue.size() == 0) {
                    System.out.println("Deck is empty");
                } else {
                    dequeue.popRight();
                    dequeue.display();
                }
                break;
            default:
                break;
            }
            numberOfLines--;
        }
    }
}
