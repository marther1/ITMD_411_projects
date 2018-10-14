/**
 * 
 * @author Amir
 * 2/4/18
 * AccountHolderTest.java
 * Lab 1
 * This is a program for the Bank of IIT that match an ATM's function 
 * where you can make deposits, withdrawals, and even see the annual interest report
 * and the bank of IIT wishes to update the annual interest rate that can be possible as well 
 */
//import packages
import java.util.Scanner; //user input
import java.text.SimpleDateFormat;
import java.util.Calendar;
public class AccountHolderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create local variables
		double balance = 0;
		double rateUpdate = 0;
		AccountHolder ac = null;
		//set default interest rate to 0.04
		AccountHolder.annualInterestRate = 0.04;
		//create scanner object to receive input from user
		Scanner sc = new Scanner(System.in);
		//ask the user for a starter balance
		System.out.println("Please enter the starter balance here: ");	
		balance = sc.nextDouble();
		ac = new AccountHolder(balance);
		int menu; 
		boolean quit = false;
		System.out.println("\nMain menu");
		//do while loop until the loop is exit
		do {
			//case choices
			System.out.println("\nPress 1. To deposit");
			System.out.println("Press 2. To withdraw");
			System.out.println("Press 3. To display the monthly balances with the current annual interest rate");
			System.out.println("Press 4. To change the annual interest rate");
			System.out.println("Press 5. To display the current balance in the account");
			System.out.println("Press 6. To exit");
			menu = sc.nextInt();
		switch (menu) {
			case 1: 
				System.out.println("Enter a deposit amount");
				balance = sc.nextDouble();
				//check if a positive value is entered, else end the program
				if (balance > 0) {
				ac.deposit(balance);
				System.out.println("Your new balance in the account is " +  ac.getBalance());
				}
				else {
					throw new IllegalArgumentException("Invalid entry, please try again by entering a positive value");
				}
				break;
			case 2: 
				System.out.println("Enter a withdrawal amount");
				balance = sc.nextDouble();
				ac.withdrawal(balance);
			
				//display new balance
				System.out.println("Your new balance in the account is " +  ac.getBalance());
				break;
			case 3: 
				//for loop to calculate balance with monthly interest rate
				for(int count = 1; count < 12; count++) {
					ac.monthlyInterest();
					System.out.print("Month balance for month#" + count + ": ");
					System.out.println(ac);
				};
				break;
			case 4: 
				//update interest rate
				System.out.println("enter a new interest rate: ");
				rateUpdate = sc.nextDouble();
				AccountHolder.modifyMonthlyInterest(rateUpdate);
				break;
			case 5: 
				//display balance
				System.out.println(ac);
				break;
			case 6: 
				//exit the program
				quit = true;
				break;
			default: System.out.println("Invalid entry! Please try again.");
			
					
		}
		} while (!quit);
		sc.close();
		System.out.println("Transcation Completed.\nHave a nice day!");
		//display timestamp
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
		System.out.println("Cur dt=" + timeStamp + "\nProgrammed by Mohmedamir Arther\n");
	}
}
