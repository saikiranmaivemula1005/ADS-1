import java.util.Scanner;
class Stock {
	String name;
	float percentage;
	Stock(String n, float p) {
	this.name = n;
	this.percentage = p;
	}
	String getName() {
		return name;
	}
	float getPercentage() {
		return percentage;
	}
}

class StockPercentage {
	private MinPQ<Stock> minObj;
    private MaxPQ<Stock> maxObj;
    StockPercentage() {
    	minObj = new MinPQ<Stock>();
		maxObj = new MaxPQ<Stock>();
    }
    public void insert(Stock stock) {
    	minObj.insert(stock);
    }
    public void printmin() {
    	for (int i = 0; i < 5; i++) {
    		minObj.get(i);
    	}
    }
    public void printmax() {
    	for (int i = 0; i < 5; i++) {
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
		while (sc.hasNextLine()) {
			// String[] tokens = sc.nextLine().split(",");
			String[] tokens = sc.next().split(",");
			String name = tokens[0];
			float percentage = Float.parseFloat(tokens[1]);
			Stock stock = new Stock(name, percentage);
			sp.insert(stock);
		}
		sp.printmin();
		sp.printmax();
	}
}