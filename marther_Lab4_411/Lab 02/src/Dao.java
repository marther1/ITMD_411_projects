/** 
 * @author Amir
 * 4/3/18
 * Dao.java
 * Lab 4
 * This program first makes a connection to a database.
 * Then creates a table in which the data is then inserted.
 * Then the inserted data is retrieved from the database. 
 * And finally it outputs the retrieved data in the console and a GUI frame.   
 * 
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dao {
	//Declare DB objects 
	DBConnect conn = null;
	Statement stmt = null;

	// constructor
	public Dao() { //create db object instance
		conn = new DBConnect();
	}
	// CREATE TABLE METHOD
	public void createTable() {
		try {
			
			// Open a connection
			System.out.println("Connecting to a selected database to create Table...");
			System.out.println("Connected database successfully...");

			// Execute create query
			System.out.println("Creating table in given database...");
			stmt = conn.connect().createStatement();
			
			
			//Create table if not exists in db
			String sql = "CREATE TABLE IF NOT EXISTS M_Arth_tab " + 
		             	"(pid INTEGER not NULL AUTO_INCREMENT, " + 
		             " id VARCHAR(10), " +
		            " income numeric(8,2), " + 
		           " pep VARCHAR(3), " + 
		          " PRIMARY KEY ( pid ))";
			
			stmt.executeUpdate(sql);
	
			System.out.println("Created table in given database...");
			
			conn.connect().close(); //close db connection 
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		}
	}

	// INSERT INTO METHOD
	public void insertRecords(BankRecords[] robjs) throws SQLException {
		int count = 1;
		  // Execute a query
		  System.out.println("Inserting records into the table...");
		  //stmt = conn.connect().createStatement();

		  // Include all object data to the database table
		  //for (int i = 0; i < robjs.length; ++i) {
	        
			  // finish string assignment to insert all object data 
			  // (pid, id, income, pep) into your database table
		  	
			  String sql = "INSERT INTO M_Arth_tab (pid, id, income, pep) VALUES (?, ?, ?, ?)";
			  //create preparedstatement
			  PreparedStatement statement = (PreparedStatement) conn.connect().prepareStatement(sql);
			  System.out.println("Adding data to database...");
			  for(BankRecords bankRecord : robjs) {
			//insert data from csv file to the db
				 
		           statement.setInt(1, count);
		           statement.setString(2, bankRecord.getId());
		           statement.setDouble(3, bankRecord.getIncome());
		           statement.setString(4, bankRecord.getPep());
		          
		         statement.executeUpdate(sql);
		          count++;
		          
		       }
			  //update db with the inserted data
		  	stmt.executeUpdate(null);
	        conn.connect().close();
System.out.println("Connection Closed..");
	 }
	//retrieve records
	public ResultSet retrieveRecords() {
			 ResultSet rs = null;
			 
			 //connect to db to create statement
			 System.out.println("Connecting to a selected database for Records retrievals...");
			 try {
				stmt = conn.connect().createStatement();
				System.out.println("Connected database successfully...");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 //creating select statement for id, income, pep order by pep desc
			 System.out.println("Creating Select statement...");
			 String sql = "SELECT id, income, pep from M_Arth_tab order by pep desc";
			 try {
				rs = stmt.executeQuery(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 try {
				conn.connect().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 return rs;
			}

	
}	