package banking;
/**
 * Represents a customer of a bank
 * @author fengliang
 *
 */
public class Customer {
	/**
	 * Name of customer.
	 */
	String name; 
	
	/**
	 * Address of customer.
	 */
	String address; // address should be null by default and we don't set it in the constructor- for JUnit testing 
	
	//constructor
	/**
	 * Creates a customer with the given name
	 * @param name
	 */
	public Customer(String name) {
		//sets instance variable name to given name
		this.name = name; 
	}
	
	//methods 
	
	/**
	 * Sets the address of customer to be given address
	 * @param address for customer 
	 * @return nothing = void 
	 */
	public void setAddress(String address) {
		//takes an given address and sets it to a instance var address to given address
		this.address = address;
	}
	
	/**
	 * Return customer's name 
	 * @return name of customer (string)
	 */
	public String getName() {
		return this.name; //this.name refers to the instance variable 'name'
	}
	
	
	/**
	 * Return customer's address
	 * @return address of customer
	 */
	public String getAddress() {
		return this.address; 
	}
}
