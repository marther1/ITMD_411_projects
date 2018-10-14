import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author Amir
 * 2/15/18
 * BankRecordsTest.java
 * Lab 2
 * This program reads, processes, and prints data from a csv(excel) file.
 * This program first reads all the data from the excel file.
 * This program then processes all the data from the excel (csv) file.
 * Lastly, this program prints the first 25 data to the user in the console log.
 * In short, this program helps Bank of IIT to process loans based on their clients details in the file.
 * 
 */
public class BankRecordsTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BankRecords br = new BankRecords();
		br.readData();
		//print current date & time with the programmer's name.
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
		System.out.println("\nCur dt=" + timeStamp + "\nProgrammed by Mohmedamir Arther\n");
	}

}
