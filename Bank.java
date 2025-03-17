package banking;

import java.util.Scanner;

/**
 * Represent a bank for managing customers and their bank accounts.
 * @author fengliang
 *
 */
public class Bank {

	public static void main(String[] args) {
		
		//creates new instance for Bank Class
		Bank bank = new Bank();
		//call the run method in the bank class
		bank.run();
	}
	/**
	 * Runs the program by initializing and managing, bank accounts and customers,
	 */
	public void run() {
		System.out.println("Welcom to the Bank! What is your name?");
		Scanner scanner = new Scanner(System.in);
		
		//get the next token (word), which is the customer's name 
		String name = scanner.next();
		
		System.out.println("Hello " + name + "! We are creating checking and saving accounts for you.");
		
		//create customer with given name 
		Customer customer = new Customer(name);
		
		//get address 
		System.out.println("What is your address?");
		
		//get the next token/word, which is the customer's address
		String address = scanner.next();
		
		//set the customer's address
		customer.setAddress(address);
		
		//create a checking account for customer 
		BankAccount checkingAccount = new BankAccount("checking", customer);
		
		//create a saving account for customer
		BankAccount savingsAccount = new BankAccount("saving", customer);
		
		//gets and prints the customer info associated with the checking account 
		System.out.println();
		System.out.println("Customer info: ");
		System.out.println(checkingAccount.getCustomerInfo());
		
		//get and print account info for checking account 
		System.out.println("Checking account: ");
		System.out.println(checkingAccount.getAccountInfo());
		System.out.println("Saving acount: ");
		System.out.println(savingsAccount.getAccountInfo());
		
		//deposits 
		
		//info checking 
		System.out.println();
		System.out.println("Amount (decimal) to deposit into your checking account?");
		double amount = scanner.nextDouble(); //get next token (double)
		checkingAccount.deposit(amount);//deposit into checking account 
		
		//into savings 
		System.out.println();
		System.out.println("Amount (decimal) to deposit into your savings account?");
		amount = scanner.nextDouble(); //get next token (double)
		savingsAccount.deposit(amount);//deposit into saving account 
		
		//print new balance
		System.out.println(checkingAccount.getAccountInfo());
		System.out.println(savingsAccount.getAccountInfo());
		
		//withdrawals 
		
		//from checking 
		System.out.println(); //blank line 
		System.out.println("Amount(decimal) to withdraw from your checking account?");
		amount = scanner.nextDouble(); //get next token (double)
		
		try {
			checkingAccount.withdraw(amount);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}//withdraw from checking 
		//java force you to handle exception when you call the method 
		//one way to deal with it is to use try/catch
	
	 
		//from savings 
	    System.out.println();//blank line 
	    System.out.println("Amount(decimal) to withdraw from your savings account?");
	    amount = scanner.nextDouble(); //get next token (double)
	
	    try {
	    	savingsAccount.withdraw(amount);
	    } catch (Exception e) {
	    	// TODO Auto-generated catch block
	    	System.out.println(e.getMessage());
	    }//withdraw from checking 
	    //java force you to handle exception when you call the method 
	    //one way to deal with it is to use try/catch
	    
	    //print new balances 
	    System.out.println(checkingAccount.getAccountInfo());
	    System.out.println(savingsAccount.getAccountInfo());
	    
	    scanner.close();  
	
	}	
		
}
