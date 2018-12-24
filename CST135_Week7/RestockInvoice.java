
package application;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

public class RestockInvoice {
	int lowInventory = 3;
	int maxInventory = 25;
	String directory = "C:/Users/Kurt/eclipse-workspace/CST-135 Project/bin/";
	public RestockInvoice(Dispenser vendingMachine) throws IOException {
		FileWriter fw = new FileWriter(new File(directory, vendingMachine.getInventoryFileName() + ".txt"));
		fw.write("Restock Invoice for " + vendingMachine.getInventoryFileName() + " Vending Machine ID#" + vendingMachine.getIdNumber());
		//System.out.println("Restock Invoice for " + vendingMachine.getInventoryFileName() + " Vending Machine ID#" + vendingMachine.getIdNumber());
		fw.write(System.getProperty( "line.separator" ));
		for(DispenserQueue queue : vendingMachine.getQueues()) {
			if(queue.getProductCount() <= lowInventory) {
				fw.write(queue.getProductName() + " is low and more needs to be ordered.");
				fw.write(System.getProperty( "line.separator" ));
				fw.write("Need to order " + (maxInventory - queue.getProductCount()) + " units.\n");
				fw.write(System.getProperty( "line.separator" ));
			    DecimalFormat formatter = new DecimalFormat("#0.00");
			    double orderTotal = (maxInventory * queue.getProductCount());
				fw.write("The cost to order is: $" + formatter.format(orderTotal));
				fw.write(System.getProperty( "line.separator" ));
			}
			fw.write(System.getProperty( "line.separator" ));
		}
		fw.close();
	}

}
