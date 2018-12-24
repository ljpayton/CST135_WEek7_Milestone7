package application;
import java.util.ArrayList;

public class Dispenser {

	private int idNumber;
	private String inventoryFileName;
	public ArrayList<DispenserQueue> productQueues;
	public DispenserQueue[] dispenserArray;
	public int productCount;
	public Dispenser() {
		productQueues = new ArrayList<DispenserQueue>();
		//fillDispenser();
	}

	// Creates a new inventory slot for products, and adds the specified product to
	// the slot
	public void addNewProductToDispenser(Product newProduct) {
		DispenserQueue newProductSlot = new DispenserQueue(newProduct);
		productQueues.add(newProductSlot);
	}

	// This is the generic call for adding a product to the dispenser because it
	// checks to see if there is a queue for the product already, and if so it adds
	// it to the queue or creates a new one altogether if necessary
	public void addProductToDispenser(Product productToAdd) {
		// If there are no queues, it creates one
		if (productQueues.isEmpty()) {
			addNewProductToDispenser(productToAdd);
		} else {
			// Creates a queue number for indexing purposes
			int queueNum = 0;
			for (@SuppressWarnings("unused") DispenserQueue queue : productQueues) {
				// System.out.println(queue.getBrand() + queue.getProductName()); //This part
				// was used for debugging
				queueNum++;
			}
			// Flags to determine whether or not the new product matches either of the
			// categories
			boolean brandMatched = false;
			boolean nameMatched = false;

			// Loops through all available queues and compares the new product with the
			// properties that the queue has that tells it what the queue is full of
			for (int i = 0; i < productQueues.size(); i++) {
				//If the brand matches, set the flag
				if (productToAdd.getBrand().equals(productQueues.get(i).getBrand())) {
					brandMatched = true;
				}
				//if the product name matches, set the flag
				if (productToAdd.getName().equals(productQueues.get(i).getProductName())) {
					nameMatched = true;
				}
				//set the index of the queue number equal to whatever the current queue we are on is
				queueNum = i;
			}
			//If both properties matched, it is an identical product and thus needs to be added to that queue
			if (brandMatched == true && nameMatched == true) {
				productQueues.get(queueNum).addProductToQueue(productToAdd);
			}
			//If only the brand matched, it's a different product and needs a new queue
			if (brandMatched == true && nameMatched == false) {
				addNewProductToDispenser(productToAdd);
			}
			//If its the same product, but from a different brand, it needs a new queue
			if (brandMatched == false && nameMatched == true) {
				addNewProductToDispenser(productToAdd);
			}
			//If neither properties matched, it needs a new queue
			if (brandMatched == false && nameMatched == false) {
				addNewProductToDispenser(productToAdd);
			}
		}
	}

	//Removes the specified product from the dispenser entirely
	public void removeProductFromDispenser(DispenserQueue productToRemove) {
		productQueues.remove(productToRemove);
	}

	//Creates the inventory
	public void fillDispenser() {
		// Multiple instances of the same product should be added to the queue that is
		// already there

		// Constructor field order
		// name, brand, foodGroup, price, sugar, protein, sodium calories

		// Drink Test
		addProductToDispenser(new Drink("power-c", "Vitamin Water", "Drink", .99, 32, 0, 0, 120));
		addProductToDispenser(new Drink("vital-t", "Vitamin Water", "Drink", .99, 32, 0, 0, 120));
		addProductToDispenser(new Drink("XXX", "Vitamin Water", "Drink", .99, 31, 0, 0, 120));
		addProductToDispenser(new Drink("XXX", "Vitamin Water", "Drink", .99, 31, 0, 0, 120));
		addProductToDispenser(new Drink("XXX", "Vitamin Water", "Drink", .99, 31, 0, 0, 120));
		addProductToDispenser(new Drink("XXX", "Vitamin Water", "Drink", .99, 31, 0, 0, 120));
		addProductToDispenser(new Drink("XXX", "Vitamin Water", "Drink", .99, 31, 0, 0, 120));
		addProductToDispenser(new Drink("Original", "Coca-Cola", "Drink", .99, 39, 0, 45, 140));
		addProductToDispenser(new Drink("Vanilla", "Coca-Cola", "Drink", .99, 42, 0, 35, 150));
		addProductToDispenser(new Drink("Cherry", "Coca-Cola", "Drink", .99, 42, 0, 35, 150));

		// Gum Test
		addProductToDispenser(new Gum("Polar Ice", "Extra", "Gum", .75, 0, 0, 0, 5));
		addProductToDispenser(new Gum("Spearmint", "Extra", "Gum", .75, 0, 0, 0, 5));
		addProductToDispenser(new Gum("Cinnamon", "Extra", "Gum", .75, 0, 0, 0, 5));
		addProductToDispenser(new Gum("Watermelon", "Extra", "Gum", .75, 0, 0, 0, 5));
		addProductToDispenser(new Gum("Watermelon", "Extra", "Gum", .75, 0, 0, 0, 5));
//		addProductToDispenser(new Gum("Watermelon", "Wrigley's", "Gum", .75, 0, 0, 0, 5));  //If time permits, we could add brand functionality, but as of Milestone #4, there simply isn't enough time to work it into the requirements
//		addProductToDispenser(new Gum("Watermelon", "Wrigley's", "Gum", .75, 0, 0, 0, 5));

		// Chip Test
		addProductToDispenser(new Chips("Corn", "Doritos", "Chips", .98, 1, 2, 180, 150));
		addProductToDispenser(new Chips("Ranch", "Doritos", "Chips", .98, 1, 2, 180, 150));

		// Candy Test
		addProductToDispenser(new Candy("Chocolate", "Hershey's", "Candy", .99, 24, 35, 3, 220));
		addProductToDispenser(new Candy("Krackel", "Hershey's", "Candy", .99, 23, 3, 45, 210));
		for (int i = 0; i < 10; i++) {
			addProductToDispenser(new Candy("White Chocolate", "Hershey's", "Candy", .99, 21, 3, 105, 230));
		}
		addProductToDispenser(new Candy("Almond", "Hershey's", "Candy", .99, 19, 4, 25, 210));

	}

