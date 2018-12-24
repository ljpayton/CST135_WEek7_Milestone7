
package application;
import javafx.scene.image.ImageView;
public class Customer {

	private String name;
	private Product intendedPurchase;
	private String intendedPurchaseName;
	private ImageView imageView;
	
	
	public Customer(String customerName, Product product) {
		name = customerName;
		intendedPurchase = product;
	}
	
	public Customer(String customerName, String productName) {
		name = customerName;
		intendedPurchaseName = productName;
	}
	
	
	public String getCustomerName() {
		return name;
	}
	
	public Product getIntendedPurchase() {
		return intendedPurchase;
	}
	
	public String toString() {
		return name + ", " + intendedPurchaseName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIntendedPurchaseName() {
		return intendedPurchaseName;
	}

	public void setIntendedPurchaseName(String intendedPurchaseName) {
		this.intendedPurchaseName = intendedPurchaseName;
	}

	public ImageView getImageView() {
		return imageView;
	}

	public void setImageView(ImageView imageView) {
		this.imageView = imageView;
	}

	public void setIntendedPurchase(Product intendedPurchase) {
		this.intendedPurchase = intendedPurchase;
	}
	
	
}
