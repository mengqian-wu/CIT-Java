package banking;
/**
 * Represents a checking.savings bank account for a customer.
 * @author fengliang
 *
 */
public class BankAccount {
	//define three instance variables for the BankAccount class
    /**
     * Type of account (checking/savings)
     */
	String accountType;
	
	/**
	 * Balance for bank account
	 */
	double balance;
	
	/**
	 * Customer for this account.
	 */
	Customer customer; //when we haven't create Customer class, Java doesn't know what Customer is. 
	 
	/**
	 * Fixed amount for quick withdrawals.
	 */
	double fastCashAmount; 
	
	//constructor: a way of creating a banking account
	/**
	 * Creates a bank account of given type for given customer.
	 * @param accountType for bank account
	 * @param customer for bank account
	 */
	public BankAccount(String accountType, Customer customer) {
		this.accountType = accountType;
		this.customer = customer; 			
		// set initial default value for fast cash amount 
		this.fastCashAmount = 60; 
		
	}
	
	//methods 
	
	/**
	 * Deposits the given amount, if greater than 0  
	 * @param amount to add to balance
	 */
	public void deposit(double amount) {
		if (amount >0){
		this.balance += amount;
		}
	}
	/**
	 * Withdraws the given amount from balance
	 * @param amount
	 * @throws Exception if given amount is larger than available balance 
	 */
	
	public void withdraw(double amount) throws Exception {
		if(amount > this.balance) {
			//no enough money to withdraw 
			throw new Exception("Amount is greater than available balance.");
		}
		this.balance -= amount;
	}
	
	/**
	 * Withdraw the fast cash amount
	 * @throws Exception if given fast cash amount is greater than availabel balance 
	 */
	public void fastWithdraw() throws Exception {
		// withdraw the given fast cash amount 
		// but the balance could be less than withdrawal requirement, we need Exception 
		this.withdraw(this.fastCashAmount);
	}
	
	/**
	 * Returns account type and balance for this bank account.
	 * @return string with all the info 
	 */
	public String getAccountInfo() {
		return this.accountType + ":" + this.balance;
	}
	/**
	 * Sets the fast cash amount, if greater than 0.
	 * @param amount
	 */
	public void setFastCashAmount(double amount) {
		if (amount >0) {
		this.fastCashAmount = amount; 
		}
	}
	/**
	 * Returns the customer name and address for this bank account
	 * @return string with all the info 
	 */
	public String getCustomerInfo() {
		return this.customer.getName() + " from " + this.customer.getAddress();
	} 
	
}
