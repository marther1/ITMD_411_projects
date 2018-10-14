
import java.util.Scanner;
import java.lang.Math;
class ScannerClassExample
{
  //example of using the scanner class
  //which simplifies user input and output
  //this is part of the JDK 1.8.0_45 compiler

public static void main(String args[])	
{
  //declare a Scanner class object
  Scanner sc = new Scanner(System.in);
	
  //prompt user for their name
  System.out.println("please enter your name");
	
  //declare a local variable and read the integer
  String name = sc.nextLine();
	
  //display the name back to the user
  System.out.println("hello " + name);
	
  //prompt user for a value of x
  System.out.println("please enter a value for x");
	
  //declare a local variable and read the integer
  float x = sc.nextFloat();
 
  //prompt user for a value of y
  System.out.println("please enter a value for y");
	
  //declare a local variable and read the integer
  float y = sc.nextFloat();
  
  //sum of x and y
  float Sum = x + y;
  
  //Sub of y from x
  float Sub = x - y;
  
 //product of x and y assigned to variable w
  float w = x * y;
  
  //return the quotient of x by y
  float Quotient = x / y;

  //quotient of y by x assigned to z
  float z = y / x;
  
  //display the sum of x and y back to the user
  System.out.println("The Sum of x and y is " + Sum);
  
  //display the Sub of y from x back to the user
  System.out.println("The Sub of y from x is " + Sub);

  //display the Product of x and y back to the user
  System.out.println("The Product of x and y is " + w); 
  
  //display the quotient of x by y
  System.out.println("The Quotient of x by y is " + Quotient); 

  //display the quotient of y by x
  System.out.println("The Quotient of y by x is " + z);
 
  //return the modulus of x and y 
  System.out.println("The modulus of x and y is " + x % y);
  
  //x to the power of y
  double number = x;
  double exponent = y;
  double result = Math.pow(number , exponent );
 //display the result of the x to the power of y
  System.out.println("x to the power of y is " + result);
}
} 
