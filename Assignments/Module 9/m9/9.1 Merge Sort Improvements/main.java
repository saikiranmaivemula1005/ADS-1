import java.util.Scanner;
class main {
	main() {
    }
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	MergeSort m = new MergeSort();
    	while (sc.hasNext()) {
    		String[] input = sc.nextLine().split(",");
    		int[] dataArray = new int[input.length];
    		for (int i = 0; i < input.length; i++) {
    			dataArray[i] = Integer.parseInt(input[i]);
            }
            m.sort(dataArray);
            System.out.println(m);
    	}
    }
}
