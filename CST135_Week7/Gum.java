
package application;
public class Gum extends Snack implements Comparable<Product> {

	private String snackType = "gum";
	private boolean isGum = true;

	public Gum() {
		super();
	}

	public Gum(String name, String brand, String productClass, double price, double sugar, double protein,
			double sodium, double calories) {
		super(name, brand, productClass, price, sugar, protein, sodium, calories);
	}

	// Formatted Constructor
	public Gum(String name, String productType, double price) {
		super(name, productType, price);
	}
	
	// Formatted Constructor
	public Gum(String name, String productType,int quantity, double price) {
		super(name, productType, quantity, price);
	}

	// Copy Constructor
	public Gum(Product productToCopy) {
		super();
		this.setName(productToCopy.getName());
		this.setBrand(productToCopy.getBrand());
		this.setProductClass(productToCopy.getProductClass());
		this.setPrice(productToCopy.getPrice());
		this.setSugar(productToCopy.getSugar());
		this.setProtein(productToCopy.getProtein());
		this.setSodium(productToCopy.getSodium());
		this.setExpirationDate(productToCopy.getExpirationDate());
	}

	public String getSnackType() {
		return snackType;
	}

	@Override
	public boolean isGum() {
		return isGum;
	}

	@Override
	public String toString() {
		StringBuilder resultStringBuilder = new StringBuilder();
		resultStringBuilder.append("Gum: " + " ");
		resultStringBuilder.append(this.getName() + " ");
		resultStringBuilder.append(this.getBrand() + " ");
		resultStringBuilder.append(this.getPrice() + " ");
		resultStringBuilder.append(this.getSugar() + " ");
		resultStringBuilder.append(this.getProtein() + " ");
		resultStringBuilder.append(this.getSodium() + " ");
		resultStringBuilder.append(this.getCalories() + " ");
		resultStringBuilder.append(this.getExpirationDate() + " ");
		String result = resultStringBuilder.toString();
		return result;
	}

	@Override
	public int compareTo(Product product) {
		int result = 0;
		char[] productOne = new char[this.getName().length()];
		productOne = productNameToArray(this);
		char[] productTwo = new char[product.getName().length()];
		productTwo = productNameToArray(product);
		int lesserLength = 0;
		if(this.getName().length() > product.getName().length()) {
			lesserLength = this.getName().length();
		}
		else {
			lesserLength = product.getName().length();
		}
			
		for(int i = 0; i < lesserLength; i++) {
			Character one, two;
			one = productOne[i];
			two = productTwo[i];
			result = one.compareTo(two);
			if(result >= 1) {
				return result;
			}
			else if(result <= -1) {
				return result;
			}
			else {
				result = 0;
				if(i == lesserLength && this.getName().length() > product.getName().length()) {
					result = 1;
				}
				else if(i == lesserLength && this.getName().length() > product.getName().length()) {
					result = -1;
				}
			}
		}
		return result;
	}
	@Override
	public char[] productNameToArray(Product product) {
		int productNameLength = product.getName().length();
		char[] name = new char[productNameLength];
		for(int i = 0; i < productNameLength; i++) {
			name[i] = product.getName().charAt(i);
		}
		return name;
	}

}
