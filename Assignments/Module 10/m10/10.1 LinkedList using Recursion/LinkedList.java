/**
 * Class for node.
 */
class Node {
    /**
     * data of the node.
     */
    int data;
    /**
     * to connect the nodes.
     */
    Node next;
    /**
     * Constructs the object.
     * @param      data    data of the node.
     */
    Node(int data) {
        this.data = data;
    }
}
/**
 * class of linked list.
 */
public class LinkedList {
    /**
     * head node.
     */
    Node head;
    /**
     * size of the linkedlist.
     */
    int size;
    /**
     * method to insert at specific index.
     * @param      currentNode        The currentNode
     * @param      newNode    The new node
     * @param      position        The position
     * @param      currentNodePosition     The currentNode position
     *
     * @return     node.
     *
     * @throws     Exception  position exception.
     */
    Node insertAt(final Node currentNode, final Node newNode,
        final int position, final int currentNodePosition) throws Exception {
        if (position < 0 || position > size) {
            throw new Exception("Can't insert at this position.");
        }
        if (currentNode == null) {
            return newNode;
        } else if (currentNodePosition == position) {
            newNode.next = currentNode;
            return newNode;
        }
        currentNode.next = insertAt(currentNode.next, newNode, position, currentNodePosition + 1);
        return currentNode;
    }
    /**
     * method to reverse the nodes of linkedlist.
     * @param      currentNode   The currentNode
     * @param      previousNode  The previousNode
     * @return     head node.
     */
    Node reverse(final Node currentNode, final Node previousNode) {
        if (currentNode == null) {
            return null;
        }
        if (currentNode.next == null) {
            head = currentNode;
            currentNode.next = previousNode;
            return head;
        }
        Node next = currentNode.next;
        currentNode.next = previousNode;
        reverse(next, currentNode);
        return head;
    }
    /**
     * display method to display the linkedlist.
     */
    void display() {
        if (size == 0) {
            System.out.println("No elements to reverse.");
            return;
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