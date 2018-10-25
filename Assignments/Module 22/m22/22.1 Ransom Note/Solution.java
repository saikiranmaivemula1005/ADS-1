import java.util.Scanner;
class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inp = sc.nextLine().split(" ");
        int m = Integer.parseInt(inp[0]);
        int n = Integer.parseInt(inp[1]);
        String[] magazine = sc.nextLine().split(" ");
        String[] note = sc.nextLine().split(" ");
        SeparateChainingHashST<String, Integer> mag = new SeparateChainingHashST<String, Integer>();
        SeparateChainingHashST<String, Integer> ransom = new SeparateChainingHashST<String, Integer>();
        for (int i = 0; i < m; i++) {
            mag.put(magazine[i], 0);
        }
        for (int j = 0; j < n; j++) {
            ransom.put(note[j], 0);
        }
        for (int i = 0; i < m; i++) {
            int count = mag.get(magazine[i]);
            if (mag.contains(magazine[i])) {
                mag.put(magazine[i], count + 1);
            } else {
                mag.put(magazine[i], 1);
            }
        }
        for (int j = 0; j < n; j++) {
            if (!mag.contains(note[j])) {
                System.out.println("No");
                return;
            } else if (mag.contains(note[j])) {
                int count = ransom.get(note[j]);
                if (ransom.contains(note[j])) {
                    ransom.put(note[j], count + 1);
                } else {
                    ransom.put(note[j], 1);
                }
                if (ransom.get(note[j]) > mag.get(note[j])) {
                    System.out.println("No");
                    return;
                }
            }
        }
        System.out.println("Yes");
    }
}