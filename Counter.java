/**
 * Represents a counter.
 * @author fengliang
 *
 */
public class Counter {
	
	//instance vars 
	
	/**
	 * Internal count.
	 */
	int count; 
	
	/**
	 * Creates a counter and starts internal count at given start value 
	 * @param start
	 */
	public Counter(int start) {
		// set the given start value 
		this.count = start; 
	}
	
	/**
	 * Create a counter and starts internal count at 0. 
	 */
	public Counter() {
		this.count = 0; 
	}
	

	public static void main(String[] args) {
		
		Counter counter1 = new Counter(2); // start it with 2 
		System.out.println(counter1.count); // print the value of the count in that counter 
        
		Counter counter2 = new Counter(); 
		System.out.println(counter2.count); 
	}

}
