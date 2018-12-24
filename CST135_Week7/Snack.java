
package application;
public abstract class Snack extends Product {

	private String productType = "snack";
	private boolean isSnack = true;
	
	public Snack() {
		super();
	}
	
	
	public String getProductType() {
		return productType;
	}


	public boolean isSnack() {
		return isSnack;
	}


	public Snack(String name, String brand, String productClass, double price, double sugar, double protein, double sodium, double calories) {
		super(name, brand, productClass, price, sugar, protein, sodium, calories);
	}
	
	//Formatted Constructor
	public Snack(String name, String productType, double price) {
		super(name, productType, price);
	}
	// Formatted Constructor
	public Snack(String name, String productType,int quantity, double price) {
		super(name, productType, quantity, price);
	}
	
	

}
