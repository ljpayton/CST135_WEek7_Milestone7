package samplejava;

//import java.util.LinkedList;
//import java.util.Queue;
import java.util.Stack;

//import samplejava.people.customerQ;

public class maintest {
	public static void main(String[] args) {
	Stack <String> myQ = new Stack<String>();
	myQ.push("Jamie wants Vitamin water");
	printStack(myQ);
	myQ.push("Jones wants mint gum and hersheys");
	printStack(myQ);
	myQ.push("London wants chips, gum, candy");
	printStack(myQ);
	myQ.push("Justin wants gum, soda, gatorade");
	printStack(myQ);
	myQ.push("Kendall wants candy bar,water, gum");
	printStack(myQ);
	
	myQ.pop();
	printStack(myQ);
	myQ.pop();
	printStack(myQ);
	myQ.pop();
	printStack(myQ);
	myQ.pop();
	printStack(myQ);
	myQ.pop();
	printStack(myQ);
	
	}

	private static void printStack(Stack<String> myQ) {
		// TODO Auto-generated method stub
		if (myQ.isEmpty()) {
			System.out.println("Everbody has been helped");
			}
		else
			System.out.printf("%s Beginning Of the Line\n", myQ);

 
	}
	
}
