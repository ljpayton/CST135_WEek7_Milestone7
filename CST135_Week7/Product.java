
package application;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Product implements Comparable<Product> {

	// Shared Properties
	private String name;
	private String brand;
	private String productClass;
	private double price;

	// Nutrition Facts
	private double sugar;
	private double protein;
	private double sodium;
	private double calories;

	// Expiration Date - format mm/dd/yyyy
	private String expirationDate;

	@SuppressWarnings("unused")
	private int locationID;
	@SuppressWarnings("unused")
	private int quantityInMachine;
	
	
	
	// Default Constructor
	public Product() {
		this.name = null;
		this.brand = null;
		this.productClass = null;
		this.price = 0.0;
		this.sugar = 0.0;
		this.protein = 0.0;
		this.sodium = 0.0;
		this.calories = 0.0;
		this.setExpirationDate(calculateExpirationDate());
		this.locationID = 0;
	}

	// Shared Format Constructor
	public Product(String name, String productType, double price) {
		this.name = name;
		this.brand = null;
		this.productClass = productType;
		this.price = price;
		this.sugar = 0.0;
		this.protein = 0.0;
		this.sodium = 0.0;
		this.calories = 0.0;
		this.setExpirationDate(calculateExpirationDate());
	}
	
	// Shared Format Constructor
	public Product(String name, String productType, int quantity, double price) {
		this.name = name;
		this.brand = null;
		this.productClass = productType;
		this.price = price;
		this.sugar = 0.0;
		this.protein = 0.0;
		this.sodium = 0.0;
		this.calories = 0.0;
		this.setExpirationDate(calculateExpirationDate());
		this.quantityInMachine = quantity;
	}
	
	

	// Fully-Parameterized Constructor
	public Product(String name, String brand, String productClass, double price, double sugar, double protein,
			double sodium, double calories) {
		this.name = name;
		this.brand = brand;
		this.productClass = productClass;
		this.price = price;
		this.sugar = sugar;
		this.protein = protein;
		this.sodium = sodium;
		this.calories = calories;
		this.setExpirationDate(calculateExpirationDate());
	}

	// Copy Constructor
	public Product(Product productToCopy) {
		this.name = productToCopy.getName();
		this.brand = productToCopy.getBrand();
		this.productClass = productToCopy.getProductClass();
		this.price = productToCopy.getPrice();
		this.sugar = productToCopy.getSugar();
		this.protein = productToCopy.getProtein();
		this.sodium = productToCopy.getSodium();
		this.calories = productToCopy.getCalories();
		this.setExpirationDate(calculateExpirationDate());
	}

	@Override
	public String toString() {
		StringBuilder resultStringBuilder = new StringBuilder();
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getProductClass() {
		return productClass;
	}

	public void setProductClass(String productClass) {
		this.productClass = productClass;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getSugar() {
		return sugar;
	}

	public void setSugar(double sugar) {
		this.sugar = sugar;
	}

	public double getProtein() {
		return protein;
	}

	public void setProtein(double protein) {
		this.protein = protein;
	}

	public double getSodium() {
		return sodium;
	}

	public void setSodium(double sodium) {
		this.sodium = sodium;
	}

	public double getCalories() {
		return calories;
	}

	public void setCalories(double calories) {
		this.calories = calories;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String calculateExpirationDate() {
		Date today = new Date();
		LocalDate localDate = today.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int year = localDate.getYear();
		int month = localDate.getMonthValue();
		int day = localDate.getDayOfMonth();
		// For Drinks, add 9 months
		if (this.getClass().getSimpleName().equals("Drink"))
			month += 9;
		// For Chips, add 3 months
		if (this.getClass().getSimpleName().equals("Chips"))
			month += 3;
		// For Candy, add 6 months
		if (this.getClass().getSimpleName().equals("Candy"))
			month += 6;
		// For Gum, add 1 year
		if (this.getClass().getSimpleName().equals("Drink"))
			year += 1;
		String expDate = month + "/" + day + "/" + year;
		return expDate;
	}

	public boolean isDrink() {
		if (productClass.equals("Drink")) {
			return true;
		} else {
			return false;

		}
	}

	public boolean isChips() {
		if (productClass.equals("Chips")) {
			return true;
		} else {
			return false;

		}
	}

	public boolean isCandy() {
		if (productClass.equals("Candy")) {
			return true;
		} else {
			return false;

		}
	}

	public boolean isGum() {
		if (productClass.equals("Gum")) {
			return true;
		} else {
			return false;

		}
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
	public char[] productNameToArray(Product product) {
		int productNameLength = product.getName().length();
		char[] name = new char[productNameLength];
		for(int i = 0; i < productNameLength; i++) {
			name[i] = product.getName().charAt(i);
		}
		return name;
	}
	
	

}
