import java.util.Scanner;
class Node {
    String data;
    Node next;
}
class LinkedList {
    Node head;
    void insert(String data) {
        Node node = new Node();
        node.data = data;
        node.next = null;
        if (head == null) {
            head = node;
        } else {
            Node n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = node;
        }

    }
}
class AddLargeNumbers {
    
    public static LinkedList numberToDigits(String number) {
        Node node = new Node();
        LinkedList list = new LinkedList();
        String[] tokens = number.split("");
        for (int i = 0; i < number.length(); i++) {
            list.insert(tokens[i]);
        }
        System.out.println(node.toString());
        return list;
    }

    public static String digitsToNumber(LinkedList list) {
        return "";
    }

    // public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {

    // }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch(input){
            case "numberToDigits":
                LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
                LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
                System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
                System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
                break;

            // case "addLargeNumbers":
            //     LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
            //     LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
            //     LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
            //     System.out.println(AddLargeNumbers.digitsToNumber(result));
            //     break;
        }
    }
    
}
