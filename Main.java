public class Main {

	public static void main(String[] args) {
		VendingMachine vm = new VendingMachine();
		
		Product coke = new Product("Coke", 2.00);
		Product sprite = new Product("Sprite", 2.20);
		Product rice = new Product("Rice", 5.69);
		Product chocolate = new Product("Chocolate", 3.99);
		
		try {
			vm.addProduct(coke, 5);
		} catch (invalidNException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			vm.addProduct(sprite, 2);
		} catch (invalidNException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			vm.addProduct(rice, 1);
		} catch (invalidNException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			vm.addProduct(chocolate, 10);
		} catch (invalidNException e) {
			System.out.println(e.getMessage());
		}
		
		
		try {
			vm.purchase(rice);
		} catch (invalidNException e) {
			System.out.println(e.getMessage());
		}
		
		vm.insertMoney(5);
		vm.insertMoney(3);
		
		System.out.println(vm.takeProducts().toString());
		System.out.println(vm.getChange().toString());
		
		try {
			vm.purchase(rice);
		} catch (invalidNException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			vm.purchase(sprite);
		} catch (invalidNException e) {
			System.out.println(e.getMessage());
		}
		
		vm.insertMoney(1);
		
		try {
			vm.purchase(coke);
		} catch (invalidNException e) {
			System.out.println(e.getMessage());
		}
		
		vm.insertMoney(4);
		
		System.out.println(vm.takeProducts().toString());
		System.out.println(vm.getChange().toString());
		
		
		try {
			vm.purchase(chocolate);
		} catch (invalidNException e) {
			System.out.println(e.getMessage());
		}
		
		vm.insertMoney(4.2);
		
		System.out.println(vm.takeProducts().toString());
		System.out.println(vm.getChange().toString());
		
	}

}
