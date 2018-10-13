import java.util.Scanner;
class Stock {
	String name;
	String percentage;
	Stock(String n, String p) {
	this.name = n;
	this.percentage = p;
	}
	String getName() {
		return name;
	}
	String getPercentage() {
		return percentage;
	}
}

class StockPercentage {
	private MinPQ<String> minObj;
    private MaxPQ<String> maxObj;
    StockPercentage() {
    	minObj = new MinPQ<String>();
		maxObj = new MaxPQ<String>();
    }
    public void insert(Stock stock) {
    	minObj.insert(stock.getPercentage());
    	maxObj.insert(stock.getPercentage());
    }
    public void printmin() {
    	for (int i = 0; i < 5; i++) {
    		minObj.get(i);
    	}
    }
    public void printmax() {
    	for (int  i = 0; i < 5; i++) {
    		maxObj.get(i);
    	}
    }
}















class Solution {
	protected Solution() {

	}
	public static void main(String[] args) {
		StockPercentage sp = new StockPercentage();
		Scanner sc = new Scanner(System.in);
		int numberOfStocks = sc.nextInt();
		int x = 6;
		while (x != 0) {
			for (int i = 0; i < numberOfStocks; i++) {
				String[] tokens = sc.nextLine().split(",");
				String name = tokens[0];
				System.out.println(tokens[0]);
				String percentage = tokens[1];
				System.out.println(tokens[1]);
				Stock stock = new Stock(name, percentage);
				sp.insert(stock);
			}
			x--;
		}
		sp.printmin();
		sp.printmax();
	}
}