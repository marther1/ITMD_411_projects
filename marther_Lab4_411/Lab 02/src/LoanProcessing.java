/** 
 * @author Amir
 * 4/3/18
 * LoanProcessing.java
 * Lab 4
 * This program first makes a connection to a database.
 * Then creates a table in which the data is then inserted.
 * Then the inserted data is retrieved from the database. 
 * And finally it outputs the retrieved data in the console and a GUI frame.   
 * 
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class LoanProcessing extends BankRecords{

	/**
	 * @param args
	 */
	
	static PrintStream out;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankRecords br = new BankRecords();
		br.readData();
		Dao dao = new Dao();
		dao.createTable();
		
		try {
			dao.insertRecords(robjs);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println("Inserted records into the table...");
			
		} // perform inserts
		
		 try {

	           out = new PrintStream("jtable.csv");

	       } catch (FileNotFoundException e) {

	    	   System.out.println("Error warning: " + e.getMessage());

	       }
		ResultSet rs = dao.retrieveRecords(); // fill result set object

		// Create heading for display
		System.out.println("ID:			Income			Pep");
		       
		
		// Extract data from result set
			try {
				int count = 0;
				while (rs.next()) {
				// Retrieve data by column name (i.e., for id,income,pep)
					
					String id = rs.getString(1);
					double income = rs.getDouble(2);
					String pep = rs.getString(3);
				

				// Display values for id,income,pep
				System.out.printf("%-8s\t\t%-8f\t\t%-8s%n", id, income, pep);
				out.println(id + ","  + income + "," + pep);
				count++;
				  }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//run jtable
			FileToJtable j_table = new FileToJtable();
		       j_table.run_jtable();
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // closes result set object

		System.out.println(); //white space
		//print current date & time with the programmer's name.
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
		System.out.println("\nCur dt=" + timeStamp + "\nProgrammed by Mohmedamir Arther\n");	}

}
