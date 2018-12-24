package samplejava;
import java.util.LinkedList;
public class people {
	

	public class customerQ<C> {

		private LinkedList<C> customers = new LinkedList<>();

		public void Queue(){}

		public int size(){
			return customers.size();

		}

		public boolean isEmpty(){
		return customers.isEmpty();
	}

	public void enqueue(C element){
		customers.addLast(element);
	}

	public C dequeue(){
		return customers.removeFirst();

	}

	public C first(){
		return customers.getFirst();
	}
	}
}
