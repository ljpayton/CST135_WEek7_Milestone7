
package application;
import java.util.ArrayList;
import javafx.scene.image.ImageView;

public class DispenserQueue {

	String brand;
	String productName;
	String productClass;
	double productPrice;
	ArrayList<Product> slot;
	ImageView productImage;
	int locationID;
	String imageName;
	
	//Empty Queue Constructor
	public DispenserQueue() {
		slot = new ArrayList<Product>();
		productName = "empty";
		productClass = "none";
		imageName = "empty";
		//productImage = new ImageView(getClass().getResource(imageName).toExternalForm());
	}
	//Initialized Queue
	public DispenserQueue(Product productType) {
		slot = new ArrayList<Product>();
		this.addProductToQueue(productType);
		productName = productType.getName();
		brand = productType.getBrand();
		productClass = slot.get(0).getProductClass();
		productPrice = slot.get(0).getPrice();
		imageName = productName + ".jpg";
		productImage = new ImageView(getClass().getResource(imageName).toExternalForm());
		//System.out.println( imageName + " Succeeded");
	}
	//Copy Constructor
	public DispenserQueue(DispenserQueue queueToCopy) {
		slot = queueToCopy.getSlot();
		this.addProductToQueue(queueToCopy.getSlot().get(0));
		productName = queueToCopy.getProductName();
		brand = queueToCopy.getBrand();
		productClass = queueToCopy.getProductType();
		productPrice = queueToCopy.getProductPrice();
		productImage = queueToCopy.getProductImage();
	}

	
	//Adds a single product to the queue
	public void addProductToQueue(Product productToAdd) {
		slot.add(productToAdd);
		productName = productToAdd.getName();
	}
	//Removes the specified product from the queue, ex: expiration date is passed, remove it.
	public void removeProductFromQueue(Product productToRemove) {
		slot.remove(productToRemove);
	}
	
	public String getProductType() {
		return productClass;	
	}
	
	public int getNumItems() {
		int numItems = 0;
		for(@SuppressWarnings("unused") Product item : slot) {
			numItems++;
		}
		return numItems;
	}
	
	//StringUtils.center(this.getProductName(), 45);
	public String toString() {
		return String.format("%24s%24s%40d%40.2f", this.getProductName(), this.getProductClass(), this.getProductCount(), this.getProductPrice());
	}
	
	static class StringUtils {

	    public static String center(String s, int size) {
	        return center(s, size, ' ');
	    }

	    public static String center(String s, int size, char pad) {
	        if (s == null || size <= s.length())
	            return s;

	        StringBuilder sb = new StringBuilder(size);
	        for (int i = 0; i < (size - s.length()) / 2; i++) {
	            sb.append(pad);
	        }
	        sb.append(s);
	        while (sb.length() < size) {
	            sb.append(pad);
	        }
	        return sb.toString();
	    }
	}
	
	
	
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public ArrayList<Product> getSlot() {
		return slot;
	}
	public void setSlot(ArrayList<Product> slot) {
		this.slot = slot;
	}
	
	public boolean isDrinkItem() {
		if(productClass.equals("Drink")) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean isChipsItem() {
		if(productClass.equals("Chips")) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean isCandyItem() {
		if(productClass.equals("Candy")) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean isGumItem() {
		if(productClass.equals("Gum")) {
			return true;
		}
		else {
			return false;
		}
	}
	public ImageView getProductImage() {
		return productImage;
	}

	public int getProductCount() {
		int itemCount = 0;
		for(@SuppressWarnings("unused") Product item : slot) {
			itemCount++;
		}
		return itemCount;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductType(String productType) {
		productClass = productType;
		
	}
	public void setProductPrice(double price) {
		productPrice = price;
		
	}
	public String getProductClass() {
		return productClass;
	}
	public void setProductClass(String productClass) {
		this.productClass = productClass;
	}
	public int getLocationID() {
		return locationID;
	}
	public void setLocationID(int locationID) {
		this.locationID = locationID;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public void setProductImage(ImageView productImage) {
		this.productImage = productImage;
	}
	public Product removeFirst() {
		return slot.get(0);
		
	}

	

	
	
	
	
	
	
}