	// Prints out each product queue and its contents
	public void displayProducts() {
		// Tells us how many queue's there are
		//System.out.println("\n\n\n\nTotal Inventory Slots: " + productQueues.size() + "\n");
		// Loop through queue by queue
		for (DispenserQueue queue : productQueues) {
			ArrayList<Product> slot = queue.getSlot();
			for (int j = 0; j < slot.size(); j++) {
				slot.get(j);
			}
		}
	}
	
	public int getProductCount() {
		int numProducts = 0;
		for (@SuppressWarnings("unused") DispenserQueue queue : productQueues) {
			numProducts++;
		}
		return numProducts;
	}
	
	public ArrayList<DispenserQueue> searchForDrinks(){
		ArrayList<DispenserQueue> drinks = new ArrayList<DispenserQueue>();
		for(DispenserQueue productQueue : productQueues) {
			if(productQueue.isDrinkItem()) {
				drinks.add(productQueue);
			}
		}		
		return drinks;
	}
	public ArrayList<DispenserQueue> searchForChips(){
		ArrayList<DispenserQueue> chips = new ArrayList<DispenserQueue>();
		for(DispenserQueue productQueue : productQueues) {
			if(productQueue.isChipsItem()) {
				chips.add(productQueue);
			}
		}		
		return chips;
	}
	public ArrayList<DispenserQueue> searchForGum(){
		ArrayList<DispenserQueue> gum = new ArrayList<DispenserQueue>();
		for(DispenserQueue productQueue : productQueues) {
			if(productQueue.isGumItem()) {
				gum.add(productQueue);
			}
		}		
		return gum;
	}
	public ArrayList<DispenserQueue> searchForCandy(){
		ArrayList<DispenserQueue> candy = new ArrayList<DispenserQueue>();
		for(DispenserQueue productQueue : productQueues) {
			if(productQueue.isCandyItem()) {
				candy.add(productQueue);
			}
		}		
		return candy;
	}
	
	public ArrayList<DispenserQueue> getQueues(){
		return productQueues;
	}
	public DispenserQueue[] getQueuesArray(){
		DispenserQueue[] productArray = new DispenserQueue[this.getProductCount()];
		for(int i = 0; i < this.getProductCount(); i++) {
			productArray[i] = productQueues.get(i);
		}
		return productArray;
	}
	public void setQueuesArray(DispenserQueue[] queues){
		dispenserArray = queues;
	}

	public int getIDNumber() {
		return idNumber;
	}

	public void setIDNumber(int idNumber) {
		this.idNumber = idNumber;
	}
	
	public void addProductToMachine(DispenserQueue newQueue) {
		productQueues.add(newQueue);
		
	}

	public int getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}

	public String getInventoryFileName() {
		return inventoryFileName;
	}

	public void setInventoryFileName(String inventoryFileName) {
		this.inventoryFileName = inventoryFileName;
	}

	public ArrayList<DispenserQueue> getProductQueues() {
		return productQueues;
	}

	public void setProductQueues(ArrayList<DispenserQueue> productQueues) {
		this.productQueues = productQueues;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	public String toString() {
		String result = "";
		for(DispenserQueue slot : productQueues) {
			result +=  " name: " + slot.getProductName() + " stock: " + slot.getProductCount() + " price: " + slot.getProductPrice();
			result += "\n";
		}	
		return result;
		
	}
	
}
