
// the packages
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import java.lang.Math;

// the class definition
public class Projectile 
{
 // the global variables are declared
 static double angle, distance, height, time, velocity;
 final static double gravity = 32.2;

 // the class constructor ( initialize values )
 public Projectile() 
 { angle = 0; distance = 0; height = 0; time = 0; velocity = 0; }
 
 // the method to show object instantiation
 public void ObjectInstantiated()
 {
	 // display a message
	 JOptionPane.showMessageDialog(null, "object created!", 
	   "Result", JOptionPane.PLAIN_MESSAGE);
 }
 // the method to obtain data
 public void getData()
 {
   // local variables declared and assigned initial values
   String firstNum = "", secondNum = "";
   // local variables updated via prompt boxes
   firstNum = JOptionPane.showInputDialog("Enter initial velocity");
   secondNum = JOptionPane.showInputDialog("Enter angle (degrees)");
     
   // update the global variables
   velocity = Double.parseDouble(firstNum); 
   // convert the angle from degrees to radians
   angle = Double.parseDouble(secondNum) * Math.PI / 180.0;   
 }

 // method to compute maximum distance
 public double computeMaxDistance(double v, double theta)
 {
	 // declare some local variables
	 double maxDist = 0.0;
	 // assign values to the global variables
	 velocity = v;
	 angle = theta;
	 // perform the computations
	 maxDist = Math.pow(velocity, 2.0);
	 maxDist *= Math.sin(2 * angle) / gravity;
	 // return a value
	 return maxDist;
 }
 //method to compute maximum height
 public double computeMaxHeight(double v, double theta)	
 {
	 //declare some local variables
	 double maxheight = 0.0;
	 //assign values to the global variables
	 velocity = v;
	 angle = theta;
	//perform the computations
	 maxheight = Math.pow(velocity, 2.0);
	 double sin = Math.sin(angle);
	 maxheight *= Math.pow(sin, 2.0) / (2 * gravity);
	 //return a value
	 return maxheight;
 }
 //method to compute the time of flight
 public double computetimeoflight(double v, double theta)
 {
	 //declare some local variables
	 double flighttime = 0.0;
	 //assign values to the global variable
	 velocity = v;
	 angle = theta;
	 //perform the computations
	 flighttime = Math.sin(angle)* 2 * v / gravity;
 //return a value
	 return flighttime;
 }
 	
 // the main() method	
 public static void main(String args[])
 {
  // introduce a DecimalFormat object
  DecimalFormat twoPlace =  new DecimalFormat("0.00");
  // declare some variables that are local to main
  double myVelocity = 0, myDistance = 0, myAngle = 0, mymaxheight = 0, timeofflight = 0;
  // introduce a class object
  Projectile p = new Projectile();
  // announce the object  
  p.ObjectInstantiated();
  // object calls the getData() method
  p.getData();
  // assign globals to the locals 
  myVelocity = velocity;
  myAngle = angle;
  // object calls the computeMaxDistance() method
  myDistance = p.computeMaxDistance(myVelocity, myAngle);
  // display the result in a message box
  JOptionPane.showMessageDialog(null, "maximum distance: " +
    twoPlace.format(myDistance) + " feet ", "Result", 
    JOptionPane.PLAIN_MESSAGE);
//display the result in a message box
  mymaxheight = p.computeMaxHeight(myVelocity, myAngle);
  JOptionPane.showMessageDialog(null, "maximum height: " +
		    twoPlace.format(mymaxheight) + " feet ", "Result", 
		    JOptionPane.PLAIN_MESSAGE);
  //display the result in a message box
  timeofflight = p.computetimeoflight(myVelocity, myAngle);
  JOptionPane.showMessageDialog(null, "time of travel: " +
		    twoPlace.format(timeofflight) + " sec ", "Result", 
		    JOptionPane.PLAIN_MESSAGE);
  System.exit(0);
 }// end the main() method
}// end the class definition
