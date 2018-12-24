
package application;
import java.util.ArrayList;


public class Transaction {
	
	private ArrayList<Product> cart;
	private double total;
	public Transaction() {
		cart = new ArrayList<Product>();
		total = 0.00;
	}
	
	public void add(Product itemToBuy) {
		//System.out.print(itemToBuy.getName() + " was added to the cart ");
		cart.add(itemToBuy);
		total = total + itemToBuy.getPrice();
		//System.out.println("the new total is:" + total);
	}
	public void remove(Product itemToRemove) {
		//System.out.print(itemToRemove.getName() + " was removed from the cart ");
		cart.remove(itemToRemove);
		total = total - itemToRemove.getPrice();
		//System.out.println("the new total is:" + total);
	}
	

	public void payBill() {
		for (int i = 0; i < cart.size(); i++) {
			cart.get(i);
		}
		cart = new ArrayList<Product>();
		total = 0.0;
		for (int i = 0; i < cart.size(); i++) {
			cart.get(i);
		}
		if(cart != null) {
			//System.out.println("cart is not null");
		}
	}

	public double getTotal() {
		return total;
	}

	public ArrayList<Product> getItems() {
		
		if(cart == null) {
			ArrayList<Product> emptyCart = new ArrayList<Product>();
			return emptyCart;
		}
		else {
			return cart;
		}	
	}
}
