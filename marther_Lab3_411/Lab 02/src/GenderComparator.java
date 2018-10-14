 /**
 * @author Amir
 * 3/1/18
 * GenderComparator.java
 * Lab 3
 * This program sorts the array list by sex and region. 
 * After the program sorts the array list, the program gets: 
 * the averages of males and females, 
 * the number of females with mortgage and savings account, 
 * and number of males in different regions with car and 1 child.  
 *
 */
import java.util.Comparator;

public class GenderComparator implements Comparator<BankRecords>{
	 
	@Override
	public int compare(BankRecords o1, BankRecords o2) {
	// use compareTo to compare strings
	int result = o1.getSex().compareTo(o2.getSex());
		return result;
	}
 }
