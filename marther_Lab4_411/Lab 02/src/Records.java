/**
 * @author Amir
 * 3/1/18
 * Records.java
 * Lab 3
 * This program sorts the array list by sex and region. 
 * After the program sorts the array list, the program gets: 
 * the averages of males and females, 
 * the number of females with mortgage and savings account, 
 * and number of males in different regions with car and 1 child.  
 *
 */
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

public class Records extends BankRecords{
	
//create formatted object to write output directly to the
//console and to a file
    static FileWriter fw = null;
	public Records(){
		try {
			fw = new FileWriter("bankrecords.txt");
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	public static void main(String[] args)  {
	    Records br = new Records();
        br.readData();
        System.out.println("\nData analytic results: ");
        //call functions to perform analytics 
    	AverageComp();  // analyze average income 
    	femsComp();     // analyze females w. mort/savings account
    	malesComp();    // analyze male count 

        // *** close out file object ***//
    	  
    	try {
    		fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	//print current date & time with the programmer's name.
   		String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
   		System.out.println("\nCur dt=" + timeStamp + "\nProgrammed by Mohmedamir Arther\n");
   	
	}
	
	private static void femsComp() {
		Arrays.sort(robjs,new GenderComparator());
		int fsum = 0, fCt = 0;
		for (int i=0;i<robjs.length;i++)
			//female count with mortgage and savings account
			if (robjs[i].getSex().equals("FEMALE") && robjs[i].getMortgage().equals("YES") && robjs[i].getSave_act().equals("YES")) 
			{ 
				fsum += 1;
				++fCt;
			}
		System.out.println("\nNumber of Females with Mortgage and Savings account: " + fCt);
		 
		//write to the file
     	try {
	 		 fw.write("\n\nNumber of Females with Mortgage and Savings account: " + fCt);
		    } catch (IOException e) {
				 
				e.printStackTrace();
		   }  
	}
	private static void malesComp() {
		Arrays.sort(robjs,new RegionComparator());
		//initialize local variables
		int msum = 0, mCt_Rural = 0, mCt_Inner_City = 0, mCt_Town = 0, mCt_Suburban = 0;
		for (int i=0;i<robjs.length;i++) {
			//count of males in rural region with car and 1 child
			if (robjs[i].getSex().equals("MALE") && robjs[i].getRegion().equals("RURAL") && robjs[i].getChildren()==1 && robjs[i].getCar().equals("YES")) 
			{ 
				msum += 1;
				++mCt_Rural;
			}
			//count of males in Inner City region with car and 1 child
			if (robjs[i].getSex().equals("MALE") && robjs[i].getRegion().equals("INNER_CITY") && robjs[i].getChildren()==1 && robjs[i].getCar().equals("YES")) 
			{ 
				msum += 1;
				++mCt_Inner_City;
			}
			//count of males in Town region with car and 1 child
			if (robjs[i].getSex().equals("MALE") && robjs[i].getRegion().equals("TOWN") && robjs[i].getChildren()==1 && robjs[i].getCar().equals("YES")) 
			{ 
				msum += 1;
				++mCt_Town;
			}
			//count of males in Suburban region with car and 1 child
			if (robjs[i].getSex().equals("MALE") && robjs[i].getRegion().equals("SUBURBAN") && robjs[i].getChildren()==1 && robjs[i].getCar().equals("YES")) 
			{ 
				msum += 1;
				++mCt_Suburban;
			}
		}
		//output to console  
		System.out.println("\nRural region males with car and 1 child: " + mCt_Rural);
		System.out.println("Inner_City region males with car and 1 child: " + mCt_Inner_City);
		System.out.println("Town region males with car and 1 child: " + mCt_Town);
		System.out.println("Suburban region males with car and 1 child: " + mCt_Suburban);
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
   		
		//write output in file
     	try {
     		fw.write("\n\nRural region males with car and 1 child: " + mCt_Rural);
	 		fw.write("\nInner_City region males with car and 1 child: " + mCt_Inner_City);
	 		fw.write("\nTown region males with car and 1 child: " + mCt_Town);
	 		fw.write("\nSuburban region males with car and 1 child: " + mCt_Suburban);
	 		fw.write("\n\nCur dt=" + timeStamp + "\nProgrammed by Mohmedamir Arther");
		    } catch (IOException e) {
				 
				e.printStackTrace();
		   }  
	}
	
	private static void AverageComp() {
		
	Arrays.sort(robjs,new GenderComparator());
	//initialize local variables
	double fsum = 0, msum=0, fCt=0,mCt=0;
	
	for (int i=0;i<robjs.length;i++)
		//get a sum of all females' income and count
		if (robjs[i].getSex().equals("FEMALE")) { 
			fsum += robjs[i].getIncome();
			++fCt;
		}
		else{
			//count and sum of all males income
			msum+=robjs[i].getIncome();
			++mCt;
		}
	//print resulting averages to console and file
	double femAvg = fsum/(fCt);
	double maleAvg = msum/(mCt);
	
	//put average income of males and females in decimal format
	DecimalFormat deci = new DecimalFormat("0.00");
	String mAvg = deci.format(maleAvg);
	String fAvg = deci.format(femAvg);
	System.out.println("\nAverage income Females: $" + fAvg);
	System.out.println("Average income Males: $" + mAvg);
	
	//write averages of males and females in the file
     	try {
	 		fw.write("Avg inc. for females " + fAvg);
	 		fw.write("...");
	 		fw.write("\nAvg inc. for males " + mAvg);
	 		fw.write("...");
		    } catch (IOException e) {
				 
				e.printStackTrace();
		   }  
	}
}
