import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructor for solution class.
     */
    private Solution() {

    }
    /**
     * main method.
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        LinkedList ll = new LinkedList();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] tokens = sc.nextLine().split(" ");
            switch (tokens[0]) {
            case "insertAt":
                try {
                    ll.head = ll.insertAt(ll.head,
                        new Node(Integer.parseInt(tokens[2])),
                        Integer.parseInt(tokens[1]), 0);
                    ll.size++;
                    ll.display();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "reverse":
                ll.reverse(ll.head, null);
                ll.display();
                break;
            default:
                break;
            }
        }
    }
}