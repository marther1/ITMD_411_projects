
public class Fraction
{
    int num, den; 

    //default constructor
    public Fraction()
    {
        num = 1;
        den = 1;
    }
    //overloaded constructor 
    public Fraction(int n, int d)
    {
        num = n;
        if (d==0) 
        {
            System.out.println( "error- division by zero");
            System.exit(0); // termimate program if division by 0  
        }
        else
            den = d;
    }
    public Fraction Sum(Fraction someFraction)
    {
        int n = someFraction.den+someFraction.num*den;
        int d = den*someFraction.den;
        return new Fraction(n/gcd(n,d),d/gcd(n,d));  //return refreshed member values 
    }
    public Fraction Difference(Fraction someFraction)
    {
     //define function logic below
    	int n = someFraction.den-someFraction.num*den;
        int d = den*someFraction.den;
        return new Fraction(n/gcd(n,d),d/gcd(n,d));
    }
    public Fraction Multiply(Fraction someFraction)
    {
     //define function logic below
    	int n = someFraction.num*someFraction.num*num;
        int d = den*someFraction.den;
        return new Fraction(n/gcd(n,d),d/gcd(n,d));
    }
    public Fraction Division(Fraction someFraction)
    {
     //define function logic below
    	int n = someFraction.den*someFraction.num*num;
        int d = den/someFraction.num;
        return new Fraction(n/gcd(n,d),d/gcd(n,d)); 
    }
    //find and return greatest common denominator
    public int gcd(int n, int d)
    {
        int remainder;
        while (d != 0)
        {
            remainder = n % d;
            n = d;
            d = remainder;
        }
        return n;
    }
    public String toString() // Display method
    {
    	 return num + "/" + den;
    }
 
//end class
public static class FractionOps extends Fraction{
	 public FractionOps(int n, int d)
	    {
	        super(n,d); //call base constructor
	    }
}
	  public static void main(String[] args)
	    {
	 
	    Fraction frac1 = new FractionOps(1,2);
	    Fraction frac2 = new FractionOps(1,4);
	    Fraction fracResult = new Fraction();
	    Fraction fracResult1 = new Fraction();
	    Fraction fracResult2 = new Fraction();
	    Fraction fracResult3 = new Fraction();

	    fracResult = frac1.Sum(frac2); 
	    fracResult.toString();
	    fracResult1 = frac1.Difference(frac2);
	    fracResult1.toString();
	    fracResult2 = frac1.Multiply(frac2);
	    fracResult2.toString();
	    fracResult3 = frac1.Division(frac2);     
	    fracResult3.toString();
	    // Result sb 3/4
	    
	    //finish coding to call the Difference, Multiply and division functions
	    
	    //finish print statement to include displays for the fraction operations for 
	    //differences, multiplication and division

	    System.out.println("Sum result = " + fracResult + "\n");  
	    System.out.println("Difference result = " + fracResult1 + "\n"); 
	    System.out.println("Multiplication result = " + fracResult2 + "\n"); 
	    System.out.println("Division result = " + fracResult3 + "\n"); 
	    }//end main
}
