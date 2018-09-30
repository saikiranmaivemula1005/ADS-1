import java.util.Scanner;
/**
 * LinkedList implementaing Stack.
 *
 * @param   <T>  generic mode.
 */
class CircularLinkedList<T> {
  /**
   * generic type node.
   */
  private Node<T> headNode = null;
  /**
   * generic node.
   */
  private Node<T> endNode = null;
  /**
   * generic node.
   */
  private Node<T> currentNode = null;
  /**
   * Class for node.
   *
   * @param   <T>  generic mode.
   */
  class Node<T> {
    /**
     * T data element.
     */
    private T data;
    /**
     * Node next.
     */
    private Node<T> next;
  }
  /**
   * check whether stack is empty or not.
   * @return true or false.
   */
  public boolean isEmpty() {
    return headNode == null;
  }
  /**
   * push method is used to push the element.
   * @param element element to push.
   */
  public void add(final T element) {
    if (headNode == null) {
      headNode = new Node<T>();
      headNode.data = element;
      endNode = headNode;
      headNode.next = endNode;
    } else {
      Node<T> newnode = new Node<T>();
      endNode.next = newnode;
      newnode.data = element;
      newnode.next = headNode;
      endNode = newnode;
    }
  }
  /**
   * Gets the next node.
   *
   * @return     The next.
   */
  public T getNext() {
    if (currentNode == null) {
      currentNode = headNode;
    }
    Node<T> tempOne = currentNode;
    currentNode = tempOne.next;
    return tempOne.data;
  }
  /**
   * removes the element.
   *
   * @param      element  The element
   *
   * @return  returns the removed element.
   */
  public T remove(T element) {
    //if single element present
    if (headNode.next.equals(headNode) && headNode.data.equals(element)) {
      T tempOne = headNode.data;
      headNode = null;
      return tempOne;
    }
    if (headNode.data.equals(element)) {
      headNode = headNode.next;
      endNode.next = headNode;
      return element;
    }
    if (endNode.data.equals(element)) {
      Node<T> tempTwo = headNode;
      while (!tempTwo.next.equals(endNode)) {
        tempTwo = tempTwo.next;
      }
      tempTwo.next = headNode;
      endNode = tempTwo;
      return element;
    }
    //normal cases
    Node<T> currentNodetemp = headNode;
    while (!currentNodetemp.next.data.equals(element)) {
      currentNodetemp = currentNodetemp.next;
    }
    Node<T> temp2 = currentNodetemp.next.next;
    currentNodetemp.next = temp2;
     return element;
   }
 }
 /**
 * Solution class.
 */
public final class Solution {
  /**
   * Constructs the object.
   */
  private Solution() {

  }
  /**
   * main takes input from user and prints output to console.
   *
   * @param   args The commandline arguments
   */
  public static void main(final String[] args) {
    Scanner scan = new Scanner(System.in);
    int inputCount = scan.nextInt();
    for (int input = 0; input < inputCount; input++) {
      int noOfPersons = scan.nextInt();
      int mthShift = scan.nextInt();
      CircularLinkedList<Integer> cll = new CircularLinkedList<Integer>();
       for (int i = 0; i < noOfPersons; i++) {
        cll.add(i);
      }
      String string = "";
      while (!cll.isEmpty()) {
        int temp = 0;
        for (int i = 0; i < mthShift; i++) {
          temp = cll.getNext();
        }
        string += cll.remove(temp) + " ";
      }
      System.out.println(string.trim());
    }
  }
}