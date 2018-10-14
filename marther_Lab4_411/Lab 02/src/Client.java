/**
 * @author Amir
 * 2/15/18
 * Client.java
 * Lab 2
 * This program reads, processes, and prints data from a csv(excel) file.
 * This program first reads all the data from the excel file.
 * This program then processes all the data from the excel (csv) file.
 * Lastly, this program prints the first 25 data to the user in the console log.
 * In short, this program helps Bank of IIT to process loans based on their clients details in the file.
 * 
 */
public abstract class Client {
	public abstract void readData(); //read file details
	public abstract void processData(); //process file details
	public abstract void printData(); //print file details
}
