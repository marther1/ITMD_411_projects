/**
 * 
 * @author Amir
 * 2/4/18
 * AccountHolder.java
 * Lab 1
 * This is a program for the Bank of IIT that match an ATM's function 
 * where you can make deposits, withdrawals, and even see the annual interest report
 * and the bank of IIT wishes to update the annual interest rate that can be possible as well 
 */
//create public class accountholder
public class AccountHolder {
	//declare class fields
	static double annualInterestRate=0;
	
	private double balance; 
	
	//constructors
	/**
	 * 
	 * @param balance
	 */
	public AccountHolder(double balance) 
	{
		this.balance = balance;
		if (this.balance < 0) {
			throw new IllegalArgumentException("balance must be non-negative");
		}
	}

	//method to getbalance
	public double getBalance() {
		return balance;
	}
	
	//method for deposit, add to the balance
	public void deposit(double balance)
	{
		this.balance += balance;
	}
	
	//method for withdrawing money, subtract from the balance
	public void withdrawal(double balance)
	{
		//if balance is less than 100 end the program
		if (this.balance - balance < 100) {
			throw new IllegalArgumentException("Error, your account must have at least $100 balance at all time");
		}
		//else if balance is less than 500 a one-time fee of 50 will be subtracted 
		else if (this.balance - balance < 500) {
			System.out.println("Your account has less than $500, that's why a one-time fee of $50 will be subtracted");
			this.balance = this.balance - balance - 50;
		}
		//else just withdraw from the balance
		else {
			this.balance -= balance;
		}
	}
	//method for monthly interest
	public void monthlyInterest() {
		this.balance += balance * (annualInterestRate/12);
	}
	//method to modify monthly interest rate
	public static void modifyMonthlyInterest(double rateUpdate) {
		//check if rateupdate is greater than 0 but less than 1
		if(rateUpdate >= 0 && rateUpdate <= 1) {
			//update annual interest rate
			 annualInterestRate = rateUpdate;
			System.out.println("Your annual interest rate has been updated to " + rateUpdate + "%");

			}
		//else end the program
		else {
			throw new IllegalArgumentException("Invalid entry, please try again.");
        }
	}
	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance += balance;
	}
	//method for tostring, set the format to two decimal places
	public String toString() {
		return String.format("$%.2f", balance);
	}
}
