import java.util.Comparator;

 /**
 * @author Amir
 * 3/1/18
 * RegionComparator.java
 * Lab 3
 * This program sorts the array list by sex and region. 
 * After the program sorts the array list, the program gets: 
 * the averages of males and females, 
 * the number of females with mortgage and savings account, 
 * and number of males in different regions with car and 1 child.  
 *
 */
public class RegionComparator implements Comparator<BankRecords>{
	 
	@Override
	public int compare(BankRecords o1, BankRecords o2) {
	// use compareTo to compare strings
	int region = o1.getRegion().compareTo(o2.getRegion());
		return region;
	}
 }
