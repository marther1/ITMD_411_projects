//Mohmedamir Arther

import java.util.Scanner;

public class Cylinder
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		double area = 0, height = 0, radius = 0, volume = 0;
		String strName = "";
		
		System.out.println("Welcome to the Volume Program!");
		
		System.out.println("please enter your name");
		strName = sc.nextLine();		
		System.out.println("hello " + strName);
	
		System.out.println("Please enter the radius. ");
		radius = sc.nextDouble();
		
		System.out.println("Please enter the height. ");
		height = sc.nextDouble();
	
		volume = 3.1416 * radius * radius * height;
		area = 2 * 3.1416 * radius * height + (2 *3.1416 * radius * radius);
		
		System.out.println(volume);
		System.out.println(area);
		
		
		
	}
}