public class Coin {
	
	private double value;
	
	private int dollars = 0;
	private int quarters = 0;
	private int dimes = 0;
	private int nickles = 0;
	private int cents = 0;
	
	public Coin(double value) {
		this.value = value;
		translateChange();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Dollars: ");
		sb.append(dollars);
		sb.append("; ");
		sb.append("Quarters: ");
		sb.append(quarters);
		sb.append("; ");
		sb.append("Dimes: ");
		sb.append(dimes);
		sb.append("; ");
		sb.append("Nickles: ");
		sb.append(nickles);
		sb.append("; ");
		sb.append("Cents: ");
		sb.append(cents);
		
		return sb.toString();
	}
	
	private void translateChange() {
		
		int total = (int) Math.ceil(value * 100);
		
		dollars = total / 100;
		total = total % 100;
		
		if (total > 0) {
			quarters = total / 25;
			total = total % 25;
		}
		
		if (total > 0) {
			dimes = total / 10;
			total = total % 10;
		}
		
		if (total > 0) {
			nickles = total / 5;
			total = total % 5;
		}
		
		if (total > 0) {
			cents = total / 1;
		}
		
	}

}
