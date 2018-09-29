import java.util.Scanner;
class Node {
    String data;
    Node next;
}
class LinkedList {
    Node head;
    int count = 0;
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
                count++;
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
    int size() {
        return count;
    }
    String get(int i) {
        Node node = head;
        while (node.next != null ) {
            node = node.next;
            return node.data;
        }
        return "";
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

    public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
        LinkedList outputList = new LinkedList();
        Stack s1 = new Stack();
        Stack s2 = new Stack();
        int j = 0;
        for (int i = 0; i < list1.size(); i++){
            s1.push(list1.get(i));
            System.out.print(list1.get(i) + " ");
            j++;
        }
        System.out.println();
        for (int i = 0; i < list2.size(); i++){
            s2.push(list2.get(i));
            System.out.print(list2.get(i) + " ");
            j++;
        }




        return outputList;
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
                LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
                System.out.println(AddLargeNumbers.digitsToNumber(result));
                break;
        }
    }
    
}
