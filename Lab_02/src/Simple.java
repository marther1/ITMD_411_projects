// Program to calculate Simple Interest.      
// Programmer: Mohmedamir Arther Student, File Name: Simple.java
// the packages
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

// the class definition
public class Simple 
{
 // the global variables are declared
 static double earnings = 0, principal = 0, rate = 0, time = 0, amount = 0;

 // introduce a DecimalFormat object
 static DecimalFormat twoPlace = new DecimalFormat("0.00");
 
 // the method to obtain data
 public static void getData()
 {
   // local variables declared and assigned initial values
   String firstNum = "", secondNum = "", thirdNum = "";
   // local variables updated via prompt boxes
   firstNum = JOptionPane.showInputDialog("Enter the Principal");
   secondNum = JOptionPane.showInputDialog("Enter Rate, as a %");
   thirdNum = JOptionPane.showInputDialog("Enter Time, in years");
   
   // update the global variables
   principal = Double.parseDouble(firstNum); 
   rate = Double.parseDouble(secondNum);
   time = Double.parseDouble(thirdNum);
 }
 //the method to calculate earning
 public static void calcEarnings()
 {
	// update a global variable
	  earnings = principal * rate / 100 * time;;
 }
 // the method to calculate amount
 public static void calcAccumulated()
 {
	 // update a global variable
	  amount = earnings + principal;
	 
 }
 // the method to display the amount
  public static void showAccumulated()
  {
	  // display the result in a message box
	  JOptionPane.showMessageDialog(null, "Amount in Account: $" +
			  twoPlace.format(amount), "Result", JOptionPane.PLAIN_MESSAGE);
  }
 // the main() method	
 public static void main(String args[])
 {
  // call the getData() method
  getData();
  
  //call the calcEarnings() method
  calcEarnings();

  // display the result in a message box
  JOptionPane.showMessageDialog(null, "interest earnings: $" +
  twoPlace.format(earnings), "Result", JOptionPane.PLAIN_MESSAGE);
  
  //call the calcAccumulated() method
   calcAccumulated();
   
   //call the showAccumulated() method
   showAccumulated();
	  
 System.exit(0);
 }
}

