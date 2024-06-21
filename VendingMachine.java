import java.util.ArrayList;
import java.util.HashMap;

class invalidNException extends Exception {
    
    invalidNException(String s) {
        super(s);
    };
    
}

public class VendingMachine {
	
	private HashMap<Product, Integer> productList = new HashMap<>();
	private Bucket productBucket = new Bucket();
	
	private double price = 0.0;
	private double balance = 0.0;
	
	public VendingMachine() {}
	
	public void purchase(Product p) throws invalidNException {
		if (productList.get(p) == null || productList.get(p) == 0) {
			throw new invalidNException("Product not available!");
		}
		else {
			// Purchase only one or can have multiple at a time?
			// If one at a time, use a boolean or state pattern for mode selection
			productBucket.addItem(p);
			int remain = productList.get(p);
			productList.put(p, remain - 1);
			
			price += p.getPrice();
			System.out.println("Product price: " + price + ", please insert money.");
		}
	}
	
	public void insertMoney(double money) {
		if (price == 0.0) {
			System.out.println("No products selected yet.");
		}
		else {
			balance += money;
			if (balance < price) {
				System.out.println("Current balance: " + balance + ", please insert money.");
			}
			else {
				System.out.println("Payment succeeded. Please take the products and take the change.");
			}
		}
	}
	
	public Coin reset() {
		ArrayList<Product> products = productBucket.getItem();
		for (int i = 0; i < products.size(); i++) {
			Product p = products.get(i);
			int num = productList.get(p);
			productList.put(p, num);
		}
		
		return getChange();
	}
	
	public Coin getChange() {
		if (!productBucket.isEmpty()) {
			System.out.println("Please take the products first!");
			return new Coin(0);
		}
		
		Coin change = new Coin(balance - price);
		
		price = 0.0;
		balance = 0.0;
		
		return change;
	}
	
	public ArrayList<Product> takeProducts() {
		if (price == 0.0) {
			return new ArrayList<Product>();
		}
		
		return productBucket.getItem();
	}
	
	public void addProduct(Product p, int amount) throws invalidNException {
		if (amount <= 0) {
			throw new invalidNException("Invalid product number!");
		}
		else {
			productList.put(p, amount);	
		}
	}

}
