import java.util.ArrayList;

public class Bucket {
	
	ArrayList<Product> items = new ArrayList<Product>();
	
	public Bucket() {}
	
	public ArrayList<Product> getItem() {
		ArrayList<Product> items_out = (ArrayList<Product>) items.clone();
		items.clear();
		
		return items_out;
	}
	
	public void addItem(Product p) {
		items.add(p);
	}
	
	public boolean isEmpty() {
		return items.isEmpty();
	}

}
