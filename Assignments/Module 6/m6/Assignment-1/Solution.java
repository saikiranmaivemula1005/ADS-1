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
    void show() {
        Node node = head;
        while (node.next != null) {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.print(node.data);
    }
}
class Stack{
    String[] array;
    int n;
    Stack() {
        array = new String[10];
        n = 0;
    }
    void push(String item) {
        array[n++] = item;
    }
    String pop() {
        if (isEmpty()) {
            return null;
        }
        String s = array[--n];
        return s;
    }
    boolean isEmpty() {
        return (n==0);
    }
    int size() {
        return n;
    }
    void show() {
        for (int i = 0; i < n; i++) {
            System.out.print(array[i]);
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
        return list;
    }


    public static String digitsToNumber(LinkedList list) {
        String s = "";
        Node n = new Node();
        list.show();
        while(n.next != null) {
            s += n.data;
        }

        return s;
    }

    public static String addLargeNumbers(LinkedList list1, LinkedList list2) {
        LinkedList outputList = new LinkedList();
        String s = "a";
        Node node = new Node();
        // list1.show();
        System.out.println();
        // list2.show();
        Stack stack1 = new Stack();
        Stack stack2 = new Stack();
        while (node.next != null) {
            for (int i = 0; i < stack1.size(); i++) {
                stack1.push(node.data);
                node = node.next;
            }
        }
        System.out.println();
        stack1.show();
        System.out.println();



        return s;
    }
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

            case "addLargeNumbers":
                 pDigits = AddLargeNumbers.numberToDigits(p);
                 qDigits = AddLargeNumbers.numberToDigits(q);
                String result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
                // System.out.println(AddLargeNumbers.digitsToNumber(result));
                break;
        }
    }
    
}
