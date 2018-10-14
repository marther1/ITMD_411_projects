/** 
 * @author Amir
 * 4/3/18
 * DBConnect.java
 * Lab 4
 * This program first makes a connection to a database.
 * Then creates a table in which the data is then inserted.
 * Then the inserted data is retrieved from the database. 
 * And finally it outputs the retrieved data in the console and a GUI frame.   
 * 
 */

import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.SQLException;
  
public class DBConnect {
 
// Code database URL
static final String DB_URL = "jdbc:mysql://www.papademas.net/411labs?autoReconnect=true&useSSL=false";
// Database credentials
static final String USER = "db411", PASS = "411";

public Connection connect() throws SQLException {

 return DriverManager.getConnection(DB_URL, USER, PASS);

}
}

