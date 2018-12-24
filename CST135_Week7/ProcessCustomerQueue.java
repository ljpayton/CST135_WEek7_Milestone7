
package application;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class ProcessCustomerQueue {	
	private LinkedList<Customer> queue;
	
	
	public ProcessCustomerQueue() throws IOException {
		queue = new LinkedList<Customer>();
		File folder = new File("C:/Users/Kurt/eclipse-workspace/CST-135 Project/bin/customers/");
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				//System.out.println("File: " + listOfFiles[i].getName());
				queue = readCustomers(listOfFiles[i]);
			} else if (listOfFiles[i].isDirectory()) {
				//System.out.println("Directory: " + listOfFiles[i].getName());
			}
		}
		//System.out.println("Customer Queue constructor: " + queue.size());
		
		
		
	}
	
	public Customer first() {
		return queue.getFirst();
	}
	public Customer last() {
		return queue.getLast();
	}
	public int length() {
		return 0;
	}
	public void in(Customer newCustomer) {
		queue.add(newCustomer);
	}
	public void out() {
		queue.removeFirst();
		//queue.removeFirst();
	}
	public boolean isEmpty() {
		int customersInQueue = 0;
		for(@SuppressWarnings("unused") Customer customer : queue) {
			customersInQueue++;
		}
		if(customersInQueue == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	public LinkedList<Customer> getQueue(){
		return queue;
	}
	public LinkedList<Customer> readCustomers(File customerList) throws IOException{
		String currentLine = "";
		LinkedList<Customer> customers = new LinkedList<Customer>();
		BufferedReader customerInputR2 = new BufferedReader(new InputStreamReader(new FileInputStream(customerList), "UTF-8"));
				while (currentLine != null) {
					currentLine = customerInputR2.readLine();
					if (currentLine == null) {
						break;
					}
					String[] tempProductHolder = currentLine.split(",");
					String customerName = tempProductHolder[0];
					//System.out.print(customerName + " ");
					String intendedProductName = tempProductHolder[1];
					//System.out.println(intendedProductName);
					Customer newCustomer = new Customer(customerName, intendedProductName);
					customers.add(newCustomer);
				}
				customerInputR2.close();
		return customers;
	}

	public void setQueue(LinkedList<Customer> queue) {
		this.queue = queue;
	}
	
	
	
	
	
	
}





























